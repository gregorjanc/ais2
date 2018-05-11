package nal10;

import javax.jms.*;
import javax.naming.InitialContext;

public class Poslji  {

	public void posljiMail(String a, String b) throws Exception {
		
		InitialContext ctx = new InitialContext();
		Queue queue = (Queue) ctx.lookup("jms/queue/test");
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("java:/ConnectionFactory");
		QueueConnection cnn = factory.createQueueConnection("guest","guest");
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		QueueSender sender = session.createSender(queue);

		sender.send(session.createObjectMessage(new Sporocilo (a,b)),DeliveryMode.PERSISTENT,3,10000);
		
		
		//sender.send(session.createTextMessage("DAJMO!"));
		
		//sporo�ilo, ki ni trajno
//		Message m=session.createTextMessage("NETRAJNO SPOROCILO");
//		sender.send(m,DeliveryMode.NON_PERSISTENT,3,2000);

		//sporo�ilo, ki je trajno
//		m=session.createTextMessage("TRAJNO SPOROCILO");
//		sender.send(m,DeliveryMode.PERSISTENT,3,10000);

		session.close();
		
	}
	
	
}
