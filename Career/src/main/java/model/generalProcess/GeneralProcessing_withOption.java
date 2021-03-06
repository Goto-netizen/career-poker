package model.generalProcess;

import java.util.Deque;
import java.util.Iterator;
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
	int sevenFlag;
	CardAbility ca;
	
	public GeneralProcessing_withOption(List<Card> deckList,Deque<Card> fieldDeque){
		this.deckList = deckList;
		this.fieldDeque = fieldDeque;
		ca = new CardAbility();
		System.out.println("・GeneralProcessing_withOption");
		System.out.println("CardAbilityインスタンスを生成しました");
		if(!fieldDeque.isEmpty()) {//fieldDequeが空じゃなかったら
			Iterator<Card> itr = fieldDeque.descendingIterator();
			while (itr.hasNext()) {
				System.out.println("while(itr.hasNext())内fieldDeque:"+fieldDeque);
				if(itr.next().getNum().equals("Jack")) {//.nexr()➡要素を見たら次の要素に移る
					ca.setJackFlag(true);
					System.out.println("fieldDequeにJackが含まれていました。");
				}
			}
		}
		
	    
		
	}

	public void generalProcess(int index,int abilityIndex)throws Exception {
		boolean canPlayFlag = false;
		if(index == -1) {//プレイヤーがパスをした時
			System.out.println("プレイヤーがパスを行いました。");
			endRound();
			System.out.println("場をリセットしました。");
			CPUProcess(index,abilityIndex);
			this.endGameFlag = checkHandSize();
		}
		else {//プレイヤーがパス以外を選択した時
			Player player = new Player(this.deckList,index,this.fieldDeque);
			canPlayFlag = player.judge(ca);//formデータのindex値チェック
			System.out.println("P1➡canPlayFlagの値:"+canPlayFlag);
			/*ここから*/
			if(canPlayFlag) {//プレイヤーが出せるカードを選んだ時
				playerProcess(index,abilityIndex);
				this.endGameFlag = checkHandSize();//プレイヤーの手札が無くなったか判定
				System.out.println("endGameFlagの値:"+endGameFlag);
				CPUProcess(index,abilityIndex);
				this.endGameFlag = checkHandSize();	
			}
		}
		System.out.println("============================================");
	}
	
	public void playerProcess(int index,int abilityIndex) {
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
		this.sevenFlag = 1;//1:プレイヤー 2:CPU
		
		
		/*テスト用*/
		System.out.println("デッキの状態:deckList:"+this.deckList);
		System.out.println("出したカード:fieldDeque:"+this.fieldDeque);
		
		/*カードの効果発動*/
		selectCardAbility(index,abilityIndex);
		
		
		System.out.println("playerProcessが実行されました。");			
	}
	
	public void CPUProcess(int index,int abilityIndex) {
		System.out.println("============================================");
		System.out.println("CPUProcessを行います");
		System.out.println("============================================");
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
					System.out.println("============================================");
					System.out.println("CPUの処理を行います");
					System.out.println("============================================");
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
					this.sevenFlag = 2;//1:プレイヤー 2:CPU
					if(fieldDeque.peek().getNum_id() == 12) {
						cpu.selectNum_id(this.deckList);
						abilityIndex = cpu.getSelectedNum_id();
					}
					else {
						cpu.selectHandIndex(this.deckList);
						abilityIndex = cpu.getHandIndex();
					}
					
					
					/*テスト用*/
					System.out.println("デッキの状態:deckList:"+this.deckList);
					System.out.println("出したカード:fieldDeque:"+this.fieldDeque);
					
					
					/*カードの効果発動*/
					selectCardAbility(index,abilityIndex);
					
				}
				
				if(!ca.cardNumber.equals("eight")) {//場に出たカードが8じゃなかったらwhileを抜ける
					break;
				}else if(checkHandSize()) {//場に出たカードが8でも手札が0であればwhileを抜ける
					break;
				}
				else {
					endRound();//場に出たカードが8で手札も0じゃなければ場を流しwhileを続行
				}
				
			}
			
		}
		
	}


	public  void endRound() {
		while(fieldDeque.isEmpty()!= true) {
			fieldDeque.pop();
		}
		ca.setJackFlag(false);
		System.out.println("ca.getJackFlag():"+ca.getJackFlag());
		System.out.println("endRoundが実行されました");
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
		System.out.println("checkHandSizeが実行されました");
		if((count1 == 0)||(count2 == 0)) {
			return true;//ゲーム終了
		}
		else {
			return false;//ゲーム続行
		}
		
	}
	
	public void selectCardAbility(int index,int abilityIndex) {
		
		switch(ca.getCardNumber()){
			case "seven": 
				ca.sevenAbility(this.deckList ,abilityIndex,this.sevenFlag);
				break;
			case "eight":
				ca.eightAbility();
				System.out.println("ca.getEightFlag:"+ca.getEightFlag());
				break;
			case "nine":
				ca.nineAbility();
				break;
			case "ten":
				ca.tenAbility(this.deckList,abilityIndex);
				break;
			case "Jack":
				ca.jackAbility();
				break;
			case "Queen":
				ca.queenAbility(this.deckList,abilityIndex);
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
