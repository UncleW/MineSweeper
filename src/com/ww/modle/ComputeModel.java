package com.ww.modle;

import java.text.DecimalFormat;
import java.util.Random;

import com.ww.util.FinalFile;

public class ComputeModel{
	
	//计算窗口大小
	public static int[] getWindowSize(int wWidth,int wHeight){
		int w=FinalFile.mine_width*wWidth+10+8;
		int h=FinalFile.mine_width*(wHeight+2)+10+8+5+30;
		
		return new int[]{w,h};
		
	}
	
	//随机生成地雷的位置以数组形式保存，90代表地雷，其他数字代表周边8个位置地雷的总数
	public static int[][] getRandom(int wWidth,int wHeight,int mineNum){
		int get[][]=new int[wWidth][wHeight];
		Random rand=new Random();
		int aa=0,bb=0;
		do{
			aa=Math.abs(rand.nextInt())%wWidth;
			bb=Math.abs(rand.nextInt())%wHeight;
			if (get[aa][bb]==0){
				get[aa][bb]=1;
				mineNum--;
			}
			else continue;
		}while (mineNum!=0);
		int a[][]=new int[get.length+2][get[0].length+2];
		for (int i=1;i<=get.length;i++){
			for (int j=1;j<=get[0].length;j++){
				a[i][j]=get[i-1][j-1]*90;
			}
		}
		for (int i=1;i<get.length+1;i++){
			for (int j=1;j<get[0].length+1;j++){
				if (a[i][j]==0){
					a[i][j]=(a[i-1][j-1]+a[i-1][j]+a[i-1][j+1]+a[i][j-1]+a[i][j+1]+a[i+1][j-1]+a[i+1][j]+a[i+1][j+1])/90;
				}
				else continue;
			}
		}
		for (int i=0;i<get.length;i++){
			for (int j=0;j<get.length;j++){
				get[i][j]=a[i+1][j+1];
			}
		}
		return get;
	}
	
	//判断按钮是否在数组范围内
	public static boolean judgeBut(int row ,int col, int get[][]){
		if (row<get.length&row>-1&col<get.length&col>-1){
			return true;
		}
		else return false;
	}
	
	//得到某个按钮四周8个按钮的坐标
	public static int[][] genArr(int row,int col){
		int a[][]=new int[8][2];
		a[0][0]=row+1;a[0][1]=col+1;a[1][0]=row+1;a[1][1]=col;
		a[2][0]=row+1;a[2][1]=col-1;a[3][0]=row;a[3][1]=col+1;
		a[4][0]=row;a[4][1]=col-1;a[5][0]=row-1;a[5][1]=col;
		a[6][0]=row-1;a[6][1]=col+1;a[7][0]=row-1;a[7][1]=col-1;
		return a;
	}
	
	//用于时间、剩余地雷数的规范化输出
	public static String forDisp(int num){
		DecimalFormat df=new DecimalFormat("000");
		return df.format(num);
	}
	
	
	//将答案显示在控制台上
	public static void testPrint(int get[][]){
		for (int i=0;i<get.length;i++){
			for (int j=0;j<get[0].length;j++){
				System.out.print(get[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	//ͨ与setActionCommand配套使用，用于确定按钮的横纵坐标
	public static int[] getActionBut(String s){
		String[] s1=s.split(",");
		int a=Integer.parseInt(s1[0]);
		int b=Integer.parseInt(s1[1]);
		int[] c=new int[2];
		c[0]=a;
		c[1]=b;
		return c;
	}
	
	
	//生成右键监听对象的标识
	public static int[][] getListenerm(int a,int b){
		int listenerMark[][]=new int[a][b];
		for (int i=0;i<a;i++){
			for (int j=0;j<b;j++){
				listenerMark[i][j]=0;
			}
		}
		return listenerMark;
	}
	//*/
	
}