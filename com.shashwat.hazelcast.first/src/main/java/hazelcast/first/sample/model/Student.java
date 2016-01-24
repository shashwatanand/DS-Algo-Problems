package hazelcast.first.sample.model;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String studentId;

	public Student(String firstName, String lastName, String studentId) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", studentId=" + studentId + "]";
	}
}
