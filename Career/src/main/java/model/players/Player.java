package model.players;

import java.util.ArrayList;
import java.util.List;

import model.item.Card;

public class Player {
	

	/*
	 *フィールド
	 */
	List<Card> playerHandList;
	
	/*
	 * コンストラクタ
	 */
	public Player(List<Card>playerHandList) {
		this.playerHandList = playerHandList;
	}
	
	
	public List<Card> PlayerProcess(int selectedIndex)throws Exception {
		Card playerhand = playerHandList.get(selectedIndex);
		
		/*
		 * fieldList保留　テスト用
		 */
		List<Card>fieldList = new ArrayList();
		fieldList.add(playerhand);
		
		playerHandList.remove(selectedIndex);

		return playerHandList;
		
	}
	
	


}