package model;

public abstract class CelestialBody implements Comparable<CelestialBody> {
    protected String name;
    protected double radius;
    protected double mass;
    private String pictureUrl;
    public CelestialBody(String name, double radius, double mass, String pictureUrl){
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
        return System.lineSeparator() + "Name: " + name + ", Radius: " + radius + "Km, Mass: " + mass + "Kg,";
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setRad(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setMass(double mass){
        this.mass = mass;
    }
    public double getMass(){
        return mass;
    }
    public String getPictureUrl() {
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
