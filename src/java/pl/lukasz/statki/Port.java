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
public class Port {
    
    private String name;
    private String country;
    private float latitude;
    private float longitude;
    
    public Port(String name, String country, float latitude, float longitude){
        this.name = name;
        this.country = country;
        this.longitude = latitude;
        this.latitude = longitude;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    
}
