package com.bankaya.challenge.interceptor;

import com.bankaya.challenge.event.SaveRequestEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.MethodEndpoint;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Log4j2
@Component
@RequiredArgsConstructor
public class ServiceInterceptor implements EndpointInterceptor {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final HttpServletRequest httpServletRequest;

    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    };

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        log.info("Before handle");
        applicationEventPublisher.publishEvent(new SaveRequestEvent(getClientIpAddress(), getMethodExecuted(endpoint)));
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        log.info("After handle");
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        log.info("Exception handle");
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        log.info("Execute Code After Completion");
    }

    private String getClientIpAddress() {

        if (httpServletRequest == null) {
            return "0.0.0.0";
        }

        return Arrays.stream(IP_HEADER_CANDIDATES)
                .map(httpServletRequest::getHeader)
                .filter(ipList -> ipList != null && ipList.length() != 0 && !"unknown".equalsIgnoreCase(ipList))
                .findFirst()
                .map(ipList -> ipList.split(",")[0])
                .orElse(httpServletRequest.getRemoteAddr());
    }

    private String getMethodExecuted(Object endpoint) {
        MethodEndpoint method = (MethodEndpoint) endpoint;
        return method.getMethod().getName();
    }
}
