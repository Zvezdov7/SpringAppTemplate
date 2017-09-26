package ru.siblion.zvezdov.cardsapi.jaxrs;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Dmitry on 23.09.2017.
 */
public class TemplateJaxRsClient {
    public Response callService() {
        Client forisClient = ClientBuilder.newClient();
        forisClient.register(new TemplateJaxRsFilter());
        Response response = forisClient.target("http://template.com/api/template")
                .request(MediaType.TEXT_XML)
                .header("", "")
                .post(Entity.entity("Body data", MediaType.TEXT_XML));
        forisClient.close();
        return response;
    }
}
