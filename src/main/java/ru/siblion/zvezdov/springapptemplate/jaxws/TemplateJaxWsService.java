package ru.siblion.zvezdov.springapptemplate.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Dmitry on 26.09.2017.
 */
@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC) // RPC style
public interface TemplateJaxWsService {

    @WebMethod
    String getMessage(String name);
}
