package com.encore.self.test;

import com.encore.self.Programmer;

public class ProgrammerTest {
	public static void main(String[] args) {
		
		Programmer pm1 = new Programmer();
		Programmer pm2 = new Programmer();
		
		pm1.setProgrammerInfo("�̸���", 177, 76.3, "M");
		pm2.setProgrammerInfo("������", 170, 60.2, "F");
		
		pm1.getProgrammerInfo();
		pm2.getProgrammerInfo();
		
		
	}

}
