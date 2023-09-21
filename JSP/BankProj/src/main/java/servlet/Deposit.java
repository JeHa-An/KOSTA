package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		Integer money = Integer.parseInt(request.getParameter("money"));
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		if(acc!=null) {
			acc.deposit(money);
			request.setAttribute("acc", acc);
			request.setAttribute("page", "accountinfo");
		} else {
			request.setAttribute("err", "계좌번호가 틀립니다.");
			request.setAttribute("page", "error");
		}
		dispatcher.forward(request, response);
	}

}
