package com.syukri.uaspbo.menu;

public class checkEnding {
    public static boolean hasWon(java.util.Map<String, java.util.Set<String>> monsterCounter) {
        if (monsterCounter == null) return false;

        return monsterCounter.getOrDefault("Basic", java.util.Collections.emptySet()).size() >= 3 &&
               monsterCounter.getOrDefault("Fire", java.util.Collections.emptySet()).size() >= 3 &&
               monsterCounter.getOrDefault("Plant", java.util.Collections.emptySet()).size() >= 3 &&
               monsterCounter.getOrDefault("Water", java.util.Collections.emptySet()).size() >= 3;
    }

    public static boolean hasLost(int dayCounter) {
        return dayCounter > 14;
    }
}
