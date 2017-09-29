package ru.siblion.zvezdov.springapptemplate.jms.producers;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Logger;

/**
 * Created by Dmitry on 27.09.2017.
 */
public class TemplateClassicJmsProducer {
    private static final Logger logger = Logger.getLogger(TemplateClassicJmsProducer.class.getName());
    public static final String JMS_QUEUE_FACTORY = "weblogic.jms.ConnectionFactory";
    public static final String JMS_QUEUE_NAME = "jms.queue0";
    public void sendMessage() {
        try {
            Context context = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(JMS_QUEUE_FACTORY);
            Destination destination = (Destination) context.lookup(JMS_QUEUE_NAME);
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession();

            TextMessage textMessage = session.createTextMessage("This is Classic Api text message");
            MessageProducer producer = session.createProducer(destination);
            producer.send(textMessage);

            producer.close();
            session.close();
            connection.close();
            context.close();
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
