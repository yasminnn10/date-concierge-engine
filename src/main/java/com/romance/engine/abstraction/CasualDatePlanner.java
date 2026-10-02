package com.romance.engine.abstraction;

import com.romance.engine.implementor.DateLocationProvider;
import com.romance.engine.model.Location;

public class CasualDatePlanner extends DatePlanner {

    public CasualDatePlanner(DateLocationProvider locationProvider) {
        super(locationProvider);
    }

    @Override
    public String planDate(int budget) {
        Location location = locationProvider.findLocation(budget, "Casual");
        return "Casual Date Plan: " + location.getName() + " (Rating: " + location.getRating() + ")";
    }
}