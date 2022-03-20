package uke12.boss;

public class Boss implements Worker {

	Worker secretary = new Secretary();
	
	@Override
	public String work() {
		return secretary.work();
	}
	
	public static void main(String[] args) {
		Boss boss = new Boss();
		System.out.println(boss.work());

		// Hvordan hadde dette sett ut uten bruk av interface?
		// Hvordan hadde det fungert å arve her?
	}

}
