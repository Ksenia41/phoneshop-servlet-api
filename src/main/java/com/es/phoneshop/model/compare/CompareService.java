package com.es.phoneshop.model.compare;

import com.es.phoneshop.model.compare.Compare;
import com.es.phoneshop.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class CompareService {
    private static final String COMPARE_LIST_ATTRIBUTE_NAME = "compareList";
    private static CompareService instance = new CompareService();

    private CompareService() {
    }

    public static CompareService getInstance() {
        return instance;
    }

    public Compare getCompareList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Compare Compare = (Compare) session.getAttribute(COMPARE_LIST_ATTRIBUTE_NAME);
        if (Compare == null) {
            Compare = new Compare();
            session.setAttribute(COMPARE_LIST_ATTRIBUTE_NAME, Compare);
        }
        return Compare;
    }

    /*public void delete(Compare Compare, Product product){
        List<Product> list = Compare.getCompareProducts();
        for(int i = 0; i < list.size(); i++){
            if(product.equals(list.get(i).getProduct())){
                list.remove(i);
                break;
            }
        }
    }
*/
  /*  public void clearCompare(Compare Compare){
        List<Product> list = Compare.getCompareItems();
        list.clear();
    }*/

/*
    public void add(Compare Compare, Product product, int quantity){
        addOrUpdate(Compare, product, quantity, true);
    }*/
/*

    public void update(Compare Compare, Product product, int quantity){
        addOrUpdate(Compare, product, quantity, false);
    }
*/


    public void add(Compare Compare, Product product){
        List<Product> CompareItems = Compare.getCompareProducts();
        if(CompareItems.size() == 3){
            CompareItems.remove(0);
        }
        CompareItems.add(product);
    }
}
