import io.javalin.http.Context;
import io.javalin.http.Handler;
import model.PlanetSystemController;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import model.PlanetController;
import model.UniverseRepository;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) {
        UniverseRepository universeRepository = new UniverseRepository();
        PlanetSystemController planetSystemController = new PlanetSystemController(universeRepository);
        PlanetController planetController = new PlanetController(universeRepository);


        Javalin app = Javalin.create().start();
        app.config.enableWebjars();

        app.get("/", ctx -> ctx.result("Hello World"));                                                                 //app.get(<din path>, <handler-interface>);


                                                                                                                                 //Views
        app.get("/planet-systems", new VueComponent("planet-system-overview"));                                     // overview: Alle PlanetSystemene
        app.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));                     // detail: spesifikk PlanetSystem
        app.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));           //Planet detaljer for en spesifikk planet


                                                                                                                    // Api pathsene
        app.get("/api/planet-systems", planetSystemController::getAllPlanetSystems);
        app.get("/api/planet-systems/:planet-system-id", planetSystemController::getSpecificPlanetSystem);     // Path først, så hva planet/planetsystem controlleren skal hente
        app.get("/api/planet-systems/:planet-system-id/planets", planetController::getAllPlanets);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id", planetController::getSpecificPlanet);



    }
}
