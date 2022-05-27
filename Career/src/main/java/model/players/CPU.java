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
		onlyFlag1List = gatherFlag1Card(deckList);
		System.out.println("onlyFlag1List:"+onlyFlag1List);
		System.out.println("fieldStack:"+fieldStack);
		
		//場のカードより大きいカードだけ収集
		canPlayCardsList = checkCanPlayCard(onlyFlag1List);//ここ
		
		//場のカードより大きいカードがある
		if(canPlayCardsList.size() != 0) {
			selectedCard_id = selectCard_id(canPlayCardsList.size(),canPlayCardsList);
		}
		else {//CPUはパスをする
			CPUPassFlag = true;
		}
		
		
		
		
	}
	
	public List<Card> gatherFlag1Card(List<Card> deckList){
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
		Card CPUSelectedCard = null;
		int CPUSelectedCard_id = 0;
		Random rd = new Random();
		int random = rd.nextInt(listSize);
	
		//出せるカードの中からランダムで選出
		CPUSelectedCard = canPlayCardsList.get(random);	
		CPUSelectedCard_id = CPUSelectedCard.getCard_id();
		return 	CPUSelectedCard_id;
	}
	
	public void changeCardFlag(List<Card> deckList,int selectedCard_id) {
		int selectedIndex = 0;
		for(int i=0;i<deckList.size();i++) {
			if(deckList.get(i).getCard_id() == selectedCard_id) {
				selectedIndex = i;
			}
		}
		
		deckList.get(selectedIndex).setCard_flag(3);
		
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
