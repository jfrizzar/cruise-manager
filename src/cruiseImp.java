import javax.swing.JOptionPane;

public class cruiseImp{
    public static void main(String args[]){

        cruise c1 = new cruise("J1", "Jamaica - Nassau", 250.10, 0);

        String option;

        do{
            option = customerOption();
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
}