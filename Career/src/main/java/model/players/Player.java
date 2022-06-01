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
		
	}
	
	public boolean judge(CardAbility ca) {
		
		if(fieldDeque.isEmpty()) {			
			return true;
			
		}else {
			Card hand = deckList.get(index);
			int handStrength = hand.getStrength();
			System.out.println("hand:"+hand);
			
			Card fieldTop = fieldDeque.peek();
			int fieldStrength = fieldTop.getStrength();
			System.out.println("ca.getJackFlag():"+ca.getJackFlag());
			if(ca.getJackFlag() == true) {//イレブンバックの時
				if(hand.getNum().equals("Joker")) {//プレイヤーが選んだ手札がjokerの時
					hand.setStrength(6);//手札のjokerの強さを6にする
					handStrength = hand.getStrength();//手札の強さを更新
				}
				if(fieldTop.getNum_id() == 14) {//場のトップがjokerの時
					if(hand.getCard_id() == 7) {//でかつ選択されているFlag1のカードがスペードの2の時
						hand.setStrength(5);
						return true;//そのカードも出すことができる
					}
				}
				if(handStrength < fieldStrength) {
					return true;
				}
			}
			else {
				if(fieldTop.getNum_id() == 14) {//場のトップがjokerの時
					if(hand.getCard_id() == 11) {//でかつ選択されているFlag1のカードがスペードの7の時
						hand.setStrength(17);
						return true;//そのカードも出すことができる
					}
				}
				if(handStrength > fieldStrength) {
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