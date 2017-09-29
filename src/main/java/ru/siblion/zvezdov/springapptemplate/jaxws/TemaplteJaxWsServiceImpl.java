package ru.siblion.zvezdov.springapptemplate.jaxws;

import javax.jws.WebService;

/**
 * Created by Dmitry on 26.09.2017.
 */
@WebService(endpointInterface = "ru.siblion.zvezdov.springapptemplate.jaxws.TemplateJaxWsService")
public class TemaplteJaxWsServiceImpl implements TemplateJaxWsService {
    @Override
    public String getMessage(String name) {
        return "Jax Ws Rpc" + name;
    }
}
