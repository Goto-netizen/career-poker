package model.option;

import java.util.ArrayList;
import java.util.List;

import model.item.Card;

public class CardAbility {

	boolean eightFlag;
	boolean jackFlag;
	public String cardNumber;
	
	public CardAbility(){
		
	}
	
	public List<Card> sevenAbility(List<Card> deckList ,int throw_index) {
		
		deckList.get(throw_index).setCard_flag(1);
		return deckList;
	}
	
	public void eightAbility() {
		//this.eightFlag = true;
		setEightFlag(true);
		System.out.println("eightFlag:"+this.eightFlag);
		
	}
	
	public void nineAbility() {
		
	}
	
	public List<Card> tenAbility(List<Card> deckList ,int throw_index) {
		
		deckList.get(throw_index).setCard_flag(4);
		return deckList;
	}
	
	public void jackAbility() {
		setJackFlag(true);
		System.out.println("jackFlag:"+this.jackFlag);
	}
	
	public List<Card> queenAbility(List<Card> deckList ,int blast_index) {
		List<Card> newDeckList = new ArrayList<Card>();
		for(Card card : deckList){
			
			
			Card deck = new Card(card.getCard_id(),card.getNum(),card.getMark(),card.getStrength());
			if(card.getStrength()==blast_index) {
				deck.setCard_flag(4);
			}else {
				deck.setCard_flag(card.getCard_flag());
			}
			newDeckList.add(deck);
		}
		return newDeckList;
		
	}
	public void kingAbility() {
		
	}
	
	public void setEightFlag(boolean eightFlag) {
		this.eightFlag = eightFlag;
	}
	
	public void setCardNumber(Card topCard) {
		this.cardNumber = topCard.getNum();
	}
	
	public String getCardNumber() {
		return this.cardNumber;
	}
	
	public boolean getEightFlag() {
		return this.eightFlag;
	}
	
	public void setJackFlag(boolean jackFlag) {
		this.jackFlag = jackFlag;
	}
	
	public boolean getJackFlag() {
		return this.jackFlag;
	}
}
