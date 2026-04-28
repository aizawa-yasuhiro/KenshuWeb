package kadai03;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchEmpCtrlServ
 */
@WebServlet( urlPatterns = { "/SearchEmpCtrlServ", "/kadai03" } )
public class SearchEmpCtrlServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmpCtrlServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// DB接続変数定義
		Connection con = null;				// DB接続
		PreparedStatement pstmt = null;		// SQL結果保持用オブジェクト
		ResultSet rst  = null;				// レコード

		// DB接続情報定義
		String url = "jdbc:mariadb://localhost/kenshudb";	//接続パス
		String id  = "root";	  //ログインID（SQL研修で使用したユーザ）
		String pw  = "aizawa";	//パスワード（SQL研修で使用したパスワード）

		// 検索内容
		String sql = "SELECT EMPNO,ENAME FROM EMP WHERE ENAME LIKE ? ORDER BY EMPNO";		// 使用SQL
		ArrayList<SearchEmpEntity> lstEmp = new ArrayList<SearchEmpEntity>();	// 社員情報リスト
		SearchEmpEntity recEmp = null;											// 1レコード分の社員情報




		// ■エンコーディング
		response.setContentType("text/html; charaset=UTF-8");
		request.setCharacterEncoding("UTF-8");


		// ■検索条件を取得し、モデルに設定する
		SearchEmpBean objSearchEmpBean = new SearchEmpBean();
		String condNm = request.getParameter("paramNm");
		objSearchEmpBean.setCondNm(condNm);


		// ■DBを検索する
		try{
			// JDBCドライバをロードし、コネクションを作成する
			Class.forName("org.mariadb.jdbc.Driver");	// DBごとの決まり文句
			con = DriverManager.getConnection(url, id, pw);


			// EMP表を検索する
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + condNm + "%");
			rst = pstmt.executeQuery();


			// 検索結果をリストに格納する
			while(rst.next()) {
				recEmp = new SearchEmpEntity();
				recEmp.setEmpNo(rst.getString("EMPNO"));	// 社員番号
				recEmp.setEName(rst.getString("ENAME"));	// 社員名
				lstEmp.add(recEmp);
			}

		} catch(SQLException ex) {

    		// ★実際にはコンソールにエラー出力ではなく、エラー画面への遷移
			System.out.println("SQLException:" + ex);
			return;

		} catch(ClassNotFoundException ex) {

    		// ★実際にはコンソールにエラー出力ではなく、エラー画面への遷移
			System.out.println("ClassNotFoundException:" + ex);
			return;

		} finally {

    		try {
				// DB接続を閉じる
				if(rst != null) rst.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();

    		} catch(SQLException ex) {
				return;
			}

		}



		// ■検索結果をモデルクラスに設定する
		objSearchEmpBean.setLstEmp(lstEmp);

		// ■検索条件をセッションに保存する
		HttpSession sess = request.getSession(true);
		sess.setAttribute("COND_NM", condNm);

		// ■リクエストにモデルクラスを設定
		request.setAttribute("searchBean", objSearchEmpBean);

		// ■次画面に遷移
		String nextPage = "/jsp/kadai03/EmpList.jsp";
		getServletContext().getRequestDispatcher(nextPage).forward(request, response);
	}

}
