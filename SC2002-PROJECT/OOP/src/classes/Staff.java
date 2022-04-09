package classes;

/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

/**
 * create staff class
 */
public class Staff {
    /**
     * unique identifier of staff
     */
    private int staffID;
    /**
     * name of staff member
     */
    private String staffName;
    /**
     * role of staff member
     */
    private String staffRole;
    /**
     * status of staff member
     */
    private boolean staffStatus;

    /**
     * constructor for staff
     * @param staffID unique identifier of staff
     * @param staffName name of staff member
     * @param staffRole role of staff member
     * @param staffStatus status of staff member
     */
    public Staff(int staffID, String staffName, String staffRole, boolean staffStatus) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffRole = staffRole;
        this.staffStatus = staffStatus;
    }

    /**
     * get the id of staff member
     * @return id of staff member
     */
    public int getStaffID() {
        return staffID;
    }

    /**
     * get the name of staff member
     * @return name of staff member
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * get the role of staff member
     * @return the role of staff member
     */
    public String getStaffRole() {
        return staffRole;
    }

    /**
     * get the status of staff member
     * @return the status of staff member
     */
    public boolean getStaffStatus() {
        return staffStatus;
    }

    /**
     * set the status of staff
     * @param stat of staff
     * @return status of staff
     */
    public boolean setStaffStatus(boolean stat) {
        this.staffStatus = stat;
        return stat;
    }

    /**
     * create staff member
     * @param staffID unique identifier of staff member
     * @param staffName name of staff member
     * @param staffRole role of staff member
     * @param staffStatus status of staff member
     * @return new staff member
     */
    public static Staff createStaff(int staffID, String staffName, String staffRole, boolean staffStatus){
        return new Staff(staffID,staffName,staffRole, staffStatus);
    }
}
