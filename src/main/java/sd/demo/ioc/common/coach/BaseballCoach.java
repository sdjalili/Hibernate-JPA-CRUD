package sd.demo.ioc.common.coach;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Recovery day! go for a an easy walk.";
    }
}
