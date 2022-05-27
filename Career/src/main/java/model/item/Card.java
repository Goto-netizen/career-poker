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
	 * EmployeeBeanを構築します。
	 */
	public Card(int card_id) {
		this.card_id = card_id;

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
		this.strength=strength;
	}
}
