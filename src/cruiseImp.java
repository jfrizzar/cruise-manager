import javax.swing.JOptionPane;

public class cruiseImp{
    public static void main(String args[]){
        String option;
        int optionInteger;
        final int MAX_CRUISES = 10;
        final int MAX_TICKETS = 300;
        cruise[] cruisesArray = new cruise[MAX_CRUISES];

        do{
            //Get user input from the option selection menu
            option = customerOption();
            try{
                optionInteger = Integer.parseInt(option);
            }catch(NumberFormatException nfe){
                continue;
            }

            //Create a cruise method is executed
            if(optionInteger == 1){
                if(cruise.getCruiseCount() >= MAX_CRUISES){
                    JOptionPane.showMessageDialog(null, "Maximum number of cruises has been reached." +
                    " Please choose another option or delete an existing cruise.");
                }
                else{
                    cruise currentCruise = createCruise();
                    //Count is equal to 0 if error caused nothing to be returned
                    if(cruise.getCruiseCount() == 0 || currentCruise == null){
                        cruisesArray[cruise.getCruiseCount()] = currentCruise;
                    }
                    else{
                        cruisesArray[cruise.getCruiseCount() - 1] = currentCruise;
                    }
                }
            }
            
            //Search a cruise method is executed
            if(optionInteger == 2){
                searchCruise(cruisesArray);
            }

            //Remove a cruise method is executed
            if(optionInteger == 3){
                cruisesArray = removeCruise(cruisesArray);
            }

            //Sell a cruise method is executed
            if(optionInteger == 4){
                sellCruise(cruisesArray, MAX_TICKETS);
            }

            //Display all cruises method is executed
            if(optionInteger == 5){
                displayCruises(cruisesArray, MAX_TICKETS);
            }

        }while(option != "exit");
    }

























    //This method presents a menu to the users and prompts them to select an option
    public static String customerOption(){
            String option = JOptionPane.showInputDialog("~~ Welcome to the Frizzar Cruise Company ~~\n" +
            "Please one of the following options\n\n" +
            "(1) Create Cruise\n" +
            "(2) Search Cruise\n" +
            "(3) Remove Cruise\n" +
            "(4) Book Cruise\n" +
            "(5) Display Cruises\n\nType \"exit\" to exit the program.");

            try{
                if(option.toLowerCase().equals("exit"))
                    {
                        JOptionPane.showMessageDialog(null, "Exiting Program.");
                        return "exit";
                    }
                else if(Integer.parseInt(option) < 1 || Integer.parseInt(option) > 5)
                    {
                        JOptionPane.showMessageDialog(null, "Enter an integer between 1 and 5.");
                        return "";
                    }
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Enter an integer between 1 and 5.");
                return "";
            }catch(NullPointerException npe){
                return "exit";
            }
            return option;
    }


    /*Create Cruise Method, this method creates an object cruise with user input. It carefully updates the cruise count
    that is to be used in the rest of the program. This object is added to the array of cruises*/
    public static cruise createCruise(){
        try{
            cruise currentCruise = new cruise("J----", "location1 - location2", 0.01, 0);
            currentCruise.setCruiseID(JOptionPane.showInputDialog("Enter a 5 character cruise ID starting with the letter \"J\"."));
            currentCruise.setCruiseRoute(JOptionPane.showInputDialog("Enter a cruise route in the format: location1 - location2."));
            String ticketString = JOptionPane.showInputDialog("Enter the ticket cost for the cruise.");

            try{
                double ticketDouble = Double.parseDouble(ticketString);
                currentCruise.setTicketCost(ticketDouble);
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Enter a valid decimal number.");
                cruise.setCruiseCount(cruise.getCruiseCount() - 1);
                    return null;
            }catch(IllegalArgumentException iae){
                JOptionPane.showMessageDialog(null, iae.getMessage());
                cruise.setCruiseCount(cruise.getCruiseCount() - 1);
                    return null;
            }
                        return currentCruise;                
        }catch(IllegalArgumentException iae){
            JOptionPane.showMessageDialog(null, iae.getMessage());
                cruise.setCruiseCount(cruise.getCruiseCount() - 1);
                    return null;
        }catch(NullPointerException npe){
                cruise.setCruiseCount(cruise.getCruiseCount() - 1);
                    return null;
                }
    }

    /*Search Cruise Method, this method asks the user for a cruise ID and loops over the cruise array trying
    to match the cruise ID to the ID of the cruise object within the array*/
    public static void searchCruise(cruise[] cruisesArray){
        String searchID = JOptionPane.showInputDialog("Enter the cruise ID of the cruise " +
        "you are searching for. Cruise ID's start with the letter J.");

        if(searchID == null){
                return;
        }
        else if(!searchID.startsWith("J") || searchID.length() != 5){
            JOptionPane.showMessageDialog(null, "Please enter a 5 character cruise ID starting with the letter J.");
                return;
        }

        for(int i = 0; i < cruisesArray.length; i++){
            try{
                if(cruisesArray[i].getCruiseID().equals(searchID)){
                    JOptionPane.showMessageDialog(null, cruisesArray[i].toString());
                     return;
                }
            }catch(NullPointerException npe){
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "Cruise could not be found.");
            return;
    }

    /*Remove Cruise Method, this method checks to see if there are any cruises and if there are presents them
    to the user. After the user has made a selection of which cruises to delete a for loop is used to loop
    over appropriate elements shifting elements to the left to save over eachother*/

    public static cruise[] removeCruise(cruise[] cruisesArray){
        String allCruises = "";
        int userOption = 0;

        if(cruise.getCruiseCount() == 0){
            JOptionPane.showMessageDialog(null, "There are currently no cruises.");
            return cruisesArray;
        }

        for(int i = 0; i < cruise.getCruiseCount(); i++){
            allCruises += "(" + (i + 1) + ") " + cruisesArray[i].toString() + "\n";
        }
        
        try{
            //Take user option an subtract 1 from it to correspond to element in array
            userOption = Integer.parseInt(JOptionPane.showInputDialog(allCruises + "\nSelect the cruise that you want to remove.")) - 1;   
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please enter a number that is available on the menu.");
            return cruisesArray;
        }

        if(userOption < 0 || userOption > cruise.getCruiseCount() - 1){
            JOptionPane.showMessageDialog(null, "Please enter a number that is available on the menu.");
            return cruisesArray;
        }
        
        for(int i = userOption; i < cruisesArray.length - 1; i++){
            cruisesArray[i] = cruisesArray[i + 1];
        }
        
        //Setting the final element to null due to not being able to do it in the for loop without a array index error.
        cruisesArray[cruisesArray.length - 1] = null;

        //Decrement total cruise count by 1
        cruise.setCruiseCount(cruise.getCruiseCount() - 1);
            return cruisesArray;
    }

    /*Book Cruise Method, this method uses a loop to present a string of all cruises to a user,
    the user can then select which cruise they want to sell tickets for. Individual cruise ticket
    sold count and revenue is updated along with the total revenue*/

    public static void sellCruise(cruise[] cruisesArray, int MAX_TICKETS){
        String allCruises = "";
        int userOption = 0;
        int ticketAmount = 0;

        if(cruise.getCruiseCount() == 0){
            JOptionPane.showMessageDialog(null, "There are currently no cruises.");
                return;
        }

        for(int i = 0; i < cruise.getCruiseCount(); i++){
            allCruises += "(" + (i + 1) + ") " + cruisesArray[i].toString() + "\n";
        }
        
        try{
            userOption = Integer.parseInt(JOptionPane.showInputDialog(allCruises + "\nSelect a cruise")) - 1;
            if(userOption < 0 || userOption > cruise.getCruiseCount() - 1){
                JOptionPane.showMessageDialog(null, "Please enter a number that is available on the menu.");
                    return;  
            }
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please enter a number that is available on the menu.");
                return;
        }

        try{
            ticketAmount = Integer.parseInt(JOptionPane.showInputDialog("How many tickets do you want to sell for cruise: " 
            + cruisesArray[userOption].getCruiseID()));

                if (cruisesArray[userOption].getTicketSoldCount() + ticketAmount > MAX_TICKETS){
                    JOptionPane.showMessageDialog(null, "There are not enough tickets available for this cruise." +
                        " There are " + (MAX_TICKETS - cruisesArray[userOption].getTicketSoldCount()) + " tickets" +
                        " left for this cruise.");
                            return;
                }
                else if(ticketAmount < 1){
                    JOptionPane.showMessageDialog(null, "You cannot sell less than 1 ticket.");
                        return;
                }

            cruisesArray[userOption].setTicketSoldCount(ticketAmount + cruisesArray[userOption].getTicketSoldCount());
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
                return;
        }catch(IllegalArgumentException iae){
            JOptionPane.showMessageDialog(null, iae.getMessage());
                return;
        }

        //This line updates the total earnings accross all cruises
        cruise.setTotalEarning(cruise.getTotalEarning() + (ticketAmount*cruisesArray[userOption].getTicketCost()));
            return;
    }

    //Display Cruise Method, uses an empty string and for loop to build a string that can be presented to the user

    public static void displayCruises(cruise[] cruisesArray, int MAX_TICKETS){
        String allCruises = "";

        if(cruise.getCruiseCount() == 0){
            JOptionPane.showMessageDialog(null, "There are currently no cruises.");
            return;
        }

        for(int i = 0; i < cruise.getCruiseCount(); i++){
            allCruises += "(" + (i + 1) + ") " + cruisesArray[i].toString() + "\n" + "| Revenue: $" + 
            String.format("%.2f", cruisesArray[i].getTicketCost() * cruisesArray[i].getTicketSoldCount()) 
            + "| Remaining Seats: " + (MAX_TICKETS - cruisesArray[i].getTicketSoldCount()) + "\n";
        }

        allCruises +="\n\n Current number of cruises: " + cruise.getCruiseCount() + 
        "\n Total revenue: $" + String.format("%.2f", cruise.getTotalEarning());
        JOptionPane.showMessageDialog(null, allCruises);
    }
}