package controllers;

import Repository.UniverseCSVRepository;
import Repository.UniverseJSONRepository;
import io.javalin.http.Context;
import Repository.UniverseRepository;

public class PlanetSystemController{
private UniverseCSVRepository universeRepository;

    public PlanetSystemController(UniverseCSVRepository unRepository){
        this.universeRepository = unRepository;
    }

    public void getAllPlanetSystems(Context context){                          //app.get(<din path>, <handler-interface>);

        context.json(universeRepository.getAllPlanetSystems());

        }                                       // app.get("api/planet-systems ", );



    public void getSpecificPlanetSystem(Context context){

                                                                                // app.get("api/planet-systems/:planet-system-id", );
        String planetSystemNavn = context.pathParam("planet-system-id");

        context.json(universeRepository.getOneSpecificPlanetSystem(planetSystemNavn));

    }




    }


