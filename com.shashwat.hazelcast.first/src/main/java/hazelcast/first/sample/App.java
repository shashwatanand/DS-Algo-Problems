package hazelcast.first.sample;

import java.text.SimpleDateFormat;

import hazelcast.first.sample.model.Student;
import hazelcast.first.sample.model.Students;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class App {
	private final IMap<Object, Object> loggedOnStudents;
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
}
