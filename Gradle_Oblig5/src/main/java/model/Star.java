package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Star extends CelestialBody {
    private double effectiveTemperature;
    private static final double MSUN = 1.98892*Math.pow(10,30);
    private static final double RSUN = 695700;
    public Star(){}
    public Star(String name, double mass, double radius, double effectiveTemperature, String pictureUrl) {
        super(name,radius,mass, pictureUrl);
        this.effectiveTemperature = effectiveTemperature;
    }
    @JsonIgnore
    public double getMsun(){

        return mass/MSUN;                       //Deler vanlig enhet på massen for å få Msun.
    }
    @JsonIgnore
    public double getRsun(){
                                                //Deler vanlig enhet(km) med rad(km) for å få Rsun.
        return radius/RSUN;
    }
    @Override
    public String toString() {
        return  super.toString() + " Temp: " + effectiveTemperature + "C" + ", PictureURL: " + getPictureUrl();                                //Overrider toString metoden slik at den viser relevant informasjon istede for hvor den befinner seg, type etc.


    }

    public double getEffectiveTemperature(){
        return  effectiveTemperature;
    }
    public void setEffectiveTemperature(double effectiveTemperature){
        this.effectiveTemperature = effectiveTemperature;
    }
}