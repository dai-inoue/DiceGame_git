package jp.sample.dicegame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  // サイコロを振って出た目の数を１個ずつ配列でカウントしてい
  @Test
  @DisplayName("6が出た回数が3になる")
  void testrecord() {
    Statistics statistics = new Statistics();
    int[] faces = {2, 2, 5, 6, 6, 6};
    statistics.record(faces);
    int result = statistics.getMaxCount();
    int expected = 3;
    org.junit.jupiter.api.Assertions.assertEquals(expected, result);
  }

  // １～６で最も頻繁に出た目
  @Test
  @DisplayName("5が3回で最多のとき、最も出た目が『5』になること")
  void testgetMostFrequentFace() {
    Statistics statistics = new Statistics();
    int[] face = {4, 4, 5, 6, 5, 5};
    statistics.record(face);
    int result = statistics.getMostFrequentFace();
    int expected = 5;
    org.junit.jupiter.api.Assertions.assertEquals(expected, result);
  }

  //// 出目の出力頻度チェック
  // assertEquals(3, statistics.getMostFrequentFace());
  //// 出力回数のチェック
  // assertEquals(2, statistics.getMaxCount());

  // 合計平均
  @Test
  @DisplayName("100を2で割ると50が返されること")
  void testcalcAverageTotal() {
    Statistics statistics = new Statistics();
    int totalSum = 100;
    int rollCount = 2;
    int expected = 50; // 期待される結果

    double result = statistics.calcAverageTotal(totalSum, rollCount);
    org.junit.jupiter.api.Assertions.assertEquals(expected, result);
  }

  // メモ帳（faceCount）を全部見て、最大カウント数
	//案件ブランチの作成練習20260603
  @Test
  @DisplayName("4が何回出たかの回数を確認")
  void testgetMaxCount() {
    Statistics statistics = new Statistics();
    int[] face = {4, 4, 4, 3, 5};
    statistics.record(face);
    int result = statistics.getMaxCount();
    int expected = 3;
    org.junit.jupiter.api.Assertions.assertEquals(expected, result);
  }
}

