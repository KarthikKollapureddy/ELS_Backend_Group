package coms.Groups.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import coms.Groups.DAO.FileDao;
import coms.Groups.model.FileDB;

@Service
public class FileServiceImp implements FileService {
	
	@Autowired FileDao fdao;
	
	@Override
	public FileDB store(MultipartFile file,int groupId) throws IOException {
		String name=StringUtils.cleanPath(file.getOriginalFilename());
		FileDB filedb=new FileDB(name,file.getContentType(),file.getBytes(),groupId);
		return fdao.save(filedb);
		
	}
	
	
	
	@Override
	public Stream<FileDB> getAll(int groupId){
		return fdao.findByGroupId(groupId).stream();
	}

	@Override
	public FileDB getFile(String id) {
		// TODO Auto-generated method stub
		return fdao.findById(id).get();
	}

}
