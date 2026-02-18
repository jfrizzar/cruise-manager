Patriot Ships is a new cruise line company which has a ﬂeet of 10 cruise ships, each with a capacity of 300 passengers. To manage its operations eﬃciently, the company is looking for a program that can help track its ﬂeet, manage bookings, and calculate revenue for each cruise.

Each cruise is tracked by a Cruise Identiﬁer (must be 5 characters long), cruise route (e.g. Miami to Nassau), and ticket price. The program should also track how many tickets have been sold for each cruise.

# Task
    Create an object-oriented solution with a menu that allows a user to select one of the following options:

    Create Cruise – This op=on allows a user to create a new cruise by entering all necessary details (Cruise ID, route, ticket price). If the maximum number of cruises has already been created, display an error message.
        
    Search Cruise – This op=on allows to search a cruise by the user provided cruise ID.
        
    Remove Cruise – This op=on allows a user to delete a cruise. The user must ﬁrst see a list of all available cruises and then select which one to remove. If the user selects an invalid cruise or if there are no cruises available, display an error message.
        
    Book Cruise Ticket – This op=on allows a user to sell a ticket for one of the cruises. The user selects the cruise and speciﬁes how many tickets to sell. If the user selects an invalid cruise, or if there aren’t enough available seats on the cruise, an error message should be displayed.
        
    Display Cruises – This op=on displays detailed information about all cruises, including the number of tickets sold, total revenue for each cruise, and the number of remaining seats. It should also show the current number of cruises and total revenue generated across all cruises. If no cruises have been created, display an error message.
        
    Exit – This op=on will terminate the program.

    After completing any action, the program should return to the menu, allowing the user to choose another option. The program will continue until the user selects the exit option.

# Sample

    ** Patriot Cruises **

    Choose on of the following options:
    1. Create Cruise
    2. Search Cruises
    3. Remove Cruise
    4. Sell Cruise Ticket
    5. Display All Cruises
    6. Exit

    Enter your choice:

    ** Patriot Cruises **
    Cruise ID | Cruise Route | Ticket Cost | Ticket Sold | Total Earning

    P001 | Alasksa to Jamaica | $300 | 50 | $15000

    Total cruises: 1
    Total earnings: $15000

# Guidelines
    you can assume that users won’t enter two bus tours with the same ID or bus name.
        
    Aim to use object-oriented programming techniques throughout your solution — procedural approaches won’t meet the project requirements.
        
    Your program should feature arrays of objects and include at least one static variable to manage shared data.
        
    Try to stay within the scope of arrays rather than using structures like ArrayList, since this project focuses on mastering arrays of objects.
        
    Design your solution to be modular, meaning you’ll use methods (other than main) where each method handles one clear task. Make sure your design class and implementation class are separate.

    Include the following in your code:

    Constants, constructors, accessors, and mutators
    A toString() method
    Exception handling, as needed

    Keep your imports simple — you’ll only need JOptionPane for this project (no other libraries should be used).
        
    Avoid using regular expressions for validation. Instead, use the Character and String classes to check IDs.
        
    Only use the programming features and functions covered in IT 106 or IT 206 this semester. Using advanced features not discussed in class could result in a grade penalty or Honor Code issue. When in doubt — just ask your instructor first!

# Requirements
    1 Identify and Describe Your Classes

    List each class you plan to include in your solution.
    For each one, write a short (1–2 sentence) description that explains its purpose and role in the program.

    2 Create Your Data Definition Class (DDC)

    Design a UML Class Diagram that clearly shows:
    Class variables and their purposes
    Accessors and mutators (getters and setters)
    Any special-purpose methods
    Constructors and how they initialize data
    Provide a short explanation for each item in your diagram.

    3 Implement Your Solution in Java

    Write a well-organized and efficient Java program that follows your design from the earlier steps.
    Include meaningful comments and documentation throughout your code. Refer to the Documentation Expectations guide for formatting and content suggestions.
    Make sure your program reflects good coding style, logical structure, and clear variable names so others can easily read and understand your work.


    Helpful Hints

    Build on what you’ve learned. Think back to how you handled array insertions and deletions in IT 106 — those same principles will help here.
        
    Plan your validations carefully. Consider what inputs or data might cause issues and make sure your program handles them smoothly.
        
    Keep methods organized. Any methods that summarize or analyze data across multiple objects should go in the implementation class to maintain clean design and separation of concerns.


    Hints

    You do NOT need to use arrays to solve this problem. Keep in mind once you have finished entering the information for one group, it is not necessary to keep the information.
        
    Think about any special purpose methods that might be needed in the data definition class. Special purpose methods are important when using values in instance variables to perform a specific process.