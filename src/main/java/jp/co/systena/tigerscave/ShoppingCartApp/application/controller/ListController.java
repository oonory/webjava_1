package jp.co.systena.tigerscave.ShoppingCartApp.application.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.ShoppingCartApp.application.model.Item;
import jp.co.systena.tigerscave.ShoppingCartApp.application.model.ListForm;

@Controller  // Viewあり。Viewを返却するアノテーション
public class ListController {

  @Autowired
  HttpSession session;                  // セッション管理

  @RequestMapping(value="/shoppingcart", method = RequestMethod.GET)          // URLとのマッピング
  public ModelAndView show(ModelAndView mav) {
    // Viewに渡すデータを設定
    // セッション情報から保存したデータを取得してメッセージを生成
    ListForm listForm = (ListForm) session.getAttribute("form");
    session.removeAttribute("form");
    if (listForm != null) {
      mav.addObject("message", listForm.getItemName()+"をカートに追加しました");
    }
    mav.addObject("listForm", new ListForm());  // 新規クラスを設定

    List<Item> items = (List<Item>) session.getAttribute("ListView");
    if( items == null) {
        items = new ArrayList<Item>();
        session.setAttribute("itemList", items);
    }
    mav.addObject("items", items);

    BindingResult bindingResult = (BindingResult) session.getAttribute("result");
    if (bindingResult != null) {
      mav.addObject("bindingResult", bindingResult);
    }
    // Viewのテンプレート名を設定
    mav.setViewName("ListView");
    return mav;
  }

  @RequestMapping(value="/shoppingcart", method = RequestMethod.POST)  // URLとのマッピング
  public ModelAndView order(ModelAndView mav, @Valid ListForm listForm, BindingResult bindingResult, HttpServletRequest request) {

    List<Item> items = (List<Item>)session.getAttribute("ListView");
    if( items == null) {
      items = new ArrayList<Item>();
        session.setAttribute("itemList", items);
    }

    if (bindingResult.getAllErrors().size() > 0) {
      // エラーがある場合はそのまま戻す
      mav.addObject("listForm",listForm);  // 新規クラスを設定

      mav.addObject("items", items);

      // Viewのテンプレート名を設定
      mav.setViewName("ViewList");
      return mav;

    }
    Item item = new Item();
    item.setItemName(listForm.getItemName());
    items.add(item);

    Item price =new Item();
    item.setPrice(listForm.getPrice());
    items.add(price);
    // データをセッションへ保存
    session.setAttribute("form", listForm);
    return new ModelAndView("redirect:/listView");        // リダイレクト
  }
}
