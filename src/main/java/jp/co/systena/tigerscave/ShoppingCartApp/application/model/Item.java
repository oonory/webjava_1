package jp.co.systena.tigerscave.ShoppingCartApp.application.model;

public class Item {

  // 商品名
  private String name;

  public String getItemName() {
    return this.name;
  }
  // setter
  public void setItemName(String item) {
    this.name = item;
  }

  // 値段
  private int price;

  public int getPrice() {
    return this.price;
  }
  // setter
  public void setPrice(int price) {
    this.price = price;
  }
}
