import java.util.Date;

public class NaturalSatellite extends CelestialBody {
    public double semiMajorAxis;
    public double eccentricity = Math.random();
    private int orbitalPeriod;
    private String centralCelestialBody;

    public NaturalSatellite(String name, double radius, double mass, double semiMajorAxis, double eccentricity, int orbitalPeriod) {
        super(name, radius, mass);
        this.semiMajorAxis = semiMajorAxis;
        this.eccentricity = eccentricity;
        this.orbitalPeriod = orbitalPeriod;
    }

    public double getSemiMajorAxis(){ return semiMajorAxis;}
public double getEccentricity(){ return eccentricity;}
public int getOrbitalPeriod(){ return orbitalPeriod;}
public String getCentralCelestialBody(){ return centralCelestialBody;}

public void setSemiMajorAxis(double semiMajorAxis){ this.semiMajorAxis = semiMajorAxis;}
public void setEccentricity(double eccentricity){this.eccentricity = eccentricity;}
public void setOrbitalPeriod(int orbitalPeriod){this.orbitalPeriod = orbitalPeriod;}
public void setCentralCelestialBody(String centralCelestialBody){this.centralCelestialBody = centralCelestialBody;}
}
