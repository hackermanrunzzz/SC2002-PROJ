package classmgr;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import classes.Staff;

import java.util.ArrayList;

/**
 * create staff manager class
 */
public class StaffManager {
    /**
     * create an array of staff members
     */
    ArrayList<Staff> staffs = new ArrayList<Staff>();

    /**
     * constructor for staff manager
     * @param staff array of staff members
     */
    public StaffManager(ArrayList<Staff> staff) {
        this.staffs = staff;
    }

    /**
     * get the array of staff members
     * @return the array of staff members
     */
    public ArrayList<Staff> getStaffs() {
        return staffs;
    }

    /**
     * print the details of staff members
     */
    public void printStaffs(){
        for(Staff s: staffs){
            System.out.println("Staff ID : " +s.getStaffID() + "          Staff Name : " + s.getStaffName() +
                    "            Staff Role : " + s.getStaffRole());
        }
    }

    /**
     * update the status of staff member
     * @param sid staff id
     */
    public void updateStatus(int sid) {
        Staff s = staffs.get(sid-1);
        s.setStaffStatus(true);

        System.out.println("Welcome, " + s.getStaffName() + "! You are logged in.");
    }

    /**
     * sign a staff member out of system
     */
    public void signOut() {
        for(Staff s: staffs){
            if(s.getStaffStatus() == true)
                s.setStaffStatus(false);
        }
    }
}
