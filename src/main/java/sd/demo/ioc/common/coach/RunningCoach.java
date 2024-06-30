package sd.demo.ioc.common.coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
@Lazy
public class RunningCoach implements Coach{
    public RunningCoach() {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }
    //define init method
    @PostConstruct
    public void doInitiateTrackCoach(){
        System.out.println("in Init() :  " + getClass().getSimpleName());
    }

    //define destroy method
    @PreDestroy
    public void doDestroyTrackCoach(){
        System.out.println("in Destroy() : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k today.";
    }
}
