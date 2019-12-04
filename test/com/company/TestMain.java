package com.company;

import org.junit.Test;

import java.util.Scanner;

public class TestMain {

    public TestMain() {
        run();
    }

    @Test
    public void run(){
        Game game = new Game();
        game.play();
    }
}
