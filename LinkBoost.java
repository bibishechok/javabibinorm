public class LinkBoost {
    public String name;
    public int id;
    public Integer money;
    int bought;
    String sold;
    public LinkBoost next;

    public LinkBoost(int id, String name, Integer money, int bought, String sold)
    {
        this.id=id;
        this.name=name;
        this.money=money;
        this.bought=bought;
        this.sold=sold;
    }
}
