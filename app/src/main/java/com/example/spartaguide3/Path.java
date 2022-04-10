package com.example.spartaguide3;

import android.location.Location;

import java.sql.Array;
import java.util.ArrayList;

public class Path {
    private ArrayList<Location> locations = new ArrayList<Location>();
    private String name;

    public Path (String name){
        this.name = name;
        locations = new ArrayList<Location>();
    }

    public Path (String name, ArrayList<Location> points){
        this.name = name;
        locations = points;
    }

    public Location getClosestPoint(Location currentLocation){
        Location closest = locations.get(0);
        float minDist = currentLocation.distanceTo(closest);
        for (Location loc : locations) {
            float distance = loc.distanceTo(currentLocation);
            if (distance < minDist){
                closest = loc;
                minDist = distance;
            }
        }
        return closest;
    }

    public void addLocation(Location loc){
        locations.add(loc);
    }

    public void removeLastLocation(){
        locations.remove(locations.size() - 1);
    }
}
