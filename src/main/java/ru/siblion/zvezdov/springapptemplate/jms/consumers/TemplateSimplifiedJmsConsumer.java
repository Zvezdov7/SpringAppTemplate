package ru.siblion.zvezdov.springapptemplate.jms.consumers;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Dmitry on 27.09.2017.
 */
public class TemplateSimplifiedJmsConsumer {
    public static final String JMS_QUEUE_FACTORY = "weblogic.jms.ConnectionFactory";
    public static final String JMS_QUEUE_NAME = "jms.queue0";

    public String receiveMessage() {
        try {
            Context context = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(JMS_QUEUE_FACTORY);
            Destination destination = (Destination) context.lookup(JMS_QUEUE_NAME);
            Message message = connectionFactory.createContext().createConsumer(destination).receive();
            context.close();
            return message.getBody(String.class);
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
        return "None";
    }
}
