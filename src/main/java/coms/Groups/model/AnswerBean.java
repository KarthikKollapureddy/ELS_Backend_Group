package coms.Groups.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answer_info")
public class AnswerBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int answerId;
	String answer;
	int questionId;
	int userId;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public AnswerBean(int answerId, String answer, int questionId, int userId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.questionId = questionId;
		this.userId = userId;
	}
	public AnswerBean() {
		super();
	}

}
