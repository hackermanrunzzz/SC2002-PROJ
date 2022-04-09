/**
 * @author Gladys Loh
 * @version 1.0
 * @since 9th November 2021
 */
package classmgr;

import classes.Table;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * create table manager class
 */
public class TableManager {
    /**
     * create an array of tables
     */
    private static ArrayList<Table> tables = new ArrayList<Table>();


    /**
     * set the array of tables
     * @param tables array of tables to be set
     */
    public void setTables(ArrayList<Table> tables) {
        TableManager.tables = tables;
    }

    /**
     * set status of table to be available
     * @param tableID of table to be set available
     */
    public void leaveTable(int tableID){
        for(Table t: tables){
            if(t.getTableID()==tableID) t.setTableStatus(Table.TableStatus.AVAILABLE);
        }
    }

    /**
     * check if table is available to be reserved
     * @param tableID of table
     * @return boolean value if table is available
     */
    public boolean checkAvailability(int tableID){
        for(Table t: tables){
            if(t.getTableID()==tableID & t.getTableStatus().equals(Table.TableStatus.OCCUPIED)){
                return true;
            }
        }
        return false;

    }

    /**
     * print out all details of tables
     */
    public void printTables(){
            for (Table a : tables) {
                if (a.getTableStatus() == Table.TableStatus.AVAILABLE) {
                    a.printTableInfo();
                }
            }

    }

    /**
     * print out occupied table details
     */
    public void printOccupiedTables(){
        for (Table a : tables) {
                if (a.getTableStatus() == Table.TableStatus.OCCUPIED) {
                    a.printTableInfo();
                }
            }
    }

    /**
     * finds a table to be reserved
     * @param reservationDateTime date and time of reservation
     * @param numOfPax number of people to reserve for
     * @return value if table can be found
     */
    public int findReservationTable(Calendar reservationDateTime, int numOfPax){
        Table availableTable = checkAvailableTable(reservationDateTime, numOfPax);

        if(numOfPax > 0 && numOfPax <=10) {
            System.out.println("Looking for a vacant table.......");
            if (availableTable == null) {
                System.out.println("Sorry. There are no available tables at this timing.");
                return -1;
            }else{
                availableTable.printTableInfo();
                System.out.println("We found a table!\n");
                return availableTable.getTableID();
            }
        }else if(numOfPax>10){
            System.out.println("Sorry. There are no available tables for this pax.");
            return -1;
        }
        return -1;
    }

    /**
     * checks for available table to be reserved
     * @param reservationDateTime date and time of reservation
     * @param pax number of people to reserve for
     * @return table
     */
    public Table checkAvailableTable(Calendar reservationDateTime, int pax) {
        for (Table a : tables) {
            if (pax <= a.getTableCapacity() && a.getTableStatus() == Table.TableStatus.AVAILABLE) {
                return a;
            }
        }

        return null;
    }

}
