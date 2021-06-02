/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Order_H;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author 小黄的天下
 */
public class setWindow {
    
    public static void setFrameCenter(JFrame frame){
        int windowWidth = frame.getWidth(); // 获取窗体的宽
	int windowHeight = frame.getHeight();// 获取窗体的高
	Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
	Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
	int screenWidth = screenSize.width; // 获取屏幕的宽
	int screenHeight = screenSize.height; // 获取屏幕的高
	frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗体出现的坐标
	
    }
    
    public static void setTable(JTable table){//定义table
        table.getTableHeader().setFont(new Font(null,Font.BOLD,14));// 设置表头名称字体样式
        table.getTableHeader().setResizingAllowed(false);// 设置不允许手动改变列宽
        table.getTableHeader().setResizingAllowed(false);//设置不允许拖动重新排序各列
        table.getTableHeader().setBackground(Color.CYAN);
        table.setShowVerticalLines(false);//不显示竖直方向的网格线
        
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();//显示和编辑二维单元表
        r.setHorizontalAlignment(JLabel.CENTER); //中心对齐
        table.setDefaultRenderer(Object.class, r);//更改渲染器，改成r定义的
        
        table.setRowHeight(30);		//设置行高
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setPreferredScrollableViewportSize(new Dimension(400, 490));//设置此表视口的首选大小

    }
    
    public static void setFrameNear(JFrame frame){
        int windowWidth = frame.getWidth(); // 获取窗体的宽
	int windowHeight = frame.getHeight();// 获取窗体的高
	Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
	Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
	int screenWidth = screenSize.width; // 获取屏幕的宽
	int screenHeight = screenSize.height; // 获取屏幕的高
	frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// 设置窗体出现的坐标
    }
    
}
