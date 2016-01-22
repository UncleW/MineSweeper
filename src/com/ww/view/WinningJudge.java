package com.ww.view;
/*
 * 判断输赢
 * 1.当除了地雷格其他格子都被点击过了判定为赢
 * 2.当所有红旗下面都是雷而且红旗数等于总地雷数时判定为赢
 * 
 */
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.ww.util.FinalFile;

public class WinningJudge extends Thread{
	SaoleiView slV;
	JButton[][] but;
	//int[][] isMine;
	//int flag;
	public WinningJudge(SaoleiView slV){
		this.slV=slV;
		but=slV.getMineField();
		//isMine=slV.getIsMine();
		//flag=0;
	}
	public void run(){
		//
		while(true){
			int minenum=0;
			for (int i=0;i<but.length;i++){
				for (int j=0;j<but[i].length;j++){
					if (but[i][j].getBorder()==FinalFile.bor_0){
						minenum++;
					}
				}
			}
			int flagnu=0;
			for (int i=0;i<but.length;i++){
				for (int j=0;j<but[i].length;j++){
					if(but[i][j].getIcon()==FinalFile.Right_Icon[1]&&slV.getIsMine()[i][j]==90){
						flagnu++;
					}
				}
			}
			if ((minenum==slV.getMineNum()||flagnu==slV.getMineNum())&&!slV.isWinFlag()){
				//System.out.println(slV.getJtMineNum().getText());
				//System.out.println(flagnu);
				JOptionPane.showMessageDialog(slV.getContentPane(),"赢了", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
				slV.initializingPanel();
				//flag=1;
				//break;
			}
			//System.out.println(flagnu);
		}
		
	}
	
}
