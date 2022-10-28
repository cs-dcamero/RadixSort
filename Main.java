
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

        
            
        // pass the path to the file as a parameter
        File file = new File("pokemon.txt");
        Scanner sc = new Scanner(file);
        Radixpasses = sc.nextInt();
        //System.out.println(passes);            
        sc.useDelimiter(",|\\n");
        sc.nextLine();
        while (!sc.hasNext("END"))
        {
            Entry item = new Entry();
            
            item.key = sc.next();
            item.value = sc.next();             
            
            //System.out.print(item.key);
            //System.out.print(" ");
            //System.out.println(item.value);
            LLmain.AddTail(item);
            //count++;            
        }        
        sc.close();
        

        //System.out.println(LL1.PeekHead());
        //System.out.println(LL1.PeekTail());
        //LLmain.Print();

        // Buckets are also linkedlists
        // send main array to buckets back to array
        int digitcounter = Radixpasses - 1;
        //System.out.println("digit counter " + digitcounter);
        while(Radixpasses > 0)
        {
            // sort items by the first digit
            //System.out.println(LLmain.PeekHead().key);
             // index of array for transferring to buckets
            while(!LLmain.IsEmpty())
            {   
                char index = 0;             
                index = LLmain.PeekHead().key.charAt(digitcounter);
                LLarray[Character.getNumericValue(index)].AddTail(LLmain.RemoveHead());
                //System.out.println(index);
            }

            //LLmain.AddHead(LLarray[1].PeekHead());
            
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
        //LLarray[1].Print();
        //LLarray[2].Print();
        //LLarray[0].AddTail(LLmain.RemoveHead());
        //LLmain.RemoveHead();
        //LLarray[0].Print();

    }
}