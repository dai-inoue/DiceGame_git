package jp.sample.dicegame;

/**
 * <ul>
 * <li>Rollable インタフェース サイコロやコインを振る機能</li>
 * <li>その二つ(サイコロやコイン)の名前をユーザーが選んだ際に返す共通ルールを定義</li>
 * </ul>
 */
public interface Rollable {

  // サイコロ コインを振るためのメソッド
  int roll();

  // サイコロ コインの名前を返すためのメソッド
  String getName();

}
