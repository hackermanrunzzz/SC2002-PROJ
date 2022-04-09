package classmgr;
/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */

import classes.Member;
import ui.ReservationUI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * create member manager class
 */
public class MemberManager {
    /**
     * create scanner object to receive input
     */
    private static Scanner sc = new Scanner(System.in);
    /**
     * create an array of members
     */
    ArrayList<Member> members = new ArrayList<Member>();

    /**
     * constructor for member manager
     * @param members array of members
     */
    public MemberManager(ArrayList<Member> members) {
        this.members = members;
    }

    /**
     * add member
     * @return boolean value if member can be added
     */
    public boolean addMember(){
        System.out.println("Enter new member's contact:");
        String contact = sc.nextLine();
        for(Member m: members){
            if(m.getMemberContact()==contact){
                System.out.println("He/She is already a member!");
                return false;
            }
        }
        System.out.println("Enter new member's name:");
        String name = sc.nextLine();
        members.add(new Member(name, contact));
        System.out.println("Congrats! He/She is now a member!");
        return true;
    }

    /**
     * checks if customer is a member
     * @param phoneNumber of customer
     * @return boolean value if customer is a member
     */
    public boolean isMember(String phoneNumber){

        if(!ReservationUI.isValidMobileNo(phoneNumber)) return false;
        for (Member m : members){
            if (phoneNumber.equals(m.getMemberContact())){
                return true;
            }
        }
        return false;
    }

    /**
     * view the list of members
     */
    public void viewMembers(){
        System.out.println("No. Member Name     Member Contact");
        for(int i = 0; i<members.size(); i++){
            System.out.println((i+1) +". "+ members.get(i).getMemberName() + " : "
                    + members.get(i).getMemberContact());
        }
    }

    /**
     * remove a member
     * @return boolean value if member can be removed
     */
    public boolean removeMember(){
        System.out.println("Enter member's contact:");
        String contact = sc.nextLine();
        for(Member m: members){
            if(m.getMemberContact().equals(contact)) {
                members.remove(m);
                System.out.println(m.getMemberName() + " is no longer a member.");
                return true;
            }
        }
        System.out.println("He/She was not a member.");
        return false;
    }
}
