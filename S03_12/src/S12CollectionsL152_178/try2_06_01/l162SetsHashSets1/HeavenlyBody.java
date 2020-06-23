package S12CollectionsL152_178.try2_06_01.l162SetsHashSets1;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    //FIELDS
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    //CONSTRUCTOR
    public HeavenlyBody(String name, double orbitalPeriod) {
        System.out.println("Creating a "+this.getClass().getSimpleName()+": "+name);
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<HeavenlyBody>();
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    //METHODS
    public boolean addSatellite(HeavenlyBody satellite) {
        System.out.println("Adding a Satellite to:" + this.name+ ". named: "+satellite.getName());
        return this.satellites.add(satellite);
    }


    // 163
    @Override
    public boolean equals(Object o) {
        // if equals true
        if (this == o) {
            return true;
        }
        System.out.println("obj.getClas()"+ o.getClass());
        System.out.println("this.getClas()"+ this.getClass());
        // if o is null then prevent a non pointer exception
        if (o == null || this.getClass() != o.getClass()) return false;

        // check equals as a String
        String objName = ((HeavenlyBody) o).getName();
        return this.name.equals(objName);
    }

    //164
    @Override
    public int hashCode() {
        // with the addition of the number, We guarantee that it cant return 0
        return name.hashCode()+57;
    }
}