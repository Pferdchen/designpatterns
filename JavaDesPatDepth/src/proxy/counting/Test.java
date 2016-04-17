package proxy.counting;

public class Test {

	public static void main(String[] args) throws Exception {
		Borrow br = new Borrow();
		BorrowProxy bp = new BorrowProxy(br);

		Book book = new Book("1000", "Computer application");
		br.setBook(book);
		bp.borrow();

		book = new Book("1001", "Computer application 2");
		br.setBook(book);
		bp.borrow();

		bp.log();
	}

}
