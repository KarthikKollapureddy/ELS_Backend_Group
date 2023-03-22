package coms.Groups.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ELearning.model.RegisterUser;

import coms.Groups.exceptionsGlobal.AnswerAlreadyExists;
import coms.Groups.exceptionsGlobal.AnswerNotFound;
import coms.Groups.exceptionsGlobal.AssignmentNotFound;
import coms.Groups.exceptionsGlobal.QuestionAlreadyExists;
import coms.Groups.exceptionsGlobal.QuestionNotFound;
import coms.Groups.message.ResponseFile;
import coms.Groups.model.AnswerBean;
import coms.Groups.model.Assignments;
import coms.Groups.model.FileDB;
import coms.Groups.model.QuestionBean;
import coms.Groups.model.Submissions;
import coms.Groups.service.AnswerService;
import coms.Groups.service.AssignmentsService;
import coms.Groups.service.FileService;
import coms.Groups.service.GroupService;
import coms.Groups.service.QuestionService;


@RestController
@RequestMapping("/elearning/api/groups/")
@CrossOrigin(origins="*")

public class GroupController {
	
	@Autowired GroupService groupService;
	@Autowired AnswerService ansService;
	@Autowired QuestionService quesService;
	@Autowired FileService fileService;
	@Autowired AssignmentsService assignService;
	
	
	@GetMapping("people/{groupId}")
	public List<RegisterUser> getPeople(@PathVariable int groupId){
		return groupService.getInfo(groupId);
		
	}
	
	@PostMapping("questions/create")
	public ResponseEntity<QuestionBean> postQuestion(@RequestBody QuestionBean question) throws QuestionAlreadyExists{
		return new ResponseEntity<QuestionBean>(quesService.postQues(question),HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("questions/getQuestion/{id}")
	public ResponseEntity<List<QuestionBean>> getQuestion(@PathVariable int id) throws QuestionNotFound{
		return new ResponseEntity<List<QuestionBean>>(quesService.getQues(id),HttpStatus.OK);
		
		
	}
	
	@PatchMapping("questions/editQuestion/{id}")
	public ResponseEntity<QuestionBean> editQuestion(@PathVariable int id,@RequestBody String question) throws QuestionNotFound{
		System.out.print(question)	;
		return new ResponseEntity<QuestionBean>(quesService.editQues1(id, question),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("questions/delQuestion/{id}")
	public ResponseEntity<String> delQuestion(@PathVariable int id) throws QuestionNotFound{
		return new ResponseEntity<String>(quesService.deleteQues(id),HttpStatus.OK);
		
		
	}
	
	@PostMapping("answers/create")
	public ResponseEntity<AnswerBean> postAnswer(@RequestBody AnswerBean ans) throws AnswerAlreadyExists{
		return new ResponseEntity<AnswerBean>(ansService.postAnswer(ans),HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("answers/getAnswers/{id}")
	public ResponseEntity<List<AnswerBean>> getAnswers(@PathVariable int id) throws AnswerNotFound{
		return new ResponseEntity<List<AnswerBean>>(ansService.getAnswers(id),HttpStatus.OK);
		
		
	}
	
	@PatchMapping("answers/editAnswer/{id}")
	public ResponseEntity<AnswerBean> editAnswer(@PathVariable int id,@RequestBody String ans) throws AnswerNotFound{
		return new ResponseEntity<AnswerBean>(ansService.editAnswer(id,ans),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("answers/delAnswer/{id}")
	public ResponseEntity<String> delAnswer(@PathVariable int id) throws  AnswerNotFound{
		return new ResponseEntity<String>(ansService.deleteAns(id),HttpStatus.OK);
		
		
	}
	
	@PostMapping("/files/upload/{groupId}")
	public ResponseEntity<FileDB> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable int groupId ) throws IOException{
		return new ResponseEntity<FileDB>(fileService.store(file,groupId),HttpStatus.CREATED);
		
	}
	
	@GetMapping("files/{groupId}")
	public ResponseEntity<List<ResponseFile>> getFiles(@PathVariable int groupId){
		List<ResponseFile> res=  fileService.getAll(groupId).map(dbFile -> {
			String fileUri=ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("elearning/api/groups/files/"+groupId+"/")
					.path(dbFile.getFileId())
					.toUriString();
			return new ResponseFile(
					dbFile.getName(),
					fileUri,
					dbFile.getType(),
					dbFile.getData().length);
		}).collect(Collectors.toList());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(res);		
					
				
		
		
	}
	
	@GetMapping("/files/{groupId}/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id,@PathVariable int groupId) {
	    FileDB fileDB = fileService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	  
	  @PostMapping("/assignments/post/{groupId}")
	  public ResponseEntity<Assignments> postAssign(@PathVariable int groupId,@RequestBody Assignments ass){
		return new ResponseEntity<Assignments>(assignService.postAssign(ass),HttpStatus.OK);
		  
	  }
	  
	 @GetMapping("/assignments/get/{groupId}")
	 public ResponseEntity<List<Assignments>> getAssign(@PathVariable int groupId) throws AssignmentNotFound {
		 return new ResponseEntity<List<Assignments>>(assignService.getAssignments(groupId),HttpStatus.OK);
	 }
	 
	 @PostMapping("/assignments/submit/{assignId}/{id}")
	  public ResponseEntity<Submissions> submitAssign(@PathVariable int assignId,@PathVariable int id,@RequestParam("file") MultipartFile file) throws IOException{
		return new ResponseEntity<Submissions>(assignService.submitAssign(assignId,id,file),HttpStatus.OK);
		  
	  }
	 
	 @GetMapping("assignments/todo/{userId}")
	 public ResponseEntity<List<Assignments>> getTodo(@PathVariable int userId){
		 return new ResponseEntity<List<Assignments>>(assignService.getTodo(userId),HttpStatus.OK);
	 }

}
