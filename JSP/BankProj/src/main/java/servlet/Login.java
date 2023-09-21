package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		if(member!=null) {
			if(member.getId().equals(id)) {
				if(member.getPassword().equals(password)) { // 정상처리
					session.setAttribute("id", id);
					request.setAttribute("page", "makeaccount");	
				} else {
					request.setAttribute("err", "비밀번호가 틀립니다.");
					request.setAttribute("page", "error");	
				}
			} else { 
				request.setAttribute("err", "아이디가 틀립니다.");
				request.setAttribute("page", "error");
			}
		} else { // 회원가입하지 않음
			request.setAttribute("err", "회원가입이 되어있지 않습니다.");
			request.setAttribute("page", "error");
		}
		dispatcher.forward(request, response);
	}

}
