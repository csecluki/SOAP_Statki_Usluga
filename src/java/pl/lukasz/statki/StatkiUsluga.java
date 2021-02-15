/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lukasz.statki;

import java.util.HashMap;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Lenovo
 */
@WebService(serviceName = "StatkiUsluga")
public class StatkiUsluga {
   
    Map<Integer, Statek> statki = new HashMap<>();
    Map<String, Port> porty = new HashMap<>();

    /**
     * This is a sample web service operation
     * @param MMSI
     * @param name
     * @param flag
     * @param vtype
     * @param img
     * @param grossTonnage
     * @return 
     */
    @WebMethod(operationName = "dodajStatek")
    public int dodajStatek(
            @WebParam(name = "MMSI") int MMSI,
            @WebParam(name = "name") String name,
            @WebParam(name = "flag") String flag,
            @WebParam(name = "vtype") String vtype,
            @WebParam(name = "img") byte[] img,
            @WebParam(name = "grossTonnage") int grossTonnage) {
        Statek nowyStatek = new Statek(MMSI, name, flag, vtype, img, grossTonnage);
        statki.put(MMSI, nowyStatek);
        System.out.println(statki);
        return MMSI;
    }
    
    @WebMethod(operationName = "dodajPort")
    public void dodajPort(
            @WebParam(name = "name") String name,
            @WebParam(name = "country") String country,
            @WebParam(name = "latitude") float latitude,
            @WebParam(name = "longitude") float longitude) {
        Port nowyPort = new Port(name, country, latitude, longitude);
        porty.put(name, nowyPort);
    }
    
    @WebMethod(operationName = "pobierzDaneStatku")
    public Statek pobierzDaneStatku (@WebParam(name = "MMSI") int MMSI) throws IncorrectMMSIException {
        if (statki.containsKey(MMSI)) {
            return statki.get(MMSI);
        } else {
            throw new IncorrectMMSIException();
        }
    }
    
    @WebMethod(operationName = "pobierzDanePortu")
    public Port pobierzDanePortu (@WebParam(name = "name") String name) {
        return porty.get(name);
    }
    
    @WebMethod(operationName = "odbierzZgloszenie")
    public String odbierzZgloszenie (
            @WebParam(name = "MMSI") int MMSI,
            @WebParam(name = "portName") String portName,
            @WebParam(name = "latitude") float latitude,
            @WebParam(name = "longitude") float longitude,
            @WebParam(name = "knots") float knots) throws IncorrectMMSIException, IncorrectPortException {
        if (statki.containsKey(MMSI)) {
            if (porty.containsKey(portName)) {
                Statek plynacyStatek = statki.get(MMSI);
                Port portDocelowy = porty.get(portName);
                double odlegloscLatitude = Math.abs(portDocelowy.getLatitude() - latitude);
                double odlegloscLongitude = Math.abs(portDocelowy.getLongitude() - longitude);
                double calkowitaOdleglosc = Math.sqrt(Math.pow(odlegloscLatitude, 2) + Math.pow(odlegloscLongitude, 2));
                double kilometry = calkowitaOdleglosc * 111;
                int czasPrzybycia = (int)Math.round(kilometry / (knots * 1.852));
                return String.valueOf(czasPrzybycia);
            } else {
                throw new IncorrectPortException();
            }
        } else {
            throw new IncorrectMMSIException();
        }
    }
}
