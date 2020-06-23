package S12CollectionsL152_178.try1_05_30.L162SetsHashSets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    // A map for solarsystem with String and a HeavenlyBody
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    // A set of HeavenlyBody for planets
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        /* 162. Sets and Hashsets
        * A Set cannont contains duplicates.
        * there is no way to retrieve an item of a set
        * */

        //Creating planets putting in the solar system
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Creating the satellite
        HeavenlyBody tempSatellite = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempSatellite = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Mars

        tempSatellite = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Mars

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempSatellite = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Jupiter

        tempSatellite = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Jupiter

        tempSatellite = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Jupiter

        tempSatellite = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        // Printing the planets
        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        // Printing the planets
        HeavenlyBody body = solarSystem.get("Mars");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody satellite: body.getSatellites()) {
            System.out.println("\t" + satellite.getName());
        }

        // It creates a Set of moons and add all the satellites of each planet
        Set<HeavenlyBody> allSatellites = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            allSatellites.addAll(planet.getSatellites());
        }

        // Print it
        System.out.println("All Moons");
        for(HeavenlyBody moon : allSatellites) {
            System.out.println("\t" + moon.getName());
        }

        /*163*/
        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("*************163**************");
        for(HeavenlyBody planet: planets){
            System.out.println(planet.getName()+": "+planet.getOrbitalPeriod());
        }






    }
}
