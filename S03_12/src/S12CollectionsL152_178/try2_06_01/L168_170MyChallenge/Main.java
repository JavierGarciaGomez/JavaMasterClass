package S12CollectionsL152_178.try2_06_01.L168_170MyChallenge;

import java.util.*;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<HeavenlyBody> heavenlyBodies = new HashSet<>();

    public static void main(String[] args) {
        //Creating planets putting in the solar system
        HeavenlyBody temp = new Planet("Earth", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        heavenlyBodies.add(temp);


        temp = new Planet("Earth", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        heavenlyBodies.add(temp);


        HeavenlyBody tempSatellite = new Satellite("Moon", 27);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Earth
        heavenlyBodies.add(tempSatellite);


        tempSatellite = new Satellite("Moon", 27);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Earth
        heavenlyBodies.add(tempSatellite);


        temp = new Planet("Moon", 27);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        heavenlyBodies.add(temp);


        tempSatellite = new Satellite("GAMEDIA", 27);
        solarSystem.put(tempSatellite.getName(), tempSatellite);
        temp.addSatellite(tempSatellite); // temp is still Earth
        heavenlyBodies.add(tempSatellite);


        for(HeavenlyBody h: heavenlyBodies){
            System.out.println(h.toString());
        }

    }
}
