package kadai04;

/**
 *	【課題４】<br>
 * 1レコード分の品物情報（単価, 数量）を保持するクラス<br>
 *
 * @author Nishimoto
 * @version 1.0
 *
 */
public class ShopCartEntity {

	private int tanka;		// 単価
	private int suryo;		// 数量


	/**
	 *	単価を取得する<br>
	 *
	 *	@return tanka 単価
	*/
	public int getTanka() {
		return tanka;
	}

	/**
	 *	単価を設定する<br>
	 *
	 *	@param tanka 単価
	*/
	public void setTanka(int tanka) {
		this.tanka = tanka;
	}

	/**
	 *	数量を取得する<br>
	 *
	 *	@return suryo 数量
	*/
	public int getSuryo() {
		return suryo;
	}

	/**
	 *	数量を設定する<br>
	 *
	 *	@param suryo 数量
	*/
	public void setSuryo(int suryo) {
		this.suryo = suryo;
	}



}
