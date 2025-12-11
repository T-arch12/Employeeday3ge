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
    public void calculateWageTillCondition() {
        dailyWages.clear();
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        System.out.println("=== Wage Calculation until 100 hours OR 20 days ===");
        while (totalHours < MAX_TOTAL_HOURS && totalDays < MAX_WORKING_DAYS) {
            totalDays++;
            calculateAttendence();

            int hoursWorked;
            switch (dailyAttendence) {
                case 2: hoursWorked = workPerDay; break;
                case 1: hoursWorked = halfDay; break;
                default: hoursWorked = 0;
            }

            int wage = hoursWorked * hourlyPay;
            dailyWages.add(wage);
            totalHours += hoursWorked;
            totalWage += wage;

            System.out.printf("Day %2d: Attendance=%s, Hours=%d, DailyWage=%d, TotalHours=%d%n",
                    totalDays,
                    dailyAttendence == 2 ? "Full" : dailyAttendence == 1 ? "Part" : "Absent",
                    hoursWorked,
                    wage,
                    totalHours);
        }

        System.out.println("Stopped: Total Days = " + totalDays + ", Total Hours = " + totalHours + ", Total Wage = " + totalWage);
    }

    /**
     * Utility: print the list of daily wages collected
     */
    public void printDailyWagesList() {
        System.out.println("Daily wages list: " + dailyWages);
    }


}
