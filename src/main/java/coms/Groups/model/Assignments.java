package coms.Groups.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assignments_info")
public class Assignments {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int assignId;
	private String assignName;
	private int groupId;
	private Date startDate;
	private Date endDate;
	public int getAssignId() {
		return assignId;
	}
	public void setAssignId(int assignId) {
		this.assignId = assignId;
	}
	public String getAssignName() {
		return assignName;
	}
	public void setAssignName(String assignName) {
		this.assignName = assignName;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Assignments(int assignId, String assignName, int groupId, Date startDate, Date endDate) {
		super();
		this.assignId = assignId;
		this.assignName = assignName;
		this.groupId = groupId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Assignments(String assignName, int groupId, Date startDate, Date endDate) {
		super();
		this.assignName = assignName;
		this.groupId = groupId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Assignments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
