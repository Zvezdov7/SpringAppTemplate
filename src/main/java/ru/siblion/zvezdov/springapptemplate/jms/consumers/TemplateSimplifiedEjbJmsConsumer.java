package ru.siblion.zvezdov.springapptemplate.jms.consumers;

import ru.siblion.zvezdov.springapptemplate.jms.producers.TemplateSimplifiedEjbJmsProducer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dmitry on 28.09.2017.
 */
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
@MessageDriven(mappedName = "jms.queue0", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class TemplateSimplifiedEjbJmsConsumer implements MessageListener {
    private static final Logger logger = Logger.getLogger(TemplateSimplifiedEjbJmsProducer.class.getName());
    @Override
    public void onMessage(Message message) {
        try {
            logger.log(Level.INFO, message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
