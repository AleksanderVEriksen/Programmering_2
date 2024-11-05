public class Star extends CelestialBody {
    private double effectiveTemp;
    private static final double MSUN = 1.98892*Math.pow(10,30);
    private static final double RSUN = 695700;

    public Star(String name, double radius, double mass, double effectiveTemp) {
        super(name,radius,mass);
        this.effectiveTemp = effectiveTemp;
    }
    public double getMsun(){

        return mass/MSUN;                       //Deler vanlig enhet på massen for å få Msun.
    }
    public double getRsun(){
                                                //Deler vanlig enhet(km) med rad(km) for å få Rsun.
        return radius/RSUN;
    }
    @Override
    public String toString() {
        return  super.toString() + " Temp: " + effectiveTemp + "C";                                //Overrider toString metoden slik at den viser relevant informasjon istede for hvor den befinner seg, type etc.


    }
    public double getEffectiveTemp(){
        return  effectiveTemp;
    }
    public void setEffectiveTemp(double effectiveTemp){
        this.effectiveTemp = effectiveTemp;
    }
}