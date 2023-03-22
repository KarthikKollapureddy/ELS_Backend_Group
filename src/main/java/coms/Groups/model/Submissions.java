package coms.Groups.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="submission_info")
public class Submissions {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String submissionId;
	
	public String name;
	public String type;
	
	@Lob
	public byte[] data;
	
	public int assignId;
	public int userId;
	public String getSubmissionId() {
		return submissionId;
	}
	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public int getAssignId() {
		return assignId;
	}
	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Submissions(String submissionId, String name, String type, byte[] data, int assignId, int userId) {
		super();
		this.submissionId = submissionId;
		this.name = name;
		this.type = type;
		this.data = data;
		this.assignId = assignId;
		this.userId = userId;
	}
	public Submissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Submissions(String name, String type, byte[] data, int assignId, int userId) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.assignId = assignId;
		this.userId = userId;
	}
	
	
  
	
}
