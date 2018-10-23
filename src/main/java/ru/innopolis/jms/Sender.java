package ru.innopolis.jms;

import com.google.gson.Gson;
import org.apache.activemq.ActiveMQConnectionFactory;
import ru.innopolis.jms.request.ItemRequest;

import javax.jms.*;

public class Sender {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;

    public Sender() {
        factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        try {
            connection = factory.createConnection();
            connection.setClientID("sender");
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("itemsDao");
            producer = session.createProducer(destination);
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(ItemRequest itemRequest) throws JMSException{
        TextMessage message = session.createTextMessage();
        Gson gson = new Gson();
        message.setText(gson.toJson(itemRequest));
        producer.send(message);
    }
}
