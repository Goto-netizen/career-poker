package model.option;

import java.util.List;

import model.item.Card;

public class CardAbility {

	boolean jackFlag;
	public int cardNumber;
	
	public CardAbility(Card topCard){
		this.cardNumber = Integer.parseInt(topCard.getNum());
	}
	public CardAbility(){
		

	}
	
	public void sevenAbility() {
		
		
	}
	
	public void eightAbility() {
		
		
	}
	
	public void nineAbility() {
		
	}
	
	public List<Card> tenAbility(List<Card> deckList ,int index) {
		
		deckList.get(index).setCard_flag(4);
		
		return deckList;
	}
	public void jackAbility() {
		
		
		
		
	}
	public void queenAbility() {
		
	}
	public void kingAbility() {
		
	}
	
}
