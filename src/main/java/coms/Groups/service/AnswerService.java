package coms.Groups.service;

import java.util.List;

import coms.Groups.exceptionsGlobal.AnswerNotFound;
import coms.Groups.model.AnswerBean;

public interface AnswerService {

	AnswerBean postAnswer(AnswerBean answer);

	AnswerBean editAnswer(int answerId, String ans) throws AnswerNotFound;

	String deleteAns(int answerId) throws AnswerNotFound;

	AnswerBean getAnswer(int answerId);

	List<AnswerBean> getAnswers(int id) throws AnswerNotFound;

}
