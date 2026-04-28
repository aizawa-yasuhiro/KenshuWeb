package kadai04;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *	【課題４】<br>
 * 値取得用Bean
 *
 * @author Nishimoto
 *
 */
public class ShopCartBean {

	private ArrayList<String> lstItemNm = new ArrayList<String>();	// 品名リスト
	private HashMap<String, ShopCartEntity> mapItem = new HashMap<String, ShopCartEntity>();	// 品物情報マップ


	//■メンバ変数のアクセサメソッド --------------------------------------------------
	/**
	 * 品名リストを取得する<br>
	 *
	 * @return lstItemNm
	 */
	public ArrayList<String> getLstItemNm() {
		return lstItemNm;
	}

	/**
	 * 品名リストを設定する<br>
	 *
	 * @param lstItemNm
	 */
	public void setLstItemNm(ArrayList<String> lstItemNm) {
		this.lstItemNm = lstItemNm;
	}


	/**
	 * 品物情報マップを取得する<br>
	 *
	 * @return mapItem
	 */
	public HashMap<String, ShopCartEntity> getMapItem() {
		return mapItem;
	}

	/**
	 * 品物情報マップを設定する<br>
	 *
	 * @param mapItem
	 */
	public void setMapItem(HashMap<String, ShopCartEntity> mapItem) {
		this.mapItem = mapItem;
	}


	//■画面表示用のアクセサメソッド --------------------------------------------------
	/**
	 *	品名リストの件数を取得する<br>
	 *
	 *	@return 品名リストの件数
	*/
	public int getLstItemNmCnt() {
		return lstItemNm.size();
	}

	/**
	 *	品名リストから、対象行の品名を取得する<br>
	 *
	 *  @param  rowNo  行番号
	 *	@return 対象行の品名
	*/
	public String getItemNmByRowNo(int rowNo) {
		return lstItemNm.get(rowNo);
	}

	/**
	 *	品物情報マップから、対象行の単価を取得する<br>
	 *
	 *  @param  rowNo  行番号
	 *	@return 対象行の単価
	*/
	public int getTankaByRowNo(int rowNo) {
		return mapItem.get(lstItemNm.get(rowNo)).getTanka();
	}

	/**
	 *	品物情報マップから、対象行の数量を取得する<br>
	 *
	 *  @param  rowNo  行番号
	 *	@return 対象行の数量
	*/
	public int getSuryoByRowNo(int rowNo) {
		return mapItem.get(lstItemNm.get(rowNo)).getSuryo();
	}
}
