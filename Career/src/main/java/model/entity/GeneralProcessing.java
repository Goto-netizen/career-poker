package model.entity;

import java.util.List;

public class GeneralProcessing {
	List<TestBean> playerHandList; 
	List<TestBean> CPUHandList; 
	List<TestBean> fieldList; 
	List<TestBean> dicardFieldList;
	
	public GeneralProcessing(List<TestBean> playerHandList,List<TestBean> CPUHandList,List<TestBean> fieldList,List<TestBean> dicardFieldList){
		this.playerHandList = playerHandList;
		this.CPUHandList = CPUHandList;
		this.fieldList = fieldList;
		this.dicardFieldList = dicardFieldList;
		
	}
	
	public boolean judge(int selectedIndex) {
		
		return false;//boolean型の変数
	}
	
	
	public void playerProcess(int selectedIndex) {
		
		
		
	}
	
	
	public void CPUProcess() {
		
		
		
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
		return this.fieldList;
	}
}
