package kadai03;

/**
 *	【課題３】<br>
 * 1レコード分の社員情報（社員番号, 社員名）を保持するクラス<br>
 *
 * @author Nishimoto
 * @version 1.0
 *
 */
public class SearchEmpEntity {

	private String empNo;		// 社員番号
	private String eName;		// 社員名

	/**
	 *	社員番号を設定する<br>
	 *
	 *	@param empNo 社員番号
	*/
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 *	社員番号を取得する<br>
	 *
	 *	@return 社員番号
	*/
	public String getEmpNo() {
		return empNo;
	}


	/**
	 *	社員名を設定する<br>
	 *
	 *	@param eName 社員名
	*/
	public void setEName(String eName) {
		this.eName = eName;
	}

	/**
	 *	社員名を取得する<br>
	 *
	 *	@return 社員名
	*/
	public String getEName() {
		return eName;
	}

}
