package ru.siblion.zvezdov.cardsapi.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmitry on 01.09.2017.
 */
@ApplicationPath("/jaxrs")
public class JaxRsApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(TemplateJaxRsFilter.class);
        set.add(TemplateJaxRsService.class);
        return set;
    }
}
