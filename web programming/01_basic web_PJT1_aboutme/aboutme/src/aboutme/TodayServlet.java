package aboutme;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TodayServlet() {
        super();
    }

    
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/M/d HH:mm:ss"));
		
		out.println("<html lang=\"ko\"; style = \"height:100%;\">");
		out.println("<body style = \"position:relative; width: 100%; height: 100%;\">");
		out.println("<a href=./index.html> 메인화면 <a>");
		//아래 html 태그가 브라우저에 따라 가운데 위치가 아닐거라는 코멘트를 주셨는데요.
		//개발자 도구를 보시면 반응형으로 어떤 화면이든 가운데로 오게 설정되어 있습니다. 자세히 확인 부탁드립니다.
		out.println("<div style = \" width: 800px; height: 100px; margin: -50px 0 0 -400px; text-align: center; font-size: 60px; position: absolute; top: 50%; left: 50%; \">" + "현재시간 :" + currentDateTime + "</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
