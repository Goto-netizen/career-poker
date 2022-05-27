package model.generalProcess;

import java.util.Deque;
import java.util.List;

import model.item.Card;
import model.players.CPU;
import model.players.Player;

public class GeneralProcessing {
	List<Card> deckList;
	int cardFlag = 0;
	boolean endGameFlag;
	
	public GeneralProcessing(List<Card> deckList){
		this.deckList = deckList;
		
		
	}
	
	public void generalProcess(List<Card> deckList ,int index,Deque<Card> deque) {
		
		distributeCard();
		Player player = new Player(deckList,index,deque);
		CPU cpu = new CPU(deckList,index,deque);
		
		boolean canPlayFlag = false;
		boolean endGameFlag = false;
		
		try {
			canPlayFlag = player.judge(deckList,index,deque);
			System.out.println("canPlayFlagの値:"+canPlayFlag);
			/*ここから*/
			if(canPlayFlag) {//プレイヤーが出せるカードを選んだ時
				
				player.playerProcess(deckList,index,deque);//プレイヤーの処理
				
				System.out.println("プレイヤーの処理が行われました。");
				if(player.getPlayerPassFlag() == true) {//プレイヤーがパスをした時
					System.out.println("プレイヤーがパスを行いました。");
					endRound();
					System.out.println("場をリセットしました。");
				}
				
				endGameFlag = checkHandSize();//プレイヤーの手札が無くなったか判定
				
				System.out.println("endGameFlagの値:"+endGameFlag);
				
				cpu.CPUProcess();//CPUの処理
				System.out.println("CPUの処理が行われました。");
				if(cpu.getCPUPassFlag() == true) {//CPUがパスをした時
					endRound();
				}
				endGameFlag = checkHandSize();
				
			}
		} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}
	
	public void distributeCard() {
		for(int i=0;i<deckList.size();i++) {
			cardFlag = deckList.get(i).getCard_flag();
			if(cardFlag == 0) {
				playerHandList.add(deckList.get(i));
			}
			if(cardFlag == 1){
				CPUHandList.add(deckList.get(i));
			}
		}
		
	}
	
	public  void endRound() {
		
	}
	
	public  boolean checkHandSize() {
		
		return false;
	}
	
	public boolean getEndGameFlag() {
		return this.endGameFlag;
	}
	
}
