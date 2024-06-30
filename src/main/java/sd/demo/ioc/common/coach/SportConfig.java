package sd.demo.ioc.common.coach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

  //  @Bean("swimCoachTest")
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
