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
	
	
	public void playMyHand()throws Exception {
		//List<Card> deck = new ArrayList<Card>();
		Card hand = deckList.get(index);
		
		hand.setCard_flag(3);
		System.out.println("deckListの要素番号"+index+"のフラグを3に変えました");
		fieldDeque.push(hand);
		System.out.println("フィールドデキューに"+hand+"を追加しました");
		
		System.out.println("playMyHandが実行されました");
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
		
		System.out.println("judgeが実行されました");
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