public class Ticket {

    /**
     * Ticket's information. Including show name, available number and ticket price.
     */
    private String showName;
    private int availableNumber;
    private double ticketsPrice;

    /**
     * Constructor
     */
    public Ticket(String showName, int availableNumber, double ticketsPrice) {
        this.showName = showName;
        this.availableNumber = availableNumber;
        this.ticketsPrice = ticketsPrice;
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

    public double getTicketsPrice() {

        return ticketsPrice;
    }

    public void setTicketsPrice(double ticketPrice) {

        this.ticketsPrice = ticketPrice;
    }

    @Override
    public String toString(){
        return showName + "/n" + availableNumber + "/n" + ticketsPrice;
    }
}
