import Repository.UniverseCSVRepository;
import model.PlanetSystem;
import Repository.UniverseJSONRepository;
import controllers.PlanetSystemController;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import controllers.PlanetController;
import Repository.UniverseRepository;

import java.util.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {


        // ---------- Leser 100 planeter fra json fil ---------- //
        System.out.println("*--------------------------------------------------*100 Planeter fra json fil*---------------------------------------------------");

        UniverseJSONRepository JSONKILDE = new UniverseJSONRepository("planets_100.json");
        JSONKILDE.lesJsonfil();
        //System.out.println("Spesifikk system: " + JSONKILDE.getOneSpecificPlanetSystem("Solar System"));                // -- Nice -- //
        //System.out.println("Spesifikk planet: " + JSONKILDE.getOneSpecificPlanet("Solar System","Earth"));              // -- Nice -- //
        //System.out.println("Alle planeter: " + JSONKILDE.getAllPlanets("Solar System"));                                // -- Nice -- //
        //System.out.println("Spesifikk planet:" + JSONKILDE.getOneSpecificPlanet("Solar System","Saturn"));              // -- Nice -- //
        soutPrint();

        // ---------- Leser 100 planeter fra CSV fil ---------- //
        System.out.println("*--------------------------------------------------*100 Planeter fra CSV fil*---------------------------------------------------");
       UniverseCSVRepository CSVKILDE = new UniverseCSVRepository("planets_100.csv");
        CSVKILDE.lesCSV();
          //System.out.println(CSVKILDE.getOneSpecificPlanetSystem("Solar System"));            // -- Nice -- //
       //System.out.println(CSVKILDE.getAllPlanetSystems());                                    // -- Nice -- //
         // System.out.println(CSVKILDE.getAllPlanets("Solar System"));                         // -- Nice -- //
         //S ystem.out.println(CSVKILDE.getOneSpecificPlanet("Solar System","Neptune"));        // -- Nice -- //



        PlanetSystemController planetSystemController = new PlanetSystemController(CSVKILDE);
        PlanetController planetController = new PlanetController(CSVKILDE);





        Javalin app = Javalin.create().start();
        app.config.enableWebjars();

        app.get("/", ctx -> ctx.result("Hello World"));                                                                 //app.get(<din path>, <handler-interface>);


                                                                                                                                 //Views
        app.get("/planet-systems", new VueComponent("planet-system-overview"));                                     // overview: Alle PlanetSystemene
        app.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));                     // detail: spesifikk PlanetSystem
        app.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));            //Planet detaljer for en spesifikk planet
        app.get("/planet-systems/:planet-system-id/planets/:planet-id/update",new VueComponent("planet-update"));
        app.get("/planet-systems/:planet-system-id/createplanet", new VueComponent("planet-create"));


                                                                                                                    // Api pathsene
        app.get("/api/planet-systems", planetSystemController::getAllPlanetSystems);
        app.get("/api/planet-systems/:planet-system-id", planetSystemController::getSpecificPlanetSystem);     // Path først, så hva planet/planetsystem controlleren skal hente
        app.get("/api/planet-systems/:planet-system-id/planets", planetController::getAllPlanets);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id", planetController::getSpecificPlanet);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id/delete", planetController::Delete);
        app.post("/api/planet-systems/:planet-system-id/createplanet", planetController::CreatePlanet);
        app.post("/api/planet-systems/:planet-system-id/planets/:planet-id/update",planetController::updatePlanet);


    }

    private static void soutPrint() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

    }
}
