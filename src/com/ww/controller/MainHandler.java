package com.ww.controller;
/*
 * 实现鼠标左键单击、左右键点击监听
 */

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ww.modle.ComputeModel;
import com.ww.util.FinalFile;
import com.ww.view.SaoleiView;

public class MainHandler implements ActionListener,java.awt.event.MouseListener{
	
	private SaoleiView slV;
	private int row,col;
	private int[] xy;
	public MainHandler(SaoleiView slV){
		this.slV=slV;
	}
	public MainHandler(SaoleiView slV,int row,int col){
		super();
		this.slV=slV;
		this.row=row;
		this.col=col;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		xy=ComputeModel.getActionBut(e.getActionCommand());
		slV.setTimerFlag(true);
		//如果没有被标上红旗，则翻开
		if(slV.getMineField()[xy[0]][xy[1]].getIcon()!=FinalFile.Right_Icon[1]){
			setType(xy[0],xy[1]);
		}		
	}
	//内部函数，判断点击的按钮是否是地雷
	public void setType(int row,int col){
		JButton but=slV.getMineField()[row][col];
		but.setBorder(FinalFile.bor_2);
		but.setIcon(null);
		slV.getListenerMarkm()[row][col]=0;
		//如果是地雷
		if (slV.getIsMine()[row][col]==90){
			but.setIcon(FinalFile.Mine_Icon[1]);
			slV.setWinFlag(true);
			slV.showMine();
			JOptionPane.showMessageDialog(slV.getContentPane(),"输了", "踩到雷了！", JOptionPane.INFORMATION_MESSAGE);
			slV.initializingPanel();
		}
		//如果是空。。对周边8个格子进行迭代判断
		else if (slV.getIsMine()[row][col]==0){
			int a[][]=ComputeModel.genArr(row, col);
			for (int i=0;i<a.length;i++){
				if(ComputeModel.judgeBut(a[i][0], a[i][1], slV.getIsMine())){
					if (slV.getMineField()[a[i][0]][a[i][1]].getBorder()!=FinalFile.bor_2){
						setType(a[i][0],a[i][1]);
					}
				}
			}			
		}
		//将周边地雷数量显示在格子中
		else {
			String s=Integer.toString(slV.getIsMine()[row][col]);
			but.setText(s);}
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	//鼠标左右键同时按下，判断周边地雷格
	public void mousePressed(MouseEvent e){
		
		if (e.getModifiersEx()==(MouseEvent.BUTTON1_DOWN_MASK|MouseEvent.BUTTON3_DOWN_MASK)){
			int a[][]=ComputeModel.genArr(row, col);
			int b=0;
			for (int i=0;i<a.length;i++){
				if(ComputeModel.judgeBut(a[i][0], a[i][1], slV.getIsMine())){
					if (slV.getMineField()[a[i][0]][a[i][1]].getIcon()==FinalFile.Right_Icon[1]){
						b++;
					}
				}
			}
			if (String.valueOf(b).equals(slV.getMineField()[row][col].getText())){
				for (int i=0;i<a.length;i++){
					if(ComputeModel.judgeBut(a[i][0], a[i][1], slV.getIsMine())){
						if (slV.getMineField()[a[i][0]][a[i][1]].getIcon()!=FinalFile.Right_Icon[1]){
								if (slV.getIsMine()[a[i][0]][a[i][1]]==90){
									setType(a[i][0],a[i][1]);
									break;
								}
								else setType(a[i][0],a[i][1]);
							
							//String s=Integer.toString(slV.getIsMine()[row][col]);
							//slV.getMineField()[a[i][0]][a[i][1]].setText(s);
						}
					}
				}
			}
			
			
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}