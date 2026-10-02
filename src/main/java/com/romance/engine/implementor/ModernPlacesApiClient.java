package com.romance.engine.implementor;

import com.romance.engine.model.Location;

public class ModernPlacesApiClient implements DateLocationProvider {
    @Override
    public Location findLocation(int maxBudget, String category) {
        return new Location("Skyline Lounge в Talan Towers (Астана)", category, 4.8);
    }
}