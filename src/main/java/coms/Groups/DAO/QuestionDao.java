package coms.Groups.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.Groups.model.QuestionBean;

@Repository
public interface QuestionDao extends JpaRepository<QuestionBean, Integer> {

	List<QuestionBean> findByGroupId(int groupId);

	QuestionBean findByQuestion(String question);

}
