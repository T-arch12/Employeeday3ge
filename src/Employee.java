import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Employee {

    private static int workPerDay = 8;
    private static int halfDay = 4;
    private static int hourlyPay = 12;
    private static int MAX_WORKING_DAYS = 20;
    private static int MAX_TOTAL_HOURS = 100;


    private static final Random rand = new Random();


    int dailyAttendence;
    int dailySalary = 0;


    private final List<Integer> dailyWages = new ArrayList<>();
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


    public void printDailyWagesList() {
        System.out.println("Daily wages list: " + dailyWages);
    }
    public static int computeEmployeeWage() {
        List<Integer> wages = new ArrayList<>();
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while (totalHours < MAX_TOTAL_HOURS && totalDays < MAX_WORKING_DAYS) {
            totalDays++;
            int attendance = rand.nextInt(3); // 0,1,2
            int hoursWorked = (attendance == 2) ? workPerDay : (attendance == 1) ? halfDay : 0;
            int daily = hoursWorked * hourlyPay;
            wages.add(daily);
            totalHours += hoursWorked;
            totalWage += daily;

            // Console output to show progress
            String attStr = (attendance == 2) ? "Full" : (attendance == 1) ? "Part" : "Absent";
            System.out.printf(" Day %2d -> %s, Hours=%2d, Daily=%d, TotalHours=%d%n",
                    totalDays, attStr, hoursWorked, daily, totalHours);
        }

        System.out.println(" Final -> Days=" + totalDays + ", Hours=" + totalHours + ", TotalWage=" + totalWage);
        System.out.println(" Daily wages: " + wages);
        return totalWage;
    }

}
