package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class PlanetSystem {
    private String name;
    private Star centerStar;         //Instanse variabler
    private ArrayList<Planet> planets = new ArrayList<>();
    private String pictureUrl;
    public PlanetSystem(){};
    public PlanetSystem(String name, Star centerStar, String pictureUrl) {
        this.name = name;
        this.centerStar = centerStar;
        this.pictureUrl = pictureUrl;
    }

    public PlanetSystem(String name, Star centerStar, ArrayList<Planet> planets, String pictureUrl) {  //Konstruktør med instansevariablene som argument
        this.name = name;
        this.centerStar = centerStar;
        this.planets = planets;
        this.pictureUrl = pictureUrl;
    }



    @JsonIgnore
public Planet getPlanetWithName(String planetNavn){
        for(Planet planet : planets){
           // System.out.println("X: " + x + ", Planet name: " + planet.name);   //Går gjennom planet arrayet der alle planetene er lagret
            if(planet.getName().equals(planetNavn)){                                  // Sjekker om Stringen er lik navnet på planetene i Array listen

                return planet;                                         // Returnere planeten med det navnet og bruker toString() metoden for å få mer informasjon
            }
        }
        return null;                                                          //Om Stringen ikke er lik navnene i Array listen, så returnerer String s="Planeten finnes ikke"
}
    @JsonIgnore
public Planet getstorPlanet(){
    if (planets.size() == 0)
        return null;

    Planet largestPlanet = planets.get(0);

    for (Planet currentPlanet : planets) {
        if (currentPlanet.getRadius() > largestPlanet.getRadius()) {
            largestPlanet = currentPlanet;
        }
        else if (currentPlanet.getRadius() == largestPlanet.getRadius()) {
            if (currentPlanet.getMass() > largestPlanet.getMass())
                largestPlanet = currentPlanet;
        }
    }

    return largestPlanet;
    }

    @JsonIgnore
    public Planet getlitenPlanet() {
        if (planets.size() == 0)
            return null;

        Planet smallestPlanet = planets.get(0);

        for (Planet currentPlanet : planets) {
            if (currentPlanet.getRadius() < smallestPlanet.getRadius()) {
                smallestPlanet = currentPlanet;
            }
            else if (currentPlanet.getRadius() == smallestPlanet.getRadius()) {
                if (currentPlanet.getMass() < smallestPlanet.getMass())
                    smallestPlanet = currentPlanet;
            }
        }

        return smallestPlanet;
    }
   @Override
    public String toString() {
        return name + "\n" +
                "Stjerne: " + centerStar + "\n"   //Overrider toString metoden slik at den viser relevant informasjon istede for hvor den befinner seg, type etc.
                + "Planeter: " + planets + "\n" + "PictureURL: " + getPictureUrl();  // Uten dette hadde vi fått det her : PlanetSystem@3feba861
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;                                          //Innkapsling
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setPlanetInPlanetsystem(ArrayList<Planet> planets) {
        this.planets = planets;
    }
    public ArrayList<Planet> getPlanets(){return planets;}

    public String getPictureUrl() {
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    public void addPlanet(Planet navn){planets.add(navn);}
}
