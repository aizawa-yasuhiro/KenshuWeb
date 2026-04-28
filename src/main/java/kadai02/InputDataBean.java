package kadai02;

import java.io.Serializable;

public class InputDataBean implements Serializable{

	private String name;		// 名前
	private String address;		// 住所
	private String sex;			// 性別
	private String job;			// 職業

	private static final long serialVersionUID  = 1L;

	public InputDataBean() {}

	/**
	 * コード値から性別に変換する
	 * @param cd
	 * @return
	 */
	public String convSexCd(String cd) {
		String strRet = "";

		switch (cd) {
			case "1":
				strRet = "男";
				break;

			case "2":
				strRet = "女";
				break;

			default:
				strRet = "未選択";
		}

		return strRet;
	}

	/**
	 * コード値から職業に変換する
	 * @param cd
	 * @return
	 */
	public String convJobCd(String cd) {
		String strRet = "";

		switch (cd) {
			case "1":
				strRet = "自営業";
				break;

			case "2":
				strRet = "会社員";
				break;

			case "3":
				strRet = "会社役員";
				break;

			case "9":
				strRet = "無職";
				break;

			default:
				strRet = "未選択";
		}

		return strRet;
	}

	/**
	 * 特殊文字を変換する
	 * @param str
	 * @return
	 */
	private String chgSpChar(String str) {
		String strRet = "";

		// 変換
		strRet = str.replaceAll("&", "&amp;");
		strRet = strRet.replaceAll("<" , "&lt;"  );
		strRet = strRet.replaceAll(">" , "&gt;"  );
		strRet = strRet.replaceAll("\"", "&quot;");
		strRet = strRet.replaceAll("'" , "&#39;" );
		strRet = strRet.replaceAll(" " , "&nbsp;" );

		return strRet;
	}


	/*
	 *  setter/getter
	 */
	public String getName() {
		return chgSpChar(name);	// 特殊文字を変換
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return chgSpChar(address);	// 特殊文字を変換
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
