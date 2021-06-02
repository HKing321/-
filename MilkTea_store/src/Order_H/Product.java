/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Order_H;

/**
 *
 * @author 小黄的天下
 */
public class Product {//商品定义
    
    private String id;//编号
    private String name;//名字
    private double price;//价格
    private int num;//数量
    private String sizetype;//尺寸大小
    
    public int getNum() {
	return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
	return id;
    }
    
    public void setId(String id) {
	this.id = id;
    }
    
    public String getName() {
	return name;
    }
    
    public void setName(String name) {
	this.name = name;
    }
    
    public double getPrice() {
	return price;
    }
    
    public void setPrice(double price) {
	this.price = price;
    }
    
    public String getSizetype(){
        return sizetype;
    }
    
    public void setSizetype(String sizetype){
        this.sizetype = sizetype;
    }
    
    public Product(String id,String name,double price,int num,String sizetype) {
	this.id=id;
	this.name=name;
	this.price=price;
	this.num=num;
        this.sizetype=sizetype;
    }

}
