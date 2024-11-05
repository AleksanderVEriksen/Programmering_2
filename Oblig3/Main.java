import java.util.ArrayList;

public class Main{

    public static void main(String[] args){
        ArrayList<Planet> planets = new ArrayList<>(8);             //Lager arraylist for planets og en for star som jeg kan legge inn i Solar system objectet under
        ArrayList<Star> stars = new ArrayList<>(1);                 // Maks 8 for planeter og 1 for stjernen

        PlanetSystem SolarSystem = new PlanetSystem("Solar System", stars,planets);    //stars og planets er Arraylistene.
        Star sun = new Star("Sun",695342,1.9885*Math.pow(10,30),5777);

        Planet Mercury = new Planet("Mercury", 3.283*Math.pow(10,23),2439.7,0.387,0.206,88,sun);
        Planet Venus = new Planet("Venus", 4.867*Math.pow(10,24),6051.8,0.723,0.007,225,sun);
        Planet Earth = new Planet("Earth", 5.972*Math.pow(10,24),6371,1,0.017,365,sun);
        Planet Mars = new Planet("Mars", 6.39*Math.pow(10,23),3389.5,1.524,0.093,687,sun);
        Planet Jupiter = new Planet("Jupiter", 1.898*Math.pow(10,27),69911,5.20440,0.049,4380,sun);                  //Oppgave 2.2
        Planet Saturn = new Planet("Saturn", 5.683*Math.pow(10,26),58232,9.5826,0.057,10585,sun);
        Planet Uranus = new Planet("Uranus", 8.681*Math.pow(10,25),25362,19.2184,0.046,30660,sun);
        Planet Neptune = new Planet("Neptune", 1.024*Math.pow(10,26),24622,30.11,0.010,60225,sun);


        planets.add(Mercury);
        planets.add(Venus);
        planets.add(Earth);                 // Legger da planet objektene og star objektene i sine ArrayListen, slik at de blir lagret i Planet system objectet "Solar system"
        planets.add(Mars);
        planets.add(Jupiter);              //Oppgave 2.2
        planets.add(Saturn);
        planets.add(Uranus);
        planets.add(Neptune);
        stars.add(sun);
        System.out.println(" ");
        System.out.println("--------------------------toString----------------------------------");
        System.out.println(SolarSystem.toString()); //Oppgave 2.3
        System.out.println(sun.toString());
        System.out.println(Jupiter.toString());
        System.out.println(Earth.toString());
        System.out.println(" ");
        System.out.println("---------------------------Mjup/Msun---------------------------------");
        System.out.println(Saturn.getName() + "\n" + Saturn.getMjup() + " Mjup" + "\n" + Saturn.getRjup() + " Rjup");   //Oppgave 2.4
        System.out.println(sun.getName() + "\n" + sun.getMsun() + " Msun" + "\n" + sun.getRsun() + " Rsun");            //Oppgave 2.4
        System.out.println(" ");
        System.out.println("---------------------------SurfaceGrav---------------------------------");
        System.out.println(Neptune.getName() + " " + "har en surfaceGravity på " + Neptune.surfaceGravity() + " g");   //Oppgave 2.5
        System.out.println(" ");
        System.out.println("----------------------------Størst/Minst--------------------------------");
        System.out.println(SolarSystem.getstorPlanet() + " er den største planeten i " + SolarSystem.getName());         //Oppgave 2.6
        System.out.println(SolarSystem.getlitenPlanet() + " er den minste planeten i " + SolarSystem.getName());       //Oppgave 2.6
        System.out.println(" ");
        System.out.println("-------------------------Mearth/Rearth-----------------------------------");
        System.out.println(Mars.getName() + " har en Mearth på " + Mars.Mearth() + " ME");
        System.out.println(Mars.getName() + " har en Rearth på " + Mars.Rearth() + " RE");      //Bonus oppgave 3.1s











        

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-----------------------OBLIG3------------------------------");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("---------------Finne Planet basert på navn----------------------");
        System.out.println(SolarSystem.getPlanetWithName("Earth"));                                // Sender String, Oppgave 2.2
        System.out.println("------------------------Earth distance to Sun at * degrees------------------------------------");
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBody(0) + "Km to the Sun at  0 degrees");
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBody(90) + "Km to the Sun at  90 degrees");    //Oppgave 2.5
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBody(180) + "Km to the Sun at  180 degrees");
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBody(270) + "Km to the Sun at  270 degrees");
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBody(360) + "Km to the Sun at  360 degrees");
        System.out.println("-----------------------Earth velocity at distance-------------------------------------");
        System.out.println("At a distance of " + Earth.distanceToCentralBody(0) + " km, Earth has a velocity of " + Earth.orbitingVelocity(0) + " km/s");
        System.out.println("At a distance of " + Earth.distanceToCentralBody(45) + " km, Earth has a velocity of " + Earth.orbitingVelocity(45) + " km/s");
        System.out.println("At a distance of " + Earth.distanceToCentralBody(90) + " km, Earth has a velocity of " + Earth.orbitingVelocity(90) + " km/s");   // oppgave 2.6
        System.out.println("At a distance of " + Earth.distanceToCentralBody(135) + " km, Earth has a velocity of " + Earth.orbitingVelocity(135) + " km/s");
        System.out.println("At a distance of " + Earth.distanceToCentralBody(180) + " km, Earth has a velocity of " + Earth.orbitingVelocity(180) + " km/s");
        System.out.println("--------------------Orbiting velocity in m/s-------------------------");
        System.out.println("At a distance of " + Earth.distanceToCentralBody(0) + " km, Earth has a velocity of " + Earth.orbitingVelocityInMs(0) + " m/s");
        System.out.println("At a distance of " + Earth.distanceToCentralBody(45) + " km, Earth has a velocity of " + Earth.orbitingVelocityInMs(45) + " m/s");
        System.out.println("At a distance of " + Earth.distanceToCentralBody(90) + " km, Earth has a velocity of " + Earth.orbitingVelocityInMs(90) + " m/s");  //Oppgave 3.1
        System.out.println("At a distance of " + Earth.distanceToCentralBody(135) + " km, Earth has a velocity of " + Earth.orbitingVelocityInMs(135) + " m/s");
        System.out.println("At a distance of " + Earth.distanceToCentralBody(0) + " km, Earth has a velocity of " + Earth.orbitingVelocityInMs(180) + " m/s");
        System.out.println("--------------------------Distance to central Body in radians--------------------------");
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBodytoRadians(0) + " km With radians as input");
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBodytoRadians(Math.PI/2) + " km With radians as input") ;
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBodytoRadians(Math.PI) + " km With radians as input");                     //Oppgave 3.2
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBodytoRadians((Math.PI*3)/2) + " km With radians as input");
        System.out.println("Earth has a distance of " + Earth.distanceToCentralBodytoRadians(Math.PI*2) + " km With radians as input");
    }

}
