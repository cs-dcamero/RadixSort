//
// Implement file reading
//
//

import java.io.File;
import java.util.Scanner;

class Main
{
public static void main(String[] args) throws Exception
    {
        System.out.println("this is a test");
       
    // pass the path to the file as a parameter
    File file = new File("years.txt");
    Scanner sc = new Scanner(file);

    int passes = sc.nextInt();

    System.out.println(passes);
    
    Entry item = new Entry();

    sc.useDelimiter(",|\\n");

    sc.nextLine();

    int count = 0;
    LinkedList LL1 = new LinkedList();

    while (!sc.hasNext("END"))
    {
        
        item.key = sc.next();
        item.value = sc.next();

        System.out.print(item.key);
        System.out.print(" ");
        System.out.println(item.value);
        count++;
        
    }
      
    System.out.println(count);
    sc.close();
    }
}