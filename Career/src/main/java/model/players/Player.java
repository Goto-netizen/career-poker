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
	Stack<Card>fieldStack;
	
	/*
	 * コンストラクタ
	 */
	public Player(List<Card> deckList ,int index,Stack<Card> fieldStack) {
		this.deckList = deckList;
		this.index = index;
		this.fieldStack = fieldStack;
	}
	
	
	public void playerProcess()throws Exception {
		//List<Card> deck = new ArrayList<Card>();
		Card hand = deckList.get(index);
		
		hand.setCard_flag(3);
		
		fieldStack.push(hand);
		
	}
	
	public boolean judge() {
		
		if(fieldStack.isEmpty()) {			
			return true;
			
		}else {
			Card hand = deckList.get(index);
			int handstrength = hand.getStrength();
			
			Card fieldtop = fieldStack.peek();
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
		return fieldStack;
	}
	
	
	public boolean getPlayerPassFlag() {
		return true;
	}
	
	


}