package model;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import model.IUniverseRepository;
import model.PlanetSystem;
import model.UniverseRepository;
import io.javalin.Javalin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PlanetSystemController{
private UniverseRepository universeRepository;

    public PlanetSystemController(UniverseRepository unRepository){
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


