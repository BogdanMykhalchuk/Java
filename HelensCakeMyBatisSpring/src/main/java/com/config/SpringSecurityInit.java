package com.config;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by Dreawalker on 29.08.2017.
 */
public class SpringSecurityInit extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityInit() {
        super(SecurityConfig.class);
    }
}
