public class Employee {
    int dailyAttendence;
    int workPerDay=8;
    int halfDay=4;
    int dailySalary=0;
    int hourlyPay=12;
    public void calculateAttendence(){
        if(Math.random()<0.5){
         dailyAttendence=0;
         System.out.println("Absent");
        }else{
            dailyAttendence=1;
            System.out.println("Present");
        }
    }
    public void dailyWage(){
        if(dailyAttendence==1){
            dailySalary=workPerDay;
            System.out.println(dailySalary);
        }else{
            System.out.println("no pay");
        }
    }


}
