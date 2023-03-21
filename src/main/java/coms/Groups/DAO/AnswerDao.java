package coms.Groups.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.Groups.model.AnswerBean;

@Repository
public interface AnswerDao extends JpaRepository<AnswerBean, Integer> {

	AnswerBean findByAnswer(String answer);

	List<AnswerBean> findByQuestionId(int id);

}
   