package hazelcast.first.sample;

import java.util.concurrent.TimeUnit;

public class MainClass {
	public static void main(String[] args) {
		StudentChooser chooser = new StudentChooser();
		App app = new App();
		while(true) {
			String studentId = chooser.getNextStudentId();
			if (app.isStudentLogged(studentId)) {
				app.logout(studentId);
			} else {
				app.logon(studentId);
			}
			
			app.display();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
