package com.romance.engine.implementor;

import com.romance.engine.model.Location;

public interface DateLocationProvider {
    Location findLocation(int maxBudget, String category);
}