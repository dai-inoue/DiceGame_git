package jp.sample.dicegame;

/*
 * 役割 「結果を覚えて分析する人」 責務（やること） 出目の回数を記録・最も多く出た目を返す・平均を計算する イメージ ノート係 出た数字をメモして集計する人
 */
public class Statistics {
  private int[] faceCount = new int[7]; // フィールド変数(出目ごとの集計表)

  // サイコロを振って出た目の数を１個ずつ配列でカウントしていく
  public void record(int[] faces) {
    // 1個ずつ取り出す
    for (int face : faces) {
      if (face >= 0 && face < faceCount.length) {
        // 対応する目のカウントを1増やす
        faceCount[face]++;
        System.out.println(faceCount);
      }
    }
  }

  // １～６で最も頻繁に出た目
  public int getMostFrequentFace() {
    int maxCount = -1;
    int mostFace = 1;

    for (int i = 1; i < faceCount.length; i++) {
      // 1〜6の各出目が「それぞれ何回出たか」を順番に確認し、最多を探す
      if (faceCount[i] > maxCount) {
        // maxCountとfaceCount[i]の中身確認
        maxCount = faceCount[i];
        System.out.println(maxCount);
        mostFace = i;
      }
    }
    return mostFace;
  }

  // 合計平均
  public double calcAverageTotal(int totalSum, int rollCount) {
    if (rollCount == 0) {
      return 0.0;
    }
    return (double) totalSum / rollCount;
  }

  // メモ帳（faceCount）を全部見て、最大カウント数
  public int getMaxCount() {
    int maxCount = 0;
    for (int count : faceCount) {
      if (count > maxCount) {
        maxCount = count;
      }
    }
    return maxCount;
  }

  // 最も頻繁に出た目や、その出現回数などの統計情報を整形して出力します。
  public void printSummary(int totalSum, int rollCount) {
    int mostFace = getMostFrequentFace();

    double avetotal = calcAverageTotal(totalSum, rollCount);

    int maxCount = getMaxCount();

    System.out.println("統計レポート");
    System.out.printf("全ロールの合計平均: %.1f%n", avetotal);
    System.out.println("最も多く出た目: " + mostFace + " (回数: " + maxCount + "回出ました)");
    System.out.println("ゲームを終了します。お疲れ様でした！");
  }
}
