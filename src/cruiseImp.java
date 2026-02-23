import javax.swing.JOptionPane;

public class cruiseImp{
    public static void main(String args[]){
        String option;
        int optionInteger;
        double revenue = 0;
        final int MAX_CRUISES = 1;
        final int MAX_PAX = 300;
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
                    if(cruise.getCruiseCount() == 0){
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
                JOptionPane.showMessageDialog(null, searchedCruise);
            }

            //Remove a cruise method is executed
            if(optionInteger == 3){
                cruisesArray = removeCruise(cruisesArray);
            }

            //Sell a cruise method is executed
            if(optionInteger == 4){
                revenue += sellCruise(cruisesArray);
            }

            //Display all cruises method is executed
            if(optionInteger == 5){
                displayCruises(cruisesArray);
            }

        }while(option != "exit");
    }

























    public static String customerOption(){
        String option;
            option = JOptionPane.showInputDialog("~~ Welcome to the Frizzar Cruise Company ~~\n" +
            "Please one of the following options\n\n" +
            "(1) Create a new cruise\n" +
            "(2) Search for an existing cruise\n" +
            "(3) Remove an existing cruise\n" +
            "(4) Sell one of your cruise tickets\n" +
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
            currentCruise.setCruiseID(JOptionPane.showInputDialog("Enter a cruise ID starting with the letter \"J\"."));
            currentCruise.setCruiseRoute(JOptionPane.showInputDialog("Enter a cruise route in the format: location1 - location2."));
            currentCruise.setTicketCost(Double.parseDouble(JOptionPane.showInputDialog("Enter the ticket cost for the cruise")));
            return currentCruise;
        }catch(IllegalArgumentException iae){
            cruise currentCruise = new cruise("J----", "location1 - location2", 0.01, 0);
            cruise.setCruiseCount(cruise.getCruiseCount() - 2);
            currentCruise = null;
            return currentCruise;
        }catch(NullPointerException npe){
            cruise currentCruise = new cruise("J----", "location1 - location2", 0.01, 0);
            cruise.setCruiseCount(cruise.getCruiseCount() - 2);
            JOptionPane.showMessageDialog(null, "Invalid entry. Returning to main menu.");
            currentCruise = null;
            return currentCruise;
        }
    }

    //Search for a cruise method
    public static String searchCruise(cruise[] cruisesArray){

        String searchID = JOptionPane.showInputDialog("Enter the cruise ID of the cruise you are searching for");
        for(int i = 0; i < cruisesArray.length; i++){
            try{
                if(cruisesArray[i].getCruiseID().equals(searchID)){
                    return cruisesArray[i].toString();
                }
            }catch(NullPointerException npe){
                return "Cruise could not be found";
            }
        }
        return "Cruise could not be found";
    }

    //Remove a cruise method
    public static cruise[] removeCruise(cruise[] cruisesArray){
        String allCruises = "";
        int userOption = 0;

        if(cruise.getCruiseCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no cruises currently.\n Returning to main menu");
            return cruisesArray;
        }

        for(int i = 0; i < cruise.getCruiseCount(); i++){
            allCruises += "( " + (i + 1) + " ) " + cruisesArray[i].toString() + "\n";
        }
        
        try{
            userOption = Integer.parseInt(JOptionPane.showInputDialog(allCruises + "\nSelect the number of the cruise that you want to remove."));            
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
            return cruisesArray;
        }

        userOption -= 1;

        
        if(userOption < 0 || userOption > cruise.getCruiseCount() - 1){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
            return cruisesArray;
        }
        
        for(int i = userOption; i < cruisesArray.length - 1; i++){
            cruisesArray[i] = cruisesArray[i + 1];
        }
        
        int finalIndex = cruisesArray.length - 1;
        cruisesArray[finalIndex] = null;
        return cruisesArray;
    }

    //Sell cruise ticket method
    public static double sellCruise(cruise[] cruisesArray){
        String allCruises = "";
        int userOption = 0;
        int ticketAmount = 0;

        if(cruise.getCruiseCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no cruises currently.\n Returning to main menu");
            return -1;
        }

        for(int i = 0; i < cruise.getCruiseCount(); i++){
            allCruises += "( " + (i + 1) + " ) " + cruisesArray[i].toString() + "\n";
        }
        
        try{
            userOption = Integer.parseInt(JOptionPane.showInputDialog(allCruises + "\nSelect the cruise for which you want to sell tickets."));            
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
            return -1;
        }

        userOption -= 1;

        try{
            ticketAmount = Integer.parseInt(JOptionPane.showInputDialog("How many tickets do you want to sell for cruise " + cruisesArray[userOption].getCruiseID()));
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error, please enter a valid integer");
        }

        cruisesArray[userOption].setTicketSoldCount(ticketAmount);

        return ticketAmount * cruisesArray[userOption].getTicketCost();
    }

    //Display all cruises method
    public static void displayCruises(cruise[] cruisesArray){
        String allCruises = "";

        if(cruise.getCruiseCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no cruises currently.\n Returning to main menu");
            return;
        }

        for(int i = 0; i < cruise.getCruiseCount(); i++){
            allCruises += "( " + (i + 1) + " ) " + cruisesArray[i].toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, allCruises);
    }
}