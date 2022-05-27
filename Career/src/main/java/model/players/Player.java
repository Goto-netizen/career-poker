package model.players;

import java.util.Deque;
import java.util.List;

import model.item.Card;

public class Player {
	

	/*
	 *フィールド
	 */
	List<Card> deckList;
	int index;
	Deque<Card>deque;
	
	/*
	 * コンストラクタ
	 */
	public Player(List<Card> deckList ,int index,Deque<Card> deque) {
		this.deckList = deckList;
		this.index = index;
		this.deque = deque;
	}
	
	
	public void playerProcess(List<Card> deckList ,int index,Deque<Card> deque)throws Exception {
		//List<Card> deck = new ArrayList<Card>();
		Card hand = deckList.get(index);
		
		hand.setCard_flag(3);
		
		deque.push(hand);
		
	}
	
	public boolean judge(List<Card> deckList ,int index,Deque<Card> deque) {
		Card hand = deckList.get(index);
		int handstrength = hand.getStrength();
		
		Card fieldtop = deque.peek();
		int fieldstrength = fieldtop.getStrength();
		
		if(deque.isEmpty()==true) {			
			return true;
			
		}else if(handstrength > fieldstrength) {
			return true;
		}
		return false;

	}
	
	


}