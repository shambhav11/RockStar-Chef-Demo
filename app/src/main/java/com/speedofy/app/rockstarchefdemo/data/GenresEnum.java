package com.speedofy.app.rockstarchefdemo.data;

import java.util.HashMap;
import java.util.Map;

public enum GenresEnum {
    Action(28),
    Adventure(12),
    Animation(16),
    Comedy(35),
    Crime(80),
    Documentary(99),
    Drama(18),
    Family(10751),
    Fantasy(14),
    History(36),
    Horror(27),
    Music(10402),
    Mystery(9648),
    Romance(10749),
    Science_Fiction(878),
    TV_Movie(10770),
    Thriller(53),
    War(10752),
    Western(37)
    ;

    private int value;
    private static Map map = new HashMap<>();

    GenresEnum(int value) {
        this.value = value;
    }

    static {
        for (GenresEnum movieType : GenresEnum.values()) {
            map.put(movieType.value, movieType);
        }
    }

    public static GenresEnum valueOf(int movieType) {
        return (GenresEnum) map.get(movieType);
    }

    public int getValue() {
        return value;
    }
}
