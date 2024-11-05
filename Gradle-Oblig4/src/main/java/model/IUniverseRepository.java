package model;

import java.util.ArrayList;

public interface IUniverseRepository {                    //metodene som er aktuelle for uthenting av data defineres
    ArrayList<PlanetSystem> getAllPlanetSystems();
    PlanetSystem getOneSpecificPlanetSystem(String Planetsystem_name);

    ArrayList<Planet> getAllPlanets();
    Planet getOneSpecificPlanet(String Planet_navn);
}
                                                       // Definer get-metoder i interfacet og lag selve implementasjonen i klassen (vi skal utvide med flere metoder her senere):
                                                                 //Hente alle planetsystemer
                                                                // Hente ett spesifikt planetsystem
