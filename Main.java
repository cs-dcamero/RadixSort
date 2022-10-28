
import java.io.File;
import java.util.Scanner;

//import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args) throws Exception
    {  
        int Radixpasses = 0; // number of passes for Radix sort
        

        LinkedList[] LLarray;
        LLarray = new LinkedList[10];

        for(int i = 0; i < LLarray.length; i++)
        {
            LLarray[i] = new LinkedList();
        }

        LinkedList LLmain = new LinkedList();
        
        File file = new File("years.txt");
        Scanner sc = new Scanner(file);

        // read the number of passes needed for Radix Sort from file
        Radixpasses = sc.nextInt();
           
        sc.useDelimiter(",|\\n");
        sc.nextLine();

        while (!sc.hasNext("END"))
        {
            Entry item = new Entry();
            
            item.key = sc.next();
            item.value = sc.next();             
            
            LLmain.AddTail(item);           
        }        
        sc.close();
        
        int digitcounter = Radixpasses - 1;
        //System.out.println("digit counter " + digitcounter);
        while(Radixpasses > 0)
        {

            while(!LLmain.IsEmpty())
            {   
                char index = LLmain.PeekHead().key.charAt(digitcounter);
                LLarray[Character.getNumericValue(index)].AddTail(LLmain.RemoveHead());
                //System.out.println(index);
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
            //LLmain.Print();
            //index--;
            digitcounter--;
            Radixpasses--;          
            
        }
        LLmain.Print();
    }
}