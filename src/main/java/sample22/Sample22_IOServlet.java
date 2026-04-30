package sample22;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample22_IOServlet
 */
@WebServlet( urlPatterns = { "/Sample22_IOServlet", "/Sample22" } )
public class Sample22_IOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample22_IOServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// エンコーディング
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

//		String param = request.getParameter("param");		// 入力値取得
//
//		// 画面表示
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>サンプル２２</title></head>");
//		out.println("<body>");
//		if (param.isEmpty()) {
//			out.println("未入力です");
//		} else {
//			out.println("<h1>" + param + "</h1> と入力しました。");
//		}
//		out.println("</body></html>");
//		out.close();

		response.getWriter().append("<html><head><title>サンプル２２</title></head><body>\n");
		String param = request.getParameter("param");		// 入力値取得
		if (param.isEmpty()) {
			response.getWriter().append("未入力です");
		} else {
			response.getWriter().append("<h1>" + param + "</h1> と入力しました。");
		}
		response.getWriter().append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
