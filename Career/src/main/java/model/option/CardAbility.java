package model.option;

import java.util.ArrayList;
import java.util.List;

import model.item.Card;

public class CardAbility {

	boolean eightFlag = false;
	boolean jackFlag;
	public String cardNumber;
	
	public CardAbility(Card topCard){
		this.cardNumber = topCard.getNum();
	}
	public CardAbility(){
		

	}
	
	public List<Card> sevenAbility(List<Card> deckList ,int abilityIndex) {
		
		deckList.get(abilityIndex).setCard_flag(1);
		return deckList;
	}
	
	public void eightAbility() {
		
		
		eightFlag = true;
		
	}
	
	public void nineAbility() {
		
	}
	
	public List<Card> tenAbility(List<Card> deckList ,int abilityIndex) {
		
		deckList.get(abilityIndex).setCard_flag(4);
		return deckList;
	}
	
	public void jackAbility() {
		jackFlag = true;
		
	}
	public List<Card> queenAbility(List<Card> deckList ,int abilityIndex) {
		List<Card> newDeckList = new ArrayList<Card>();
		for(Card card : deckList){
			
			
			Card deck = new Card(card.getCard_id(),card.getNum(),card.getMark(),card.getStrength());
			if(card.getStrength()==abilityIndex) {
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
	public boolean getEightFlag() {
		return this.eightFlag;
	}
	public boolean getJackFlag() {
		return this.jackFlag;
	}
}
