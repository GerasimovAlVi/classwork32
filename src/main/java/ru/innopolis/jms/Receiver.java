package ru.innopolis.jms;

import com.google.gson.Gson;
import org.apache.activemq.ActiveMQConnectionFactory;
import ru.innopolis.jms.request.ItemRequest;

import javax.jms.*;

public class Receiver {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageConsumer consumer = null;

    public Receiver() {
        factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        try {
            connection = factory.createConnection();
            connection.setClientID("receiver");
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("itemsDao");
            consumer = session.createConsumer(destination);
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public String receiverdMessage() throws JMSException {
        TextMessage message = (TextMessage) consumer.receive();
        return message.getText();
    }
}
