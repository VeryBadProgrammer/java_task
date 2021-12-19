package com.homework.lesson5.task2;

import static com.homework.lesson5.task2.Game.SNOWBALLS;
import static com.homework.lesson5.task2.Game.BERRIES;
import static com.homework.lesson5.task2.Game.BOATS;
import static com.homework.lesson5.task2.Game.BOOT;

public enum Season {
    WINTER(SNOWBALLS), SUMMER(BERRIES), AUTUMN(BOOT), SPRING(BOATS);
    private Game game;

    Season(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
