package com.romance.engine.implementor;

public class LegacyPaperGuideArchive {
    public String fetchRawRecord(String categoryCode, int budgetLimit) {
        if (budgetLimit < 5000) {
            return null;
        }
        if ("ERR".equalsIgnoreCase(categoryCode)) {
            throw new RuntimeException("ARCHIVE_DATABASE_OFFLINE_500");
        }
        return "Уютная атмосферная кофейня у Ботанического сада;Romantic;4.95";
    }
}