package ru.siblion.zvezdov.springapptemplate.jms.producers;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

/**
 * Created by Dmitry on 28.09.2017.
 */
@Stateless
public class TemplateSimplifiedEjbJmsProducer {
    @Inject
    @JMSConnectionFactory("jms.connectionfactory5")
    JMSContext context;

    @Resource(name = "jms.queue0")
    Destination destination;

    public void sendMessage(String message) {
        context.createProducer().setProperty("Template", "Template Message").send(destination, message);
    }
}
