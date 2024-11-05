package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;

public abstract class NaturalSatellite extends CelestialBody {
    private double semiMajorAxis;
    private double eccentricity;
    private double orbitalPeriod;
    private Star centralCelestialBody;
    private static final int AU = 149597871;
    public NaturalSatellite(){}
    public NaturalSatellite(String name, double radius, double mass, double semiMajorAxis, double eccentricity, double orbitalPeriod, Star centralCelestialBody, String pictureUrl) {
        super(name, radius, mass, pictureUrl);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
        this.centralCelestialBody = centralCelestialBody;
    }
 @Override
 public String toString(){
        return  super.toString() + " SemiMajorAxis: " + semiMajorAxis + ", Eccentricity: " + eccentricity + ", OrbitalPeriod: " + orbitalPeriod + ", PictureURL: " + getPictureUrl();
 }
    @JsonIgnore
  public int distanceToCentralBody(double degrees){
            double rad = Math.toRadians(degrees);                // får inn et tall som argument
            double a = semiMajorAxis;                            // Blir gjort om til radianer
            double e = eccentricity;
            double r = (a*(1-Math.pow(e,2)))/(1+e*Math.cos(rad));    // Formel der radianene blir gjort til cos

            return (int) (r*AU);                             //Returnere svar i int
 }
    @JsonIgnore
 public int distanceToCentralBodytoRadians(double radians) {
        double rad = Math.toDegrees(radians);                     // Radianer som argument, gjør om radian inputen til grader, for så å sende den gjennom distanceToCentralBody
        return (int)(distanceToCentralBody(rad));                 // Gjør return til int slik at den
    }

    @JsonIgnore
    public double orbitingVelocity(double distance){
        double v;                  //hastigheten i m/s
        final double G = 0.00000000006674;    //Gravitational constant
        double M = centralCelestialBody.getMass();       //massen til "central body", altså objektet den naturlige satelitten sirkler rundt
        double  r = distanceToCentralBody(distance)*Math.pow(10,3);                                      //avstanden i meter
        v = (Math.sqrt((G*M)/r))/1000;                    //Returnere i km/s
        //System.out.println( G + " " + M + " " + r + " " + distance + " " + Math.sqrt((G*M)/r) + " " + conVert);
        return v;
    }

    @JsonIgnore
    public  int orbitingVelocityInMs(double degrees){
        return (int)(orbitingVelocity(degrees)*1000);
    }

    public double getSemiMajorAxis(){ return semiMajorAxis;}
public double getEccentricity(){ return eccentricity;}
public double getOrbitalPeriod(){ return orbitalPeriod;}
public Star getCentralCelestialBody(){ return centralCelestialBody;}

public void setSemiMajorAxis(double semiMajorAxis){ this.semiMajorAxis = semiMajorAxis;}
public void setEccentricity(double eccentricity){this.eccentricity = eccentricity;}
public void setOrbitalPeriod(double orbitalPeriod){this.orbitalPeriod = orbitalPeriod;}
public void setCentralCelestialBody(Star centralCelestialBody){this.centralCelestialBody = centralCelestialBody;}
}
