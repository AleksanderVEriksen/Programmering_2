package controllers;

import Repository.UniverseCSVRepository;
import Repository.UniverseJSONRepository;
import io.javalin.http.Context;
import model.Planet;
import Repository.UniverseRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlanetController {
    private UniverseCSVRepository PlanetRespository;

    public PlanetController(UniverseCSVRepository PlanetRespository) {
        this.PlanetRespository = PlanetRespository;
    }


    public void getAllPlanets(Context context) {                          //app.get(<din path>, <handler-interface>);
        String sortering = context.queryParam("sort_by");
        String systemnavn = context.pathParam(":planet-system-id");


        ArrayList<Planet> allplanets = PlanetRespository.getAllPlanets(systemnavn);
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
        }
        context.json(allplanets);
    }

        public void getSpecificPlanet (Context context){

            String planetNavn = context.pathParam(":planet-id");
            String systemnavn = context.pathParam(":planet-system-id");

            context.json(PlanetRespository.getOneSpecificPlanet(systemnavn,planetNavn));

        }


        public void Delete(Context context){

            String planetnavn = context.pathParam(":planet-id");
            String systemnavn = context.pathParam(":planet-system-id");
            PlanetRespository.DeletePlanet(systemnavn,planetnavn);

            String redir = "/planet-systems/" +  systemnavn;
            context.redirect(redir);

        }
        public void CreatePlanet(Context context){
            String systemnavn = context.pathParam(":planet-system-id");
            PlanetRespository.makePlanet(
                    systemnavn,
                    context.formParam("name"),
                    context.formParam("radius"),
                    context.formParam("mass"),
                    context.formParam("semiMajorAxis"),
                    context.formParam("eccentricity"),
                    context.formParam("orbitalPeriod"),
                    context.formParam("pictureUrl")
            );
        String redir = "/planet-systems/" + systemnavn
                + "/planets/" + context.formParam("name");
            context.redirect(redir);
        }
        public void updatePlanet(Context context){
            String systemnavn = context.pathParam(":planet-system-id");
            PlanetRespository.UpdatePlanet(
                    systemnavn,
                    context.formParam("name"),
                    context.formParam("radius"),
                    context.formParam("mass"),
                    context.formParam("semiMajorAxis"),
                    context.formParam("eccentricity"),
                    context.formParam("orbitalPeriod"),
                    context.formParam("pictureUrl")
            );
            String redir = "/planet-systems/" + systemnavn
            + "/planets/" + context.formParam("name");
            context.redirect(redir);

        }


    }

