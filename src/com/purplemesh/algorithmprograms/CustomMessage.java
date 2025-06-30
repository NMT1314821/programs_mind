package com.purplemesh.algorithmprograms;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.purplemesh.utility.Utility;

public class CustomMessage 
{
    public static void main(String[] args) 
    {
        
        String message = "Hello <<name>>, We have your full name as <<full name>> in our system. " +
                "your contact number is 91-xxxxxxxxxx. " +
                "Please, let us know in case of any clarification. Thank you BridgeLabz 01/01/2016.";

        
        System.out.println("Enter the firstName");
        String firstName = Utility.getString();
        System.out.println("Enter the fullName");
        String fullName = Utility.getString();
        System.out.println("Enter the PhoneNumber");
        String phoneNumber = Utility.getString();

       
        String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        
        message = message.replaceAll("<<name>>", firstName);

      
        message = message.replaceAll("<<full name>>", fullName);

        
        message = message.replaceAll("91-\\d{10}|91-x{10}", phoneNumber);

       
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        
        System.out.println("\nCustomized Message:\n");
        System.out.println(message);
    }
}
