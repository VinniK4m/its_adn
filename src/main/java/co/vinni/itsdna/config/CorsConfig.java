package co.vinni.itsdna.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * Class to configure Cross filter connections
 * @author Vinni - vinni_@yahoo.com
 */
@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer setWebConfig(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://domain2.com")
                        .allowedMethods("GET", "POST", "PUT","DELETE");
            }
        };
    }

}
