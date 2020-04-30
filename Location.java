package com.company;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    
    // Creates a location using the given ID, the provided description, as well as the where the location is.
    // Ensures the exit to the game can't be null.
    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        } else{
            this.exits = new HashMap<String, Integer>();
        }

            this.exits.put("Q", 0);
    }
    
    // Returns the player's current location
    public int getLocationID() {
        return locationID;
    }

    // Returns the description of the current location
    public String getDescription() {
        return description;
    }

    // Provides the application with a HAsh map of exits
    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
