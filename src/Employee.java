import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Employee {
    int dailyAttendence;
    int workPerDay=8;
    int halfDay=4;
    int dailySalary=0;
    int hourlyPay=12;
    private final Random rnd = new Random();
    private final List<Integer> dailyWages = new ArrayList<>();
    private final int MAX_WORKING_DAYS = 20;   // UC5
    private final int MAX_TOTAL_HOURS = 100;
    public void calculateAttendence(){
        if(((Math.random()*100)%3 )==0){
         dailyAttendence=0;
         System.out.println("Absent");
        }
        else if(((Math.random()*100)%3 )==1){
            dailyAttendence=1;
            System.out.println("part time");
        }


        else{
            dailyAttendence=1;
            System.out.println("Present");
        }
    }
    public void dailyWage(){
        if(dailyAttendence==1){
            dailySalary=workPerDay;
            System.out.println(dailySalary);
        }
        else if(dailyAttendence==2){
            dailySalary=workPerDay * hourlyPay;
            System.out.println(dailySalary);
        }
        else{
            System.out.println("no pay");
        }
    }
    public void calculateMonthlyWage() {
        dailyWages.clear();
        int totalWage = 0;
        System.out.println("=== Monthly Wage Calculation (20 working days) ===");
        for (int day = 1; day <= MAX_WORKING_DAYS; day++) {
            calculateAttendence();
            dailyWage();
            totalWage += dailySalary;
            System.out.println("Day " + day + " => Wage: " + dailySalary);
        }
        System.out.println("Total monthly wage for " + MAX_WORKING_DAYS + " days = " + totalWage);
    }


}
