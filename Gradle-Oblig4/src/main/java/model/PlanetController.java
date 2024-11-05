package model;

import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PlanetController {
    private UniverseRepository PlanetRespository;

    public PlanetController(UniverseRepository PlanetRespository) {
        this.PlanetRespository = PlanetRespository;
    }


    public void getAllPlanets(Context context) {                          //app.get(<din path>, <handler-interface>);
        String sortering = context.queryParam("sort_by");


        ArrayList<Planet> allplanets = PlanetRespository.getAllPlanets();


        if (sortering != null) {
            switch (sortering) {
                case "name":
                    Collections.sort(allplanets);
                    break;
                case "mass":
                    allplanets.sort(new Comparator<Planet>() {
                        @Override
                        public int compare(Planet o1, Planet o2) {
                            return (int) (o1.getMass() - o2.getMass());
                        }

                    });
                    break;
                case "radius":
                    allplanets.sort(new Comparator<Planet>() {
                        @Override
                        public int compare(Planet o1, Planet o2) {
                            return (int) (o1.getRadius() - o2.getRadius());
                        }
                    });
                    break;


            }
        }// app.get("api/planet-systems ", );
        context.json(allplanets);
    }

        public void getSpecificPlanet (Context context){

            // app.get("api/planet-systems/:planet-system-id", );
            String planetNavn = context.pathParam("planet-id");

            context.json(PlanetRespository.getOneSpecificPlanet(planetNavn));
        }


    }

