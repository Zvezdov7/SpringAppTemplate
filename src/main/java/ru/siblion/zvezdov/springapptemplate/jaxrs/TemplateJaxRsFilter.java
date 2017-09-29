package ru.siblion.zvezdov.springapptemplate.jaxrs;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by Dmitry on 25.09.2017.
 */
@Provider
public class TemplateJaxRsFilter implements ContainerRequestFilter, ContainerResponseFilter, ClientRequestFilter, ClientResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {

    }

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {

    }

    @Override
    public void filter(ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext) throws IOException {

    }
}
