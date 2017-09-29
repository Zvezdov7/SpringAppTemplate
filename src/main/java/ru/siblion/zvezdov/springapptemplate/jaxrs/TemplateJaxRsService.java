package ru.siblion.zvezdov.springapptemplate.jaxrs;

import ru.siblion.zvezdov.springapptemplate.jms.consumers.TemplateSimplifiedJmsConsumer;
import ru.siblion.zvezdov.springapptemplate.jms.producers.TemplateClassicJmsProducer;
import ru.siblion.zvezdov.springapptemplate.jms.producers.TemplateLegacyJmsProducer;
import ru.siblion.zvezdov.springapptemplate.jms.producers.TemplateSimplifiedEjbJmsProducer;
import ru.siblion.zvezdov.springapptemplate.jms.producers.TemplateSimplifiedJmsProducer;
import ru.siblion.zvezdov.springapptemplate.model.TemplateModel;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Dmitry on 23.09.2017.
 */
@Path("/template")
public class TemplateJaxRsService {

    @GET
    public String getMethod() {
        return "String";
    }

    @GET
    @Path("{id}")
    public String getByIdMethod(@PathParam("id") String id) {
        return "String" + id;
    }

    @POST
    @Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String postMethod(String body) {
        return "String";
    }

    @PUT
    public String putMethod(String body) {
        return "String";
    }

    @DELETE
    @Path("{id}")
    public String deleteById(@PathParam("id") String id) {
        return "Delete" + id;
    }


    @GET
    @Path("getSomeHeaders")
    public Response getSomeHeaders(
            @QueryParam("templateId") String id,
            @Context HttpHeaders headers,
            @HeaderParam("templateHeader") String templateHeader) {
        Response.ResponseBuilder responseBuilder = Response
                .status(Response.Status.OK)
                .entity("Template Entity");
        return responseBuilder.build();
    }

    @GET
    @Path("/templateModel/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TemplateModel getModel(@PathParam("id") int id) {
        return new TemplateModel(id, "TemplateName");
    }

    /*----------JMS BLOCK----------*/

    @GET
    @Path("/sendLegacyJmsMessage")
    public String sendLegacyMessage() {
        TemplateLegacyJmsProducer producer = new TemplateLegacyJmsProducer();
        producer.sendMessage();
        return "OK";
    }

    @GET
    @Path("/sendClassicJmsMessage")
    public String sendClassicMessage() {
        TemplateClassicJmsProducer producer = new TemplateClassicJmsProducer();
        producer.sendMessage();
        return "OK";
    }

    @GET
    @Path("/sendSimplifiedJmsMessage")
    public String sendSimplifiedMessage() {
        TemplateSimplifiedJmsProducer producer = new TemplateSimplifiedJmsProducer();
        producer.sendMessage("This is Simplified Api Jms Message");
        return "OK";
    }

    @EJB
    TemplateSimplifiedEjbJmsProducer ejbJmsProducer;

    @GET
    @Path("/sendSimplifiedEjbJmsMessage")
    public String sendSimplifiedEjbMessage() {
        ejbJmsProducer.sendMessage("This is Ejb Simplified Api message");
        return "OK";
    }

    @GET
    @Path("/receiveSimplifiedJmsMessage")
    public String receiveSimplifiedMessage() {
        TemplateSimplifiedJmsConsumer consumer = new TemplateSimplifiedJmsConsumer();
        return consumer.receiveMessage();
    }

}
