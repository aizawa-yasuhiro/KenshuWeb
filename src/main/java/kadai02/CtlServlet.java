package kadai02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CtlServlet
 */
@WebServlet( urlPatterns = { "/CtlServlet", "/kadai02" } )
public class CtlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtlServlet() {
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

		// エンコーディング
		response.setContentType("text/html; charaset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// 値の取得
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String sexCd = request.getParameter("sex");
		String jobCd = request.getParameter("job");

		InputDataBean objInputBean = new InputDataBean();

		// コード値を変換
		String sex = objInputBean.convSexCd(sexCd);
		String job = objInputBean.convJobCd(jobCd);

		// 値をモデルクラスに設定
		objInputBean.setName(name);
		objInputBean.setAddress(address);
		objInputBean.setSex(sex);
		objInputBean.setJob(job);

		// リクエストにモデルクラスを設定
		request.setAttribute("inputBean", objInputBean);

		// 次画面に遷移
		String nextPage = "/jsp/kadai02/Kakunin.jsp";
		getServletContext().getRequestDispatcher(nextPage).forward(request, response);
	}

}
