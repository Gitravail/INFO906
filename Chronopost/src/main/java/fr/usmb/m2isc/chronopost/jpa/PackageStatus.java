package fr.usmb.m2isc.chronopost.jpa;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class PackageStatus {

    public static State ParseState(String state) {
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

    public enum State {
        REGISTRATION, PENDING, TRANSITING, BLOCKED, DELIVERED, UNKNOWN;
    }

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade=CascadeType.ALL)
    private Coordinate coordinate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String location;
    private State state;

    public PackageStatus() {
        this.date = new Date();
    }

    public PackageStatus(Coordinate coordinate, String location, State state) {
        this.date = new Date();
        this.coordinate = coordinate;
        this.location = location;
        this.state = state;
    }

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
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");
        return formater.format(date);
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
