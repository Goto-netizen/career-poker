package model.item;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	/**
	 * リストを生成
	 */
	List<Card> cardList = new ArrayList<Card>();
	/**
	 * コンストラクタ
	 */
	public Deck() {
		cardList.add(Card(1, "ace", "heart", 14));
	}

}
