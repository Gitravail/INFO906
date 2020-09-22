import java.sql.Timestamp;

public class PackageStatus {

    public enum State {
        REGISTRATION, PENDING, TRANSITING, BLOCKED, DELIVERED
    }

    private Coordinate coordinate;
    private Timestamp date;
    private String location;
    private State state;

    public PackageStatus(Coordinate coordinate, Timestamp date, String location, State state) {
        this.coordinate = coordinate;
        this.date = date;
        this.location = location;
        this.state = state;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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
