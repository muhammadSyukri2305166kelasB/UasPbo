package com.syukri.uaspbo.menu;

public class checkEnding {
    public static boolean hasWon(java.util.Map<String, java.util.Set<String>> monsterCounter) {
        if (monsterCounter == null) return false;

        return monsterCounter.getOrDefault("none", java.util.Collections.emptySet()).size() >= 3 &&
               monsterCounter.getOrDefault("fire", java.util.Collections.emptySet()).size() >= 3 &&
               monsterCounter.getOrDefault("plant", java.util.Collections.emptySet()).size() >= 3 &&
               monsterCounter.getOrDefault("water", java.util.Collections.emptySet()).size() >= 3;
    }

    public static boolean hasLost(int dayCounter) {
        return dayCounter > 14;
    }
}
