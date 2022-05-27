package model.generalProcess;

import java.util.List;
import java.util.Stack;

import model.item.Card;
import model.players.CPU;
import model.players.Player;

public class GeneralProcessing {
	List<Card> deckList;
	Stack<Card> fieldStack;
	int cardFlag = 0;
	boolean endGameFlag;
	
	public GeneralProcessing(List<Card> deckList,Stack<Card> fieldStack){
		this.deckList = deckList;
		this.fieldStack = fieldStack;
		
	}
	
	public void generalProcess(int index) {
		
		boolean canPlayFlag = false;
		
		try {
			Player player = new Player(deckList,index,fieldStack);
			canPlayFlag = player.judge();
			System.out.println("canPlayFlagの値:"+canPlayFlag);
			/*ここから*/
			if(canPlayFlag) {//プレイヤーが出せるカードを選んだ時
				
				player.playerProcess();//プレイヤーの処理
				deckList = player.getDeckList();
				fieldStack = player.getFieldStack();
				
				
				System.out.println("deckList:"+deckList);
				System.out.println("fieldStack:"+fieldStack);
				System.out.println("プレイヤーの処理が行われました。");
				if(player.getPlayerPassFlag() == true) {//プレイヤーがパスをした時
					System.out.println("プレイヤーがパスを行いました。");
					endRound();
					System.out.println("場をリセットしました。");
				}
				
				endGameFlag = checkHandSize();//プレイヤーの手札が無くなったか判定
				
				System.out.println("endGameFlagの値:"+endGameFlag);
				
				CPU cpu = new CPU(deckList,fieldStack);
				
				cpu.CPUProcess();//CPUの処理
				
				deckList = cpu.getDeckList();
				fieldStack = cpu.getFieldStack();
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
	
	public  void endRound() {
		
	}
	
	public  boolean checkHandSize() {
		
		return false;
	}
	
	public List<Card> getDeckList(){
		return this.deckList;
	}
	public Stack<Card> getFieldStack(){
		return this.fieldStack;
	}
	
	
	public boolean getEndGameFlag() {
		return this.endGameFlag;
	}
	
}
