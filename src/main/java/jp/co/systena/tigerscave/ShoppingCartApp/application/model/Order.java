package jp.co.systena.tigerscave.ShoppingCartApp.application.model;

public class Order {

  // 商品
  private Item item;

  public Item orderItemName() {
    return this.item;
  }
  // setter
  public void setOrderItemName(Item item) {
    this.item = item;
  }

  // 個数
  private int num;

  public int getNum() {
    return this.num;
  }
  // setter
  public void setNum(int num) {
    this.num = num;
  }
}
