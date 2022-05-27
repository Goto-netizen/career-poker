package model.generalProcess;

import java.util.List;

import model.item.Card;
import model.players.CPU;
import model.players.Player;

public class GeneralProcessing {

	List<Card> playerHandList; 
	List<Card> CPUHandList; 
	List<Card> deckList;
	int cardFlag = 0;
	
	public GeneralProcessing(List<Card> deckList){
		this.deckList = deckList;
		
		
	}
	
	public void generalProcess(int index) {
		
		distributeCard();
		Player player = new Player(playerHandList);
		CPU cpu = new CPU(CPUHandList);
		
		boolean canPlayFlag = false;
		
		try {
			canPlayFlag = player.judge(index);
			System.out.println("canPlayFlagの値:"+canPlayFlag);
			/*ここから*/
			if(canPlayFlag) {//プレイヤーが出せるカードを選んだ時
				
				player.playerProcess(index);//プレイヤーの処理
				
				System.out.println("プレイヤーの処理が行われました。");
				if(gp.getPlayerPassFlag() == true) {//プレイヤーがパスをした時
					System.out.println("プレイヤーがパスを行いました。");
					gp.endRound();
					System.out.println("場をリセットしました。");
				}
				
				endGameFlag = gp.checkHandSize();//プレイヤーの手札が無くなったか判定
				
				System.out.println("endGameFlagの値:"+endGameFlag);
				if(endGameFlag == true) {//プレイヤーの手札が0の時
					//session.setAttribute("勝者");
					//終了.jspへ
				}
				gp.CPUProcess();//CPUの処理
				System.out.println("CPUの処理が行われました。");
				if(gp.getCPUPassFlag() == true) {//CPUがパスをした時
					gp.endRound();
				}
				endGameFlag = gp.checkHandSize();
				if(endGameFlag == true) {
					//session.setAttribute("勝者");
					//終了.jspへ
				}
			}
		} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}
	
	public void distributeCard() {
		for(int i=0;i<deckList.size();i++) {
			cardFlag = deckList.get(i).getCardFlag();
			if(cardFlag == 0) {
				playerHandList.add(deckList.get(i));
			}
			else {
				CPUHandList.add(deckList.get(i));
			}
		}
		
	}
	
	public  void endRound() {
		
	}
	
	public  boolean checkHandSize() {
		
		
	}
}
