package hazelcast.first.sample;

import hazelcast.first.sample.model.Student;
import hazelcast.first.sample.model.Students;

import java.util.Random;

public class StudentChooser {
	private static Random rand = new Random(System.currentTimeMillis());
	
	public String getNextStudentId() {
		Students students = new Students();
		int size = students.size();
		Student student = students.get(rand.nextInt(size));
		return student.getStudentId();
	}
}
