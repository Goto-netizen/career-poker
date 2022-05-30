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
	
	public GeneralProcessing_withOption() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void generalProcess(int index) {
		boolean canPlayFlag = false;
		if(index == -1) {//プレイヤーがパスをした時
			System.out.println("プレイヤーがパスを行いました。");
			endRound();
			System.out.println("場をリセットしました。");
			CPUProcess(index);
			this.endGameFlag = checkHandSize();
		}
		else {//プレイヤーがパス以外を選択した時
			Player player = new Player(this.deckList,index,this.fieldDeque);
			canPlayFlag = player.judge();//formデータのindex値チェック
			System.out.println("P1➡canPlayFlagの値:"+canPlayFlag);
			/*ここから*/
			if(canPlayFlag) {//プレイヤーが出せるカードを選んだ時
				playerProcess(index);
				this.endGameFlag = checkHandSize();//プレイヤーの手札が無くなったか判定
				System.out.println("endGameFlagの値:"+endGameFlag);
				CPUProcess(index);
				this.endGameFlag = checkHandSize();	
			}
		}
	}
	
	public void playerProcess(int index) {
		Player player = new Player(this.deckList,index,this.fieldDeque);
		
		try {
			player.playMyHand();//プレイヤーの処理
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*処理結果を代入*/
		this.deckList = player.getDeckList();
		this.fieldDeque = player.getFieldDeque();
		
		/*カードの効果発動*/
		selectCardAbility(index);
		
		/*テスト用*/
		System.out.println("deckList:"+this.deckList);
		System.out.println("fieldDeque:"+this.fieldDeque);
		System.out.println("プレイヤーの処理が行われました。");			
	}
	
	public void CPUProcess(int index) {
		CardAbility ca = new CardAbility();
		if(ca.getEightFlag()) {
			//プレイヤーが８を出してCPUがパス
		}else {
			while(ca.getEightFlag()) {   //CPUが８を出すとCPUのターン
				CPU cpu = new CPU(this.deckList,this.fieldDeque);
				
				try {
					cpu.CPUProcessSequence();//CPUの処理
				} catch (Exception e) {
					e.printStackTrace();
				 }
				
				/*処理結果を代入*/
				this.deckList = cpu.getDeckList();
				this.fieldDeque = cpu.getFieldDeque();
				
				/*カードの効果発動*/
				selectCardAbility(index);
				if(!ca.cardNumber.equals("8")) {
					break;
				}
				System.out.println("CPUの処理が行われました。");
				if(cpu.getCPUPassFlag() == true) {//CPUがパスをした時
					endRound();
				}
			}
			
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
	
	public void selectCardAbility(int index) {
		CardAbility ca = new CardAbility(this.fieldDeque.peek());
		
		switch(ca.cardNumber){
			case "seven": 
				ca.sevenAbility();
				break;
			case "eight":
				ca.eightAbility();
				break;
			case "nine":
				ca.nineAbility();
				break;
			case "ten":
				ca.tenAbility(this.deckList,index);
			case "Jack":
				ca.jackAbility();
				break;
			case "Queen":
				ca.queenAbility(this.deckList,index);
				break;
			case "King":
				ca.kingAbility();
				break;
		
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
