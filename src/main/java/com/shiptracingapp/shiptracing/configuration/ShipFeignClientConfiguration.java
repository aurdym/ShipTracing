package com.shiptracingapp.shiptracing.configuration;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.security.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

import java.util.List;

//@Configuration
public class ShipFeignClientConfiguration {

    @Bean
    RequestInterceptor oauth2FeignRequestInterceptor(ShipsApiProperties properties) {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resource(properties.getClientId(), properties.getSecret()));
    }

    OAuth2ProtectedResourceDetails resource(String clientId, String secret) {
        var details = new ClientCredentialsResourceDetails();
        details.setAccessTokenUri("https://id.barentswatch.no/connect/token");
        details.setClientId(clientId);
        details.setClientSecret(secret);
        details.setScope(List.of("api"));
        details.setAuthenticationScheme(AuthenticationScheme.form);
        details.setClientAuthenticationScheme(AuthenticationScheme.form);

        return details;
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
