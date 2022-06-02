package model.players;

import java.util.Deque;
import java.util.List;

import model.item.Card;

public class Player_forBeginerMode {
	

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
	public Player_forBeginerMode(List<Card> deckList ,int index,Deque<Card> fieldDeque) {
		this.deckList = deckList;
		this.index = index;
		this.fieldDeque = fieldDeque;
	}
	
	
	public void playMyHand()throws Exception {
		Card hand = deckList.get(index);
		hand.setCard_flag(3);
		System.out.println("deckListの要素番号"+index+"のフラグを3に変えました");
		fieldDeque.push(hand);
		System.out.println("フィールドデキューに"+hand+"を追加しました");
		
	}
	
	public boolean judge() {
		
		if(fieldDeque.isEmpty()) {			
			return true;
			
		}else {
			Card hand = deckList.get(index);
			int handStrength = hand.getStrength();
			System.out.println("hand:"+hand);
			
			Card fieldTop = fieldDeque.peek();
			int fieldStrength = fieldTop.getStrength();
			
			if(handStrength > fieldStrength) {
					return true;
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