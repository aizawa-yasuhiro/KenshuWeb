package sample24;
import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = { "/Sample24_ControllerServlet", "/Sample24" } )
public class Sample24_ControllerServlet extends HttpServlet implements Servlet {
    private static final long serialVersionUID = 1L;
    public Sample24_ControllerServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        // エンコーディング
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // 値をモデルクラスに設定
        Sample24_ModelBean objModelBean = new Sample24_ModelBean();
        String param = request.getParameter("param");
        objModelBean.setParam(param);

        // リクエストにモデルクラスを設定
        request.setAttribute("modelBean", objModelBean);

        // 次画面に遷移
        String nextPage = "/jsp/Sample24_ViewJSP.jsp";
        getServletContext().getRequestDispatcher(nextPage).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
