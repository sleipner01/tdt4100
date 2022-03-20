package uke12.boss;

public class Boss extends Worker{

	Secretary secretary = new Secretary();
	
	@Override
	public String work() {
		return secretary.work();
	}
	
	public static void main(String[] args) {
		Boss boss = new Boss();
		System.out.println(boss.work());
	}

}
