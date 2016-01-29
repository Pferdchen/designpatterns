package command.multithreads;

public class Test {

	public static void main(String[] args) throws Exception {
		Msgsrc src = new Msgsrc();
		ShowReceive rvr = new ShowReceive();
		EmailReceive rvr2 = new EmailReceive();
		Command com = new Command(rvr, src);
		Command com2 = new Command(rvr2, src);

		CommandManage manage = new CommandManage(src);
		manage.addCommand(com);
		manage.addCommand(com2);
		manage.start();

		String s[] = { "li:aaa", "zhang:hello", "li:bbb" };
		for (int i = 0; i < s.length; i++) {
			src.come(s[i]);
			Thread.sleep(1000);
		}
		manage.bMark = false;
	}

}
