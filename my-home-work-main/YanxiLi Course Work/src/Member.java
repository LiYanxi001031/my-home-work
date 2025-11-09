import java.util.HashMap;

public class Member {

    /**
     * Member's information. Including first name, last name
     */
    private String firstName;
    private String lastName;
    private HashMap<String, Integer> tickets;

    /**
     * Constructor
     */

    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tickets = new HashMap<>();
    }

    /**
     * get & set Method
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

    public HashMap<String, Integer> getTickets() {
        return tickets;
    }

    public void setTickets(HashMap<String, Integer> tickets) {
        this.tickets = tickets;
    }

    public boolean addTicket(String ticket) {
        this.tickets.put(ticket, 1);
        return true;
    }

    public boolean removeTicket(String ticket) {
        this.tickets.remove(ticket);
        return false;
    }

    /**
     * Override toString
     *
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
