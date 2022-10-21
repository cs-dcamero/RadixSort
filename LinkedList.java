/*=======================================================================

 Douglas Camero
 CSc 130
 Professor Cook
 Assignment 1

 Implement Node and LinkedList Classes
 with some basic functions
 Node class will hand Print() and Contains() methods
 via recursion 

========================================================================= */



class LinkedList
{
    private Node head;
    private Node tail;

    public String About()
    {
        String about;
        about = "===================================================================\n";
        about += "Author: Douglas Camero\nThis is my best attempt at creating a Node and LinkedList class :)\n";
        about += "===================================================================\n";
        return about;
    }

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    /* 
    * add an element to the head of the LinkedList and
    * reassign the head to the newly created node
    */
    public void AddHead(String value)
    {      
        Node addNode = new Node(value); // create a new node

        if(head == null) // if true, we know that the LL is empty
        {
            head = addNode; // point head to the new node
            tail = addNode; // point tail to the new node

        }
        else
        {
            addNode.next = head; // point new node to the old head
            head = addNode; // move the head too the new node

        }
    }

    /*
     * add an element to the end of the LinkedList
     * and reassign the tail to the newly created node 
     */
    void AddTail(String value)
    {
        Node addNode = new Node(value);

        if(head == null && tail == null) // check to make sure the LL is empty
        {
            head = addNode; // point head to the new node
            tail = addNode; // point tail to the new node
        }

        else
        {
            tail.next = addNode; // point the current tail.next pointer to the newly created tail
            tail = addNode; // point tail to the newly created node
        }

    }

    String RemoveHead()
    {      
       if(head == null) // make sure the list is not alread empty
        {
            return "";
        }

        // List was not empty so lets Remove the head

        String result = head.value;

        head = head.next; // move the head to the next value in the list

        if(head == null) // check to see if list it now empty
        {
            tail = null; // if LL is empty reset tail to null
        }

        return result;        
    }

    String PeekHead()
    {
        if(IsEmpty()) // is empty to check if the list is empty
        {
            return "";
        }

        else
        {
            return head.value; // return the current head value
        }
    }

    /*
    * Implemented to help check that LinkedList
    * is filling properly
    */
    String PeekTail()
    {
        if(IsEmpty())
        {
            return "";
        }

        else
        {
            return tail.value;
        }
    }

    boolean IsEmpty()
    {
        return head == null;
    }

    public boolean Contains(String value)
    {
            if(IsEmpty()) // make sure list is not empty
            {
                return false;
            }

            return head.Contains(value); // not empty; move to Contains() in Node class            
    }

    public void Print()
    {
        if(head != null) // make sure the head is not null
        {
            head.Print(); // move to the Print() in node class
        }

        else
        {
            System.out.print(" "); //
        }
    }
}