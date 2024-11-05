package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Star.class, name = "star"),
        @JsonSubTypes.Type(value = Planet.class, name = "Planet")

})
public abstract class CelestialBody implements Comparable<CelestialBody> {
    protected String name;
    protected double radius;
    protected double mass;
    private String pictureUrl;
    public CelestialBody(){}
    public CelestialBody(String name, double mass, double radius, String pictureUrl){
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.pictureUrl = pictureUrl;
    }
    @Override
    public int compareTo(CelestialBody other) {
        return this.getName().compareTo(other.getName());
    }
    @Override
    public String toString(){
        return System.lineSeparator() + "Name: " + name +  ", Mass: " + mass + "Kg, Radius: " + radius + "Km,";
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setMass(double mass){
        this.mass = mass;
    }
    public double getMass(){
        return mass;
    }
    public void setRad(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
