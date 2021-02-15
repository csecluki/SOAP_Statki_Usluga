/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lukasz.statki;

/**
 *
 * @author Lenovo
 */
public class Statek {
    
    private int MMSI;
    private String name;
    private String flag;
    private String vtype;
    private byte[] img;
    private int grossTonnage;
        
    public Statek(int MMSI, String name, String flag, String vtype, byte[] img, int grossTonnage) {
        this.MMSI = MMSI;
        this.name = name;
        this.flag = flag;
        this.vtype = vtype;
        this.img = img;
        this.grossTonnage = grossTonnage;
        
    }

    public int getMMSI() {
        return MMSI;
    }

    public void setMMSI(int MMSI) {
        this.MMSI = MMSI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public int getGrossTonnage() {
        return grossTonnage;
    }

    public void setGrossTonnage(int grossTonnage) {
        this.grossTonnage = grossTonnage;
    }
    
}
