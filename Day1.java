import java.io.*;
import java.util.*;

public class Day1{
	
private static Scanner x;
	
	public static void openFile() {
		try {
			x = new Scanner(new File("c:\\input.txt"));
		}
		catch(Exception e) {
			System.out.println("could not find file");
		}
	}
	
	public static ArrayList<Integer> readFile() {
		 ArrayList<Integer>  v = new  ArrayList<Integer> (); 
		while(x.hasNextInt()) {
			int a = x.nextInt();
			v.add(a); 
		}
		return v;
	}
	
	public static void closeFile() {
		x.close();
	}
	
	public static void main(String[] args) throws IOException {
        
		ArrayList<Integer> AR = new  ArrayList<Integer> ();  
       openFile();
       AR = readFile();
       closeFile();
      HashSet<Long> pastFrequencies = new HashSet<>();
      
      boolean partTwoAnswerFound = false;
      long currentFrequency = 0;
      
      for(int cyclesComplete = 0; !partTwoAnswerFound; cyclesComplete++)
      {
    	  for (int i = 0; i < AR.size() && !partTwoAnswerFound; ++i)
    	  {
    		  // First so we get that zero added.
    		  pastFrequencies.add(currentFrequency);
    		  
    		  //The new frequency is the old one plus the change.
    		  currentFrequency += AR.get(i);;
    		  
    		  //Part one answer. (Ending frequency)
    		  if (cyclesComplete == 1 && i == AR.size() - 1)
    			  System.out.println("Part 1: " + currentFrequency/2);
    		  
    		  //Part two answer. (First repeating frequency)
    		  if (pastFrequencies.contains(currentFrequency))
    		  {
    			  System.out.println("Part 2: " + currentFrequency);
    			  // And quit cuz we're done.
    			  partTwoAnswerFound = true;
    		  }
    		  
    		  // Add it to the list
    		  pastFrequencies.add(currentFrequency);
    	  }
      }
    	  
       
      
    
	}

}

