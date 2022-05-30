package model.option;

import java.util.List;

import model.item.Card;

public class CardAbility {

	boolean jackFlag;
	public String cardNumber;
	private boolean OrderCPUPass;
	
	public CardAbility(Card topCard){
		this.cardNumber = topCard.getNum();
	}
	public CardAbility(){
		

	}
	
	public void sevenAbility() {
		
		
	}
	
	public boolean eightAbility() {
		OrderCPUPass = true;
		return OrderCPUPass;
		
	}
	
	public void nineAbility() {
		
	}
	
	public List<Card> tenAbility(List<Card> deckList ,int index) {
		
		deckList.get(index).setCard_flag(4);
		
		return deckList;
	}
	public void jackAbility() {
		jackFlag = true;
		
	}
	public void queenAbility() {
		
	}
	public void kingAbility() {
		
	}
	
	public boolean getJackFlag() {
		return this.jackFlag;
	}
}
