public class Star extends CelestialBody {
    private float effectiveTemp;
    private static final double Msun = 1.98892*Math.pow(10,30);
    private static final double Rsun = 695700;

    public Star(String name, double radius, double mass, float effectiveTemp) {
        super(name,radius,mass);
        this.effectiveTemp = effectiveTemp;
    }
    public double getMsun(){

        return mass/Msun;                       //Deler vanlig enhet på massen for å få Msun.
    }
    public double getRsun(){
                                                //Deler vanlig enhet(km) med rad(km) for å få Rsun.
        return radius/Rsun;
    }
    @Override
    public String toString() {
        return "Name: " + name + " " +
               "Radius: " + radius + "km" + " " +    //Overrider toString metoden slik at den viser relevant informasjon istede for hvor den befinner seg, type etc.
               "Mass: " + mass + "kg" + " " +
                "Temp: " + effectiveTemp + "C";
    }
}