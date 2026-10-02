package com.romance.engine.abstraction;

import com.romance.engine.implementor.DateLocationProvider;

public abstract class DatePlanner {
    protected final DateLocationProvider locationProvider;

    protected DatePlanner(DateLocationProvider locationProvider) {
        this.locationProvider = locationProvider;
    }

    public abstract String planDate(int budget);
}