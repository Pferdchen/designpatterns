package decorator.showweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Product extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Product() {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse rep)
			throws ServletException, IOException {
		rep.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		try {
			IShow obj = new Show();
			IShow obj2 = new PageShow(obj);
			String s = obj2.show(req);
			rep.getWriter().print(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
