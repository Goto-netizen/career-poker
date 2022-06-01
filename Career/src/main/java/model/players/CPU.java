package model.players;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

import model.item.Card;
import model.option.CardAbility;

public class CPU {
	
	/*
	 *フィールド
	 */
	boolean CPUPassFlag;
	List<Card>deckList;
	Deque<Card>fieldDeque;
	int selectedIndex;
	int abilityIndex;
	/*
	 * コンストラクタ
	 */
	public CPU(List<Card>deckList,Deque<Card>fieldDeque) {
		this.deckList = deckList;
		this.fieldDeque = fieldDeque;
		System.out.println("CPUが初期化されました");
	}
	
	
	public void CPUProcessSequence(CardAbility ca)throws Exception {//一連のCPU処理
		//List<Card> canPlayIdList = new ArrayList<>(); 
		List<Card> onlyFlag1List = new ArrayList<>();
		List<Card> canPlayCardsList = new ArrayList<>();
		int selectedCard_id = 0;
		
		//Flagが1のカードだけ収集
		onlyFlag1List = gatherFlag1Card();
		System.out.println("  -onlyFlag1List:"+onlyFlag1List);
		System.out.println("  -fieldDeque:"+fieldDeque);
		
		//場のカードより大きいカードだけ収集
		canPlayCardsList = checkCanPlayCard(onlyFlag1List,ca);//ok
		System.out.println("  -canPlayCardsList:"+canPlayCardsList);
		System.out.println("  -fieldDeque:"+fieldDeque);
		
		//場のカードより大きいカードがある
		if(canPlayCardsList.size() != 0) {//ok
			selectedCard_id = selectCard_id(canPlayCardsList.size(),canPlayCardsList);//選択した手札のカードID
			System.out.println("  -selectedCard_id:"+selectedCard_id);
			changeCard_Flag(selectedCard_id);//ok
			playCPUCard();
			System.out.println("  -fieldDeque:"+fieldDeque);
		}
		else {//CPUはパスをする
			CPUPassFlag = true;
		}
		
	}
	
	public List<Card> gatherFlag1Card(){
		System.out.println("・gatherFlag1Card");
		List<Card> onlyFlag1List = new ArrayList<>();
		for(int i=0;i<deckList.size();i++) {
			if(deckList.get(i).getCard_flag() == 1) {
				onlyFlag1List.add(deckList.get(i));
			}
			
		}
		System.out.println("  -gatherFlag1Cardが実行されました");
		
		return onlyFlag1List;
	}
	
	public List<Card> checkCanPlayCard(List<Card>onlyFlag1List,CardAbility ca){
		System.out.println("・checkCanPlayCard");
		List<Card> canPlayCardsList = new ArrayList<>();
		if(fieldDeque.isEmpty()) {
			System.out.println("  -fieldDequeは空です");
			canPlayCardsList = onlyFlag1List;
		}
		else {
			System.out.println("  -fieldDequeは空ではありません。");
			for(int i=0;i<onlyFlag1List.size();i++) {
				if(ca.getJackFlag() == true) {//jackFlagがtrueの時
					if(onlyFlag1List.get(i).getNum().equals("Joker")) {
						onlyFlag1List.get(i).setStrength(6);
					}
					if(fieldDeque.peek().getStrength()>onlyFlag1List.get(i).getStrength()) {
						canPlayCardsList.add(onlyFlag1List.get(i));
					}
				}
				else {
					if(fieldDeque.peek().getStrength()<onlyFlag1List.get(i).getStrength()) {
						canPlayCardsList.add(onlyFlag1List.get(i));
					}
				}
				
			}
		}
		System.out.println("  -checkCanPlayCardが実行されました");
		return canPlayCardsList;
	}
	
	public int selectCard_id(int listSize,List<Card> canPlayCardsList) {
		System.out.println("・selectCard_id");
		Card CPUSelectedCard = null;
		int CPUSelectedCard_id = 0;
		Random rd = new Random();
		int random = rd.nextInt(listSize);
	
		//出せるカードの中からランダムで選出
		CPUSelectedCard = canPlayCardsList.get(random);	
		CPUSelectedCard_id = CPUSelectedCard.getCard_id();
		System.out.println("  -selectCard_idが実行されました");
		return 	CPUSelectedCard_id;
	}
	
	public void changeCard_Flag(int selectedCard_id) {
		System.out.println("・changeCard_Flag");
		for(int i=0;i<deckList.size();i++) {
			if(deckList.get(i).getCard_id() == selectedCard_id) {//選んだカードのIDと同じ山札のカードの時
				selectedIndex = i;
			}
		}
		
		deckList.get(selectedIndex).setCard_flag(3);//フラグを3に書き換える
		System.out.println("  -書き換え後のdeckListの中身"+deckList);
		System.out.println("  -changeCard_Flagが実行されました");
	}
	
	public void playCPUCard() {
		System.out.println("・playCPUCard");
		fieldDeque.push(deckList.get(selectedIndex));//余りが入った
		System.out.println("  -playCPUCardが実行されました");
	}
	
	public void selectAbilityIndex(List<Card> deckList) {
		System.out.println("・selectAbilityIndex");
		Random rd = new Random();
		List<Card> onlyFlag1List = new ArrayList<>();
		Card selectedCard = null;
		//Flagが1のカードだけ収集
		onlyFlag1List = gatherFlag1Card();

		int random = (rd.nextInt(onlyFlag1List.size()));
		selectedCard = onlyFlag1List.get(random);
		
		setAbilityIndex(deckList.indexOf(selectedCard));
		
		System.out.println("  -selectAbilityIndexが実行されました");
	}
	
	public void setAbilityIndex(int abilityIndex) {
		this.abilityIndex = abilityIndex;
	}
	
	public int getAbilityIndex(){
		return this.abilityIndex;
	}
	
	public void setDeckList(List<Card> deckList) {
		this.deckList = deckList;
	}
	
	public List<Card> getDeckList(){
		return this.deckList;
	}
	
	public void setFeildDeque(Deque<Card>fieldDeque) {
		this.fieldDeque = fieldDeque;
	}
	
	public Deque<Card> getFieldDeque(){
		return this.fieldDeque;
	}
	
	public boolean getCPUPassFlag() {
		return CPUPassFlag;
	}
}
