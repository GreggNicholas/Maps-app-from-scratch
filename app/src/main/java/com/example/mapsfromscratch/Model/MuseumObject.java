package com.example.mapsfromscratch.Model;

public class MuseumObject {

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;


    public MuseumObject(String name, String address, String city, String state, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }


}
