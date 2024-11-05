package Repository;

import model.Planet;
import model.PlanetSystem;
import model.Star;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UniverseCSVRepository extends Thread implements IUniverseRepository {
   public HashMap<String, PlanetSystem> planetSystemOversikt = new HashMap<>();

   private String filnavn;


    public UniverseCSVRepository(String filnavn){
        this.filnavn = filnavn;
        lesCSV();
        skrivCSV();

    }




    public void lesCSV() {


        try (BufferedReader buffleser = new BufferedReader(new FileReader(this.filnavn))){

            String linje;



            while((linje = buffleser.readLine()) != null){
                String[] deler = linje.split(",");
                Star centerStar;//, = new Star(deler[2]Double.parseDouble(deler[3]), Double.parseDouble(deler[4]), Double.parseDouble(deler[5]), deler[6]);

                PlanetSystem planetsystem;


                if (planetSystemOversikt.containsKey(deler[0])){
                    planetsystem = planetSystemOversikt.get(deler[0]);
                    centerStar = planetsystem.getCenterStar();

                }
                else{
                    centerStar = new Star(deler[2],Double.parseDouble(deler[3]), Double.parseDouble(deler[4]), Double.parseDouble(deler[5]), deler[6]);
                    planetsystem = new PlanetSystem(deler[0], centerStar, deler[1]);
                }
                Planet enplanet = new Planet(deler[7], Double.parseDouble(deler[8]), Double.parseDouble(deler[9]), Double.parseDouble(deler[10]), Double.parseDouble(deler[11]), Double.parseDouble(deler[12]), centerStar, deler[13]);
                planetsystem.addPlanet(enplanet);



                    planetSystemOversikt.put(deler[0],planetsystem );



            }

        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

       // System.out.println(planetSystemOversikt);


    }
    public void skrivCSV() {


        try (BufferedWriter bufretSkriver = new BufferedWriter(new FileWriter("skriv_PlanetSystem_Til_CSV.csv"))) {

            String separator = ",";


          //System.out.println(planetSystemOversikt.values());
          //System.out.println(planetSystemOversikt.keySet());
            for(PlanetSystem etplanetsystem : planetSystemOversikt.values()) {
                int key=0;
               // System.out.println(etplanetsystem);

                bufretSkriver.write( etplanetsystem.getName()  + separator + etplanetsystem.getPictureUrl() + separator + "\n" + etplanetsystem.getCenterStar() +
                        separator +  etplanetsystem.getPlanets() + "\n");
                // Skriver et linjeskift

                bufretSkriver.newLine();




            }
        } catch (FileNotFoundException fnfe) {
            // Skriver ut feilmelding om filen ikke finnes
            System.out.println(fnfe.getMessage());
        } catch (IOException ioexc) {
            // skriver ut feilmelding om det oppstår feil ved skriving til fil
            System.out.println(ioexc.getLocalizedMessage());
        }

    }

    @Override
    public ArrayList<PlanetSystem> getAllPlanetSystems() {

        return new ArrayList<>(planetSystemOversikt.values());


    }

    @Override
    public PlanetSystem getOneSpecificPlanetSystem(String Planetsystem_name) {

        return planetSystemOversikt.get(Planetsystem_name);
    }

    @Override
    public ArrayList<Planet> getAllPlanets(String PlanetSystem) {

            return getOneSpecificPlanetSystem(PlanetSystem).getPlanets();
        }

    @Override
    public Planet getOneSpecificPlanet(String planetsystem,String Planet_navn) {

        for ( PlanetSystem enPlanet : planetSystemOversikt.values()) {
           //System.out.println(enPlanet);
            if(planetSystemOversikt.get(planetsystem).getPlanetWithName(Planet_navn)!=null) {
                return planetSystemOversikt.get(planetsystem).getPlanetWithName(Planet_navn);
            }

        }
        return null;
        /*ArrayList<Planet> planets = this.getAllPlanets(planetsystem);
        for (Planet p : planets) {
            if (p.getName().equalsIgnoreCase(Planet_navn)) {
                return p;
            }
        }
        return null;*/

        //return getOneSpecificPlanetSystem(planetsystem).getPlanetWithName(Planet_navn);


    }

    @Override
    public Planet makePlanet(String planetsystem, String name, String mass, String radius, String semiMajorAxis, String eccen, String orbitalP, String pictureurl) {

        Star stjerne = planetSystemOversikt.get(planetsystem).getCenterStar();

        planetSystemOversikt.get(planetsystem).addPlanet(new Planet(
                name, Double.parseDouble(mass),
                Double.parseDouble(radius),
                Double.parseDouble(semiMajorAxis),
                Double.parseDouble(eccen),
                Double.parseDouble(orbitalP),
                stjerne,pictureurl)
        );
        Thread makeTrad = new Thread(
                this::skrivCSV
    );
        makeTrad.start();
        return planetSystemOversikt.get(planetsystem).getPlanetWithName(name);
    }


    @Override
    public void UpdatePlanet(String system,String planetname, String radius, String mass, String semiMajorAxis, String eccen,String orbitalP, String pictureurl) {

            planetSystemOversikt.get(system).getPlanetWithName(planetname).setName(planetname);  // Får en feil her som jeg ikke skjønner noe av, alt annet kan jeg endre.
            planetSystemOversikt.get(system).getPlanetWithName(planetname).setMass(Double.parseDouble(mass));
            planetSystemOversikt.get(system).getPlanetWithName(planetname).setRad(Double.parseDouble(radius));
            planetSystemOversikt.get(system).getPlanetWithName(planetname).setSemiMajorAxis(Double.parseDouble(semiMajorAxis));
            planetSystemOversikt.get(system).getPlanetWithName(planetname).setEccentricity(Double.parseDouble(eccen));
            planetSystemOversikt.get(system).getPlanetWithName(planetname).setOrbitalPeriod(Double.parseDouble(orbitalP));
            planetSystemOversikt.get(system).getPlanetWithName(planetname).setPictureUrl(pictureurl);

        Thread updateTrad = new Thread(
                this::skrivCSV
        );
        updateTrad.start();

    }

    @Override
    public void DeletePlanet(String planetsystem,String planet) {

        ArrayList<Planet> planets = this.getAllPlanets(planetsystem);

        Planet planetsd = null;

        for (Planet p: planets) {
            if (p.getName().equalsIgnoreCase(planet)) {
                planetsd = p;
                break;
            }
        }

        if (planet != null) {
            planets.remove(planetsd);
        }
        start();
    }

    @Override
    public void run() {
        skrivCSV();
    }
}
