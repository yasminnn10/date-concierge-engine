package com.romance.engine.implementor;

import com.romance.engine.exceptions.LocationProviderException;
import com.romance.engine.model.Location;

public class LegacyArchiveAdapter implements DateLocationProvider {
    private final LegacyPaperGuideArchive legacyArchive;

    public LegacyArchiveAdapter(LegacyPaperGuideArchive legacyArchive) {
        this.legacyArchive = legacyArchive;
    }

    @Override
    public Location findLocation(int maxBudget, String category) {
        try {
            String rawData = legacyArchive.fetchRawRecord(category, maxBudget);

            if (rawData == null) {
                throw new LocationProviderException("Legacy archive: Location not found for given budget limit");
            }

            String[] parts = rawData.split(";");
            if (parts.length < 3) {
                throw new LocationProviderException("Legacy archive: Invalid record format");
            }

            String name = parts[0];
            String locCategory = parts[1];
            double rating = Double.parseDouble(parts[2]);

            return new Location(name, locCategory, rating);

        } catch (LocationProviderException e) {
            throw e;
        } catch (Exception e) {
            throw new LocationProviderException("Legacy archive failed: " + e.getMessage());
        }
    }
}