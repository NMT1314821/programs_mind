package com.purplemesh.algorithmprograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import com.purplemesh.utility.Utility;


public class BinarySearchWord{
    public static void main(String[] args) {
        StringBuilder data = new StringBuilder();
        try {
            File myFile = new File("D://filestore//update.txt");
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                data.append(reader.nextLine()).append(",");
            }
            reader.close();
            //System.out.println(data);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
            return;
        }
     
        String[] words = data.toString().split(",");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim(); 
        }
        System.out.println(Arrays.toString(words));
        Arrays.sort(words);
        
        System.out.println("Enter the search word:");
        String input= Utility.getString().trim();
      
        int low = 0;
        int high = words.length - 1;
        boolean found = false;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            int cmp = input.compareToIgnoreCase(words[mid]);

            if (cmp == 0) {
                found = true;
                break;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (found) 
        {
            System.out.println("Element foudnd");
        }
        else
        {
        	System.out.println("Element not found");
        }
    }
}




