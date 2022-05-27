package model.players;

import java.util.List;
import java.util.Stack;

import model.item.Card;

public class Player {
	

	/*
	 *フィールド
	 */
	List<Card> deckList;
	int index;
	Stack<Card>fieldstack;
	
	/*
	 * コンストラクタ
	 */
	public Player(List<Card> deckList ,int index,Stack<Card> fieldstack) {
		this.deckList = deckList;
		this.index = index;
		this.fieldstack = fieldstack;
	}
	
	
	public void playerProcess()throws Exception {
		//List<Card> deck = new ArrayList<Card>();
		Card hand = deckList.get(index);
		
		hand.setCard_flag(3);
		
		fieldstack.push(hand);
		
	}
	
	public boolean judge() {
		
		if(fieldstack.isEmpty()) {			
			return true;
			
		}else {
			Card hand = deckList.get(index);
			int handstrength = hand.getStrength();
			
			Card fieldtop = fieldstack.peek();
			int fieldstrength = fieldtop.getStrength();
			
			if(handstrength > fieldstrength) {
				return true;
			}
		}
		
		return false;

	}
	
	public List<Card> getDeckList(){
		return deckList;
	}
	
	public Stack<Card> getFieldStack(){
		return fieldstack;
	}
	
	
	public boolean getPlayerPassFlag() {
		return true;
	}
	
	


}