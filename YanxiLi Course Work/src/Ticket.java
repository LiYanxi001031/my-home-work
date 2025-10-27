public class Ticket {

    /**
     * Ticket's information. Including show name, available number and tickets price.
     */
    private String showName;
    private int availableNumber;
    private int ticketsPrice;

    /**
     * Constructor
     * @param showName
     * @param availableNumber
     * @param ticketPrice
     */
    public Ticket(String showName, int availableNumber, int ticketPrice) {
        this.showName = showName;
        this.availableNumber = availableNumber;
        this.ticketsPrice = ticketPrice;
    }

    /**
     * get & set Method
     * @return
     */
    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(int availableNumber) {
        this.availableNumber = availableNumber;
    }

    public int getTicketsPrice() {
        return ticketsPrice;
    }

    public void setTicketsPrice(int ticketPrice) {
        this.ticketsPrice = ticketPrice;
    }
}
