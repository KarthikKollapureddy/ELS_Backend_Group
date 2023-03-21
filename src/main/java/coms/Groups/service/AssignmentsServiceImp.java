package coms.Groups.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import coms.Groups.DAO.AssignmentDao;
import coms.Groups.model.Assignments;

@Service
public class AssignmentsServiceImp implements AssignmentsService {

	@Autowired AssignmentDao assign;
	@Override
	public Assignments postAssign(Assignments ass) {
		// TODO Auto-generated method stub
		return assign.save(ass);
	}

}
