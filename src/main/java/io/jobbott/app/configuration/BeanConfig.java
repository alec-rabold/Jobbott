package io.jobbott.app.configuration;

import com.github.scribejava.apis.LinkedInApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import io.jobbott.app.repository.YelpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import static io.jobbott.app.util.Constants.*;

@Configuration
public class BeanConfig {

    @Autowired
    private Environment env;

    @Bean
    public YelpDao yelpDao() {
        return new YelpDao();
    }

    @Bean
    public OAuth20Service linkedinAuth(){
        return new ServiceBuilder(env.getProperty(API_KEY_LINKEDIN))
                .apiSecret(env.getProperty(API_SECRET_LINKEDIN))
                .callback(URI_HOMEPAGE + CALLBACK_LINKEDIN)
                .defaultScope(LINKEDIN_DEFAULT_SCOPE)
                .build(LinkedInApi20.instance());
    }

}
