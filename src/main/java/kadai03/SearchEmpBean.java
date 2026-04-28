package kadai03;

import java.util.ArrayList;

/**
 * 表検索・値取得用Bean
 *
 * @author Nishimoto
 *
 */
public class SearchEmpBean {

	private String condNm;						// 検索条件：名前
	private ArrayList<SearchEmpEntity> lstEmp;	// 社員情報リスト

	/**
	 *	検索条件：名前を設定する<br>
	 *
	 *	@param condNm 検索条件：名前
	*/
	public void setCondNm(String condNm) {
		this.condNm = condNm;
	}

	/**
	 *	検索条件：名前を取得する<br>
	 *
	 *	@return 検索条件：名前
	*/
	public String getCondNm() {
		return condNm;
	}


	/**
	 *	社員情報リストを設定する<br>
	 *
	 *	@param lstEmp 社員情報リスト
	*/
	public void setLstEmp(ArrayList<SearchEmpEntity> lstEmp) {
		this.lstEmp = lstEmp;
	}


	/**
	 *	社員情報リストの件数を取得する<br>
	 *
	 *	@return 社員情報リストの件数
	*/
	public int getLstEmpCnt() {
		return lstEmp.size();
	}


	/**
	 *	社員情報リストの対象行の社員番号を取得する<br>
	 *
	 *  @param  rowNo  行番号
	 *	@return 対象行の社員番号
	*/
	public String getEmpNo(int rowNo) {
		return lstEmp.get(rowNo).getEmpNo();
	}


	/**
	 *	社員情報リストの対象行の社員名を取得する<br>
	 *
	 *  @param  rowNo  行番号
	 *	@return 対象行の社員番号
	*/
	public String getEName(int rowNo) {
		return lstEmp.get(rowNo).getEName();
	}
}
