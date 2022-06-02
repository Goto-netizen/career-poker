package model.generalProcess;

import java.util.Deque;
import java.util.List;

import model.item.Card;
import model.option.CardAbility;
import model.players.CPU_forBeginerMode;
import model.players.Player_forBeginerMode;

public class GeneralProcessing {
	List<Card> deckList;
	Deque<Card> fieldDeque;
	int cardFlag = 0;
	boolean endGameFlag;
	CardAbility ca;
	
	public GeneralProcessing(List<Card> deckList,Deque<Card> fieldDeque){
		this.deckList = deckList;
		this.fieldDeque = fieldDeque;
		ca = new CardAbility();
	}
	
	public void generalProcess(int index) {
		
		boolean canPlayFlag = false;
		
		try {
			Player_forBeginerMode playerbm = new Player_forBeginerMode(deckList,index,fieldDeque);
			if(index == -1) {//プレイヤーがパスをした時
				System.out.println("プレイヤーがパスを行いました。");
				endRound();
				System.out.println("場をリセットしました。");
				
				CPU_forBeginerMode cpu_bm = new CPU_forBeginerMode(deckList,fieldDeque);
				
				cpu_bm.CPUProcessSequence();//CPUの処理
				
				deckList = cpu_bm.getDeckList();
				fieldDeque = cpu_bm.getFieldDeque();
				System.out.println("CPUの処理が行われました。");
				if(cpu_bm.getCPUPassFlag() == true) {//CPUがパスをした時
					endRound();
				}
				endGameFlag = checkHandSize();		
				
				
			}
			else {
				canPlayFlag = playerbm.judge();
				System.out.println("P1➡canPlayFlagの値:"+canPlayFlag);
				/*ここから*/
				if(canPlayFlag) {//プレイヤーが出せるカードを選んだ時
					
					playerbm.playMyHand();//プレイヤーの処理
					deckList = playerbm.getDeckList();
					fieldDeque = playerbm.getFieldDeque();
					
				
					System.out.println("deckList:"+deckList);
					System.out.println("fieldDeque:"+fieldDeque);
					System.out.println("プレイヤーの処理が行われました。");
					if(playerbm.getPlayerPassFlag() == true) {//プレイヤーがパスをした時
						System.out.println("プレイヤーがパスを行いました。");
						endRound();
						System.out.println("場をリセットしました。");
					}
				
					endGameFlag = checkHandSize();//プレイヤーの手札が無くなったか判定
					
					System.out.println("endGameFlagの値:"+endGameFlag);
					CPU_forBeginerMode cpu_bm = new CPU_forBeginerMode(deckList,fieldDeque);
			
					cpu_bm.CPUProcessSequence();//CPUの処理
					
					deckList = cpu_bm.getDeckList();
					fieldDeque = cpu_bm.getFieldDeque();
					System.out.println("CPUの処理が行われました。");
					if(cpu_bm.getCPUPassFlag() == true) {//CPUがパスをした時
						endRound();
					}
					endGameFlag = checkHandSize();		
				}
				
			}
			
		} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
		 }
	}
	
	public  void endRound() {
		while(fieldDeque.isEmpty()!= true) {
			fieldDeque.pop();
		}
	}
	
	public  boolean checkHandSize() {
		int count1 = 0;
		int count2 = 0;
		
		for(int i=0;i<deckList.size();i++) {
			if(deckList.get(i).getCard_flag()==0) {//山札に自分のカードが残っていない
				count1++;
			}
			
			if(deckList.get(i).getCard_flag()==1) {//山札にCPUのカードが残っていない
				count2++;
			}
		}
		
		if((count1 == 0)||(count2 == 0)) {
			return true;//ゲーム終了
		}
		else {
			return false;//ゲーム続行
		}
		
	}
	
	public List<Card> getDeckList(){
		return this.deckList;
	}
	public Deque<Card> getFieldDeque(){
		return this.fieldDeque;
	}
	
	
	public boolean getEndGameFlag() {
		return this.endGameFlag;
	}
	
}
