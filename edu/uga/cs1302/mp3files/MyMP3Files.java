package edu.uga.cs1302.mp3files;

import java.io.File;
import java.util.ListIterator;
import java.util.Scanner;



public class MyMP3Files {

    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in); //call to keyboard for futer input readings
	
	boolean existanceCheck = true; //boolean value used to determine the iterations of the next d-while loop
	String pathname; //the string value of the next input reading
	do{
	    System.out.println("Please enter the pathname of the directory to be checked: ");
	    pathname = keyboard.next();
	    
	    File fileCheck = new File(pathname); //creates a new file object instance 
	    //use instance to check if the directory exists and is in fact a directory
	    if(fileCheck.exists() && fileCheck.isDirectory() == true) 
		existanceCheck = true;
	    else {
		existanceCheck = false;
		System.out.println("The pathname is invalid!");
	    }
	} while(existanceCheck = false);

	//more created objects to checkt he contents within the folder
	File newFileCheck = new File(pathname);
	File[] fileArray = newFileCheck.listFiles();
	
	SimpleArrayList<MP3File> simpleArrayList = new SimpleArrayList<MP3File>();
	
	//loop checks the file suffixes of the contents of the folder. if the file has
	//the suffix ".mp3" then it is put in the created simple array list
	for(int i = 0; i < fileArray.length; i++) {
	    String checkString = fileArray[i].getAbsolutePath();
	    if(checkString.charAt(checkString.length() - 1) == '3' 
	       && checkString.charAt(checkString.length() - 2) == 'p' &&
	       checkString.charAt(checkString.length() - 3) == 'm' 
	       && checkString.charAt(checkString.length() - 4) == '.') {
		MP3File newMP3 = new MP3File(fileArray[i].getAbsolutePath());
		simpleArrayList.add(newMP3);
	    }
	}
	//iterator created to iterate over values in the array list
	ListIterator<MP3File> iter = simpleArrayList.listIterator(0);
	
	//prints all values of the contents of the directory.
	while(iter.hasNext() == true) {
	    System.out.println(iter.next().toString());
	}
	
	while(iter.hasPrevious() == true) {
	    iter.previous();
	}
	
	String userInput = null;
	
	while(userInput != "q") {
	    
	    System.out.println("Please enter a key from any of the options (press h for help) : ");
	    userInput = keyboard.next();
	    
	    if(userInput == "h") {
		System.out.println("Press n to move to the next file, if one is present.");
		System.out.println("Press b to move to the previous file, if one is present.");
		System.out.println("Press i to print information about the current file.");
		System.out.println("Press p to play the current file.");
		System.out.println("Press h to display a help screen.");
		System.out.println("Press q to quit the program.");
	    }
	    
	    else if(userInput == "n") {
		if(iter.hasNext() == true) {
		    iter.next();
		}
		else
		    System.out.println("End of the list.");
	    }
	    
	    else if(userInput == "b") {
		if(iter.hasPrevious() == true) {
		    iter.previous();
		}
		else 
		    System.out.println("Top of the list.");
	    }
	    
	    else if(userInput == "i") {
		iter.next().toString();
		iter.previous();
	    }
	    
	    else if(userInput == "p") {
		iter.next().play();
		iter.previous();
	    }
	    
	    else if(userInput == "q") {
		System.exit(0);
	    }
	    
	    else
		System.out.println("Invalid input! Please try again.");
	}
	
	
    }
}
