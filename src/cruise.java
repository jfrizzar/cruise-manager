public class cruise {

    private String cruiseID;
    private String cruiseRoute;
    private static int cruiseCount;
    private double ticketCost;
    private int ticketSoldCount;
    private static int totalTicketSoldCount;
    private static double totalEarning;

    //There are two constructors: a default contructor and parameterized
    //They are chained together so that the count is always updated
    public cruise(){
        this("", "", 0.0, 0);
    };

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
        if(!cruiseID.startsWith("J")){
            throw new IllegalArgumentException("cruiseID must start with \"J\".");
        }
        this.cruiseID = cruiseID;
    }

    public void setCruiseRoute(String cruiseRoute){
        if(cruiseRoute.isEmpty() || cruiseRoute == null){
            throw new IllegalArgumentException("Cruise route cannot be empty. Enter a cruise route in the format: location1 - location2.");
        }
        this.cruiseRoute = cruiseRoute;
    }

    public static void setCruiseCount(int cruiseCount){
        if(cruiseCount < 0){
            throw new IllegalArgumentException("Cruise count cannot be less than 0.");
        }
        cruise.cruiseCount = cruiseCount;
    }

    public void setTicketCost(double ticketCost){
        if(ticketCost < 0.01){
            throw new IllegalArgumentException("The ticket cost cannot be less than $0.01.");
        }
        this.ticketCost = ticketCost;
    }

    public void setTicketSoldCount(int ticketSoldCount){
        if(ticketSoldCount < 0){
            throw new IllegalArgumentException("The ticket sold count cannot be less than 0.");
        }
        this.ticketSoldCount = ticketSoldCount;
    }

    public static void setTotalTicketSoldCount(int totalTicketSoldCount){
        if(totalTicketSoldCount < 0){
            throw new IllegalArgumentException("The total ticket sold count a cannot be less than 0");
        }
        cruise.totalTicketSoldCount = totalTicketSoldCount;
    }

    public static void setTotalEarning(double totalEarning){
        cruise.totalEarning = totalEarning;
    }

    public String toString(){
        String details = "";
        return details;
    }
}
