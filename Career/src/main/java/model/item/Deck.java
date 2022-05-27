package model.item;

import java.util.ArrayList;
import java.util.List;
import model.item.Card;

public class Deck {
	/**
	 * リストを生成
	 */
	List<Card> cardList = new ArrayList<Card>();
	/**
	 * コンストラクタ
	 */
	public Deck() {
		cardList.add(Card(setCard_id(1), setNum("")))
	}

}
