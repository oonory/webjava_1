package jp.co.systena.tigerscave.ShoppingCartApp.application.model;

import javax.validation.constraints.Size;

public class ListForm {

  private String name;

  public String getItemName() {
    return this.name;
  }
  // setter
  public void setItemName(String item) {
    this.name = item;
  }

  @Size(max=7)
  private int price;

  public int getPrice() {
    return this.price;
  }
  // setter
  public void setPrice(int price) {
    this.price = price;
  }
}
