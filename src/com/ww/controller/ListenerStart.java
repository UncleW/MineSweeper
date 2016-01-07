package com.ww.controller;

import java.awt.event.*;
import com.ww.view.*;

public class ListenerStart implements ActionListener{
	private SaoleiView slV;
	public ListenerStart(SaoleiView slV){
		this.slV=slV;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//窗口初始化
		slV.InitializingPanel();
		
		
	}
	

}
