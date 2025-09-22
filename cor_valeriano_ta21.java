//author me
import java.util.Scanner;

public class COR_T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("What is your name: ");
        String name = scanner.nextLine();
        System.out.print("What is your course: ");
        String course = scanner.nextLine();
        System.out.print("What is your address: ");
        String address = scanner.nextLine();
        String[] subject = new String[11];
        subject[0] = "CCS0021";
        subject[1] = "CCS0021L";
        subject[2] = "CS0001";
        subject[3] = "CS0003";
        subject[4] = "CS0003L";
        subject[5] = "CS0070";
        subject[6] = "CS0070L";
        subject[7] = "GED0021";
        subject[8] = "GED0075";
        subject[9] = "GED0081";
        subject[10] = "GED0081L";
        
        int[] unit = new int[11];
        unit[0] = 2;
        unit[1] = 1;
        unit[2] = 3;
        unit[3] = 2;
        unit[4] = 1;
        unit[5] = 2;
        unit[6] = 1;
        unit[7] = 3;
        unit[8] = 3;
        unit[9] = 2;
        unit[10] = 1;
        
        String[] days = new String[11];
        days[0] = "T";
        days[1] = "F";
        days[2] = "M/TH";
        days[3] = "F";
        days[4] = "S";
        days[5] = "T";
        days[6] = "M";
        days[7] = "M/TH";
        days[8] = "F/T";
        days[9] = "F";
        days[10] = "S";
        
        String[] time = new String[11];
        time[0] = "13:00:00-15:40:00";
        time[1] = "13:00:00-15:50:00";
        time[2] = "15:00:00-16:50:00 / 15:00:000-16:50:00";
        time[3] = "07:00:00-09:40:00";
        time[4] = "07:00:00-09:50:00";
        time[5] = "10:00:00-12:40:00";
        time[6] = "10:00:00-12:50:00";
        time[7] = "17:00:00-18:50:00 / 17:00:00-18:50:00";
        time[8] = "17:00:00-18:50:00 / 17:00:00-18:50:00";
        time[9] = "10:00:00-12:40:00";
        time[10] = "10:00:00-12:50:00";
        
        System.out.println("COR: ");
        System.out.println("Student Name: "+name);
        System.out.println("Course: "+course);
        System.out.println("Address: "+address);
        int totalunits = 0;
        for (int i = 0; i < 11; i++) {
            System.out.printf("Subject: %s \t Unit: %d \t Days: %s \t Time: %s%n",subject[i], unit[i], days[i], time[i]);
            totalunits += unit[i];
        }
        System.out.println("Total Units: "+totalunits);
        final int price = 1400;
        int tuition = price * totalunits;
        System.out.printf("Tuition Fee: %,d Php",tuition);
        scanner.close();
    }
}
