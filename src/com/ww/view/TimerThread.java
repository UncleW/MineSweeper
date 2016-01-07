package com.ww.view;


import com.ww.modle.ComputeModel;
import com.ww.view.SaoleiView;
/*
 * 此类独立线程，用于面板上的计时功能
 */

public class TimerThread extends Thread{
	private SaoleiView slV;
	private int i;
	public TimerThread(SaoleiView slV){
		this.slV=slV;
	}
	public void run(){
		this.i=0;
		
		while(true){
			if (slV.isTimerFlag()){
				runtimer();
			}
		
		}
	}
	
	

	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	public synchronized void runtimer(){
		while(i<1000){
			if (slV.isTimerFlag()){
				slV.getJtTime().setText(ComputeModel.forDisp(Integer.parseInt(slV.getJtTime().getText())+1));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				i++;
				//System.out.println(i);
				//System.out.println(slV.isTimerFlag());
			}
			else {i=0;break;}
		}
	}
}




//*/