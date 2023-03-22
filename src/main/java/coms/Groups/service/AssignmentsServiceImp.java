package coms.Groups.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.Student.model.StudentBean;
import com.Trainer.model.GroupBean;

import coms.Groups.DAO.AssignmentDao;
import coms.Groups.DAO.SubmissionDao;
import coms.Groups.exceptionsGlobal.AssignmentNotFound;
import coms.Groups.model.Assignments;
import coms.Groups.model.Submissions;

@Service
public class AssignmentsServiceImp implements AssignmentsService {

	@Autowired AssignmentDao assign;
	@Autowired SubmissionDao submit;
	@Autowired RestTemplate restTemplate;
	@Override
	public Assignments postAssign(Assignments ass) {
		// TODO Auto-generated method stub
		return assign.save(ass);
	}
	@Override
	public List<Assignments> getAssignments(int groupId) throws AssignmentNotFound {
		// TODO Auto-generated method stub
		List<Assignments> res=assign.findByGroupId(groupId);
		if(res.isEmpty()) {
			throw new AssignmentNotFound();
		}
		return res;
	}
	@Override
	public Submissions submitAssign(int assignId, int id, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		String name=StringUtils.cleanPath(file.getOriginalFilename());
		Submissions sub=new Submissions(name,file.getContentType(),file.getBytes(),assignId,id);
		Submissions sub1=submit.findByUserIdAndAssignId(id,assignId);
		if(sub1 == null) {
		return submit.save(sub);
		}
		sub1=new Submissions(name,file.getContentType(),file.getBytes(),assignId,id);
		
		return submit.saveAndFlush(sub1);
	}
	@Override
	public List<Assignments> getTodo(int userId) {
		// TODO Auto-generated method stub
		Date cur=new Date();
		ResponseEntity<GroupBean[]> res=restTemplate.getForEntity("http://localhost:8787/elearning/api/student/joinedClasses/"+userId,GroupBean[].class);
		List<GroupBean> gr=Arrays.asList(res.getBody());
		List<Assignments> res1=new ArrayList<>();
		for(GroupBean sub:gr) {
			List<Assignments> ass=assign.findByGroupId(sub.getGroupId());
			for(Assignments a:ass) {
				if( ! submit.existsByUserIdAndAssignId(userId,a.getAssignId())) {
			          res1.add(a);
		}
		}
		
	}
		return res1;
	}

}
