package hazelcast.first.sample.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Students {
	private final Map<String, Student> map;
	
	private final Student[] students = {
			new Student("1", "firstname1", "lastName1"),
			new Student("2", "firstname2", "lastName2"),
			new Student("3", "firstname3", "lastName3"),
			new Student("4", "firstname4", "lastName4"),
			new Student("5", "firstname5", "lastName5"),
		};
	
	public Students() {
		this.map = new HashMap<String, Student>();
		for (Student student : students) {
			this.map.put(student.getStudentId(), student);
		}
	}
	
	public int size() {
		return this.map.size();
	}
	
	public Student get(String id) {
		return this.map.get(id);
	}
	
	public Student get(int index) {
		return this.students[index];
	}
	
	public Set<String> getAllStudentId() {
		return this.map.keySet();
	}
}
