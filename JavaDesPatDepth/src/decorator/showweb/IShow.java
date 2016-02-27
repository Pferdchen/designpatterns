package decorator.showweb;

import javax.servlet.http.HttpServletRequest;

public interface IShow {

	int getPage();

	int getTotal();

	String show(HttpServletRequest req) throws Exception;
}
