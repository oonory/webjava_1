package jp.co.systena.tigerscave.ShoppingCartApp.application.model;

import org.springframework.stereotype.Service;

@Service
public class Listservice {
  public String[] getItemList() {
    String[] items  = {"リンゴ", "オレンジ"};
    return items;
  }
}