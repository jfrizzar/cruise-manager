import javax.swing.JOptionPane;

public class cruise {

    private String cruiseID;
    private String cruiseRoute;
    private double ticketCost;
    private int ticketSoldCount;
    private static int totalTicketSoldCount;
    private static int cruiseCount;
    private static double totalEarning;


    //Default constructor
    public cruise(){
        this("", "", 0.0, 0);
    };

    //Parameterized constructor
    public cruise(String cruiseID, String cruiseRoute, double ticketCost, int ticketSoldCount){
        setCruiseID(cruiseID);
        setCruiseRoute(cruiseRoute);
        setTicketCost(ticketCost);
        cruiseCount++;
    };

    //Get methods
    public String getCruiseID(){
        return cruiseID;
    }

    public String getCruiseRoute(){
        return cruiseRoute;
    }
    
    public static int getCruiseCount(){
        return cruiseCount;
    }

    public double getTicketCost(){
        return ticketCost;
    }

    public int getTicketSoldCount(){
        return ticketSoldCount;
    }

    public static int getTotalTicketSoldCount(){
        return totalTicketSoldCount;
    }

    public static double getTotalEarning(){
        return totalEarning;
    }

    //Set methods
    public void setCruiseID(String cruiseID){
        if(!cruiseID.startsWith("J") || cruiseID.isEmpty() || cruiseID == null || cruiseID.length() != 5){
            throw new IllegalArgumentException("cruiseID must start with a \"J\" and be 5 characters long. (e.g. J0001, J0002, etc.)");
        }
        this.cruiseID = cruiseID;
    }

    public void setCruiseRoute(String cruiseRoute){
        if(cruiseRoute.isEmpty() || cruiseRoute == null){
            throw new IllegalArgumentException("The cruise route cannot be empty. Enter a cruise route in the format:" +
            "location1 - location2. (e.g. Jamaica - Nassau)");
        }
        this.cruiseRoute = cruiseRoute;
    }

    public static void setCruiseCount(int cruiseCount){
        if(cruiseCount < 0){
            throw new IllegalArgumentException("The cruise count cannot be less than 0.");
        }
        try{
            cruise.cruiseCount = cruiseCount;     
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "The cruise count must be an integer.");
        }
    }

    public void setTicketCost(double ticketCost){
        if(ticketCost < 0.01){
            throw new IllegalArgumentException("The ticket cost cannot be less than $0.01.");
        }
        try{
            this.ticketCost = ticketCost;           
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "The ticket cost must be a valid decimal number.");
        }
    }

    public void setTicketSoldCount(int ticketSoldCount){
        if(ticketSoldCount < 0){
            throw new IllegalArgumentException("The ticket sold count cannot be less than 0.");
        }
        try{
            this.ticketSoldCount = ticketSoldCount;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "The ticket sold count must be a valid integer");
        }
    }

    public static void setTotalTicketSoldCount(int totalTicketSoldCount){
        if(totalTicketSoldCount < 0){
            throw new IllegalArgumentException("The total ticket sold count a cannot be less than 0");
        }
        try{
            cruise.totalTicketSoldCount = totalTicketSoldCount;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "The total ticket sold count must be a valid integer.");
        }

    }

    public static void setTotalEarning(double totalEarning){
        if(totalEarning < 0){
            throw new IllegalArgumentException("The total earning must be positive");
        }
        try{
            cruise.totalEarning = totalEarning;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,"The total earnings must be a valid decimal number");
        }
    }

    public String toString(){
        return "Cruise ID: " + getCruiseID() + " | Cruise Route: " + getCruiseRoute() + " | Ticket Cost: $" + String.format("%.2f", getTicketCost()) + " | Ticket Sold Count: " + getTicketSoldCount();
    }

    public static void decrementCruise(int cruiseTotal){
        cruise.cruiseCount -= 1;
    }
}