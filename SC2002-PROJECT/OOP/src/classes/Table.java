package classes;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import java.util.ArrayList;

/**
 * create table class
 */
public class Table {
    /**
     * possible status values of table
     */
    public enum TableStatus {
        /**
         * table is occupied
         */
        OCCUPIED,
        /**
         * table is available
         */
        AVAILABLE};
    /**
     * unique identifier of the table
     */
    private int tableID;
    /**
     * max number of seats for the table
     */
    private int tableCapacity;
    /**
     * whether table is occupied or available
     */
    private TableStatus tableStatus;
    /**
     * array of reservations
     */
    private ArrayList<Reservation> reservationOwner;

    /**
     * constructor for table
     * @param tableID unique identifier for table
     * @param tableCapacity max number of seats in a table
     */
    public Table(int tableID, int tableCapacity) {
        this.tableID = tableID;
        this.tableCapacity = tableCapacity;
        this.tableStatus = TableStatus.AVAILABLE;
        this.reservationOwner = new ArrayList<Reservation>();
    }

    /**
     * get the id of table
     * @return id of table
     */
    public int getTableID() {
        return tableID;
    }

    /**
     * get the table capacity
     * @return table capacity
     */
    public int getTableCapacity() {
        return tableCapacity;
    }

    /**
     * get the status of table
     * @return table status
     */
    public TableStatus getTableStatus() {
        return tableStatus;
    }

    /**
     * set the status of table
     * @param tableStatus to be set
     */
    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }

    /**
     * print out details of table
     */
    public void printTableInfo(){
        System.out.println("Table " + this.tableID + "\t\tPax: " + this.tableCapacity + "\t\tStatus: " + this.tableStatus);
    }

}
