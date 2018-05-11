package nal10;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;



import paketi.Mail;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class Prejem implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			ObjectMessage tm = (ObjectMessage) message;
			try {

				Mail m = new Mail();
				Sporocilo s = (Sporocilo) tm.getObject();
				m.posljiMail(s.getEmail(),s.getKdo());
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Prispelo je neznano sporocilo.");
		}

	}

}
