/**
 * @author Gladys Loh
 * @version 1.0
 * @since 9th November 2021
 */
package classmgr;//package classmgr;

import classes.Reservation;
import classes.Table;
import initialize.Restaurant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * create reservation manager class
 */
public class ReservationManager {
    /**
     * create scanner object to receive input
     */
    private static Scanner sc = new Scanner(System.in);
    /**
     * create an array of reservations
     */
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    /**
     * create an array of tables
     */
    private ArrayList<Table> tables = new ArrayList<Table>();
    //private static ArrayList<Reservation> settledReservations = Restaurant.settledReservations;

    /**
     * Initalize all reservations and tables
     * @param reservations a list of all reservations
     * @param tables a list of all tables
     */
    public ReservationManager(ArrayList<Reservation> reservations, ArrayList<Table> tables) {
        this.reservations = reservations;
        this.tables = tables;
    }

    /**
     * Get array of all reservations
     * @return an array of reservations
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Make new reservation and will set table status to OCCUPIED
     * Reservation id is made by getting the last reservation id and adding 1
     * @param customerName preferred name of the customer
     * @param customerContact customer contact number
     * @param numOfPax number of people for reservations
     * @param arrivalTime arrival time for reservation
     * @param tableId table allocated to reservation
     */
    public void makeReservation(String customerName, int customerContact, int numOfPax, Calendar arrivalTime, int tableId){

        boolean status = true;
        int resId = 10000;
        if(reservations.size() > 0){
            resId = reservations.get(reservations.size()-1).getReservationID()+1;
        }

        System.out.println("\nReservation is Confirmed!\nReservation ID:" + resId);
        reservations.add(new Reservation(resId, numOfPax, customerName, customerContact,  status , arrivalTime, tableId));
        tables.get(tableId-1).setTableStatus(Table.TableStatus.OCCUPIED);
        return;
    }

    /**
     * This is to check if date is valid
     * 1. Format has to be correct dd/mm/yyyy
     * 2. No date should be 3 months later from current date
     * @param date reservation date
     * @return true if valid, false if invalid
     */
    public boolean checkValidReservationDate(Calendar date){
        Calendar now = Calendar.getInstance();
        if(date.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR) &&
                date.get(Calendar.YEAR) == now.get(Calendar.YEAR)){
            return true;
        }else if(date.before(now)){
            System.out.println("! ERROR: This date is invalid");
            return false;
        }
        long diff = date.getTimeInMillis() - now.getTimeInMillis();
        long ddays = diff / (24 * 60 * 60 * 1000);
        if(ddays>90){
            System.out.println("! ERROR: Booking is only valid for 3 months in advannce");
            return false;
        }
        return true;
    }

    /**
     * This is to check if time is valid
     * 1. Time cannot be pass working hours
     * 2. Booking only should be made every 0 or 30th minute of the hour
     * @param time of reservation
     * @return boolean value if reservation is valid
     */
    public boolean checkValidReservationTime(Calendar time){
        if((time.get(Calendar.HOUR_OF_DAY)) < Restaurant.OPENING_HOUR || (time.get(Calendar.HOUR_OF_DAY)) > Restaurant.CLOSING_HOUR) {
            System.out.println("! ERROR: Invalid time, beyond working hours");
            return false;
        }else if((time.get(Calendar.MINUTE)) == 0 || (time.get(Calendar.MINUTE)) == 30){
            return true;
        }
        System.out.println("! ERROR: Invalid time");
        return false;
    }

    /**
     * First, gets date input and checks for incorrect format
     * If format is right, next step is to check for valid date
     * When date is valid, an array of time slots will be returned
     * Only time displayed in the array can be selected
     * @return valid reservation arrival time
     */
    public Calendar getValidReservationDateTime(){
        String date = "";
        String time = "";
        List times = new ArrayList();
        Date parsedDate = null;
        SimpleDateFormat dateFormat = null;
        boolean validDate = false;
        Calendar arrivalTime = Calendar.getInstance();

        do {
            System.out.print("Enter reservation date (dd/MM/yyyy): ");
            date = sc.nextLine();
            //create a date format for user to input
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                parsedDate = dateFormat.parse(date);
            } catch (ParseException e) {
                System.out.println("! ERROR: Entered reservation date is not in the correct format!");
                continue;
            }
            arrivalTime.setTime(parsedDate);
            validDate = checkValidReservationDate(arrivalTime);
            times = checkReservations(arrivalTime);

        } while (!validDate);

        System.out.print( "Available time slots: ") ;
        System.out.print(times +" \n");

        validDate = false;

        if(times.size()>0) {
            do {
                System.out.print("Enter reservation time: ");
                time = sc.nextLine();
                if (times.contains(time)) {
                    //create a date format for user to input
                    dateFormat = new SimpleDateFormat("HH:mm");
                    try {
                        parsedDate = dateFormat.parse(time);

                    } catch (ParseException e) {
                        System.out.println("! ERROR: Entered reservation time is not in the correct format!");
                        continue;
                    }
                    arrivalTime.setTime(parsedDate);
                    validDate = checkValidReservationTime(arrivalTime);
                } else {
                    System.out.println("! ERROR: Invalid time");
                }

            } while (!validDate);
        }else{
            System.out.println("! ERROR: Invalid time");
            return null;
        }
            date = date + " " + time;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date d = dateFormat.parse(date);
            arrivalTime.setTime(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return arrivalTime;
    }

    /**
     * Display all reservations made with full details
     */
    public void showAllReservations() {

        if (reservations.isEmpty() == true) {
            System.out.println("\nThere are currently no reservations");
        } else {
            System.out.println("============ ALL RESERVATIONS ===============");

            for (Reservation r : reservations) {
                Date date = r.getArrivalTime().getTime();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                String strDate = dateFormat.format(date);
                System.out.println(r.toString());
            }
        }
    }

    /**
     * Display all reservations in a shorter format
     * reservation id and reservation date/time
     * @return  number of reservations
     */
    public int showReservationShort(){
        if (reservations.isEmpty() == true) {
            System.out.println("There are currently no reservations");
            return 0;
        } else {
            System.out.println("============ ALL RESERVATIONS ===============");
            for (Reservation r : reservations) {
                Date date = r.getArrivalTime().getTime();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                String strDate = dateFormat.format(date);
                System.out.println("ID: "+ r.getReservationID() + "\t Date: "+ strDate);
             }
            return reservations.size();
        }
    }

    /**
     * Search for specific reservations
     * @param resId unique reservation id
     */
    public void searchReservation(int resId) {
        if(reservations.isEmpty() == true){
            System.out.println("\nThere are currently no reservations");
        }else{
            for(Reservation r: reservations){
                if(r.getReservationID() == resId){
                    System.out.println("========================================");

                    System.out.println("\nFound reservation: ");
                    Date date = r.getArrivalTime().getTime();
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    String strDate = dateFormat.format(date);
                    System.out.println(r.toString());
                    return;
                }
           }
        }
        System.out.println("Reservation can't be found");

    }

    /**
     * Calculate the available time slots for the date
     * Only future/advanced time will be display
     * @param date date and time of reservation
     * @return array of valid time slots for date
     */
    public List showTimeSlots(Calendar date){
        int gapInMinutes =  30 ;  // Define your span-of-time.
        int j;
        List<String> times = new ArrayList<>() ;
        LocalTime t = LocalTime.of(12,0);
        int min = 30;

        for(j = 0; j<20; j++){
            times.add(t.toString());
            t = t.plusMinutes(min);
        }

        LocalDateTime now = LocalDateTime.now();
        if(date.get(Calendar.DAY_OF_YEAR) == now.getDayOfYear() &&
                date.get(Calendar.YEAR) == now.getYear()){
            int n = 0;
            if(now.getHour() >= 12 && now.getHour() <22){
                n = (now.getHour()-12)*2+1;

                if(now.getMinute() > 30){
                    n = (now.getHour()-12)*2+2;
                }
            }

            times = times.subList(n,times.size());

            return times;
        }

        return times;

    }

    /**
     * Checks for all reservations that have the same date and time
     * @param date reservation date/time
     * @return list of valid time slots
     */
    public List checkReservations(Calendar date){

        List times = new ArrayList();
        String enteredDate = new SimpleDateFormat("dd/MM/yyyy").format(date.getTime());
        times = showTimeSlots(date);

        /* this for loop to check if select date matches any reservation date,
        and then display the available time slots for the date */

        for(Reservation r: reservations){
            String resDate = new SimpleDateFormat("dd/MM/yyyy").format(r.getArrivalTime().getTime());
        }
        return times;
    }

    /**
     * Remove specific reservation by Id
     * Will check if reservation for table has any pending orders before removing
     * @param resId reservation id
     * @return reservation id = success; -1= there is a pending order for table; 0= reservation id cannot be found
     */
    public int removeReservation(int resId){
        int index = 0;
        for(Reservation r : reservations){
            if(r.getReservationID() == resId){
                int tableId = r.getTableId();
                if(!Restaurant.allOrders.checkPendingOrder(tableId)){

                    tables.get(tableId-1).setTableStatus(Table.TableStatus.AVAILABLE);
                    reservations.remove(index);
                    return resId;
                }else{
                    return -1;
                }
            }
            index++;
        }
    return 0;
    }
}
