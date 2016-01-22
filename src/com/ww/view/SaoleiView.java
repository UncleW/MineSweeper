package com.ww.view;

import java.awt.*;
import javax.swing.*;

import com.ww.controller.RightHandler;
import com.ww.controller.MainHandler;
import com.ww.controller.ListenerStart;
import com.ww.modle.ComputeModel;
import com.ww.util.FinalFile;

public class SaoleiView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[][] mineField;
	private JButton gameStart;
	private JPanel statePanel,minePanel;
	private JTextField jtTime,jtMineNum;
	private RightHandler rh;
	private MainHandler lm;
	private int mineNum,width,height;
	private boolean timerFlag,winFlag;
	private int[][] isMine;//保存地雷位置信息，90代表地雷
	private int[][] listenerMarkm;//右键监听标志
	
	
	public SaoleiView(){
		super("扫雷");

		mineNum=FinalFile.level_1_mines;
		width=FinalFile.level_1_square;
		height=FinalFile.level_1_square;
		int size[]=ComputeModel.getWindowSize(width, height);
		this.setBounds(200,200,size[0],size[1]-8);
		this.setLayout(null);
		this.setResizable(false);
		
		//随机生成地雷位置，以数组形式保存
		this.isMine=ComputeModel.getRandom(width, height, mineNum);
		
		//输赢及计时的flag
		timerFlag=false;
		winFlag=false;
		
		
		
		statePanel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,2));
		statePanel.setBounds(5, 5, size[0]-18, FinalFile.mine_width*2);
		this.add(statePanel);
		statePanel.setBorder(FinalFile.bor_1);
		
		jtMineNum=new JTextField("0"+mineNum);
		statePanel.add(jtMineNum);
		
		gameStart=new JButton();
		gameStart.setText("Go");
		statePanel.add(gameStart);
		gameStart.addActionListener(new ListenerStart(this));
		
		jtTime=new JTextField("000");
		statePanel.add(jtTime);
		
		minePanel=new JPanel(new GridLayout(this.width,this.height));
		minePanel.setBounds(5,10+statePanel.getHeight(),
				FinalFile.mine_width*this.width,
				FinalFile.mine_width*this.height);
		minePanel.setBorder(FinalFile.bor_1);
		this.add(minePanel);
		
		this.listenerMarkm=ComputeModel.getListenerm(FinalFile.mine_width,FinalFile.mine_width);
		rh=new RightHandler(this);
		lm=new MainHandler(this);
		mineField=new JButton[this.width][this.height];
		for (int i=0;i<mineField.length;i++){
			for (int j=0;j<mineField[i].length;j++){
				mineField[i][j]=new JButton();
				mineField[i][j].setBorder(FinalFile.bor_0);
				minePanel.add(mineField[i][j]);
				mineField[i][j].setBackground(Color.LIGHT_GRAY);
				mineField[i][j].addActionListener(lm);
				mineField[i][j].addMouseListener(new MainHandler(this,i,j));
				mineField[i][j].setActionCommand(String.valueOf(i)+","+String.valueOf(j));
				mineField[i][j].addMouseListener(new RightHandler(this,i,j));
				listenerMarkm[i][j]=1;
			}
		}
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//界面初始化，点击开始或者游戏失败后调用
	public void initializingPanel(){
		this.setIsMine(ComputeModel.getRandom(this.getWidthNum(),this.getHeightNum(), this.getMineNum()));
		//ComputeModel.testPrint(this.getIsMine());
		this.getJtMineNum().setText(ComputeModel.forDisp(this.getMineNum()));
		this.getJtTime().setText(ComputeModel.forDisp(0));
		this.setTimerFlag(false);
		this.setWinFlag(false);
		for (int i=0;i<this.getMineField().length;i++){
			for (int j=0;j<this.getMineField().length;j++){
				this.getListenerMarkm()[i][j]=1;
				this.getMineField()[i][j].setBorder(FinalFile.bor_0);
				this.getMineField()[i][j].setText(null);
				this.getMineField()[i][j].setIcon(null);
			}
		}
	}
	
	//显示所有雷的位置，游戏失败时调用
	public void showMine(){
		for(int i=0;i<mineField.length;i++){
			for (int j=0;j<mineField[i].length;j++){
				if (isMine[i][j]==90){
					mineField[i][j].setIcon(FinalFile.Mine_Icon[1]);
					mineField[i][j].setBorder(FinalFile.bor_2);
				}
			}
		}
	}

	public JPanel getMinePanel() {
		return minePanel;
	}

	public void setMinePanel(JPanel minePanel) {
		this.minePanel = minePanel;
	}

	public int[][] getListenerMarkm() {
		return listenerMarkm;
	}

	public void setListenerMarkm(int[][] listenerMarkm) {
		this.listenerMarkm = listenerMarkm;
	}

	public RightHandler getRh() {
		return rh;
	}

	public MainHandler getLm(){
		return lm;
	}

	public boolean isTimerFlag() {
		return timerFlag;
	}

	public boolean isWinFlag() {
		return winFlag;
	}

	public void setWinFlag(boolean winFlag) {
		this.winFlag = winFlag;
	}

	public void setTimerFlag(boolean timerFlag) {
		this.timerFlag = timerFlag;
	}

	public int[][] getIsMine() {
		return isMine;
	}

	public void setIsMine(int[][] isMine) {
		this.isMine = isMine;
	}

	public int getMineNum() {
		return mineNum;
	}

	public int getWidthNum() {
		return width;
	}

	public int getHeightNum() {
		return height;
	}

	public JButton[][] getMineField() {
		return mineField;
	}
	
	public void setMineField(JButton[][] mineField){
		this.mineField=mineField;
	}

	public JTextField getJtMineNum() {
		return jtMineNum;
	}
	
	public JTextField getJtTime() {
		return jtTime;
	}

	public void setJtTime(JTextField jtTime) {
		this.jtTime = jtTime;
	}
	
	public void setJtMineNum(JTextField jtMineNum) {
		this.jtMineNum = jtMineNum;
	}
	//*/
}

