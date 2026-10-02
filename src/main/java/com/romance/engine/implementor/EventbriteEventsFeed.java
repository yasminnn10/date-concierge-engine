package com.romance.engine.implementor;

import com.romance.engine.model.Location;

public class EventbriteEventsFeed implements DateLocationProvider {
    @Override
    public Location findLocation(int maxBudget, String category) {
        return new Location("Вечер балета в Astana Opera", category, 4.9);
    }
}