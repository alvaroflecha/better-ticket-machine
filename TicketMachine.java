/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private double price;
    // The amount of money entered by a customer so far.
    private double balance;
    // The total amount of money collected by this machine.
    private double total;
    //The price of a ticket with discount from this machine.
    private double discountPrice;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(double cost)
    {
        price = cost;
        balance = 0;
        total = 0;
        discountPrice = price - (price * 0.1);
    }

    /**
     * @Return The price of a ticket.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(double amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            double amountLeftToPay = price - balance;
            System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents.");
                   
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public double refundBalance()
    {
        double amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    /**
     * Devuelve el dinero que hace falta meter
     * para poder imprimir un ticket
     */
    public double getAmountLeftToPay()
    {
        double amountLeftToPay;
        amountLeftToPay = price - balance;
        return amountLeftToPay;
    }
    /**
     * Vacia la maquina y devuelve la cantidad de dinero que habia en ella
     */
    public double emptyMachine()
    {
      double amountTotalMachine = balance + total;
      balance = 0;
      total = 0;
      return amountTotalMachine;
    }
    /** 
     * Realiza descuento del 10% sobre el precio del billete
     */
    
    public double getDiscountPrice()
    {
      return discountPrice;
    }
    
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicketDiscount()
    {
        if(balance >= discountPrice) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + discountPrice + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + discountPrice;
            // Reduce the balance by the prince.
            balance = balance - discountPrice;
        }
        else {
            double amountLeftToPay = discountPrice - balance;
            System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents.");
                   
        }
    }
    /**
     * Devuelve el dinero que hace falta meter
     * para poder imprimir un ticket con descuento
     */
    public double getAmountLeftToPayDiscount()
    {
       double amountLeftToPayDiscount = discountPrice - balance;
       return amountLeftToPayDiscount;
      
    }
    
}
