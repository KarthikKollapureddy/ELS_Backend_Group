package coms.Groups.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.Groups.DAO.QuestionDao;
import coms.Groups.exceptionsGlobal.QuestionAlreadyExists;
import coms.Groups.exceptionsGlobal.QuestionNotFound;
import coms.Groups.model.QuestionBean;

@Service
public class QuestionServiceImp implements QuestionService{
	
	@Autowired QuestionDao questionDao;
	

	@Override
	public String deleteQues(int questionId) throws QuestionNotFound {
		
		
		// TODO Auto-generated method stub
		Optional<QuestionBean> ques = questionDao.findById(questionId);
		if(ques.isEmpty()) {
			throw new QuestionNotFound();
		}
		else {
			questionDao.deleteById(questionId);
			return "Success";
		}
		
	}

	@Override
	public List<QuestionBean> getQues(int groupId) throws QuestionNotFound {
		
		// TODO Auto-generated method stub
		List<QuestionBean> ques = questionDao.findByGroupId(groupId);
		if(ques.size() != 0) {
			return ques;
		}
		throw new QuestionNotFound();
		
	}

	@Override
	public QuestionBean postQues(QuestionBean question) throws QuestionAlreadyExists {
		// TODO Auto-generated method stub
		QuestionBean question1 =questionDao.findByQuestion(question.getQuestion());
		if(question1==null) {
			return questionDao.save(question);
		}
		else {
			throw new QuestionAlreadyExists();
		}
	}

	@Override
	public QuestionBean editQues1(int questionId, String question) throws QuestionNotFound {
		// TODO Auto-generated method stub
		Optional<QuestionBean> group2 = questionDao.findById(questionId);
		if(group2.isEmpty()) {
			throw new QuestionNotFound();
		}
		else {
		// TODO Auto-generated method stub
			group2.get().setQuestion(question);
		    return questionDao.saveAndFlush(group2.get());
	}
	}


}
