package kadai04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopCartCtrlServ
 */
@WebServlet( urlPatterns = { "/ShopCartCtrlServ", "/kadai04" } )
public class ShopCartCtrlServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartCtrlServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// セッションの開始
		HttpSession sess = request.getSession(true);

		// ■セッションにモデルクラスを保存
		ShopCartBean objShopCartBean = new ShopCartBean(); // 空のモデルクラスを作成
		sess.setAttribute("SHOPPING_CART", objShopCartBean);

		// ■リクエストにモデルクラスを設定
		request.setAttribute("scBean", objShopCartBean);

		// 次画面に遷移
		String nextPage = "/jsp/kadai04/ShopCart.jsp";
		getServletContext().getRequestDispatcher(nextPage).forward(request, response);
		return;


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エンコーディング
		response.setContentType("text/html; charaset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// セッションの開始
		HttpSession sess = request.getSession(true);

		// モデルクラス
		ShopCartBean objShopCartBean = null;


		// ■セッションからデータを取得
		// データが存在しない場合
		if(sess.getAttribute("SHOPPING_CART") == null) {

			; // ★通常、セッションタイムアウト画面へ遷移する


		// データが存在する場合
		} else {
			// セッションから取得
			objShopCartBean = (ShopCartBean) sess.getAttribute("SHOPPING_CART");
		}

		//━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

		// 押下したボタン名の取得
		String clickBtnNm = request.getParameter("clickBtnNm");


		// ●追加ボタン押下時 ------------------------------------------------------
		if("btnAdd".equals(clickBtnNm)) {

			// 入力値の取得
			String strItemNm = request.getParameter("txtItemNm");
			String strTanka = request.getParameter("txtTanka");
			String strSuryo = request.getParameter("txtSuryo");

			// エラーチェック
			String errorMsg = errorCheck(strItemNm, strTanka, strSuryo);

			if( ! errorMsg.isEmpty()) {

				// ■リクエストにエラーメッセージを保存
				request.setAttribute("msg", errorMsg);

				// エラー画面に遷移
				String nextPage = "/jsp/kadai04/ShopCartError.jsp";
				getServletContext().getRequestDispatcher(nextPage).forward(request, response);
				return;
			}

			// ■品物リストへの追加・更新
			objShopCartBean = addUpdItemList(objShopCartBean, strItemNm, strTanka, strSuryo);



		// ●確定ボタン押下時 ------------------------------------------------------
		} else if("btnKakutei".equals(clickBtnNm)) {

			// 合計金額の取得
			String strSumKngk = getSumKngk(objShopCartBean);

			// ■リクエストに合計金額を保存
			request.setAttribute("sumKngk", strSumKngk);

			// 確定画面に遷移
			String nextPage = "/jsp/kadai04/ShopCartKakutei.jsp";
			getServletContext().getRequestDispatcher(nextPage).forward(request, response);
			return;



		// ●＋・－ボタン押下時 ------------------------------------------------------
		} else if("btnPlus".equals(clickBtnNm)
				|| "btnMinus".equals(clickBtnNm)) {

			// 行番号の取得
			String strIdx = request.getParameter("clickBtnIdx");

			// ＋ボタンの場合
			if("btnPlus".equals(clickBtnNm)) {
				// 数量＋1
				objShopCartBean = addSuryo(objShopCartBean, strIdx, 1);

			// －ボタンの場合
			} else {
				// 数量－1
				objShopCartBean = addSuryo(objShopCartBean, strIdx, -1);
			}



		// エラー画面から遷移の場合 ------------------------------------------------------
		} else {
			; // 処理無し

		}

		//━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

		// ■セッションに保存
		sess.setAttribute("SHOPPING_CART", objShopCartBean);

		// ■リクエストにモデルクラスを設定
		request.setAttribute("scBean", objShopCartBean);

		// 次画面に遷移
		String nextPage = "/jsp/kadai04/ShopCart.jsp";
		getServletContext().getRequestDispatcher(nextPage).forward(request, response);
		return;
	}



	/**
	 * 入力値のエラーチェック
	 * @param _txtItem
	 * @param _txtTanka
	 * @param _txtSuryo
	 * @return
	 */
	private String errorCheck(String txtItem, String txtTanka, String txtSuryo) {

		StringBuilder sb = new StringBuilder();

		// ■品名
		// 必須チェック
		if("".equals(txtItem)) {
			sb.append("品名が入力されていません。<br>");
		}

		// ■単価
		// 必須チェック
		if("".equals(txtTanka)) {
			sb.append("単価が入力されていません。<br>");

		} else {

			int intTanka;
			try {
				// 数値チェック
				intTanka = Integer.parseInt(txtTanka);

				// 0より大きいかチェック
				if(intTanka <= 0) {
					sb.append("単価には 0より大きい値を入力してください。<br>");
				}

			} catch(NumberFormatException ex) {
				sb.append("単価が数値ではありません。<br>");
			}
		}

		// ■数量
		// 必須チェック
		if("".equals(txtSuryo)) {
			sb.append("数量が入力されていません。<br>");

		} else {

			int intSuryo;
			try {
				// 数値チェック
				intSuryo = Integer.parseInt(txtSuryo);

				// 0より大きいかチェック
				if(intSuryo <= 0) {
					sb.append("数量には 0より大きい値を入力してください。<br>");
				}

			} catch(NumberFormatException ex) {
				sb.append("数量が数値ではありません。<br>");
			}
		}

		return sb.toString();
	}

	/**
	 * 品名リスト、品物情報マップへの追加・更新
	 * @param itemNm
	 * @param tanka
	 * @param suryo
	 */
	private ShopCartBean addUpdItemList(ShopCartBean bean, String itemNm, String tanka, String suryo){

		// 数値型に変換（※事前にエラーチェックが行われていることが前提）
		int intTanka = Integer.parseInt(tanka);
		int intSuryo = Integer.parseInt(suryo);

		// モデルクラスから、品名リスト・品物情報マップ を取得
		ArrayList<String> lst = bean.getLstItemNm();
		HashMap<String, ShopCartEntity> map = bean.getMapItem();

		// 1レコード分の品物情報を保持するクラス
		ShopCartEntity objShopCartEntity =  new ShopCartEntity();



		// ■新規の品物の場合： 新規追加
		if( ! map.containsKey(itemNm)){

			// 単価・数量 を設定
			objShopCartEntity.setTanka(intTanka);
			objShopCartEntity.setSuryo(intSuryo);

			// 品名リスト、品物情報マップに新規追加
			lst.add(itemNm);
			map.put(itemNm, objShopCartEntity);



		// ■既存の品物の場合： 更新
		} else {
			// 品物情報マップから、1レコード分の品物情報を取得
			objShopCartEntity = map.get(itemNm);

			// 単価を更新、数量を加算
			objShopCartEntity.setTanka(intTanka);
			objShopCartEntity.setSuryo(objShopCartEntity.getSuryo() + intSuryo);

			// 品物情報マップを更新
			map.put(itemNm, objShopCartEntity);
		}

		// 返却用モデルクラス
		ShopCartBean retBean = new ShopCartBean();

		// 品名リスト・品物情報マップ を、返却用モデルクラスに設定
		retBean.setLstItemNm(lst);
		retBean.setMapItem(map);

		// モデルクラスを返却
		return retBean;
	}


	/**
	 * 合計金額を取得する
	 * @return
	 */
	private String getSumKngk(ShopCartBean bean) {

		// モデルクラスから、品名リスト・品物情報マップ を取得
		ArrayList<String> lst = bean.getLstItemNm();
		HashMap<String, ShopCartEntity> map = bean.getMapItem();

		int intSumKngk = 0;	// 合計金額
		ShopCartEntity objShopCartEntity = null;	// 1レコード分の品物情報

		// 合計金額を計算する
		for(int i = 0; i < lst.size(); i++) {

			// 1レコード分の品物情報を取得
			objShopCartEntity = map.get(lst.get(i));

			// 計算
			intSumKngk = intSumKngk + (objShopCartEntity.getTanka() * objShopCartEntity.getSuryo());
		}

		return String.valueOf(intSumKngk);
	}


	/**
	 * 数量を加算（＋・－ボタン押下時）
	 * @param _idx
	 * @param _num
	 */
	private ShopCartBean addSuryo(ShopCartBean bean, String idx, int num) {

		// 数値型に変換
		int iIdx = Integer.parseInt(idx);

		// モデルクラスから、品名リスト・品物情報マップ を取得
		ArrayList<String> lst = bean.getLstItemNm();
		HashMap<String, ShopCartEntity> map = bean.getMapItem();


		// 行番号から、品名を取得
		String itemNm = lst.get(iIdx);

		// 1レコード分の品物情報を取得
		ShopCartEntity objShopCartEntity = map.get(itemNm);

		// 数量に加算
		int suryo = objShopCartEntity.getSuryo() + num;


		// ■数量が1以上の場合
		if(suryo > 0) {
			// 数量をセット
			objShopCartEntity.setSuryo(suryo);
			// 品物情報マップを更新
			map.put(itemNm, objShopCartEntity);


		// ■数量が0となった場合： 行を削除
		} else {

			// 品名リスト、品物情報マップから削除
			lst.remove(iIdx);
			map.remove(itemNm);
		}


		// 返却用モデルクラス
		ShopCartBean retBean = new ShopCartBean();

		// 品名リスト・品物情報マップ を、返却用モデルクラスに設定
		retBean.setLstItemNm(lst);
		retBean.setMapItem(map);

		// モデルクラスを返却
		return retBean;
	}

}
