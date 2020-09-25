package fr.usmb.m2isc.chronopost.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PackageStatus {

    public enum State {
        REGISTRATION, PENDING, TRANSITING, BLOCKED, DELIVERED
    }

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Coordinate coordinate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String location;
    private State state;

    public PackageStatus() {

    }

    public PackageStatus(Coordinate coordinate, Date date, String location, State state) {
        this.coordinate = coordinate;
        this.date = date;
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

    public Date getDate() {
        return date;
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
