package jp.sample.dicegame;

import java.util.Random;

/*
 * 役割:統計機のテストに使用するモック用のクラス
 */
public class CheatDie extends Die {
  public CheatDie(Random random) {
    super(random);
  }

  // ブランチ作成202600709コミットマージ練習
  // 部屋が暑くて死にそう
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
