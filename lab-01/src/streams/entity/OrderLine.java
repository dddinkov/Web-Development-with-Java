package streams.entity;

public class OrderLine {
    private Item item;
    int quantity;
    boolean specialOffer;

    public OrderLine(Item item, boolean specialOffer, int quantity)
    {
        this.item = item;
        this.specialOffer = specialOffer;
        this.quantity=quantity;
    }

    public Item getItem(){
        return this.item;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public boolean isSpecialOffer(){
        return this.specialOffer;
    }

    public void setSpecialOffer(boolean specialOffer){
        this.specialOffer = specialOffer;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}
