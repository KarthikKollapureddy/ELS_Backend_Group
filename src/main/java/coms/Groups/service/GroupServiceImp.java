package coms.Groups.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.ELearning.model.RegisterUser;
import com.Student.model.StudentBean;
import com.Trainer.model.GroupBean;

@Service
public class GroupServiceImp implements GroupService {
	
	@Autowired
	   RestTemplate restTemplate;

	@Override
	public List<RegisterUser> getInfo(int groupId) {
		
		List<RegisterUser> res=new ArrayList<>();
		GroupBean gr= restTemplate.getForObject("http://localhost:8787/elearning/api/trainer/getClass/"+groupId, GroupBean.class);
		
		RegisterUser trainer= restTemplate.getForObject("http://localhost:8787/elearning/api/main/userData/"+gr.getTrainerId(), RegisterUser.class);
		res.add(trainer);
		
ResponseEntity<StudentBean[]> response= restTemplate.getForEntity("http://localhost:8787/elearning/api/student/getParticipants/"+groupId,StudentBean[].class);
			   
		
//		GroupBean[] res = response.getBody();
	List<StudentBean> stud=Arrays.asList(response.getBody());
	for(StudentBean s:stud) {
		RegisterUser st= restTemplate.getForObject("http://localhost:8787/elearning/api/main/userData/"+s.getUserId(), RegisterUser.class);
		res.add(st);
	}
	return res;
	}

}
