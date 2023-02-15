package 과제.과제7.controller;

import java.util.ArrayList;

import 과제.과제7.model.Bank;
import 과제.과제7.model.Kookmin;
import 과제.과제7.model.Sinhan;
import 과제.과제7.model.Uri;

public class Bcontroller {
	
	// 싱글톤
	private static Bcontroller bc = new Bcontroller();
	private Bcontroller() {	}
	public static Bcontroller getInstance () {
		return bc;
	}
	
	private ArrayList<Bank> accountDB = new ArrayList<>();
	
	// 1. 계좌생성 함수
	public boolean newAccount ( int bNum , String password , String holder ) {
		if ( bNum == 1 ) {  Sinhan sinhan = new Sinhan(password, holder); accountDB.add(sinhan);	}
		else if ( bNum == 2 ) { Kookmin kookmin = new Kookmin(password, holder); accountDB.add(kookmin); 	}
		else if ( bNum == 3 ) { Uri uri = new Uri(password, holder); accountDB.add(uri);	}
		return true;
	}
	
}
