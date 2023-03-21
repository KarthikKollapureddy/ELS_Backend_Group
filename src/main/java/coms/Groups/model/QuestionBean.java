package coms.Groups.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_info")
public class QuestionBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int questionId;
	String question;
	int groupId;
	int userId;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public QuestionBean(int questionId, String question, int groupId, int userId) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.groupId = groupId;
		this.userId = userId;
	}
	public QuestionBean(String question, int groupId, int userId) {
		super();
		
		this.question = question;
		this.groupId = groupId;
		this.userId = userId;
	}
	public QuestionBean() {
		super();
	}
}
