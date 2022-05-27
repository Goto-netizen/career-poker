package model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneralProcessing {
	List<CardBean> playerHandList; 
	List<CardBean> CPUHandList; 
	List<CardBean> fieldList; 
	List<CardBean> discardFieldList;
	boolean playerPassFlag;
	boolean CPUPassFlag;
	
	public GeneralProcessing(List<CardBean> playerHandList,List<CardBean> CPUHandList,List<CardBean> fieldList,List<CardBean> discardFieldList){
		this.playerHandList = Collections.synchronizedList(playerHandList);
		this.CPUHandList = Collections.synchronizedList(CPUHandList);
		this.fieldList = Collections.synchronizedList(fieldList);
		this.discardFieldList = discardFieldList;
		
	}
	
	public synchronized boolean judge(int selectedIndex) throws Exception {
		
		System.out.println("fieldList.size()の値:"+fieldList.size());
		System.out.println("fieldListの値:"+fieldList);
		
		if(fieldList.size()==0) {
			return true;
			
		}else {
			CardBean playerhand = playerHandList.get(selectedIndex);
			int handstrength = playerhand.getStrength();
			
			CardBean field = fieldList.get(fieldList.size()-1);
			int fieldstrength = field.getStrength();
			
			if(fieldstrength < handstrength) {
				return true;
			}
		}
		return false;//boolean型の変数
	}
	
	
	public synchronized void playerProcess(int selectedIndex) throws Exception {
		CardBean playerhand = playerHandList.get(selectedIndex);
		System.out.println("playerhandの値："+playerhand);

		fieldList.add(playerhand);
		System.out.println("fieldListの値："+fieldList);
		
		System.out.println("playerHandListの値："+playerHandList);
		System.out.println("playerHandList.size()の値："+playerHandList.size());
		
		playerHandList.remove(selectedIndex);
		
		System.out.println("playerHandList.size()の値："+playerHandList.size());
		System.out.println("playerHandListの値："+playerHandList);
		
	}
	
	
	public synchronized void CPUProcess() throws Exception{
		List<CardBean> canPlayCardList = new ArrayList<>(); 
		int topCardIndex = (fieldList.size()-1);
		int CPUSelectedIndex = 0;
		boolean CPUCanPlayFlag = false;
		CardBean topCard = null;
		CardBean compareCard = null;
		CardBean CPUSelectedCard = null;
		
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
	
	public synchronized void endRound() {
		discardFieldList.addAll(fieldList);
		fieldList.clear();
	}
	
	public synchronized boolean checkHandSize() {
		
		System.out.println("playerHandList.size()の値："+playerHandList.size());
		
		if(playerHandList.size()==0) {
			return true;
		}
		/**/
		System.out.println("CPUHandList.size()の値："+CPUHandList.size());
		if(CPUHandList.size()==0){
			return true;
		}
		
		return false;
	}
	
	
	public synchronized List<CardBean> getPlayerHandList(){
		return this.playerHandList;
	}
	
	public synchronized List<CardBean> getCPUHandList(){
		return this.CPUHandList;
	}
	
	public synchronized List<CardBean> getFieldList(){
		return this.fieldList;
	}
	
	public synchronized List<CardBean> getDiscardFieldList(){
		return this.discardFieldList;
	}
	
	public synchronized boolean getPlayerPassFlag(){
		return this.playerPassFlag;
	}
	
	public synchronized boolean getCPUPassFlag(){
		return this.CPUPassFlag;
	}
}
