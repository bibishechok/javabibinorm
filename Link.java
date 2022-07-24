public class Link {
    public String name;
    public int id;
    public Integer money;
    int bought;
    public Link next;

    public Link(int id, String name, Integer money, int bought)
    {
        this.id=id;
        this.name=name;
        this.money=money;
        this.bought=bought;
    }
}
