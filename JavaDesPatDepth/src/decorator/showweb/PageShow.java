package decorator.showweb;

import javax.servlet.http.HttpServletRequest;

public class PageShow extends Decorator {

	public PageShow(IShow obj) {
		super(obj);
	}

	public String ctrlShow() {
		String s = "<div>"
				+ "<a title='first' href='javascript:void(0)' onclick='go(this)'>Homepage</a>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<a title='prev' href='javascript:void(0)' onclick='go(this)'>Previous</a>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<a title='next' href='javascript:void(0)' onclick='go(this)'>Next</a>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<a title='tail' href='javascript:void(0)' onclick='go(this)'>Endpage</a>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "Turn to ";

		String subs = "<select id='selctl' onchange='gosel(this)'>";
		for (int i = 1; i <= getTotal(); i++) {
			if (i == getPage())
				subs += "<option selected value='" + i + "'>" + i + "</option>";
			else
				subs += "<option value='" + i + "'>" + i + "</option>";
		}
		subs += "</select></div>";
		return s + subs;
	}

	public String show(HttpServletRequest req) throws Exception {
		String s = super.show(req);
		s += ctrlShow();
		return s;
	}
}
