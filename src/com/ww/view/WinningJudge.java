package com.ww.view;
/*
 * 独立线程，以剩下地雷的数量来触发判断是否游戏胜利
 */
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ww.util.FinalFile;

public class WinningJudge extends Thread{
	SaoleiView slV;
	JButton[][] but;
	int[][] isMine;
	int flag;
	public WinningJudge(SaoleiView slV){
		this.slV=slV;
		but=slV.getMineField();
		isMine=slV.getIsMine();
		flag=0;
	}
	public void run(){
		//flag0表示失败
		while(flag==0){
			if (slV.getJtMineNum().getText().equals("000")){
				for(int i=0;i<but.length;i++){
					for (int j=0;j<but[i].length;j++){
						if(but[i][j].getIcon()==FinalFile.Right_Icon[1]){
							if(isMine[i][j]!=90){
								flag=1;
								break;
							}
							else {
								flag=0;
							}
						}
					}
				}
			}
			//JOptionPane.showMessageDialog(slV.getContentPane(),"弹出窗口", "游戏胜利“, JOptionPane.INFORMATION_MESSAGE);
			//slV.InitializingPanel();
		}
		JOptionPane.showMessageDialog(slV.getContentPane(),"弹出窗口", "游戏胜利", JOptionPane.INFORMATION_MESSAGE);
		slV.InitializingPanel();
	}
	
}
