package model;

import java.util.ArrayList;

public class UniverseRepository implements IUniverseRepository {           //som implementerer interfacet
    public ArrayList<PlanetSystem> planetSystems = new ArrayList<>();
    public ArrayList<Planet> planets = new ArrayList<>();

    public UniverseRepository(){

        Star sun = new Star("Sun",695342,1.9885*Math.pow(10,30),5777,"https://upload.wikimedia.org/wikipedia/commons/c/c3/Solar_sys8.jpg");

        Planet Mercury = new Planet("Mercury", 3.283*Math.pow(10,23),2439.7,0.387,0.206,88,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Transit_Of_Mercury%2C_May_9th%2C_2016.png/480px-Transit_Of_Mercury%2C_May_9th%2C_2016.png");
        Planet Venus = new Planet("Venus", 4.867*Math.pow(10,24),6051.8,0.723,0.007,225,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/SDO%27s_Ultra-high_Definition_View_of_2012_Venus_Transit_%28304_Angstrom_Full_Disc_02%29.jpg/480px-SDO%27s_Ultra-high_Definition_View_of_2012_Venus_Transit_%28304_Angstrom_Full_Disc_02%29.jpg");
        Planet Earth = new Planet("Earth", 5.972*Math.pow(10,24),6371,1,0.017,365,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/NASA_Earth_America_2002.jpg/480px-NASA_Earth_America_2002.jpg");
        Planet Mars = new Planet("Mars", 6.39*Math.pow(10,23),3389.5,1.524,0.093,687,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Mars_23_aug_2003_hubble.jpg/480px-Mars_23_aug_2003_hubble.jpg");
        Planet Jupiter = new Planet("Jupiter", 1.898*Math.pow(10,27),69911,5.20440,0.049,4380,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Jupiter_and_its_shrunken_Great_Red_Spot.jpg/480px-Jupiter_and_its_shrunken_Great_Red_Spot.jpg");
        Planet Saturn = new Planet("Saturn", 5.683*Math.pow(10,26),58232,9.5826,0.057,10585,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Saturn_from_Cassini_Orbiter_-_Square_%282004-10-06%29.jpg/480px-Saturn_from_Cassini_Orbiter_-_Square_%282004-10-06%29.jpg");
        Planet Uranus = new Planet("Uranus", 8.681*Math.pow(10,25),25362,19.2184,0.046,30660,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Uranus2.jpg/480px-Uranus2.jpg");
        Planet Neptune = new Planet("Neptune", 1.024*Math.pow(10,26),24622,30.11,0.010,60225,sun,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Neptune_Full_%28cropped%29.jpg/480px-Neptune_Full_%28cropped%29.jpg");

        planets.add(Mercury);
        planets.add(Venus);
        planets.add(Earth);
        planets.add(Mars);
        planets.add(Jupiter);
        planets.add(Saturn);
        planets.add(Uranus);
        planets.add(Neptune);


        PlanetSystem SolarSystem = new PlanetSystem("Solar System", sun, planets,"http://actualinfo.website/wp-content/uploads/2016/05/72b3ca0b9ae88c1dd21f4b830c13093b.jpg");    //planets er en Arrayliste
        planetSystems.add(SolarSystem);


        /*Star Kepler11 = new Star("Kepler-11",1.889E30,710310,5680,"https://upload.wikimedia.org/wikipedia/commons/6/64/Kepler11.png");

        Planet Kepler11b = new Planet("Kepler-11b",2.56796E25 ,12550 ,1.36134E7 ,0.045,10 ,Kepler11,"");
        Planet Kepler11c = new Planet("Kepler-11c",8.0622E25 ,20068 ,1.5857E7 ,0.026 ,13 ,Kepler11 , "");
        Planet Kepler11d = new Planet("Kepler-11d",3.64292E25,21852 ,2.3786E7 , 0.004,22 ,Kepler11 , "");
        Planet Kepler11e = new Planet("Kepler-11e",5.01648E25,28796 ,2.9021E7 , 0.012,31 ,Kepler11 , "");
        Planet Kepler11f = new Planet("Kepler-11f",1.37356E25 ,16628 ,3.7399E7 , 0.013,36 ,Kepler11 , "");
        Planet Kepler11g = new Planet("Kepler-11g",1.7916E27,23317 ,6.9114E7 ,0.015 ,118 ,Kepler11 , "");

        planets.add(Kepler11b);
        planets.add(Kepler11c);
        planets.add(Kepler11d);
        planets.add(Kepler11e);
        planets.add(Kepler11f);
        planets.add(Kepler11g);

        PlanetSystem Kepler11System = new PlanetSystem("Kepler-11 System",Kepler11,planets,"http://planets.ucla.edu/wp-content/uploads/2011/12/rp-kepler11.jpg");

        planetSystems.add(Kepler11System);
        */








    }

    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {

            return new ArrayList<>(planetSystems);

    }

    @Override
    public PlanetSystem getOneSpecificPlanetSystem(String PlanetSystem_name) {
        for (PlanetSystem etPlanetsystem: planetSystems) {
            if(etPlanetsystem.getName().equals(PlanetSystem_name)) {
                return etPlanetsystem;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Planet> getAllPlanets() {
        return new ArrayList<>(planets);
    }

    @Override
    public Planet getOneSpecificPlanet(String Planet_navn) {
        for (Planet enPlanet: planets) {
            if(enPlanet.getName().equals(Planet_navn)) {
                return enPlanet;
            }
        }
        return null;
    }
}
