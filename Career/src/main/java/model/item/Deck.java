package model.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {
	/**
	 * リストを生成
	 */
	public List<Card> cardList = new ArrayList<Card>();
	/**
	 * コンストラクタ
	 */
	public Deck() {
		cardList.add(new Card(1, "ace", "heart", 14, 1));
		cardList.add(new Card(2, "ace", "diamond", 14, 1));
		cardList.add(new Card(3, "ace", "spade", 14, 1));
		cardList.add(new Card(4, "ace", "club", 14,  1));
		cardList.add(new Card(5, "two", "heart", 15, 2));
		cardList.add(new Card(6, "two", "diamond", 15, 2));
		cardList.add(new Card(7, "two", "spade", 15, 2));
		cardList.add(new Card(8, "two", "club", 15,2));
		cardList.add(new Card(9, "seven", "heart", 7,7));
		cardList.add(new Card(10, "seven", "diamond", 7,7));
		cardList.add(new Card(11, "seven", "spade", 7,7));
		cardList.add(new Card(12, "seven", "club", 7,7));
		cardList.add(new Card(13, "eight", "heart", 8,8));
		cardList.add(new Card(14, "eight", "diamond", 8,8));
		cardList.add(new Card(15, "eight", "spade", 8,8));
		cardList.add(new Card(16, "eight", "club", 8,8));
		cardList.add(new Card(17, "nine", "heart", 9,9));
		cardList.add(new Card(18, "nine", "diamond", 9,9));
		cardList.add(new Card(19, "nine", "spade", 9,9));
		cardList.add(new Card(20, "nine", "club", 9,9));
		cardList.add(new Card(21, "ten", "heart", 10,10));
		cardList.add(new Card(22, "ten", "diamond", 10,10));
		cardList.add(new Card(23, "ten", "spade", 10,10));
		cardList.add(new Card(24, "ten", "club", 10,10));
		cardList.add(new Card(25, "Jack", "heart", 11,11));
		cardList.add(new Card(26, "Jack", "diamond", 11,11));
		cardList.add(new Card(27, "Jack", "spade", 11,11));
		cardList.add(new Card(28, "Jack", "club", 11,11));
		cardList.add(new Card(29, "Queen", "heart", 12,12));
		cardList.add(new Card(30, "Queen", "diamond", 12,12));
		cardList.add(new Card(31, "Queen", "spade", 12,12));
		cardList.add(new Card(32, "Queen", "club", 12,12));
		cardList.add(new Card(33, "King", "heart", 13,13));
		cardList.add(new Card(34, "King", "diamond", 13,13));
		cardList.add(new Card(35, "King", "spade", 13,13));
		cardList.add(new Card(36, "King", "club", 13,13));
		cardList.add(new Card(37, "Joker", "black", 16,14));
		cardList.add(new Card(38, "Joker", "red", 16,14));
		

	}
	//シャッフル
public void distribution() {
		
	Collections.shuffle(cardList);
	
		int i = 0;
		for(Card card :cardList) {
			if(i<16) {
				card.setCard_flag(0);
			}else if(i<32) {
				card.setCard_flag(1);
			}else {
				card.setCard_flag(-1);
			}
			i++;	
		}
		//並び替え
		cardList.sort(Comparator.comparing(Card::getCard_flag).thenComparing(Card::getStrength));
		//return cardList;
	}

	

}
