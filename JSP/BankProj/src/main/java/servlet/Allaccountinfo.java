package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class Allaccountinfo
 */
@WebServlet("/allaccountinfo")
public class Allaccountinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allaccountinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Account> accs = new ArrayList<>();
		HttpSession session = request.getSession();
		
		Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			if(name.equals("member") || name.equals("id"))continue;
			Account acc = (Account)session.getAttribute(name);
			accs.add(acc);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		if(accs.size() > 0) {
			request.setAttribute("accs", accs);
			request.setAttribute("page", "allaccountinfo");
		} else {
			request.setAttribute("err", "등록된 계좌가 없습니다.");
			request.setAttribute("page", "error");
		}
		dispatcher.forward(request, response);
	}

}
