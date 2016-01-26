package hazelcast.first.sample;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import hazelcast.first.sample.model.Student;
import hazelcast.first.sample.model.Students;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class App {
	private final IMap<Object, Student> loggedOnStudents;
	private final Students db;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm:ss-SS");
	private long modificationTime;
	
	
	public App() {
		this.db = new Students();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance();
		this.loggedOnStudents = instance.getMap("Students");
	}
	
	public void logon(String studenId) {
		Student student = this.db.get(studenId);
		this.loggedOnStudents.put(studenId, student);
		this.modificationTime = System.currentTimeMillis();
	}
	
	public void logout(String studentId) {
		this.loggedOnStudents.remove(studentId);
		this.modificationTime = System.currentTimeMillis();
	}
	
	public boolean isStudentLogged(String studentId) {
		return this.loggedOnStudents.containsKey(studentId);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Student> getAllStudentsList() {
		return new ArrayList(loggedOnStudents.values());
	}
	
	public Collection<Student> getAllStudent() {
		return this.loggedOnStudents.values();
	}
	
	public void display() {
		StringBuilder sb = new StringBuilder("Logged on Students : ");
		Collection<Student> students = this.loggedOnStudents.values();
		for (Student student : students) {
			sb.append(student).append("\n");
		}
		sb.append(dateFormat.format(new Date(this.modificationTime))).append("\n");
		System.out.println(sb.toString());
	}
}
