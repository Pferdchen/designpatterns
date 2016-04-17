package proxy.counting;

public class Borrow implements IBorrow {

	private Book book;

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	@Override
	public boolean borrow() {
		// TODO implement functionality to save info into database
		return true;
	}

}
