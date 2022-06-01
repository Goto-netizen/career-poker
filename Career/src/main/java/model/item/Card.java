package model.item;

public class Card{
	
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
	 * カードの数字（Jokerは14）
	 */
	private int num_id;



	/**
	 * EmployeeBeanを構築します。
	 */
	public Card(int card_id,String num,String mark,int strength, int num_id) {
		
		//メンバ変数の初期化
		this.card_id = card_id;
		this.num = num;
		this.mark = mark;
		this.strength = strength;
		this.num_id = num_id;
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
	/**
	 * フィールドnum_idの値を返します。
	 * @return カードフラグ
	 */
	public int getNum_id() {
		return num_id;
	}
	
	/**
	 * フィールドnum_idに値をセット。
	 */
	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}
	@Override
	public String toString() {
		return card_id+":"+num+":"+mark+":"+strength+":"+card_flag;
	}
}
