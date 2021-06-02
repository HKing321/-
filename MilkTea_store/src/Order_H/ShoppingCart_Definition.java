/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Order_H;

import java.util.ArrayList;

/**
 *
 * @author 小黄的天下
 */
public class ShoppingCart_Definition {
    
    private static double total = 0;//定义总价
    ArrayList<Product> product = new ArrayList<Product>(); //商品动态数组
    
    public ArrayList<Product> getProduct() {
		return product;
    }

    public void setProduct(ArrayList<Product> product) {
		this.product = product;
    }
    
    public static double getTotal(){
        return total;
    }
    
    public static void setTotal(double total){
        ShoppingCart_Definition.total = total;
    }
    
    public int addProduct(Product pro){//添加
        int i = 0;
        for(Product e:product){
            if(e.getId().equals(pro.getId())){
                int n = e.getNum() + pro.getNum();
                e.setNum(n);
                return i;
            }
            i++;
        }
        product.add(pro);
        total = pro.getPrice() *pro.getNum()+ total;
        return -1;
    }
        
}
