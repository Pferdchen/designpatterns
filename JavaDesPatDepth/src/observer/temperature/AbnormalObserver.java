package observer.temperature;

import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import db.connection.DbProc;

public class AbnormalObserver implements Observer {

	private int c = 0;

	@Override
	public void update(Observable o, Object arg) {
		Subject subject = (Subject) o;
		Factor fac = (Factor) arg;
		if (subject.getData() < fac.getLimit()) {
			c = 0;
			return;
		}
		c++;
		saveToAbnormal(subject);
		if (c == fac.getTimes()) {
			sendEmail(fac);
			c = 0;
		}
	}

	private void saveToAbnormal(Subject subject) {
		String strSQL = "insert into abnormal values(" + subject.getData() + ", now()";
		DbProc dbobj = new DbProc();
		try {
			dbobj.connect();
			dbobj.executeUpate(strSQL);
			dbobj.close();
		} catch (Exception e) {
		}
	}

	private void sendEmail(Factor factor) {
		String host = "smtp.163.com";
		String from = "dqjbd@163.com";
		String to = factor.getAddress();
		String userName = "dqjbd";
		String pwd = "123456";
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);

		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject("Temperature warning info.");
			msg.setText("Room temperature in an abnormal state");
			msg.saveChanges();

			Transport transport = session.getTransport("smtp");
			transport.connect(host, userName, pwd);
			transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
		} catch (Exception e) {
		}
	}

}
