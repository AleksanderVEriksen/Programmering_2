package Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Planet;
import model.PlanetSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UniverseJSONRepository implements IUniverseRepository {
        private String filnavn;
        public ArrayList<PlanetSystem> systemJSON = new ArrayList<>();


    public UniverseJSONRepository(String filnavn){
        this.filnavn = filnavn;
        lesJsonfil();
        skrivTilJson();

    }


        public void lesJsonfil() {

            ObjectMapper objectMapper = new ObjectMapper();

            try {
               PlanetSystem[] lesplanetSystem = objectMapper.readValue(new File(this.filnavn), PlanetSystem[].class);

                Collections.addAll(systemJSON, lesplanetSystem);


            }catch(JsonParseException | JsonMappingException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
            System.out.println("JSON: " + "\n" + systemJSON);
        }


    public void skrivTilJson(){
        File file = new File("skriv_PlanetSystems_Til_JSON.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,systemJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {

        return new ArrayList<>(systemJSON);
    }

    @Override
    public PlanetSystem getOneSpecificPlanetSystem(String Planetsystem_name) {

        for (PlanetSystem etPlanetsystem: systemJSON) {

            if(etPlanetsystem.getName().equals(Planetsystem_name)) {
                return etPlanetsystem;
            }
        }
        return null;


    }

    @Override
    public ArrayList<Planet> getAllPlanets(String planetsystemname) {


        return getOneSpecificPlanetSystem(planetsystemname).getPlanets();


    }

    @Override
    public Planet getOneSpecificPlanet(String system,String Planet_navn) {


        return getOneSpecificPlanetSystem(system).getPlanetWithName(Planet_navn);
    }

    @Override
    public Planet makePlanet(String planetsystem, String name, String mass, String radius, String semiMajorAxis, String eccen, String orbitalP, String pictureurl) {
        return null;
    }

    @Override
    public void UpdatePlanet(String planetsystem,String name, String mass, String radius, String semiMajorAxis, String eccen, String orbitalP, String pictureurl) {

    }

    @Override
    public void DeletePlanet(String planetsystem,String planetnavn) {

    }

    public String getFilnavn() {
        return filnavn;
    }

    public void setFilnavn(String filnavn) {
        this.filnavn = filnavn;
    }
}
