package fr.usmb.m2isc.chronopost.jpa;

import javax.persistence.*;
import java.util.List;

/**
 * JPA object representing a package
 * A package contain its information and a list of package status used to keep track of the delivery
 */
@Entity
public class Package {

    /**
     * Unique identifier of the object, if it's null then it will be auto generated when adding it to the database
     */
    @Id
    @GeneratedValue
    private long id;

    /* Proper package attributes */
    private float weight;
    private float value;
    private String origin;
    private String destination;

    /* List of status with the cascade of the persistence and fetching of the DB PackageStatus as proper instances */
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<PackageStatus> packageStatusList;

    /* Constructors */

    public Package() { }

    /**
     * @param weight Package's weight
     * @param value Package's weight
     * @param origin Package's origin
     * @TODO use the destination value
     * @param destination Package's destination
     */
    public Package(float weight, float value, String origin, String destination) {
        this.weight = weight;
        this.value = value;
        this.origin = origin;
        this.destination = destination;
    }

    /* Getters and Setters */

    public long getId() {
        return id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<PackageStatus> getPackageStatusList() {
        return packageStatusList;
    }

    public void setPackageStatusList(List<PackageStatus> packageStatusList) {
        this.packageStatusList = packageStatusList;
    }

    /**
     * Used by the ejb object to add a status to the package
     * @param ps PackageStatus
     */
    public void addPackageStatus(PackageStatus ps) { packageStatusList.add(ps); }

    /**
     * Update a package status for a specific package
     * @param packageStatusId Id of the package status
     * @param location possibly a new location
     * @param latitude possibly a new latitude
     * @param longitude possibly a new longitude
     * @param state possibly a new state
     */
    public void editPackageStatus(long packageStatusId, String location, String latitude, String longitude, String state) {
        for (PackageStatus ps: packageStatusList) {
            if (packageStatusId == ps.getId()) {
                ps.setLocation(location);
                ps.getCoordinate().setLatitude(latitude);
                ps.getCoordinate().setLongitude(longitude);
                ps.setState(PackageStatus.parseState(state));
                break;
            }
        }
    }
}
