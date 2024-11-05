public abstract class CelestialBody {
    protected String name;
    protected double radius;
    protected double mass;
    public CelestialBody(String name, double radius, double mass){
        this.name = name;
        this.radius = radius;
        this.mass = mass;
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
}
