package com.example.mapsfromscratch.Model;

import java.util.List;

public class MuseumList {

    private List<MuseumObject> museums;

    public MuseumList(List<MuseumObject> museums) {
        this.museums = museums;
    }

    public List<MuseumObject> getMuseumList() {
        return museums;
    }
}
