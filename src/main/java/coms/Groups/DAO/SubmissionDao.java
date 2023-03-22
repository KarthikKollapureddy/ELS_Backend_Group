package coms.Groups.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.Groups.model.Submissions;

@Repository
public interface SubmissionDao extends JpaRepository<Submissions, String> {

	Submissions findByUserIdAndAssignId(int id, int assignId);

	List<Submissions> findByUserId(int userId);

	boolean existsByUserIdAndAssignId(int userId, int assignId);

}
