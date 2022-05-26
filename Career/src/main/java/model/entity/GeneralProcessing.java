package model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneralProcessing {
	List<TestBean> playerHandList; 
	List<TestBean> CPUHandList; 
	List<TestBean> fieldList; 
	List<TestBean> discardFieldList;
	boolean playerPassFlag;
	boolean CPUPassFlag;
	
	public GeneralProcessing(List<TestBean> playerHandList,List<TestBean> CPUHandList,List<TestBean> fieldList,List<TestBean> discardFieldList){
		this.playerHandList = playerHandList;
		this.CPUHandList = CPUHandList;
		this.fieldList = fieldList;
		this.discardFieldList = discardFieldList;
		
	}
	
	public boolean judge(int selectedIndex) {
		
		if(fieldList.size()==0) {
			return true;
			
		}else {
			TestBean playerhand = playerHandList.get(selectedIndex);
			int handstrength = playerhand.getStrength();
			
			TestBean field = fieldList.get(fieldList.size()-1);
			int fieldstrength = field.getStrength();
			
			if(fieldstrength < handstrength) {
				return true;
			}
		}
		return false;//boolean型の変数
	}
	
	
	public void playerProcess(int selectedIndex) {
		TestBean playerhand = playerHandList.get(selectedIndex);

		fieldList.add(playerhand);
		
		playerHandList.remove(selectedIndex);
		
		
	}
	
	
	public void CPUProcess() throws Exception{
		List<TestBean> canPlayCardList = new ArrayList<>(); 
		int topCardIndex = (fieldList.size()-1);
		int CPUSelectedIndex = 0;
		boolean CPUCanPlayFlag = false;
		TestBean topCard = null;
		TestBean compareCard = null;
		TestBean CPUSelectedCard = null;
		
		if(topCardIndex >= 0) {//場にカードがある時
			topCard = fieldList.get(topCardIndex);
			System.out.println("topCardの値は"+topCard+"です");
			for(int i=0;i<CPUHandList.size();i++) {
				compareCard = CPUHandList.get(i);
				if(compareCard.getStrength() >topCard.getStrength()) {//手札のカードが場のカードより大きい時
					canPlayCardList.add(compareCard);
				}
			}
		}
		else {
			canPlayCardList = CPUHandList;
		}
		
		System.out.println("canPlayCardListの値は"+canPlayCardList+"です");
		
		if(canPlayCardList.size() != 0) {//出せるカードの枚数が0でない時
			CPUCanPlayFlag = true;
		}
		else {
			CPUPassFlag = true;
		}
		
		if(CPUCanPlayFlag == true) {//カードが出せる時
			Random rd = new Random();
			int random = rd.nextInt(canPlayCardList.size());
		
			//出せるカードの中からランダムで選出
			CPUSelectedCard = canPlayCardList.get(random);
			
			//場のリストに選んだカードを追加
			fieldList.add(CPUSelectedCard);
			
			//CPUの手札の中から場に出したカードの要素番号を検索
			CPUSelectedIndex = CPUHandList.indexOf(CPUSelectedCard);
			
			//CPUが選んだカードを手札から除去
			CPUHandList.remove(CPUSelectedIndex);
		}
		
		
		
		
		
	}
	
	public void endRound() {
		discardFieldList.addAll(fieldList);
		fieldList.clear();
	}
	
	public boolean checkHandSize() {
		if(playerHandList.size()==0) {
			return true;
		}
		
		if(CPUHandList.size()==0){
			return true;
		}
		return false;
	}
	
	
	public List<TestBean> getPlayerHandList(){
		return this.playerHandList;
	}
	
	public List<TestBean> getCPUHandList(){
		return this.CPUHandList;
	}
	
	public List<TestBean> getFieldList(){
		return this.fieldList;
	}
	
	public List<TestBean> getDiscardFieldList(){
		return this.discardFieldList;
	}
	
	public boolean getPlayerPassFlag(){
		return this.playerPassFlag;
	}
	
	public boolean getCPUPassFlag(){
		return this.CPUPassFlag;
	}
}
