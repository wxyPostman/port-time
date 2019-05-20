package duanxin;

import java.util.Random;

public class DuanxinExcuse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Math.random();
		Duanxin.sendOne("注册", "1234", "15355424838");
		Random ran=new Random();
		String sst="";
		for(int i=0;i<4;i++){
			int ss=ran.nextInt(10);
			sst += String.valueOf(ss);
		
		
		}
		System.out.printf(sst);
	}

}
