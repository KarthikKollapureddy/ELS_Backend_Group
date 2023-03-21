package coms.Groups.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.Groups.DAO.AnswerDao;
import coms.Groups.exceptionsGlobal.AnswerNotFound;
import coms.Groups.model.AnswerBean;

@Service
public class AnswerServiceImp implements AnswerService {
	
	@Autowired AnswerDao answerDao;
	@Override
	public AnswerBean postAnswer(AnswerBean answer) {
		// TODO Auto-generated method stub
		AnswerBean answer1=answerDao.findByAnswer(answer.getAnswer());
		if(answer1==null) {
		
		}
		return answerDao.save(answer);
	}

	@Override
	public AnswerBean editAnswer(int answerId, String answer) throws AnswerNotFound {
		// TODO Auto-generated method stub
		Optional<AnswerBean> answer1 = answerDao.findById(answerId);
		if(answer1.isEmpty()) {
			throw new AnswerNotFound();
			
		}
		else {
			answer1.get().setAnswer(answer);
			return answerDao.saveAndFlush(answer1.get());
		}
	}

	@Override
	public String deleteAns(int answerId) throws AnswerNotFound {
		// TODO Auto-generated method stub
		Optional<AnswerBean> answer = answerDao.findById(answerId);
		if(answer.isEmpty()) {
		    throw new AnswerNotFound();
		}
		else {
			answerDao.deleteById(answerId);
			return "Success";
		}

}

	@Override
	public AnswerBean getAnswer(int answerId) {
		// TODO Auto-generated method stub
		return answerDao.findById(answerId).get();
	}

	@Override
	public List<AnswerBean> getAnswers(int id) throws AnswerNotFound {
		// TODO Auto-generated method stub
		List<AnswerBean> res=answerDao.findByQuestionId(id);
		if(res.size() != 0) {
			return res;
		}
		throw new AnswerNotFound();
	}

}
