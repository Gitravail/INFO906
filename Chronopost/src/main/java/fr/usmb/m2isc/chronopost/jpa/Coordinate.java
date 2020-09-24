package fr.usmb.m2isc.chronopost.jpa;

import java.util.regex.*;

public class Coordinate {
    
    private double latitude;
    private double longitude;

    public Coordinate() {

    }

    public Coordinate(String latitude, String longitude) {
        this.latitude = this.toDecimal(latitude);
        this.longitude = this.toDecimal(longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

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
