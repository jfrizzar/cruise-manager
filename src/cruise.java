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
        
        cruiseCount++;
    };

    //All of the get methods
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

    public void setCruiseID(String cruiseID){
        this.cruiseID = cruiseID;
    }

    public void setCruiseRoute(String cruiseRoute){
        this.cruiseRoute = cruiseRoute;
    }

    public static void setCruiseCount(int cruiseCount){
        cruise.cruiseCount = cruiseCount;
    }

    public void setTicketCost(double ticketCost){
        this.ticketCost = ticketCost;
    }

    public void setTicketSoldCount(int ticketSoldCount){
        this.ticketSoldCount = ticketSoldCount;
    }

    public static void setTotalTicketSoldCount(int totalTicketSoldCount){
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
