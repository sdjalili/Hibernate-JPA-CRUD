package sd.demo.ioc.common.coach;

public class SwimCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Do a 1000 meters swim to warm up.";
    }
}
