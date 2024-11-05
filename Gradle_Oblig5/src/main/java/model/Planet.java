package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.Date;
/*@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Planet.class, name = "Planet")

})*/

public class Planet extends NaturalSatellite{
      private static final double MTH = 5.972*Math.pow(10,24);
      private static final double RTH = 6371;
      private static final double MJUP = 1.898*Math.pow(10,27);
      private static final double RJUP = 71492;
public Planet(){}
public Planet(String name, double mass, double radius , double semiMajorAxis, double eccentricity, double orbitalPeriod, Star centralCelestialBody, String pictureUrl){
        super(name, radius, mass, semiMajorAxis, eccentricity, orbitalPeriod, centralCelestialBody, pictureUrl);
        }
    @JsonIgnore
public double Mearth(){
        return super.mass/MTH;
}
    @JsonIgnore
public double Rearth(){ return super.radius/RTH;}

@Override
public String toString(){
        return super.toString();
        }
    @JsonIgnore
        public double getMjup(){ return super.mass/MJUP; }          //massen som er lagret i CelestialBody(protected)
    @JsonIgnore
        public double getRjup(){ return super.radius/RJUP; }
    @JsonIgnore
public double  surfaceGravity(){
        double  g = 0.00000000006674;
        double convRad = super.radius*1000;     //Konvertere radius til meter
        return (g*super.mass)/Math.pow(convRad,2); //g ganger massen delt på convRad^2
}

}
