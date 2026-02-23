import javax.swing.JOptionPane;

public class cruiseImp{
    public static void main(String args[]){
        String option;
        int optionInteger;
        final int MAX_CRUISES = 5;
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
                    JOptionPane.showMessageDialog(null, "The maximum number of cruises has been reached." +
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
                String searchedCruise = searchCruise(cruisesArray);
                if(searchedCruise == null){
                    continue;
                }
                else{
                    JOptionPane.showMessageDialog(null, searchedCruise);
                }
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
        String option;
            option = JOptionPane.showInputDialog("~~ Welcome to the Frizzar Cruise Company ~~\n" +
            "Please one of the following options\n\n" +
            "(1) Create a new cruise\n" +
            "(2) Search for an existing cruise\n" +
            "(3) Remove an existing cruise\n" +
            "(4) Sell tickets for a cruise\n" +
            "(5) Display all cruises\n\nType \"Exit\" if you are finished.");

            try{
                if(option.toLowerCase().equals("exit"))
                    {
                        JOptionPane.showMessageDialog(null, "Exiting program.");
                        return "exit";
                    }
                else if(Integer.parseInt(option) < 1 || Integer.parseInt(option) > 5)
                    {
                        JOptionPane.showMessageDialog(null, "Enter an integer between 0 and 5.");
                        return "";
                    }
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Enter an integer between 0 and 5.");
                return "";
            }catch(NullPointerException npe){
                return "exit";
            }
            return option;
    }


    //Create a cruise method
    public static cruise createCruise(){
        try{
            cruise currentCruise = new cruise("J----", "location1 - location2", 0.01, 0);
            currentCruise.setCruiseID(JOptionPane.showInputDialog("Enter a 5 character cruise ID starting with the letter \"J\"."));
            currentCruise.setCruiseRoute(JOptionPane.showInputDialog("Enter a cruise route in the format: location1 - location2."));
            String ticketString = JOptionPane.showInputDialog("Enter the ticket cost for the cruise");

            try{
                double ticketDouble = Double.parseDouble(ticketString);
                currentCruise.setTicketCost(ticketDouble);
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Enter a valid decimal number.");
            }catch(IllegalArgumentException iae){
                JOptionPane.showMessageDialog(null, iae.getMessage());
            }
                    return currentCruise;                
        }catch(IllegalArgumentException iae){
            JOptionPane.showMessageDialog(null, iae.getMessage());
                cruise currentCruise = new cruise("J----", "location1 - location2", 0.01, 0);
                //Subtracting 2 from cruise count because 2 object were created throughout the function.
                cruise.setCruiseCount(cruise.getCruiseCount() - 2);
                currentCruise = null;
                    return currentCruise;
        }catch(NullPointerException npe){
                cruise currentCruise = new cruise("J----", "location1 - location2", 0.01, 0);
                //Subtracting 2 from cruise count because 2 object were created throughout the function.
                cruise.setCruiseCount(cruise.getCruiseCount() - 2);
                currentCruise = null;
                    return currentCruise;
                }
    }

    //Search for a cruise method
    public static String searchCruise(cruise[] cruisesArray){
        String searchID = JOptionPane.showInputDialog("Enter the cruise ID of the cruise " +
        "you are searching for. Cruise ID's start with the letter J");

        if(searchID == null){
            searchID = null;
                return searchID;
        }
        else if(!searchID.startsWith("J") || searchID.length() != 5){
            return "Invalid input. Please enter a 5 character cruise ID starting with the letter J.";
        }

        for(int i = 0; i < cruisesArray.length; i++){
            try{
                if(cruisesArray[i].getCruiseID().equals(searchID)){
                    return cruisesArray[i].toString();
                }
            }catch(NullPointerException npe){
                break;
            }
        }
        return "Cruise could not be found";
    }

    //Remove a cruise method
    public static cruise[] removeCruise(cruise[] cruisesArray){
        String allCruises = "";
        int userOption = 0;

        if(cruise.getCruiseCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no cruises currently.");
            return cruisesArray;
        }

        for(int i = 0; i < cruise.getCruiseCount(); i++){
            allCruises += "(" + (i + 1) + ") " + cruisesArray[i].toString() + "\n";
        }
        
        try{
            //Take user option an subtract 1 from it to correspond to element in array
            userOption = Integer.parseInt(JOptionPane.showInputDialog(allCruises + "\nSelect the cruise that you want to remove.")) - 1;   
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
            return cruisesArray;
        }

        if(userOption < 0 || userOption > cruise.getCruiseCount() - 1){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
            return cruisesArray;
        }
        
        for(int i = userOption; i < cruisesArray.length - 1; i++){
            cruisesArray[i] = cruisesArray[i + 1];
        }
        
        //Setting the final element to null due to not being able to do it in the for loop
        cruisesArray[cruisesArray.length - 1] = null;
        return cruisesArray;
    }

    //Sell cruise ticket method
    public static double sellCruise(cruise[] cruisesArray, int MAX_TICKETS){
        String allCruises = "";
        int userOption = 0;
        int ticketAmount = 0;

        if(cruise.getCruiseCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no cruises currently.\n Returning to main menu");
            return 0;
        }

        for(int i = 0; i < cruise.getCruiseCount(); i++){
            allCruises += "(" + (i + 1) + ") " + cruisesArray[i].toString() + "\n";
        }
        
        try{
            userOption = Integer.parseInt(JOptionPane.showInputDialog(allCruises + "\nSelect the cruise for which you want to sell tickets.")) - 1;
            if(userOption < 0 || userOption > cruise.getCruiseCount() - 1){
                JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
                    return 0;  
            }
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
                return 0;
        }

        try{
            ticketAmount = Integer.parseInt(JOptionPane.showInputDialog("How many tickets do you want to sell for cruise " 
            + cruisesArray[userOption].getCruiseID()));
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error, please enter a valid integer");
        }

        if (cruisesArray[userOption].getTicketSoldCount() + ticketAmount > MAX_TICKETS){
            JOptionPane.showMessageDialog(null, "Unable to sell tickets. The maximum # of tickets sold for a cruise is 300." +
                " There are " + (MAX_TICKETS - cruisesArray[userOption].getTicketSoldCount()) + " tickets" +
                " left for this cruise.");
                return 0;
        }
        cruisesArray[userOption].setTicketSoldCount(ticketAmount);

        //Update total earnings
        cruise.setTotalEarning(cruise.getTotalEarning() + (ticketAmount*cruisesArray[userOption].getTicketCost()));

        return ticketAmount * cruisesArray[userOption].getTicketCost();
    }

    //Display all cruises method
    public static void displayCruises(cruise[] cruisesArray, int MAX_TICKETS){
        String allCruises = "";

        if(cruise.getCruiseCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no cruises currently.\n Returning to main menu");
            return;
        }

        for(int i = 0; i < cruise.getCruiseCount(); i++){
            allCruises += "(" + (i + 1) + ") " + cruisesArray[i].toString() + "\n" + "| Revenue: $" + 
            String.format("%.2f", cruisesArray[i].getTicketCost() * cruisesArray[i].getTicketSoldCount()) 
            + "| Remaining Seats: " + (MAX_TICKETS - cruisesArray[i].getTicketSoldCount()) + "\n";
        }

            allCruises +="\n\n Current number of cruises: " + cruise.getCruiseCount() + "\n Total revenue: $" + String.format("%.2f", cruise.getTotalEarning());
        JOptionPane.showMessageDialog(null, allCruises);
    }
}