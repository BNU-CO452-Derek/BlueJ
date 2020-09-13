import java.io.*;
import java.util.Scanner;
/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kolling
 * @modified by Derek Peacock
 * @version 2016 04 13
 */
public class TicketMachine
{
    // The maximum cost of a ticket in pence
    public static final int MAX_PRICE = 500;
    // The price of a ticket from this machine in pence.
    private int price;
    // The amount of money entered by a customer so far in pence.
    private int balance;
    // The total amount of money collected by this machine in pence.
    private int total;

    private Ticket ticketPrices [];

    /**
     * Create a machine that issues tickets for the maximum price
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;

        price = MAX_PRICE;
        setupPrices();
    }

    /**
     * Create a machine that issues tickets of the given cost in pence.
     */
    public TicketMachine(int ticketCost)
    {
        this();
        price = ticketCost;
    }

    /**
     * @Return The price of a ticket in pence.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money in pence already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    public void insertCoin(Coin coin)
    {
        balance = balance + coin.getPenceValue();
        printReceived(coin.getPenceValue());
    }

    /**
     * Simulate the insertion of a uk coin.  Coins accepted are
     * 1, 2, 5, 10, 20, 50, 100 and 200p coins
     */
    public void insertCoin(int coin)
    {
        switch(coin)
        {
            case 1:  case 2:  case 5:   case 10:
            case 20: case 50: case 100: case 200: 
            
                balance = balance + coin;
                printReceived(coin);
                break;

            default: 
                System.out.println();
                System.out.println("This " + coin + " is not an acceptable coin!");
        }
    }

    /**
     * Receive an amount of money in pence from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println();
            System.out.println("Use a positive amount: " + amount);
        }
    }

    /**
     * Receive an amount of money in pence from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney()
    {
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter Ticket Price: >");

        int amount = input.nextInt();

        if(amount > 0) 
        {
            balance = balance + amount;
            printReceived(amount);
        }
        else 
        {
            System.out.println();
            System.out.println("Please use a positive amount: " + amount);
        }
    }

    public void printPrices()
    {
        printHeadings();
        int startTime = 0;
        
        for(int period = 0; period < 3; period++)
        {
            Ticket ticket = ticketPrices[period];
            System.out.print(startTime + " to ");
            System.out.println(ticket.getMaxTime() + " hrs " + ticket.getCost() + " pence");
            startTime = ticket.getMaxTime();
        }
        
        System.out.println();
    }

    private void printHeadings()
    {
        System.out.println();
        System.out.println("##############################");
        System.out.println("# Peacock Park & Ride");
        System.out.println("# Parking Tickets - PAY HERE");
        System.out.println("##############################");
        System.out.println();
    }

    private void printReceived(int amount)
    {
        printHeadings();
        System.out.println();
        System.out.println("Received " + amount + " pence");
        System.out.println("Total Received " + balance + " pence");
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) 
        {
            printHeadings();
            // Simulate the printing of a ticket.
            System.out.print("Your Parking Ticket cost ");
            System.out.println(price + " pence.");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                (price - balance) + " more pence.");

        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    private void setupPrices()
    {
        ticketPrices = new Ticket[3];

        ticketPrices[0] = new Ticket(150, 1);
        ticketPrices[1] = new Ticket(250, 2);
        ticketPrices[2] = new Ticket(500, 4);
    }
}
