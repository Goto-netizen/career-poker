package model.players;

import java.util.Deque;
import java.util.List;

import model.item.Card;
import model.option.CardAbility;

public class Player {
	

	/*
	 *フィールド
	 */
	boolean playerPassFlag;
	List<Card> deckList;
	int index;
	Deque<Card> fieldDeque;
	
	/*
	 * コンストラクタ
	 */
	public Player(List<Card> deckList ,int index,Deque<Card> fieldDeque) {
		this.deckList = deckList;
		this.index = index;
		this.fieldDeque = fieldDeque;
	}
	
	
	public void playerProcess()throws Exception {
		//List<Card> deck = new ArrayList<Card>();
		Card hand = deckList.get(index);
		
		hand.setCard_flag(3);
		
		fieldDeque.push(hand);
		
	}
	
	public boolean judge() {
		
		if(fieldDeque.isEmpty()) {			
			return true;
			
		}else {
			Card hand = deckList.get(index);
			int handstrength = hand.getStrength();
			
			Card fieldtop = fieldDeque.peek();
			int fieldstrength = fieldtop.getStrength();
			
			CardAbility ca = new CardAbility();
			
			if(ca.getJackFlag() == true) {
				if(handstrength < fieldstrength) {
					return true;
				}
			}
			else {
				if(handstrength > fieldstrength) {
					return true;
				}
			}
			
		}
		
		return false;

	}
	
	public List<Card> getDeckList(){
		return deckList;
	}
	
	public Deque<Card> getFieldDeque(){
		return fieldDeque;
	}
	
	
	public boolean getPlayerPassFlag() {
		return playerPassFlag;
	}
	
	


}