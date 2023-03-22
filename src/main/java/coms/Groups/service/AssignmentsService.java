package coms.Groups.service;



import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import coms.Groups.exceptionsGlobal.AssignmentNotFound;
import coms.Groups.model.Assignments;
import coms.Groups.model.Submissions;

public interface AssignmentsService {

	Assignments postAssign(Assignments ass);

	List<Assignments> getAssignments(int groupId) throws AssignmentNotFound;

	Submissions submitAssign(int assignId, int id, MultipartFile file) throws IOException;

	List<Assignments> getTodo(int userId);

}
