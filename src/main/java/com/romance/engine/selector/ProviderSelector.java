package com.romance.engine.selector;

import com.romance.engine.implementor.DateLocationProvider;
import com.romance.engine.implementor.EventbriteEventsFeed;
import com.romance.engine.implementor.LegacyArchiveAdapter;
import com.romance.engine.implementor.LegacyPaperGuideArchive;
import com.romance.engine.implementor.ModernPlacesApiClient;

public class ProviderSelector {

    public static DateLocationProvider selectProvider(int budget, boolean prefersEvents, boolean useLegacyArchive) {
        if (useLegacyArchive) {
            return new LegacyArchiveAdapter(new LegacyPaperGuideArchive());
        }
        if (prefersEvents) {
            return new EventbriteEventsFeed();
        }
        return new ModernPlacesApiClient();
    }
}