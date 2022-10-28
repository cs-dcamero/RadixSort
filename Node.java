public class Node
{
    public Entry value;
    public Node next;

    Node()
    {
        value = null;
        next = null;
    }

    Node(Entry data)
    {
        value = data;
        next = null;

    }

/* This method using recursion to check for a string
 * Using the Node that we currently have access to,
 * a check is done to see if that value is equal to
 * the data we are looking for. If it is equal, return true.
 * if the value is not an empty value and the Node next does not
 * equal null, we know it is safe to jump to the next node,
 * this is done using next.Contains(data), which takes us to the 
 * next node with the data we are looking for. This will repeat until
 * we either find the data we want or we do not find it. If we do not find
 * it after reaching the last Node, return false.
 */
    public boolean Contains(Entry data)
    {
        if(data == value)
        {
            return true;
        }

        if(value != null && next !=null)
        {
            return next.Contains(data);
        }

        return false;
    }

/* 
 * This method prints out the Node.value one by one until we reach
 * the last node. This is accomplished by checking that next is not null.
 * If next is not null, we need to print the node.current value, then recursively
 * jump to the next node using next.Print(). Once we reach a node that has a 
 * next value of null, we know we have reached the last node. When that happens we 
 * need to print the current node.value
 */
    public void Print()
    {                
        if(next != null)
        {
            System.out.println(value.key + " " + value.value);
            next.Print(); // this will take us to the next node to print
        }
        else
        {
            System.out.println(value.key +" " + value.value); // print when there is only 1 value in the list
        }
    }
}
