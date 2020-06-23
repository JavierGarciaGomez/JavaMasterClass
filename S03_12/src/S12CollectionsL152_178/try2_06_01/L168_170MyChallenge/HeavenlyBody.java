package S12CollectionsL152_178.try2_06_01.L168_170MyChallenge;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    //FIELDS
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyType bodyType;

    protected enum BodyType{STAR, PLANET, SATELLITE}

    //CONSTRUCTOR
    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        System.out.println("Creating a "+this.getClass().getSimpleName()+": "+name);
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<HeavenlyBody>();
        this.bodyType=bodyType;
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

    public BodyType getBodyType() {
        return bodyType;
    }

    //METHODS
    public boolean addSatellite(HeavenlyBody satellite) {
        System.out.println("Adding a Satellite to:" + this.name+ ". named: "+satellite.getName());
        if(satellite.getBodyType()==BodyType.SATELLITE){
            return this.satellites.add(satellite);
        }
        return false;
    }

    @Override
    public final boolean equals(Object o) {
        System.out.println("EQUALS" +this.getClass().getSimpleName()+" "+o.getClass().getSimpleName());

        if(o instanceof HeavenlyBody){
            // cast it as a Heavenlybody
            HeavenlyBody thatHB = (HeavenlyBody) o;
            if(this.getName()==thatHB.getName()){
                // return true or false if equals
                return this.bodyType == thatHB.bodyType;
            }
        }
        return false;

    }

    @Override
    public final int hashCode() {
        return this.name.hashCode()+57+this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + name + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", satellites=" + satellites +
                ", bodyType=" + bodyType +
                '}';
    }
}