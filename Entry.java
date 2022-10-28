public class Entry
{
    public String key;
    public String value;

    Entry()
    {
        key = null; // what is used to sort
        value = null; // what is stored at the key
    }

    Entry(Entry data)
    {
        key = data.key;
        value = data.value;
    }

}
