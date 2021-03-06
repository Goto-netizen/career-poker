package model.players;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

import model.item.Card;

public class CPU_forBeginerMode {
	
	/*
	 *フィールド
	 */
	boolean CPUPassFlag;
	List<Card>deckList;
	Deque<Card>fieldDeque;
	int selectedIndex;
	int handIndex;
	int selectedNum_id;
	/*
	 * コンストラクタ
	 */
	public CPU_forBeginerMode(List<Card>deckList,Deque<Card>fieldDeque) {
		this.deckList = deckList;
		this.fieldDeque = fieldDeque;
		System.out.println("CPUが初期化されました");
	}
	
	
	public void CPUProcessSequence()throws Exception {//一連のCPU処理
		//List<Card> canPlayIdList = new ArrayList<>(); 
		List<Card> onlyFlag1List = new ArrayList<>();
		List<Card> canPlayCardsList = new ArrayList<>();
		int selectedCard_id = 0;
		
		//Flagが1のカードだけ収集
		onlyFlag1List = gatherFlag1Card();
		System.out.println("  -onlyFlag1List:"+onlyFlag1List);
		System.out.println("  -fieldDeque:"+fieldDeque);
		
		//場のカードより大きいカードだけ収集
		canPlayCardsList = checkCanPlayCard(onlyFlag1List);//ok
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
	
	public List<Card> checkCanPlayCard(List<Card>onlyFlag1List){
		System.out.println("・checkCanPlayCard");
		List<Card> canPlayCardsList = new ArrayList<>();
		if(fieldDeque.isEmpty()) {
			System.out.println("  -fieldDequeは空です");
			canPlayCardsList = onlyFlag1List;
		}
		else {
			System.out.println("  -fieldDequeは空ではありません。");
			for(int i=0;i<onlyFlag1List.size();i++) {
				if(fieldDeque.peek().getStrength()<onlyFlag1List.get(i).getStrength()) {//手札のカードが場のカードより強さが大きい時
					canPlayCardsList.add(onlyFlag1List.get(i));
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
	
	public void selectHandIndex(List<Card> deckList) {
		System.out.println("・selectHandIndex");
		Random rd = new Random();
		List<Card> onlyFlag1List = new ArrayList<>();
		Card selectedCard = null;
		
		//Flagが1のカードだけ収集
		onlyFlag1List = gatherFlag1Card();

		int random = (rd.nextInt(onlyFlag1List.size()));
		selectedCard = onlyFlag1List.get(random);
		
		setHandIndex(deckList.indexOf(selectedCard));
		
		System.out.println("  -selectHandIndexが実行されました");
	}
	
	public void selectNum_id(List<Card> deckList) {
		System.out.println("・selectNum_id");
		Random rd = new Random();
		int random = (rd.nextInt());
		
		/*1,2,7～16をランダムで選択*/
		while(true) {
			random = rd.nextInt(16)+1;
			if((random<3)||(random>6)) {
				break;
			}
		}
		
		setSelectedNum_id(random);
		System.out.println("  -CPUはカード番号"+random+"を選択しました");
		
		System.out.println("  -selectNum_idが実行されました");
	}
	
	public void setSelectedNum_id(int selectedNum_id) {
		this.selectedNum_id = selectedNum_id;
	}
	
	public int getSelectedNum_id(){
		return this.selectedNum_id;
	}
	
	public void setHandIndex(int handIndex) {
		this.handIndex = handIndex;
	}
	
	public int getHandIndex(){
		return this.handIndex;
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
