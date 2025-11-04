import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    static List<Member> listOfMember = new ArrayList<>();
    static List<Ticket> listOfTicket =  new ArrayList<>();
    public static void main(String[] args) {

        File myFile = new File("input_data.txt");

        try {
            Scanner sc = new Scanner(myFile);
            int memberCount = sc.nextInt();
            sc.nextLine();


            for (int i = 0; i < memberCount; i++) {
                    String fullName = sc.nextLine();
                    String[] parts = fullName.split(" ");
                    String firstName = parts[0];
                    String lastName = parts[1];
                    Member m = new Member(firstName, lastName);
                    listOfMember.add(m);
                }


            int showCount = sc.nextInt();
                sc.nextLine();


            for (int i = 0; i < showCount; i++) {
                    String showName = sc.nextLine();
                    int ticketCount = sc.nextInt();
                    sc.nextLine(); // Change the line
                    double ticketPrice = Double.parseDouble(sc.nextLine());

                listOfTicket.add(new Ticket(showName, ticketCount,ticketPrice));
                }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
        boolean done = false;
        while (!done) {

            printMenu();
            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter an Option: ");
                String option = sc.nextLine();
                switch (option) {
                    case "f":
                        System.out.print("Good bye");
                        done = true;
                        break;
                        case "t":
                            ticketInformation();
                            break;
                            case "m":
                                memberInformation();
                                break;
                                case "b":
                                    buyTickets();
                                    break;
                    case "c":
                        cancelTickets();
                        break;
                    default:
                        System.out.println("Please enter a valid Option");
                }

            }catch (Exception e){
                System.out.println("Invalid Option, please try again");
            }

        }
    }

    /**
     *  print menu method.
     *
     */
    private static void printMenu() {
        System.out.println("===    Menu    ===");
        System.out.println("Select an option");
        System.out.println("f: Finish the program");
        System.out.println("t: Information about the shows");
        System.out.println("m: Information about the members");
        System.out.println("b: Update the data when buying tickets");
        System.out.println("c: Delete the data after deleting tickets");
    }

    /**
     * Print ticket information method
     *
     */
    private static void ticketInformation() {
        System.out.println("==== Ticket Information ====");

        if (listOfTicket.isEmpty()) {
            System.out.println("No ticket is found");
        }else{
            for (Ticket ticket1 :listOfTicket) {
                System.out.println("Tickets for these shows: " + ticket1.getShowName() +" is available");
                System.out.println("Tickets' availableNumber: " + ticket1.getAvailableNumber());
                System.out.println("Tickets' price: "+ ticket1.getTicketsPrice());
            }
        }
    }

    /**
     * Print memberInformation method
     *
     */
    private static void memberInformation() {
        System.out.println("==== Member Information ====");

        if (listOfMember.isEmpty()) {
            System.out.println("No members found");
        } else {
            for (Member member : listOfMember) {
                System.out.println("Member: " + member.getFirstName() + " " + member.getLastName());

                if (member.getTickets().isEmpty()) {
                    System.out.println("No tickets");
                } else {
                    double allTotal = 0;

                    for (String ticketName : member.getTickets().keySet()) {
                        int quantity = ticketName.split(" ").length;

                        double price = 0;
                        for (Ticket ticket : listOfTicket) {
                            if (ticket.getShowName().equals(ticketName)) {
                                price = ticket.getTicketsPrice();
                                break;
                            }
                        }

                        double typeTotal = quantity * price;
                        allTotal += typeTotal;
                        System.out.println(ticketName + ": " + quantity + " tickets");
                        System.out.println("Total price: " + typeTotal);
                    }
                    System.out.println("All tickets total: " +  allTotal);
                }
                System.out.println();
            }
        }
    }

    /**
     * How to buy the ticket method
     *
     */
    private static void buyTickets() {

        System.out.println("==== Buy Tickets ====");
        System.out.println("Please Select the member:");
        for (int i = 0; i < listOfMember.size(); i++) {
            System.out.println((i + 1) + ". " + listOfMember.get(i));
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an Option: ");
        int memberIndex = sc.nextInt() - 1; // 减1因为列表从0开始

        if (memberIndex < 0 || memberIndex >= listOfMember.size()) {
            System.out.println("Please enter a valid Member index");
            return;
        }
        Member member = listOfMember.get(memberIndex);


        System.out.println("Please Select the ticket:");
        for (int i = 0; i < listOfTicket.size(); i++) {
            System.out.println((i + 1) + ". " + listOfTicket.get(i).getShowName());
        }
        System.out.print("Enter an Option: ");
        int ticketIndex = sc.nextInt() - 1;

        if (ticketIndex < 0 || ticketIndex >= listOfTicket.size()) {
            System.out.println("Please enter a valid Ticket index");
            return;
        }
        Ticket ticket = listOfTicket.get(ticketIndex);

        /**
         * Change the line.
         */
        System.out.println();
        System.out.println("Number of ticket you want to buy: ");
        int quantity = sc.nextInt();

        if (quantity < 0 || quantity >= listOfTicket.size()) {
            System.out.println("Fail to buy tickets. Because We don't have enough tickets to sell or you enter a invalid number. Please enter a valid number.");
            writeLetter(member, ticket);

        }else if(member.getTickets().size() < 3 && !member.getTickets().containsKey(ticket.getShowName())) {
            member.addTicket(ticket.getShowName());
            System.out.println("You have successfully bought this ticket!");
        }else {
            System.out.println("Failed to buy ticket. Because you already have 3 types of tickets.");
        }
    }

    /**
     * How to cancel the Tickets method
     *
     */
    private static void cancelTickets() {
        System.out.println("==== Cancel Tickets ====");
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < listOfMember.size(); i++) {
            System.out.println((i + 1) + ". " + listOfMember.get(i).toString());
        }

        System.out.print("Enter an Option: ");
        int memberChoice = scanner.nextInt() - 1;

        if (memberChoice < 0 || memberChoice >= listOfMember.size()) {
            System.out.println("Member's number is invalid, please try again");
            return;
        }

        Member member = listOfMember.get(memberChoice);

        if (member.getTickets().isEmpty()) {
            System.out.println("This member has no tickets");
            return;
        }


        System.out.println("The tickets now you have:");
        List<String> ticketNames = new ArrayList<>(member.getTickets().keySet());
        int quantity = member.getTickets().get(listOfTicket.get(memberChoice).getShowName());
        for (int i = 0; i < ticketNames.size(); i++) {
            String ticketName = ticketNames.get(i);
            System.out.println((i + 1) + ". " + ticketName);
        }

        System.out.print("Select a ticket you want to cancel: ");
        int ticketChoice = scanner.nextInt() - 1 ;

        if (ticketChoice < 0 || ticketChoice >= ticketNames.size()) {
            System.out.println("Please enter a valid Ticket index");
            return;
        }

        String selectedTicket = ticketNames.get(ticketChoice);

        System.out.print("Enter quantity to cancel: ");
        int cancelQuantity = scanner.nextInt();
        if(cancelQuantity <= quantity && cancelQuantity >= 0) {
            member.getTickets().remove(selectedTicket);
            System.out.println("You have successfully cancelled " + cancelQuantity + " tickets for " + selectedTicket);
        } else {
            System.out.println("Failed to cancel tickets. Please check the ticket's quantity");
        }
    }
    public static void writeLetter(Member member, Ticket ticket) {
            try (FileWriter fw = new FileWriter("letters.txt", false)) {
                PrintWriter writer = new PrintWriter(fw);
                writer.println("Dear " + member.getFirstName() + " " + member.getLastName() + ",");
                writer.println();
                writer.println("We are sorry to inform you that we do not have enough tickets for " + ticket.getShowName() +"."+ " Please buy another show.");
                writer.println("Or you just enter a invalid number like -1. Be careful that the number can't < 0.");
                writer.println();
                writer.println("Sincerely,");
                writer.println("NEAT");
                writer.println();
            } catch (IOException e) {
                System.out.println("Error writing to letters.txt: " + e.getMessage());
        }
    }
}

