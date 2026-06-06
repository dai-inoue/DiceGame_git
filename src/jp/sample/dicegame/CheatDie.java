package jp.sample.dicegame;

import java.util.Random;

/*
 * 役割:統計機能のテストに使用するモック用のクラス
 */
public class CheatDie extends Die {
  public CheatDie(Random random) {
    super(random);
  }

  // 練習202600600606gitの扱い方を勉強してるぞ
  @Override
  public int roll() {
    return 6;
  }

  // 名前を入れてCheat Die (Always 6)が返すメソッド
  @Override
  public String getName() {
    return "Cheat Die (Always 6)";
  }
}
