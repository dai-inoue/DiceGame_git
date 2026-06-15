package jp.sample.dicegame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
 * 役割 「ゲーム全体を進行させる司会者」 責務（やること） ユーザー入力を受け取る・サイコロの個数・回数を決める・DiceSet に「振れ」と指示する・DiceSet に「振れ」と指示する
 * ・Statisticsに「記録・集計しろ」と指示する・結果を画面に表示する・ゲーム全体の流れ（開始 → 繰り返し → 終了）を管理する イメージ 司会者 / 進行役 「じゃあ振ってください！」
 * → DiceSet・「この結果、記録して！」 → Statistics・「はい、結果発表です！」 → 画面出力 【faces.length】 振ったサイコロの個数
 */
public class DiceGame {
  private Scanner scanner;
  private DiceSet diceSet;
  private Statistics stats;
  private Random random = new Random();

  public DiceGame(Scanner scanner) {
    this.scanner = scanner;
  }

  // ブランチ作成20260615コミットマージ練習再
  public void run() {// ゲーム全体の流れ
    System.out.println("ゲーム開始");
    int totalSum = 0; // 合計を溜める変数を用意


    // ユーザーが設定したサイコロ個数分のケースの準備DiceSet(int count)へ渡す
    try {
      System.out.println("1.コイン,2.サイコロ");
      System.out.println("選択してください");
      int chice = scanner.nextInt();

      Rollable selectedItem;
      if (chice == 1) {
        selectedItem = new Coin(random);
      } else if (chice == 2) {
        selectedItem = new Die(random);
      } else {
        System.out.println("無効な番号");
        selectedItem = new Die(random);
      }

      String promptMessage = selectedItem.getName() + "を何個使いますか？";
      int count = readIntInRange(promptMessage, 1, 10);

      // int count = readIntInRange(selectedItem.getName() + "を何個使いますか？", 1, 10);

      this.stats = new Statistics();
      String promptcoinMessage = selectedItem.getName() + "を何回振りますか？";

      // 1～100の中で何回回すか
      int rollCount = readIntInRange(promptcoinMessage, 1, 100);
      this.diceSet = new DiceSet(selectedItem, count);

      for (int r = 0; r < rollCount; r++) {
        int faces[] = diceSet.rollAll();
        // 記録ノートの準備↑苦手
        stats.record(faces);
        // 合計計算
        for (int face : faces) {
          totalSum += face;
        }
        System.out.println((r + 1) + "回目:");
        for (int i = 0; i < faces.length; i++) {
          System.out.print(faces[i] + (i < faces.length - 1 ? "," : ""));
        }
        System.out.println();
      }
      // 4. 結果表示
      stats.printSummary(totalSum, rollCount);

    } catch (InputMismatchException e) {
      // 3. 最後にエラーが起きた時の処理を書く
      System.out.println("エラー：数字以外が入力されました。");
      scanner.next(); // これで不正な入力をクリアします
    }
    System.out.println();
  }

  // 入力チェック
  public int readIntInRange(String prompt, int min, int max) {
    while (true) {
      System.out.println(prompt);
      try {
        int v = scanner.nextInt();
        if (v >= min && v <= max) {
          return v; // サイコロの個数の部分へ返す
        }
        System.out.println(min + "から" + max + "の間で入力してください");
      } catch (InputMismatchException e) {
        System.out.println("エラー：数字以外が入力されました数字を入力してください。");
        scanner.next();
      }
    }
  }
}

