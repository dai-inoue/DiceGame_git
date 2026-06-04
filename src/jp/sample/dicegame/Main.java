package jp.sample.dicegame;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      DiceGame game = new DiceGame(sc);
      game.run();
    }
  }
}

