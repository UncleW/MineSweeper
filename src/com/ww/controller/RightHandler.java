package com.ww.controller;

import java.awt.event.*; 
import javax.swing.*;

import com.ww.modle.ComputeModel;
import com.ww.util.FinalFile;
import com.ww.view.SaoleiView;



public class RightHandler extends MouseAdapter {
	
	SaoleiView view;
	private int row;
	private int col;
	public RightHandler(SaoleiView view,int row,int col){
		this.view=view;
		this.row=row;
		this.col=col;
	}
	
	public RightHandler(SaoleiView view){
		super();
		this.view=view;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(view.getListenerMarkm()[row][col]==1){
			if (e.isPopupTrigger()){
				JButton but=(JButton)e.getSource();
				if (but.isEnabled()){
					if (but.getIcon()==null){
						but.setIcon(FinalFile.Right_Icon[1]);
						this.view.getJtMineNum().setText(
								ComputeModel.forDisp(Integer.parseInt(this.view.getJtMineNum().getText())-1));
					}
					else if (but.getIcon()==FinalFile.Right_Icon[1]){
						but.setIcon(FinalFile.Right_Icon[2]);
						this.view.getJtMineNum().setText(
								ComputeModel.forDisp(Integer.parseInt(this.view.getJtMineNum().getText())+1));
					}
					else but.setIcon(null);
				}
			}
		}
	}
	//
	
	
}
