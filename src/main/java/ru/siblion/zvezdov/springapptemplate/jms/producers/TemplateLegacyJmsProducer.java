package ru.siblion.zvezdov.springapptemplate.jms.producers;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dmitry on 26.09.2017.
 */
public class TemplateLegacyJmsProducer {
    public static final String JMS_QUEUE_FACTORY = "weblogic.jms.ConnectionFactory";
    public static final String JMS_QUEUE_NAME = "jms.queue0";
    public void sendMessage() {
        try {
            Context context = new InitialContext();
            QueueConnectionFactory connectionFactory = (QueueConnectionFactory)context.lookup(JMS_QUEUE_FACTORY);
            QueueConnection queueConnection = connectionFactory.createQueueConnection();
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = (Queue) context.lookup(JMS_QUEUE_NAME);

            TextMessage textMessage = queueSession.createTextMessage();
            textMessage.setText("this is Jms message");

            QueueSender sender = queueSession.createSender(queue);
            sender.send(textMessage);

            sender.close();
            queueSession.close();
            queueConnection.close();
            context.close();
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
