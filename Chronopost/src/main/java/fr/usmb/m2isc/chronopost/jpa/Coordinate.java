package fr.usmb.m2isc.chronopost.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.regex.*;

/**
 * JPA entity to store coordinates in the database
 */
@Entity
public class Coordinate {

    /**
     * Unique identifier of the object, if it's null then it will be auto generated when adding it to the database
     */
    @Id
    @GeneratedValue
    private long id;

    private double latitude;
    private double longitude;

    /* Constructors */

    // Mandatory constructor for JPA objects
    public Coordinate() {

    }

    public Coordinate(String latitude, String longitude) {
        this.latitude = this.toDecimal(latitude);
        this.longitude = this.toDecimal(longitude);
    }

    /* Getters and setters */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = toDecimal(latitude);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = toDecimal(longitude);
    }

    /**
     * Convert a DMS coordinate into a decimal coordinate
     * @param degree the dms coordinate
     * @return String decimal formatted coordinates
     */
    private double toDecimal(String degree) {
        String regex = "^([0-8]?[0-9]|90)°(\\s[0-5]?[0-9]')?(\\s[0-5]?[0-9](,[0-9])?\")?$";
        if (Pattern.matches(regex, degree)) {
            String[] parts = degree.split(regex);
            double d = Double.parseDouble(parts[0]);
            double m = Double.parseDouble(parts[1]);
            double s = Double.parseDouble(parts[2]);
            return Math.signum(d) * (Math.abs(d) + (m / 60.0) + (s / 3600.0));
        }
        return Double.parseDouble(degree);
    }
}
