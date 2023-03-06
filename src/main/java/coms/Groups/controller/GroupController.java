package coms.Groups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ELearning.model.RegisterUser;

import coms.Groups.service.GroupService;


@RestController
@RequestMapping("elearning/api/groups/")
@CrossOrigin(origins="*")

public class GroupController {
	
	@Autowired GroupService groupService;
	
	@GetMapping("people/{groupId}")
	public List<RegisterUser> getPeople(@PathVariable int groupId){
		return groupService.getInfo(groupId);
		
	}

}
