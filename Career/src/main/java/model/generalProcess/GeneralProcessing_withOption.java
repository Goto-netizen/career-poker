package model.generalProcess;

import java.util.Deque;
import java.util.List;

import model.item.Card;
import model.option.CardAbility;
import model.players.CPU;
import model.players.Player;

public class GeneralProcessing_withOption {

	List<Card> deckList;
	Deque<Card> fieldDeque;
	int cardFlag = 0;
	boolean endGameFlag;
	
	public GeneralProcessing_withOption(List<Card> deckList,Deque<Card> fieldDeque){
		this.deckList = deckList;
		this.fieldDeque = fieldDeque;
		
	}
	
public void generalProcess(int index) {
		
		boolean canPlayFlag = false;
		
		try {
			Player player = new Player(deckList,index,fieldDeque);
			if(index == -1) {//プレイヤーがパスをした時
				System.out.println("プレイヤーがパスを行いました。");
				endRound();
				System.out.println("場をリセットしました。");
				
				CPU cpu = new CPU(deckList,fieldDeque);
				
				cpu.CPUProcess();//CPUの処理
				
				deckList = cpu.getDeckList();
				fieldDeque = cpu.getFieldDeque();
				System.out.println("CPUの処理が行われました。");
				if(cpu.getCPUPassFlag() == true) {//CPUがパスをした時
					endRound();
				}
				endGameFlag = checkHandSize();		
				
				
			}
			else {
				canPlayFlag = player.judge();
				System.out.println("P1➡canPlayFlagの値:"+canPlayFlag);
				/*ここから*/
				if(canPlayFlag) {//プレイヤーが出せるカードを選んだ時
					
					player.playerProcess();//プレイヤーの処理
					/*処理結果を代入*/
					deckList = player.getDeckList();
					fieldDeque = player.getFieldDeque();
					/*カードの効果発動*/
					CardAbility ca = new CardAbility(fieldDeque.peek());
					
					switch(ca.cardNumber){
						case 7: 
							ca.sevenAbility();
							break;
						case 8:
							ca.eightAbility();
							break;
						case 9:
							ca.nineAbility();
							break;
						case 10:
							ca.tenAbility(deckList,index);
						case 11:
							ca.jackAbility();
							break;
						case 12:
							ca.queenAbility();
							break;
						case 13:
							ca.kingAbility();
							break;
					
					}
					System.out.println("deckList:"+deckList);
					System.out.println("fieldDeque:"+fieldDeque);
					System.out.println("プレイヤーの処理が行われました。");
					if(player.getPlayerPassFlag() == true) {//プレイヤーがパスをした時
						System.out.println("プレイヤーがパスを行いました。");
						endRound();
						System.out.println("場をリセットしました。");
					}
				
					endGameFlag = checkHandSize();//プレイヤーの手札が無くなったか判定
					
					System.out.println("endGameFlagの値:"+endGameFlag);
					CPU cpu = new CPU(deckList,fieldDeque);
			
					cpu.CPUProcess();//CPUの処理
					
					/*処理結果を代入*/
					deckList = cpu.getDeckList();
					fieldDeque = cpu.getFieldDeque();
					
					/*カードの効果発動*/
					CardAbility ca2 = new CardAbility(fieldDeque.peek());
					
					switch(ca2.cardNumber){
						case 7: 
							ca2.sevenAbility();
							break;
						case 8:
							ca2.eightAbility();
							break;
						case 9:
							ca2.nineAbility();
							break;
						case 10:
							ca2.tenAbility(deckList,index);
						case 11:
							ca2.jackAbility();
							break;
						case 12:
							ca2.queenAbility();
							break;
						case 13:
							ca2.kingAbility();
							break;
					
					}
					System.out.println("CPUの処理が行われました。");
					if(cpu.getCPUPassFlag() == true) {//CPUがパスをした時
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
