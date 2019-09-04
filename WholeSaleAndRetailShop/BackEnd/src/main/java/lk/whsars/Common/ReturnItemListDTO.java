package lk.whsars.Common;

public class ReturnItemListDTO {

    private String itemname;
    private String itembarcode; //item id
    private int quantity;

    public int getRetQuantity() {
        return retQuantity;
    }

    public void setRetQuantity(int retQuantity) {
        this.retQuantity = retQuantity;
    }

    private int retQuantity;

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItembarcode() {
        return itembarcode;
    }

    public void setItembarcode(String itembarcode) {
        this.itembarcode = itembarcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
