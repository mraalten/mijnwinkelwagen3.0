package nl.aalten.mijnwinkelwagen.application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
/**
 * This component registers the JAX-RS endpoints with Jersey
 *
 */
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
//        initializeSwagger();
        registerEndpoints();
    }

    private void initializeSwagger() {
        register(ApiListingResource.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:9200");
        beanConfig.setBasePath("/internal");
        beanConfig.setResourcePackage("nl.aalten.mijnwinkelwagen.application");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }

    private void registerEndpoints() {
        register(ProduktenResource.class);
    }



}
