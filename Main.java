/*=======================================================================

 Douglas Camero
 CSc 130
 Professor Cook
 Assignment 2

 Implement Radix sort using LinkedList and Node classes
 from last assignments

========================================================================= */
import java.io.File;
import java.util.Scanner;

//import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args) throws Exception
    {  
        int Radixpasses = 0; // number of passes for Radix sort
        

        LinkedList[] LLarray; // Array used for the 'buckets'
        LLarray = new LinkedList[10];

        //
        // Initialize each index of array with a new LinkedList that;
        //
        for(int i = 0; i < LLarray.length; i++)
        {
            LLarray[i] = new LinkedList();
        }

        LinkedList LLmain = new LinkedList(); // this is the Main array used to store items
        
        File file = new File("zipcodes.txt");
        Scanner sc = new Scanner(file);

        // read the number of passes needed for Radix Sort from file
        Radixpasses = sc.nextInt();
           
        sc.useDelimiter(",|\\n"); // used to read a line up to ',' and '\n'
        sc.nextLine();

        //
        // Read the input file until the next line is 'END'
        // Created a new Entry and add to the tail of the LinkedList
        //
        while (!sc.hasNext("END"))
        {
            Entry item = new Entry();
            
            item.key = sc.next();
            item.value = sc.next();             
            
            LLmain.AddTail(item);           
        }        
        sc.close();
        
        int digitcounter = Radixpasses - 1;

        while(Radixpasses > 0)
        {

            while(!LLmain.IsEmpty())
            {   
                char index = LLmain.PeekHead().key.charAt(digitcounter); //get the number from 1s, 10s, 100s, ...etc
                LLarray[Character.getNumericValue(index)].AddTail(LLmain.RemoveHead()); // put into the proper bucket from 0-9
            }


            //
            // Empty the Array buckets back into the main LinkedList
            //
            for(int i = 0; i < LLarray.length; i++)
            {
                while(!LLarray[i].IsEmpty())
                {
                    LLmain.AddTail(LLarray[i].RemoveHead());
                }
            } 

            digitcounter--; // update digitcounter to get the next digit
            Radixpasses--; // update number of radixpasses left
            
        }
        //
        // Use the while loop below to print a 
        // LinkedList that is very large
        // as recursion causes a stack overflow error
        //
        while(!LLmain.IsEmpty())
        {
            System.out.println(LLmain.PeekHead().key + " " + LLmain.PeekHead().value);
            LLmain.RemoveHead();
        }

        System.out.println(LLmain.About());
        //
        // Print the now sorted LinkedList
        //
        //LLmain.Print();
    }
}