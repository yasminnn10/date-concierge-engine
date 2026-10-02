package com.romance.engine;

import com.romance.engine.abstraction.CasualDatePlanner;
import com.romance.engine.abstraction.DatePlanner;
import com.romance.engine.exceptions.LocationProviderException;
import com.romance.engine.implementor.DateLocationProvider;
import com.romance.engine.implementor.LegacyArchiveAdapter;
import com.romance.engine.implementor.LegacyPaperGuideArchive;
import com.romance.engine.model.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateConciergeTest {

    @Test
    void testBridgePatternWithFakeProvider() {
        DateLocationProvider fakeProvider = new DateLocationProvider() {
            @Override
            public Location findLocation(int maxBudget, String category) {
                return new Location("Ресторан Астана", category, 4.5);
            }
        };

        DatePlanner planner = new CasualDatePlanner(fakeProvider);
        String result = planner.planDate(10000);

        assertTrue(result.contains("Ресторан Астана"));
    }

    @Test
    void testAdapterSuccess() {
        LegacyPaperGuideArchive legacyArchive = new LegacyPaperGuideArchive();
        LegacyArchiveAdapter adapter = new LegacyArchiveAdapter(legacyArchive);

        Location location = adapter.findLocation(6000, "Romantic");

        assertNotNull(location);
        assertEquals("Уютная атмосферная кофейня у Ботанического сада", location.getName());
    }

    @Test
    void testAdapterExceptionHandling() {
        LegacyPaperGuideArchive legacyArchive = new LegacyPaperGuideArchive();
        LegacyArchiveAdapter adapter = new LegacyArchiveAdapter(legacyArchive);

        assertThrows(LocationProviderException.class, () -> {
            adapter.findLocation(1000, "Romantic");
        });
    }
}