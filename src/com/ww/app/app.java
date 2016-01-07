package com.ww.app;

import com.ww.view.*;
class app{
	public static void main(String args[]){
		SaoleiView slV=new SaoleiView();
		new TimerThread(slV).start();
		//Thread my=new Thread(new winOrLose(slV));
		//my.start();
		new WinningJudge(slV).start();
	}
}