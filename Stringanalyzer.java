/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stringanalyzer;

/**
 *
 * @author CHaDOS
 */
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
 
public class Stringanalyzer {
 
  public static void main(String[] args) {
 
	Stringanalyzer obj = new Stringanalyzer();
	obj.run();
 
  }
 
  public void run() {
 
	String csvFile = "/Users/CHaDOS/Documents/Dropbox/Public/FACES WEBSITE/this.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy1 = "$";
        String cvsSplitBy2 = ",";
        String total = "";
        ArrayList<String> thistotal = new ArrayList();
        int counter = 0;
 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
                        
                    total = total += line + "$";
		        // use comma as separator
			//String[] thisline = line.split(cvsSplitBy1);
                        
                        
                        
                       // for(int i=0; i<thisline.length; i++){
                       //     String[] readline = thisline[i].split(cvsSplitBy2);
                       //     for(int j=0; j<readline.length; j++){
                       //         //System.out.println(readline[j]);
                       //         if(j==0){
                       //             
                       //         }
                       //         else{
                       //           String[] parsedline = readline[j].split(cvsSplitBy2);
                       //             for(int m=0; m<parsedline.length; m++){
                       //                 if(parsedline[m].contentEquals("\"'N/A'\"")){
                       //                     
                       //                 }
                       //                 else{
                       //                     
                       //                     if(parsedline[m].startsWith("\"'")){
                       //                         parsedline[m] = parsedline[m].substring(2, parsedline[m].length());
                       //                     }
                       //                     if(parsedline[m].endsWith("'\"")){
                       //                         parsedline[m] = parsedline[m].substring(0, parsedline[m].length()-2);
                       //                     }
                       //                     parsedline[m] = parsedline[m].trim();
                       //                     parsedline[m] = parsedline[m].toLowerCase();
                       //                     System.out.println(parsedline[m]);
                       //                 }
                       //             }
                       //         }
                       //     }
                       // }
                        
                        
                        
                        
                        
                        // counter ++;
                        //System.out.println(counter);
                        
                        
                        
                        
                        //String adjectiveconcat ="";
                        //if(thisline[1].equals("\"'N/A'\"")){
                    
                        //}
                        //else{
                        //for(int i=1; i<thisline.length; i++){
                        //    adjectiveconcat += thisline[i];
                        //}
                        
			//System.out.println("[Face number: " + thisline[0] 
                        //        + " , Adjectives=" + adjectiveconcat + "]");
                        //}
 
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

        
        //System.out.println(total);
        
        

        String[] thisline = total.split("\\$");
        //for(int k=0; k<thisline.length; k++){
       //     System.out.println(thisline[k]);
        //}
       // for(int m=1; m<=45; m++){
        //System.out.println("Adjectives for face: "+m);
        for(int q=0; q<45; q++){
        System.out.println(" ");
        System.out.println(" FACE # " + q);
        System.out.println(" ");
        ArrayList <String> myarraylist = adjectives(thisline, q);
        int[] counts = StringCounter(myarraylist);
        }
        //for(int q=0; q<myarraylist.size(); q++){
           // System.out.println(myarraylist.get(q) + " " + counts[q]);
       // }
       // }
 
	System.out.println("Done");
  }
  
  
  
  
public ArrayList<String> adjectives(String[] thisarray, int facenumber){
    ArrayList<String> totalstring = new ArrayList();
    
    for(String mystring: thisarray){
        int thisfacenumber;
        String[] readliner = mystring.split(",");
        
        String parsednumber =readliner[0];
        //System.out.println(readliner[0] + "is the number");
        //System.out.println(readliner[0]);
        //System.out.println(readliner[1]);
       if(readliner.length > 1){
        if(parsednumber.contains((""+facenumber))){
         //if(readliner[1] != null){
           // System.out.println(readliner[1]);
            //String[] parsedline = readliner[1].split(",");
            for(int i=1; i <readliner.length; i++){
                if(readliner[i].contentEquals("\"'N/A'\"")){
                //do nothing                            
                }
                else{                         //the following code tests for characters:    
                 if(readliner[i].startsWith("\"'")){
                     readliner[i] = readliner[i].substring(2, readliner[i].length());
                 }
                 if(readliner[i].endsWith("'\"")){
                    readliner[i] = readliner[i].substring(0, readliner[i].length()-2);
                 }
                    readliner[i] = readliner[i].trim();
                    readliner[i] = readliner[i].toLowerCase();
                    totalstring.add(readliner[i]);//adds it to array after formatting
                   // System.out.println(totalstring.get(totalstring.size()-1));
                }
            }
         //}
        }
       }
    }
    for(String printthisstring : totalstring){
        //System.out.println(printthisstring);
    }
    
    
return totalstring;
}



public int[] StringCounter(ArrayList<String> thisarray){
    //boolean inarray = false;
    ArrayList<String> orderedAdjectives = new ArrayList();
    for(int k =0; k<thisarray.size(); k++){
        if(orderedAdjectives.contains(thisarray.get(k))){ //if item is already in array
        
        } else {
       orderedAdjectives.add(thisarray.get(k)); //adds it to the array
       //System.out.println("added: " + thisarray.get(k));
        }
    }
    
    
    //The following code sorts the array into alphabetical order: //
    
    Collections.sort(orderedAdjectives.subList(1, orderedAdjectives.size()));
    //for(String sortedString : orderedAdjectives){
      //  System.out.println(sortedString);
    //}
    
    
    int[] myintarray = new int[thisarray.size()]; 
    
    for(String testString : orderedAdjectives){ //loop through the array
        for(String analyzedString : thisarray){ //loops again to check against first string
            if(testString.equals(analyzedString)){ //if we have a duplicate of that adjective
                myintarray[orderedAdjectives.indexOf(analyzedString)] ++; //increase it's counter
            }
        }
    }
    

     
    //prepare to dance baby!
    
    String[] stringarray1 = new String[myintarray.length]; //new string to store adjectives in
    int[] newintarray = new int[myintarray.length];  //new array to store their score in
    
    int[] intarray1 = myintarray.clone(); //clones myintarray so I have a backup...
    for(int y=0; y<intarray1.length; y++){ //loops through the length
        int highestindex = findLargestIndex(intarray1); //gets the index with highest number
        //System.out.println(highestindex + "is highest index");
        newintarray[y] = myintarray[highestindex]; //adds index with highest number to top of array
        stringarray1[y] = orderedAdjectives.get(highestindex); //adds string with highest number to top of this array
        intarray1[highestindex] = -100; //makes the cloned array's value -100 so that it can get the next highest number
    }
    
    
    
     for(int j=0; j<orderedAdjectives.size(); j++){
         if(newintarray[j] < 5){
             
         }else{
        System.out.println(stringarray1[j] + "; " + newintarray[j]); 
         }
     }
    
    
    /*
    for(int p=0; p<thisarray.size(); p++){
        for(String analyzethisstring: thisarray){
            if(thisarray.get(p).equals(analyzethisstring)){
                myintarray[p] ++;
            }
        }
    }
    */
    
    return myintarray;
}


public int findLargestIndex(int[] numbers){   //returns the index of the highest number in array
    int newindex = 0;
    int largest = numbers[0];  
    for(int i = 1; i < numbers.length; i++){  
        if(numbers[i] > largest){  
            largest = numbers[i];
            newindex = i;
        }  
    }  
    return newindex;
}



}