package com.homework.lesson5.task2;

public enum Game {
    SNOWBALLS("снежки"),
    BOATS("запуск корабликов по ручьям"),
    BERRIES("собирание и поедание ягод"),
    BOOT("измерение глубины луж методом \"сапога\"");
    private String description;

    Game(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
