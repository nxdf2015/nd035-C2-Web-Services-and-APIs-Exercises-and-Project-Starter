package com.udacity.boogle.maps;

import javax.persistence.*;

@Entity
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Address address;

    private double lon;
    private double lat;

    public Map() {
    }

    public Map(double lon, double lat, Address address) {
        this.address = address;
        this.lon = lon;
        this.lat = lat;
    }

    public static Map of(double lon, double lat, Address address) {
        return new Map(lon,lat,address);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }


}
