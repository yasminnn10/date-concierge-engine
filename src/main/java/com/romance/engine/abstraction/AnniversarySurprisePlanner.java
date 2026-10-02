package com.romance.engine.abstraction;

import com.romance.engine.implementor.DateLocationProvider;
import com.romance.engine.model.Location;

public class AnniversarySurprisePlanner extends DatePlanner {

    public AnniversarySurprisePlanner(DateLocationProvider locationProvider) {
        super(locationProvider);
    }

    @Override
    public String planDate(int budget) {
        Location location = locationProvider.findLocation(budget, "Romantic");
        return "Anniversary Surprise Plan: " + location.getName() + " (Rating: " + location.getRating() + ")";
    }
}