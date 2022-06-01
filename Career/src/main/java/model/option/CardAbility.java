package model.option;

import java.util.List;

import model.item.Card;

public class CardAbility {

	boolean eightFlag;
	boolean jackFlag;
	public String cardNumber;
	
	public CardAbility(){
		
	}
	//プレイヤーかCPUの処理が終わった後
	public void sevenAbility(List<Card> deckList ,int abilityIndex,int sevenFlag) {
		//仮引数 int sevenFlag = 0//初期値 1//プレイヤー 2//CPU
		if(sevenFlag == 1) {
			deckList.get(abilityIndex).setCard_flag(1);//プレイヤーのカード情報をCPUに書き換える
		}
		else if(sevenFlag == 2) {
			deckList.get(abilityIndex).setCard_flag(0);//CPUのカード情報をプレイヤーに書き換える
		}
		System.out.println(deckList.get(abilityIndex)+"を渡しました");
	}
	
	public void eightAbility() {
		//this.eightFlag = true;
		setEightFlag(true);
		System.out.println("eightFlag:"+this.eightFlag);
		
	}
	
	public void nineAbility() {
		
	}
	
	public void tenAbility(List<Card> deckList ,int abilityIndex) {
		deckList.get(abilityIndex).setCard_flag(4);
		System.out.println(deckList.get(abilityIndex)+"を捨てました");
	}
	
	public void jackAbility() {
		setJackFlag(true);
		System.out.println("jackFlag:"+this.jackFlag);
	}
	
	public void queenAbility(List<Card> deckList ,int abilityIndex) {
		for(Card card : deckList){
			if(card.getNum_id() == abilityIndex) {
				card.setCard_flag(4);
			}else {
				card.setCard_flag(card.getCard_flag());
			}
		}
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
