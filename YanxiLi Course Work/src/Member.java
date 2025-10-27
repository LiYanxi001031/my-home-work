import java.util.LinkedList;

public class Member {

    /**
     * Member's information. Including first name, last name.
     */
    private String firstName;
    private String lastName;

    /**
     * Constructor
     * @param firstName
     * @param lastName
     */
    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * get & set Method
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
