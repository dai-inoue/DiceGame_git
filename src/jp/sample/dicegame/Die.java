package jp.sample.dicegame;

import java.util.Random;
/*
 * 役割 「1個のサイコロそのもの」 責務（やること） サイコロを 1回振る・1〜6 の ランダムな目を返す イメージ 実物のサイコロ 1個・「振ったら数字を出す」だけの存在
 */

public class Die implements Rollable {
  private final Random random;// フィールド変数

  // コンストラクタ Mainクラスから共有され、乱数を作成
  public Die(Random random) {
    this.random = random;
    //
  }

  // サイコロ一回振った際、「1以上7未満の数」をランダムに返す
  public int roll() {
    return random.nextInt(1, 7);
  }

  // 表示用の「サイコロ」の名前を返す
  public String getName() {
    return "サイコロ";
  }
}

