/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Order_H;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 小黄的天下
 */
public class ShoppingCart {
    JTable shoppingCartTable;//定义购物车布局
    Vector<Vector<Object>> date = new Vector<Vector<Object>>();//数据
    Vector<String> ColumnNames = new Vector<String>();//列名
    JLabel snumber;//购物车数量
    JLabel stotalprice;//购物车总价
    JFrame emptyShoppingCar = new JFrame("购物车");
    JFrame ShoppingCar = new JFrame("购物车");
    ShoppingCart_Definition shopping = new ShoppingCart_Definition();
    static CardLayout card = new CardLayout();//定义个卡片布局
    static JPanel centerPanel=new JPanel(card);
    
    public ShoppingCart(){
       ShoppingCartFrame();     
    }
    
    public void ShoppingCartFrame(){
        ShoppingCar.setLayout(null); // 清除布局函数
	ShoppingCar.setResizable(false); // 设置窗体大小不可变
        ShoppingCar.setLayout(new BorderLayout()); // 新建BorderLayout布局(边界布局)
        
        //空的购物车
        JPanel panel_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));//流式布局
        ImageIcon icon = new ImageIcon("image/ia.jpg");//设置空购物车图片
        JLabel label = new JLabel(icon);//放入布局中
	panel_1.add(label);
        
        //非空购物车
        JPanel panel_2 = new JPanel(new FlowLayout(2));//2代表右对齐，空默认居中对齐
        DefaultTableModel model = new DefaultTableModel(){//数据表，用来控制JTable,设置数据表内的数值是否可修改
            public boolean isChange(int row,int column){
                if(column == 2) return true;//返回true代表可以编辑单元格
                else return false;
            }
        };
        
        //定义Column动态数组
        ColumnNames.add("奶茶名");
        ColumnNames.add("杯具");
        ColumnNames.add("价格RMB");
        ColumnNames.add("数量");
        ColumnNames.add("总和");
        
        //定义表格
        model.setDataVector(date, ColumnNames);
        shoppingCartTable = new JTable(model);//创建一个表格，指定所以行数据和表头
        setWindow.setTable(shoppingCartTable); // 设置表格
        
        //定义滚动条
        JScrollPane shoppingCarScrollPane = new JScrollPane(shoppingCartTable);//添加滚动条
        shoppingCarScrollPane.setBorder(null);//不显示滚动条
        
        //总算
        JPanel to = new JPanel(new GridLayout(2,0));//网格布局,表示两行，不限列
        JLabel jl00 = new JLabel(" ");
        stotalprice = new JLabel("共计:" + shoppingCartTable.getRowCount()+" RMB");
        stotalprice.setFont(new Font("微软雅黑", Font.PLAIN, 19)); // 设置字体、样式、大小
        
        //按钮定义
        JButton jb1 = new JButton("删除商品");
        jb1.setFont(new java.awt.Font("黑体", 1, 20));
        JButton jb2 = new JButton("去结算");
        jb2.setFont(new java.awt.Font("黑体", 1, 20));
        
        //填充Panel
        to.add(jb1);
        to.add(jb2);
        to.add(stotalprice);
        to.add(jl00);
        
        panel_2.add(shoppingCarScrollPane);
        panel_2.add(to);
        panel_2.setBorder(new EmptyBorder(10,10,10,10));//empty指空白边界
        
        centerPanel.add(panel_1,"emptyShoppingCart");
	centerPanel.add(panel_2,"ShoppingCart");
        
        setShoppingCartCenterPanel(1);
        /*
        //判断空或非空布局
        if(shoppingCartTable.getRowCount() == 0){
            setShoppingCartCenterPanel(0);
        }else{
            setShoppingCartCenterPanel(1);
        }*/
        
        Vector<Object> row=new Vector<Object>();
        
	row.add("啵啵奶茶");
        row.add("大");
	row.add(12.0);
        row.add(5);
        row.add(12*5);
        date.add(row);
        
        ShoppingCar.add(centerPanel,BorderLayout.CENTER);
        
        //标题
        JPanel toptitle = new JPanel(new GridLayout(2,0));
        JLabel jl_1 = new JLabel("购物车");
        jl_1.setFont(new Font("微软雅黑", Font.BOLD, 25));
        snumber = new JLabel("共" + shoppingCartTable.getRowCount() + "款奶茶");
        snumber.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        toptitle.add(jl_1);
        toptitle.add(snumber);
        toptitle.setBorder(new EmptyBorder(10,10,10,10));
        ShoppingCar.add(toptitle,BorderLayout.NORTH);
        
        ShoppingCar.setSize(450, 750);
        ShoppingCar.setVisible(true);
        setWindow.setFrameNear(ShoppingCar);
        
        //对删除奶茶按钮的定义
        jb1.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(shoppingCartTable.getRowCount() == 0){
                    setShoppingCartCenterPanel(0);
                    return;
                }
                DefaultTableModel dtm = (DefaultTableModel)shoppingCartTable.getModel();//获得表格的数据
                int row=shoppingCartTable.getSelectedRow();//被选中的行
                String s=(String)dtm.getValueAt(row, 0);//获得奶茶名字
                double n=Double.parseDouble(dtm.getValueAt(row, 4).toString());//获得删除奶茶的总价
                JOptionPane.showMessageDialog(null, "奶茶 "+ s + " 删除成功！", "温馨提示",1);//定义弹窗
                dtm.removeRow(row);//删除对应行网格表奶茶数据
                shopping.getProduct().remove(row);//删除对应
                snumber = new JLabel("共" + shoppingCartTable.getRowCount() + "款奶茶");//更新奶茶款数
                shopping.setTotal(shopping.getTotal()-n);//修改总价
                stotalprice = new JLabel("共计:" + shoppingCartTable.getRowCount()+" RMB");
                if( shoppingCartTable.getRowCount() == 0 ) {
        		setShoppingCartCenterPanel(0);
        	}
            }
        });
        
        jb2.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(date.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "我找不到", "没了",0);
                    return;
		}
                 JOptionPane.showMessageDialog(null, "恭喜您，付款成功！一共消费了"+shopping.getTotal()+"RMB", "消费成功",0);
                 shopping.setTotal(0.0);
                 date.clear();//删除所有元素
                 snumber = new JLabel("共0款奶茶");
                 stotalprice.setText("共@_@元");
                 shoppingCartTable.updateUI();//刷新界面
                 setShoppingCartCenterPanel(0);
            }
        });
        
    }
    
    public static void setShoppingCartCenterPanel(int x) {//选择布局
	if( x == 0 ) {
		card.show(centerPanel,"emptyShoppingCart");
	}else {
		card.show(centerPanel,"ShoppingCart");
	}
    }
    
    public JFrame getShoppingCar(){
        return ShoppingCar;
    }
    
    public void setShoppingCar(JFrame shoppingcar){
        ShoppingCar = shoppingcar;
    }
    
    public ShoppingCart_Definition getShoppingCart_Definition(){
        return shopping;
    }
    
    public void setShoppingCart_Definition(ShoppingCart_Definition sdefinition){
        this.shopping = sdefinition;
    }
    
    public JLabel getSnumber(){
        return snumber;
    }
    
    public void setSumber(JLabel jl){
        this.snumber = jl;
    }
    
    public JLabel getStotalprice(){
        return stotalprice;
    }
    
    public void setStotalprice(JLabel jl){
        this.stotalprice = jl;
    }
    
    public Vector<Vector<Object>> getDate(){
	return date;
    }
    
    public void setDate(Vector<Vector<Object>> date) {
	this.date = date;
    }
    
    public static void main(String[] args){
        new ShoppingCart();
    }
}
