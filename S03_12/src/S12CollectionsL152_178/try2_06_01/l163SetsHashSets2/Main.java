package S12CollectionsL152_178.try2_06_01.l163SetsHashSets2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    /*We are going to create a model of the solar system. We are going to use a Map to store the HeavenlyBody objects
    * And a set to group them
    * */
    // A map for solarsystem with String and a HeavenlyBody
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    // A set of HeavenlyBody for planets
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        /* 162. Sets and Hashsets
        * A Set cannont contains duplicates is the most important differentiator.
        * There are: orderSet, HashSet and TreeSet.
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

        HeavenlyBody tempSatellite = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Earth

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

        // Printing the satellites
        HeavenlyBody body = solarSystem.get("Mars"); // To retrieve an object
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody satellite: body.getSatellites()) {
            System.out.println("\t" + satellite.getName());
        }

        // Creating a union of sets
        Set<HeavenlyBody> allSatellites = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            allSatellites.addAll(planet.getSatellites());
        }

        // Print it
        System.out.println("All satellites");
        for(HeavenlyBody moon : allSatellites) {
            System.out.println("\t" + moon.getName());
        }

        /*163*/
        System.out.println("*************163**************");

        /* Trying to add a new Pluto, but is showing it twice.
        * The reason is that they dont compare equal, this is why
        * the equals() has to be overwrite.
        * if not they just compare a simple equals method that performs a referential equality,
        * so if they point at the same object are equal
        *
        * At 1406 equals is overrrided so now pluto is not added
        * */
        temp = new HeavenlyBody("Pluto", 842);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        for(HeavenlyBody planet: planets){
            System.out.println(planet.getName()+": "+planet.getOrbitalPeriod());
        }

        /* Trying the equals with an object*/
        Object o1 = new Object();
        System.out.println(o1.equals(o1)); // true. This calls object equals()
        System.out.println("pluto".equals(o1)); // false. This calls String equals()

        /*
        * When storing a collection as a hashset or a hashmap the collection has like buckets to store objects
        * the hashcode determines the bucket where is going to enter. A requirement is that for a object to be equal
        * they need to have the same hashcode, but the opposite is not required: for two bjects to be equal not have to have
        * different hashcodes.
        * The conclusion is that overriding equals() and hashcode() is a must
        * */








    }
}
