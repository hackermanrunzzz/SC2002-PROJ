package classes;

/**
 * @author seth lee
 * @version 1.0
 * @since 9th November 2021
 */
public class Member {
    /**
     * name of member
     */
    private String memberName;
    /**
     * contact number of member
     */
    private String memberContact;

    /**
     * create constructor for member
     * @param memberName set member name
     * @param memberContact set member contact
     */
    public Member(String memberName, String memberContact) {
        this.memberName = memberName;
        this.memberContact = memberContact;
    }

    /**
     * get name of member
     * @return name of member
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * get contact number of member
     * @return number of member
     */
    public String getMemberContact() {
        return memberContact;
    }

}