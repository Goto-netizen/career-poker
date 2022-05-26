package model.entity;

import java.io.Serializable;

public class DistributionBean implements Serializable{
	
	/**
	 * カードID
	 */
	private int code;
	
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
	public DistributionBean() {

	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code=code;
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
