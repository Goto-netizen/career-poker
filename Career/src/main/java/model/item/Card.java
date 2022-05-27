package model.item;

import java.io.Serializable;

public class Card implements Serializable{
	
	/**
	 * カードID
	 */
	private int card_id;
	
	/**
	 * 数字
	 */
	private String num;

	/**
	 * マーク
	 */
	private String mark;
	
	/**
	 * 強さ
	 */
	private int strength;
	
	/**
	 * カードフラグ
	 */
	private int card_flag;



	/**
	 * EmployeeBeanを構築します。
	 */
	public Card(int card_id,String num,String mark,int strength) {
		
		//メンバ変数の初期化
		this.card_id = card_id;
		this.num = num;
		this.mark = mark;
		this.strength = strength;
	}

	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	/**
	 * フィールドnumの値を返します。
	 * @return 数字
	 */
	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * フィールドmarkの値を返します。
	 * @return マーク
	 */
	public String getMark() {
		return mark;
	}


	public void setMark(String mark) {
		this.mark = mark;
	}
	/**
	 * 強さ
	 * @return
	 */
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	/**
	 * フィールドcard_flagの値を返します。
	 * @return カードフラグ
	 */
	public int getCard_flag() {
		return card_flag;
	}
	
	/**
	 * フィールドcard_flagに値をセット。
	 * @param card_flag
	 */
	public void setCard_flag(int card_flag) {
		this.card_flag = card_flag;
	}
}
