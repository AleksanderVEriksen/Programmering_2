package Repository;

import model.Planet;
import model.PlanetSystem;

import java.util.ArrayList;

public interface IUniverseRepository {                    //metodene som er aktuelle for uthenting av data defineres
    ArrayList<PlanetSystem> getAllPlanetSystems();
    PlanetSystem getOneSpecificPlanetSystem(String Planetsystem_name);

    ArrayList<Planet> getAllPlanets(String name);
    Planet getOneSpecificPlanet(String system,String Planet_navn);



    Planet makePlanet(String planetsystem, String name, String mass, String radius, String semiMajorAxis, String eccen,String orbitalP, String pictureurl);
    void UpdatePlanet(String planetsystem,String name, String mass, String radius, String semiMajorAxis, String eccen,String orbitalP, String pictureurl);
    void DeletePlanet(String planetsystem, String planetNavn);
}
                                                       // Definer get-metoder i interfacet og lag selve implementasjonen i klassen (vi skal utvide med flere metoder her senere):
                                                                 //Hente alle planetsystemer
                                                                // Hente ett spesifikt planetsystem
