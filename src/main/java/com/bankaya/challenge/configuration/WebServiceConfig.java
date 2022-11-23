package com.bankaya.challenge.configuration;

import com.bankaya.challenge.interceptor.ServiceInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@RequiredArgsConstructor
public class WebServiceConfig extends WsConfigurerAdapter {

    private static final String URL_MAPPINGS = "/ws/*";
    private static final String BEAN_DEFAULT_WSDL_DEFINITION = "pokeapi";
    private static final String PORT_TYPE_NAME = "PokeApiPort";
    private static final String LOCATION_URI = "/ws";
    private static final String TARGET_NAME_SPACE = "http://carlosvelazquez.challenge/pokeapi";
    private static final String SCHEMA_LOCATION = "schema/pokeapi.xsd";

    private final ServiceInterceptor serviceInterceptor;

    /**
     * Indicate to spring ws that we need include this bean to handling SOAP messages.
     *
     * @param applicationContext spring context
     * @return registry servlet to dispatch message
     */
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, URL_MAPPINGS);
    }

    /**
     * Configures the annotation drive Spring WS programming model.
     *
     * @param pokeApiSchema xsd schema to handle
     * @return {@link DefaultWsdl11Definition} exposes a standard WSDL 1.1 by using XsdSchema.
     */
    @Bean(name = BEAN_DEFAULT_WSDL_DEFINITION)
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokeApiSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(PORT_TYPE_NAME);
        wsdl11Definition.setLocationUri(LOCATION_URI);
        wsdl11Definition.setTargetNamespace(TARGET_NAME_SPACE);
        wsdl11Definition.setSchema(pokeApiSchema);
        return wsdl11Definition;
    }

    /**
     * Represents an abstraction for XSD schemas.
     *
     * @return XSD schema for pokeapi
     */
    @Bean
    public XsdSchema pokeApiSchema() {
        return new SimpleXsdSchema(new ClassPathResource(SCHEMA_LOCATION));
    }

}
