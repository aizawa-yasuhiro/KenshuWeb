package sample25;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Sample25_SessionMgrServlet
 */
@WebServlet( urlPatterns = { "/Sample25_SessionMgrServlet", "/Sample25" } )
public class Sample25_SessionMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ボタンを押された回数
		int iCount = 0;

		// セッション情報から前回の表示値を取得
		HttpSession sess = request.getSession(true);						// セッション情報を取得する
		Integer intPreKaisu = (Integer)sess.getAttribute("ZENKAICHI");		// 「ZENKAICHI」というキーで値を取り出す

		if(intPreKaisu != null){
			iCount = intPreKaisu.intValue() + 1;						// 上記の値を int型に変換して 1足す
		}

		// セッションに今回の表示値を戻す
		sess.setAttribute("ZENKAICHI", iCount);

		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method=\"get\" action=\"" + response.encodeURL("/KenshuWeb/Sample25") + "\">");
		out.println("<input type=\"submit\" value=\"Send\"><br><br>");

		out.println(iCount);

		out.println("</form>");
		out.println("</body></html>");
		out.close();
	}
}
