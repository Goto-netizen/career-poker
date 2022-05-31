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
	CardAbility ca;
	
	public GeneralProcessing_withOption(List<Card> deckList,Deque<Card> fieldDeque){
		this.deckList = deckList;
		this.fieldDeque = fieldDeque;
		ca = new CardAbility();
	}

	public void generalProcess(int index)throws Exception {
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
			canPlayFlag = player.judge(ca);//formデータのindex値チェック
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
		System.out.println("============================================");
	}
	
	public void playerProcess(int index) {
		System.out.println("============================================");
		System.out.println("playerProcessを行います");
		System.out.println("============================================");
		Player player = new Player(this.deckList,index,this.fieldDeque);
		
		try {
			player.playMyHand();//プレイヤーの処理
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*処理結果を代入*/
		this.deckList = player.getDeckList();
		this.fieldDeque = player.getFieldDeque();
		ca.setCardNumber(fieldDeque.peek());
		
		/*テスト用*/
		System.out.println("deckList:"+this.deckList);
		System.out.println("fieldDeque:"+this.fieldDeque);
		
		/*カードの効果発動*/
		selectCardAbility(index);
		
		
		System.out.println("playerProcessが実行されました。");			
	}
	
	public void CPUProcess(int index) {
		System.out.println("============================================");
		System.out.println("CPUProcessを行います");
		System.out.println("============================================");
		//CardAbility ca = new CardAbility(this.fieldDeque.peek());
		System.out.println("ca.getEightflagの値："+ca.getEightFlag());
		if(ca.getEightFlag()) {
			System.out.println("if内ca.getEightflagの値："+ca.getEightFlag());
			endRound();
			//プレイヤーが８を出してCPUがパス
		}else {
			while(true) {   //CPUが８を出すとCPUのターン
				System.out.println("else内ca2.getEightflagの値："+ca.getEightFlag());
				
				CPU cpu = new CPU(this.deckList,this.fieldDeque);
				
				try {
					cpu.CPUProcessSequence(ca);//CPUの処理
				} catch (Exception e) {
					e.printStackTrace();
				 }
				
				System.out.println("CPUの処理が行われました。");
				
				if(cpu.getCPUPassFlag() == true) {//CPUがパスをした時
					endRound();
				}
				else {
					/*処理結果を代入*/
					this.deckList = cpu.getDeckList();
					this.fieldDeque = cpu.getFieldDeque();
					ca.setCardNumber(fieldDeque.peek());
					
					/*カードの効果発動*/
					selectCardAbility(index);
					
				}
				
				if(!ca.cardNumber.equals("eight")) {
					break;
				}else if(checkHandSize()) {
					break;
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
		//CardAbility ca = new CardAbility(this.fieldDeque.peek());
		
		switch(ca.getCardNumber()){
			case "seven": 
				ca.sevenAbility(this.deckList ,index);
				break;
			case "eight":
				ca.eightAbility();
				System.out.println("ca.getEightFlag"+ca.getEightFlag());
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
		System.out.println("selectCardAbilityが実行されました");
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
