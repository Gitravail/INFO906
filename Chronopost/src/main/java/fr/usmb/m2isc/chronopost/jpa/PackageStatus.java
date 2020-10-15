package fr.usmb.m2isc.chronopost.jpa;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JPA object for a package status, a step in a package delivery process
 */
@Entity
public class PackageStatus {

    /**
     * Parse a state from a string to the actual enum type
     * @param state the state as a string
     * @return State
     */
    public static State parseState(String state) {
        switch (state) {
            case "REGISTRATION":
                return State.REGISTRATION;
            case "PENDING":
                return State.PENDING;
            case "TRANSITING":
                return State.TRANSITING;
            case "BLOCKED":
                return State.BLOCKED;
            case "DELIVERED":
                return State.DELIVERED;
            default:
                return State.UNKNOWN;
        }
    }

    /* All the different possible states */
    public enum State {
        REGISTRATION, PENDING, TRANSITING, BLOCKED, DELIVERED, UNKNOWN;
    }

    /**
     * Unique identifier of the object, if it's null then it will be auto generated when adding it to the database
     */
    @Id
    @GeneratedValue
    private long id;

    /* The status coordinates are also stored in the database in another table so they are part of the cascade */
    @OneToOne(cascade=CascadeType.ALL)
    private Coordinate coordinate;

    /* The date of the step with a temporal format */
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String location;
    private State state;

    /* Constructors */

    public PackageStatus() {
        this.date = new Date();
    }

    public PackageStatus(Coordinate coordinate, String location, State state) {
        this.date = new Date();
        this.coordinate = coordinate;
        this.location = location;
        this.state = state;
    }

    /* Getters and setters */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getDate() {
        /* Date reformat when using it in the displays */
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");
        return formatter.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
