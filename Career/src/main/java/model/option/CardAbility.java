package model.option;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> branch 'master' of https://github.com/Goto-netizen/career-poker.git
import model.item.Card;

public class CardAbility {

	boolean jackFlag;
	public int cardNumber;
	
<<<<<<< HEAD
	public CardAbility(Card topCard){
		this.cardNumber = Integer.parseInt(topCard.getNum());
=======
	public CardAbility(){
		
>>>>>>> branch 'master' of https://github.com/Goto-netizen/career-poker.git
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
