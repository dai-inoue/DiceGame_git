package jp.sample.dicegame;

/*
 * 役割:振ることができるサイコロとコインをまとめて管理することができる箱 責務：保持しているサイコロとコインを一斉に振る指示を出す
 */

public class DiceSet {
  // フィールド変数
  // Rollableインターフェースを実装したものならなんでも入る箱
  private final Rollable[] items;

  // 選ばれたサイコロorコイン指定された数分作成（コンストラクタ）
  public DiceSet(Rollable prototype, int count) {
    // サイコロorコインを入れるRollable(棚)をcount段分作る
    items = new Rollable[count];
    for (int i = 0; i < count; i++) {
      // サイコロかコインそちらの専用の棚にするか決める
      items[i] = prototype;
    }
  }

  // 20260606gitの練習

  // 全てのサイコロとコインをとりあえず振ってその結果を返す
  public int[] rollAll() {
    // サイコロorコインの個数分、結果を記録できる「配列」を作成
    int[] result = new int[items.length];
    for (int i = 0; i < items.length; i++) {
      // 中身が何かは気にせず、共通の「振る」動作を実行して結果を受け取る
      result[i] = items[i].roll();
    }
    return result;
  }

  // 出目の合計を計算→後程追加メソッド
  public int sum(int[] faces) {
    int total = 0;
    for (int face : faces) {
      total += face;
    }
    return total;
  }
}
