package ui;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import classes.Invoice;
import classes.Report;
import initialize.Restaurant;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Scanner;

/**
 * create report ui class
 */
public class ReportUI {
    /**
     * create scanner object to receive input
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * let user input option to interact with report
     */
    public static void reportOptions(){
        int choice;
        do{
            System.out.println("========================================");
            System.out.println("Select option of sales report to be generated");
            System.out.println("(1) Daily Sales Report");
            System.out.println("(2) Monthly Sales Report");
            System.out.println("(3) Yearly Sales Report");
            System.out.println("(4) Go Back To Main Menu");
            System.out.println("========================================");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    generateDailyReportUI();
                    break;
                case 2:
                    generateMonthlyReportUI();
                    break;
                case 3:
                    generateYearlyReportUI();
                    break;
            }
        }while(choice < 4);
    }

    /**
     * generates the daily report
     */
   public static void generateDailyReportUI(){
        System.out.println("========================================");
        System.out.println("     Generating Daily Sales Report");
       System.out.println("========================================");
        int year = 0;
        do{System.out.println("Enter Year (2020/2021) :");
        year = sc.nextInt();
        sc.nextLine();}while(year<2020 | year>2022 );
        int month=-1;
        do{System.out.println("Enter Month (1-12) : ");
        month = sc.nextInt();
        sc.nextLine();} while( month<1 | month>12);
        YearMonth yearMonthObject = YearMonth.of(year,month);
        int day =0;
        do{ System.out.println("Enter Day (1-" +yearMonthObject.lengthOfMonth()+") :" );
        day = sc.nextInt();
        sc.nextLine();}while( day <1 | day> yearMonthObject.lengthOfMonth());
        int exist =0;
        for(Invoice i: Restaurant.report.getInvoices()) {
            if (year == i.getPaidTimestamp().get(Calendar.YEAR) &
                    month == (i.getPaidTimestamp().get(Calendar.MONTH)+1) &
                    day == i.getPaidTimestamp().get(Calendar.DATE)) exist = 1;
        }
        if(exist ==0) {
            System.out.println("There are no sales on this day.");
            return;
        }

        Report report = new Report(year,month,day);
        report.setInvoices(report.subsetInvoices());
        report.calculateReport();
       System.out.println("================================================================================");
       System.out.printf("                        Gabby FC Sales Report For %d/%d/%d\n",day,month,year);
       System.out.println("================================================================================");
       report.printReport();
    }

    /**
     * generates the monthly report
     */
    public static void generateMonthlyReportUI(){
        System.out.println("========================================");
        System.out.println("    Generating Monthly Sales Report");
        System.out.println("========================================");
        int year = 0;
        do{System.out.println("Enter Year (2020/2021) :");
            year = sc.nextInt();
            sc.nextLine();}while(year<2020 | year>2022 );
        int month=-1;
        do{System.out.println("Enter Month (1-12) : ");
            month = sc.nextInt();
            sc.nextLine();} while( month<1 | month>12);
        YearMonth yearMonthObject = YearMonth.of(year,month);
        int exist =0;
        for(Invoice i: Restaurant.report.getInvoices()) {
            if (year == i.getPaidTimestamp().get(Calendar.YEAR) &
                    month == (i.getPaidTimestamp().get(Calendar.MONTH)+1)
                  ) exist = 1;
        }
        if(exist ==0) {
            System.out.println("There are no sales in this month.");
            return;
        }

        Report report = new Report(year,month);
        report.setInvoices(report.subsetInvoices());
        report.calculateReport();
        System.out.println("================================================================================");
        System.out.printf("                          Gabby FC Sales Report For %d/%d\n",month,year);
        System.out.println("================================================================================");
        report.printReport();

    }

    /**
     * generates the yearly report
     */
    public static void generateYearlyReportUI(){

        System.out.println("========================================");
        System.out.println("    Generating Yearly Sales Report ");
        System.out.println("========================================");
        int year = 0;
        do{System.out.println("Enter Year (2020/2021) :");
            year = sc.nextInt();
            sc.nextLine();}while(year<2020 | year>2022 );
        int exist =0;
        for(Invoice i: Restaurant.report.getInvoices()) {
            if (year == i.getPaidTimestamp().get(Calendar.YEAR) ) exist = 1;
        }
        if(exist ==0) {
            System.out.println("There are no sales in this year.");
            return;
        }

        Report report = new Report(year);
        report.setInvoices(report.subsetInvoices());
        report.calculateReport();
        System.out.println("================================================================================");
        System.out.printf("                          Gabby FC Sales Report For %d\n", year);
        System.out.println("================================================================================");
        report.printReport();

     }
}
