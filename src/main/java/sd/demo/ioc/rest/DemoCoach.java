package sd.demo.ioc.rest;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import sd.demo.ioc.common.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoCoach {

    private Coach myCoach;

    // To check Bean lifeCycle comparing singleton and prototype
    private Coach firstCoach;
    private Coach secondCoach;

    //construction injection
    @Autowired
    public DemoCoach(@Qualifier("swimCoach") Coach theCoach){
        System.out.println("In Constructor:  " + this.getClass().getSimpleName());
        myCoach = theCoach;
    }

    @PostConstruct
    public void doPostConstuct(){
        System.out.println("In pre construction : " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doPreDestroy(){
        System.out.println("In pre destroy method: " + getClass().getSimpleName());
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    //Checking whether the beans are shares in a same memory or they have different instances
    @Autowired
    public void setCoach(
            @Qualifier("baseballCoach") Coach theFirstCoach,
            @Qualifier("baseballCoach") Coach theSecondCoach){

        firstCoach = theFirstCoach;
        secondCoach = theSecondCoach;
    }
    @GetMapping("/checklifecycle")
    public String checkLifeCycle(){
        return
                firstCoach.getClass().getSimpleName() + "<br>" +
                firstCoach.getDailyWorkout() + "<br>" +
                "comparing bean life cycle: firstCoach = secondCoach " + "<br>" +
                        "<span> " + (firstCoach == secondCoach) +"</span>";
    }
}
