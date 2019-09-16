package request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 간단한 가입 페이지를 호출하고
 * 가입 페이지에 입력된 내용을 처리하는 서블릿 클래스
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 1. 서버의 리소스를 요청을 처리하는 
	 * 2. 브라우저에 GET 요청으로 register 주소가 입력되었을 때
	 * 	  가입 폼이 있는 페이지를 브라우저에 보여줌
	 */
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res)
					throws ServletException, IOException {
		// 요청 객체에 대한 한글 설정
		req.setCharacterEncoding("utf-8");
		// 응답객체 한글 처리
		res.setContentType("text/html; charset=utf-8");
		
		// 03_registerForm.html 로 요청을 전달
//		RequestDispatcher reqd = req.getRequestDispatcher("03_registerForm.html");
		
//		reqd.forward(req, res);
		
		// (2) sendRedirect 로 전달 : 주소표시줄에 주소가 변경됨
		//							  /register 요청에 대한 응답이 일단 발생하고
		//							  브라우저가 응답을 해석하여 자동 요청을 발생시키므로
		res.sendRedirect("03_registerForm.html");
	}

	/**
	 * 1. 서버로 전송된 값을 처리하는 메소드
	 * 폼에 의해 POST 요청이 발생한 경우
	 * 폼의 요청 파라미터에 입력된 값들을 추출하여 처리
	 */
	protected void doPost(HttpServletRequest req
						, HttpServletResponse res)
						throws ServletException, IOException {
		// 요청 객체에 대한 한글 설정
		req.setCharacterEncoding("utf-8");
		// 응답객체 한글 처리
		res.setContentType("text/html; charset=utf-8");
		
		// 1. 요청 파라미터 추출
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		String passConfirm = req.getParameter("passConfirm");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		String[] hobbies = req.getParameterValues("hobby");
		String emailId = req.getParameter("emailId");
		String emailDomain = req.getParameter("emailDomain");
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		String phone3 = req.getParameter("phone3");
		String address = req.getParameter("address");
		String intro = req.getParameter("intro");
		// 3. 추출된 데이터 가공 => 출력
		//	(1) System.out 출력
		System.out.println("회원가입화면");
		
		// (2) 브라우저 출력
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>가입폼요청처리</title>");
		out.print("</head>");
		out.print("<body>");
			out.println("userId=" + userId + "<br />");
			out.println("<hr />");
			out.println("userName=" + userName + "<br />");
			out.println("<hr />");
			out.println("userPass=" + userPass + "<br />");
			out.println("<hr />");
			out.println("passConfirm=" + passConfirm + "<br />");
			out.println("<hr />");
			out.println("gender=" + gender + "<br />");
			out.println("<hr />");
			out.println("age=" + age + "<br />");
			out.println("<hr />");
			out.println("hobby=");
			if (hobbies != null) {
				for (String hobby: hobbies) {
					out.println(hobby + "," + "<br />");
				}
				out.println("<br />");
			} else {
				out.println("선택한 취미가 없습니다." + "<br />");
			}
			out.println("<hr />");
			out.println("email=" + emailId + "@" + emailDomain + "<br />");
			out.println("<hr />");
			out.printf("phone=%s-%s-%s <br />", phone1, phone2, phone3);
			out.println("<hr />");
			out.println("address=" + address + "<br />");
			out.println("<hr />");
			out.println("intro=" + intro + "<br />");
			out.println("<hr />");
			out.println("<h3>가입 신청 내용</h3>");
			out.println("<hr />");
		out.print("</body>");
	out.print("</html>");
	
	out.close();
	}

}
