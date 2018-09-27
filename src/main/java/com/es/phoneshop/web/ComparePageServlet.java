package com.es.phoneshop.web;

import com.es.phoneshop.model.*;
import com.es.phoneshop.model.compare.Compare;
import com.es.phoneshop.model.compare.CompareService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

public class ComparePageServlet extends HttpServlet{
    private CompareService compareService;
    private CartService cartService;
    private ProductDao productDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        compareService = compareService.getInstance();
        cartService = cartService.getInstance();
        productDao = ArrayListProductDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("compare", compareService.getCompareList(request));
        request.getRequestDispatcher("/WEB-INF/pages/compare.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer quantity;
        Long productId = Long.parseLong(request.getParameter("addToCart"));
        Product product = productDao.getProduct(productId);
        Locale locale = request.getLocale();
        try {
            quantity = DecimalFormat.getInstance(locale).parse(request.getParameter("quantity")).intValue();
            if(quantity < 0){
                throw new NumberFormatException();
            }
            if(quantity > product.getStock()){
                throw new IllegalArgumentException();
            }
            request.setAttribute("addQuantity", quantity);
        } catch (NumberFormatException ex) {
            catchExeption(product, "error", request, response);
            return;
        } catch (ParseException ex) {
            catchExeption(product, "NaN", request, response);
            return;
        } catch(IllegalArgumentException ex){
            catchExeption(product, "toMuch", request, response);
            return;
        }
        Cart cart = cartService.getCart(request);
        cartService.add(cart, product, quantity);
       // request.setAttribute("addQuantity", quantity);
        response.sendRedirect(request.getRequestURI() + "?addQuantity=" + quantity);

    }

    private void catchExeption(Product product, String type, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("error", Boolean.TRUE);
        request.setAttribute("errorText", type);
        request.setAttribute("product", product);
/*
        request.getRequestDispatcher("/WEB-INF/pages/compare.jsp").forward(request, response);
*/
doGet(request, response);
    }

}
