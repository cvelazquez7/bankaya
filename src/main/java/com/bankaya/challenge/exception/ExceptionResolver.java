package com.bankaya.challenge.exception;

import challenge.carlosvelazquez.pokeapi.ServiceException;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.namespace.QName;

public class ExceptionResolver extends SoapFaultMappingExceptionResolver {

    private static final QName CODE = new QName("code");
    private static final QName MESSAGE = new QName("message");
    private static final QName HTTP_CODE = new QName("http_code");

    /**
     * Customize default exception
     *
     * @param endpoint the executed endpoint, or {@code null} if none chosen at the time of the exception
     * @param ex       the exception to be handled
     * @param fault    the created fault
     */
    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        logger.warn("Exception processed ", ex);
        if (ex instanceof CustomException) {
            ServiceException serviceFault = ((CustomException) ex).getServiceException();
            SoapFaultDetail detail = fault.addFaultDetail();
            detail.addFaultDetailElement(CODE).addText(serviceFault.getCode());
            detail.addFaultDetailElement(MESSAGE).addText(serviceFault.getMessage());
            detail.addFaultDetailElement(HTTP_CODE).addText(serviceFault.getHttpStatusCode());
        }
    }
}
