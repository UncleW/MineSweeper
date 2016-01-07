package com.ww.util;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public interface FinalFile{
	//设置窗口上地雷的数量、方格的数量
	int level_0_square=9;
	int level_0_mines=10;
	int level_1_square=15;
	int level_1_mines=35;
	int level_2_square=21;
	int level_2_mines=80;
	//地雷宽度像素
	int mine_width=20;
	//按钮边框Style
	Border bor_0=BorderFactory.createBevelBorder(0);
	Border bor_1=BorderFactory.createBevelBorder(1);
	Border bor_2=new LineBorder(Color.gray);
	//图标设置
	Icon Start_Icon=new ImageIcon("ima/startIcon.jpg");
	Icon Right_Icon[]={null,new ImageIcon("ima/flagIcon.jpg"),new ImageIcon("ima/questionIcon.jpg")};
	Icon Mine_Icon[]={new ImageIcon("ima/mineIcon0.jpg"),new ImageIcon("ima/mineIcon1.jpg"),new ImageIcon("")};
	
	
}