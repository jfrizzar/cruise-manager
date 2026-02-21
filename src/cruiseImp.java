import javax.swing.JOptionPane;

public class cruiseImp{
    public static void main(String args[]){
        String option;
        int optionInteger;
        final int MAX_CRUISES = 10;
        cruise[] cruisesArray = new cruise[MAX_CRUISES];

        do{
            //Get user input from the option selection menu
            option = customerOption();

            optionInteger = Integer.parseInt(option);
            //Create a cruise method is executed
            if(optionInteger == 1){
                if(cruise.getCruiseCount() >= MAX_CRUISES){
                    JOptionPane.showMessageDialog(null, "The maximum number of cruises has been reached. Please choose another option or delete existing cruises");
                }
                cruise currentCruise = createCruise();
                cruisesArray[cruise.getCruiseCount() - 1] = currentCruise;
            }
            //Search a cruise method is executed
            if(optionInteger == 2){
                String searchedCruise = searchCruise(cruisesArray);
                JOptionPane.showMessageDialog(null, searchedCruise);

            }
            //Remove a cruise method is executed
            if(optionInteger == 3){

            }
            //Sell a cruise method is executed
            if(optionInteger == 4){

            }
            //Display all cruises method is executed
            if(optionInteger == 5){

            }
        }while(option != "exit");
    }

























    public static String customerOption(){
        String option;
            option = JOptionPane.showInputDialog("~~ Welcome to the Frizzar Cruise Company ~~\nPlease one of the following options\n\n( 1 ) Create a new cruise\n( 2 ) Search for an existing cruise\n( 3 ) Remove an existing cruise\n( 4 ) Sell one of your cruise tickets\n( 5 ) Display all cruises\n\nType \"Exit\" if you are finished.");
            try{
                if(option.toLowerCase().equals("exit"))
                    {
                        JOptionPane.showMessageDialog(null, "Exiting program.");
                        return "exit";
                    }
                else if(Integer.parseInt(option) < 0 || Integer.parseInt(option) > 5)
                    {
                        JOptionPane.showMessageDialog(null, "Enter an integer between 0 and 5.");
                        return "";
                    }
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Enter an integer between 0 and 5.");
                    return "";
                }
            return option;
    }

    //Create a cruise method
    public static cruise createCruise(){
        cruise currentCruise = new cruise("J", "location1 - location2", 0.01, 0);
        currentCruise.setCruiseID(JOptionPane.showInputDialog("Enter a cruise ID starting with the letter \"J\""));
        currentCruise.setCruiseRoute(JOptionPane.showInputDialog("Enter a cruise route in the format: location1 - location2."));
        currentCruise.setTicketCost(Double.parseDouble(JOptionPane.showInputDialog("Enter the ticket cost for the cruise")));
        return currentCruise;
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

    //TODO Remove a cruise method

    //TODO Sell cruise ticket method

    //TODO Display all cruises method
}