package ru.siblion.zvezdov.springapptemplate.jms.producers;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Dmitry on 27.09.2017.
 */
public class TemplateSimplifiedJmsProducer {
    private static final String JMS_QUEUE_FACTORY = "weblogic.jms.ConnectionFactory";
    private static final String JMS_QUEUE_NAME = "jms.queue0";
    public void sendMessage(String message) {
        try {
            Context context = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(JMS_QUEUE_FACTORY);
            Destination destination = (Destination) context.lookup(JMS_QUEUE_NAME);
//            JMSContext jmsContext = connectionFactory.createContext();
//            JMSProducer producer = jmsContext.createProducer();
//            producer.send(destination, message);
            connectionFactory.createContext().createProducer().send(destination, message);

            context.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
