import java.util.Date;

class Planet extends NaturalSatellite{
      private static final double mth = 5.972*Math.pow(10,24);
      private static final double rth = 6371;
      private static final double Mjup = 1.898*Math.pow(10,27);
      private static final double Rjup = 71492;

public Planet(String name, double mass, double radius, double semiMajorAxis, double eccentricity, int orbitalPeriod){
        super(name,radius,mass,semiMajorAxis,eccentricity,orbitalPeriod);
        }

public double Mearth(){
        return super.mass/mth;
}

public double Rearth(){ return super.radius/rth;}

@Override
public String toString(){
        return "Name: " + super.name + " " +
                "Radius: " + super.radius + "km" + " " +    //Overrider toString metoden slik at den viser relevant informasjon istede for hvor den befinner seg, type etc.
                "Mass: " + super.mass + "kg";
        }

        public double getMjup(){ return super.mass/Mjup; }

        public double getRjup(){ return super.radius/Rjup; }

public double  surfaceGravity(){
        double  g = 0.00000000006674;
        double convRad = super.radius*1000;     //Konvertere radius til meter
        return (g*super.mass)/Math.pow(convRad,2); //g ganger massen delt på convRad^2
}

}
