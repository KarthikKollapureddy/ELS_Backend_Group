package coms.Groups.service;

import java.util.List;

import com.ELearning.model.RegisterUser;

public interface GroupService {

	List<RegisterUser> getInfo(int groupId);

}
