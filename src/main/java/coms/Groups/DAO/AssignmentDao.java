package coms.Groups.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.Groups.model.Assignments;

@Repository
public interface AssignmentDao extends JpaRepository<Assignments, Integer> {

}
