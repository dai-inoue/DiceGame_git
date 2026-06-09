package jp.sample.dicegame;

import java.util.Random;

/**
 * <ul>
 * <li>役割:「１つのコインそのもの」 責務:コインを一度振る 1~2のランダムな目を返す また、ユーザーが「コイン」を選んだ際、"コイン (裏-表)"という名前を返す
 * <ul>
 */

public class Coin implements Rollable {
  private final Random random;// フィールド変数

  // gitブランチ練習20260609ブランチ作成練習
  // 早く扱えるよう何りたいな

  // コンストラクタ Mainクラスから共有され、乱数を作成
  public Coin(Random random) {
    this.random = random;
  }

  // コイン一回振った際、「0以上２未満」を返すため０が「裏」１が「表」となる 2回目マージ確認
  public int roll() {
    return random.nextInt(0, 2);
  }

  // 表示用の「コインコイン (裏-表)」を返す
  public String getName() {
    return "コイン (裏-表)";
  }
}
