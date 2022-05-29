package model.players;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import model.item.Card;

public class CPU {
	
	/*
	 *フィールド
	 */
	boolean CPUPassFlag;
	List<Card>deckList;
	Stack<Card>fieldStack;
	int selectedIndex;
	/*
	 * コンストラクタ
	 */
	public CPU(List<Card>deckList,Stack<Card>fieldStack) {
		this.deckList = deckList;
		this.fieldStack = fieldStack;
		System.out.println("CPUが初期化されました");
	}
	
	
	public void CPUProcess()throws Exception {
		//List<Card> canPlayIdList = new ArrayList<>(); 
		List<Card> onlyFlag1List = new ArrayList<>();
		List<Card> canPlayCardsList = new ArrayList<>();
		int selectedCard_id = 0;
		
		//Flagが1のカードだけ収集
		onlyFlag1List = gatherFlag1Card();
		System.out.println("onlyFlag1List:"+onlyFlag1List);
		System.out.println("fieldStack:"+fieldStack);
		
		//場のカードより大きいカードだけ収集
		canPlayCardsList = checkCanPlayCard(onlyFlag1List);//ok
		System.out.println("canPlayCardsList:"+canPlayCardsList);
		System.out.println("fieldStack:"+fieldStack);
		
		//場のカードより大きいカードがある
		if(canPlayCardsList.size() != 0) {//ok
			selectedCard_id = selectCard_id(canPlayCardsList.size(),canPlayCardsList);//選択した手札のカードID
			System.out.println("selectedCard_id:"+selectedCard_id);
			changeCard_Flag(selectedCard_id);//ok
			//System.out.println("onlyFlag1List:"+onlyFlag1List);
			
			playCPUCard();//
			//System.out.println("onlyFlag1List:"+onlyFlag1List);
			System.out.println("fieldStack:"+fieldStack);
		}
		else {//CPUはパスをする
			CPUPassFlag = true;
		}
		
		
		
		
	}
	
	public List<Card> gatherFlag1Card(){
		List<Card> onlyFlag1List = new ArrayList<>();
		for(int i=0;i<deckList.size();i++) {
			if(deckList.get(i).getCard_flag() == 1) {
				onlyFlag1List.add(deckList.get(i));
			}
			
		}
		System.out.println("gatherFlag1Cardが実行されました");
		
		return onlyFlag1List;
	}
	
	public List<Card> checkCanPlayCard(List<Card>onlyFlag1List){
		List<Card> canPlayCardsList = new ArrayList<>();
		if(fieldStack.isEmpty()) {
			System.out.println("fieldStackは空です");
			canPlayCardsList = onlyFlag1List;
		}
		else {
			System.out.println("fieldStackは空ではありません。");
			for(int i=0;i<onlyFlag1List.size();i++) {
				if(fieldStack.peek().getStrength()<onlyFlag1List.get(i).getStrength()) {
					canPlayCardsList.add(onlyFlag1List.get(i));
				}
			}
		}
		System.out.println("checkCanPlayCardが実行されました");
		return canPlayCardsList;
	}
	
	public int selectCard_id(int listSize,List<Card> canPlayCardsList) {
		Card CPUSelectedCard = null;//9
		int CPUSelectedCard_id = 0;
		Random rd = new Random();
		int random = rd.nextInt(listSize);
	
		//出せるカードの中からランダムで選出
		CPUSelectedCard = canPlayCardsList.get(random);	
		CPUSelectedCard_id = CPUSelectedCard.getCard_id();
		System.out.println("selectCard_idが実行されました");
		return 	CPUSelectedCard_id;
	}
	
	public void changeCard_Flag(int selectedCard_id) {
		
		for(int i=0;i<deckList.size();i++) {
			if(deckList.get(i).getCard_id() == selectedCard_id) {//選んだカードのIDと同じ山札のカードの時
				selectedIndex = i;
			}
		}
		
		deckList.get(selectedIndex).setCard_flag(3);//フラグを3に書き換える
		System.out.println("書き換え後のdeckListの中身"+deckList);
		System.out.println("changeCard_Flagが実行されました");
	}
	
	public void playCPUCard() {
		fieldStack.push(deckList.get(selectedIndex));//余りが入った
		System.out.println("playCPUCardが実行されました");
	}
	
	public void setDeckList(List<Card> deckList) {
		this.deckList = deckList;
	}
	
	public List<Card> getDeckList(){
		return this.deckList;
	}
	
	public void setFeildStack(Stack<Card>fieldStack) {
		this.fieldStack = fieldStack;
	}
	
	public Stack<Card> getFieldStack(){
		return this.fieldStack;
	}
	
	public boolean getCPUPassFlag() {
		return CPUPassFlag;
	}
}
