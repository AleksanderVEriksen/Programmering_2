import java.util.ArrayList;

public class PlanetSystem {
    private String name;
    private ArrayList<Star> centerStar;         //Instanse variabler
    private ArrayList<Planet> planets;

    public PlanetSystem(String name, ArrayList<Star> centerStar,ArrayList<Planet> planets) {  //Konstruktør med instansevariablene som argument
        this.name = name;
        this.centerStar = centerStar;
        this.planets = planets;
    }
public String Planet(String planetNavn){
        String s = "Planeten finnes ikke";
        for(Planet planet : planets){
           // System.out.println("X: " + x + ", Planet name: " + planet.name);
            if(planetNavn.equals(planet.name)){

                return planet.toString();
            }
        }
        return s;
}
public String getstorPlanet(){
        double highRad = 0;    // Variabel for masse og rad, som vi lagrer i loopen
        double highMass = 0;
        String stor = "haha";
    for (Planet planet : planets) {         // Itterer gjennom hele planet array-lista.
        // System.out.println("Før: " + stor);
        if (planet.getRadius() > highRad) {       // Om radiusen til den planeten vi er på er høyere en variabelen highrad
            stor = planet.getName();               // skal Stringen stor få navnet på planeten vi er på
            highRad = planet.getRadius();            // highrad skal få radiusen
            highMass = planet.getMass();             // highMass skal få massen
            //System.out.println("Etter: " + stor );
        }
        if (planet.getRadius() == highRad) {        // Om en planet har samme radius som highrad
            if (planet.getMass() > highMass) {        // skal massen til planeten sammenliknes
                stor = planet.getName();            // om massen er større, oppdateres Stringen stor sitt navn, og highMass sin verdi.
                highMass = planet.getMass();
                // System.out.println("Rad er lik rad: " + stor);
            }
        }
    }
        return stor;
    //System.out.println(stor + " er den største planeten i " + name);    //Etter loopen printes planeten som er størst
    }


    public String getlitenPlanet(){
        double lowRad = 10*Math.pow(10,23);
        double lowMass = 10*Math.pow(10,23);  // Motsatt av det over, her finner vi den minste planeten
        String liten = "haha";                // variablene er satt høye for at de skal oppdatere med en gang den første planeten kommer opp.
        for (Planet planet : planets) {
            // System.out.println("Før: " + stor);
            if (planet.getRadius() < lowRad) {
                // System.out.println(planets.get(i).getName() + " " + planets.get(i).getRadius() + " VS " + highRad );
                liten = planet.getName();
                lowRad = planet.getRadius();
                lowMass = planet.getMass();
                //System.out.println("Etter: " + stor );
            }
            if (planet.getRadius() == lowRad) {
                if (planet.getMass() < lowMass) {
                    liten = planet.getName();
                    lowMass = planet.getMass();
                    // System.out.println("Rad er lik rad: " + stor);
                }
            }
        }
        return liten;
    }
   @Override
    public String toString() {
        return name + "\n" +
                "Stjerne: " + centerStar + "\n"   //Overrider toString metoden slik at den viser relevant informasjon istede for hvor den befinner seg, type etc.
                + "Planeter:" + planets + "\n";  // Uten dette hadde vi fått det her : PlanetSystem@3feba861
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;                                          //Innkapsling
    }

    public void setCntrS(ArrayList<Star> centerStar) {
        this.centerStar = centerStar;
    }

    public ArrayList<Star> getCntrS() {
        return centerStar;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }


}
