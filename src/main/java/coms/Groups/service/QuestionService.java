package coms.Groups.service;

import java.util.List;

import coms.Groups.exceptionsGlobal.QuestionAlreadyExists;
import coms.Groups.exceptionsGlobal.QuestionNotFound;
import coms.Groups.model.QuestionBean;

public interface QuestionService {

	String deleteQues(int questionId) throws QuestionNotFound;

	List<QuestionBean> getQues(int groupId) throws QuestionNotFound;

	QuestionBean postQues(QuestionBean question) throws QuestionAlreadyExists;

	QuestionBean editQues1(int questionId, String question) throws QuestionNotFound;

}
