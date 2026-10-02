package com.romance.engine;

import com.romance.engine.abstraction.AnniversarySurprisePlanner;
import com.romance.engine.abstraction.CasualDatePlanner;
import com.romance.engine.abstraction.DatePlanner;
import com.romance.engine.implementor.DateLocationProvider;
import com.romance.engine.selector.ProviderSelector;

public class Main {
    public static void main(String[] args) {
        int budget = 15000;

        DateLocationProvider modernProvider = ProviderSelector.selectProvider(budget, false, false);
        DatePlanner casualPlanner = new CasualDatePlanner(modernProvider);
        System.out.println(casualPlanner.planDate(budget));

        DateLocationProvider eventProvider = ProviderSelector.selectProvider(budget, true, false);
        DatePlanner anniversaryPlanner = new AnniversarySurprisePlanner(eventProvider);
        System.out.println(anniversaryPlanner.planDate(budget));

        DateLocationProvider legacyAdapter = ProviderSelector.selectProvider(budget, false, true);
        DatePlanner legacyPlanner = new CasualDatePlanner(legacyAdapter);
        System.out.println(legacyPlanner.planDate(budget));
    }
}