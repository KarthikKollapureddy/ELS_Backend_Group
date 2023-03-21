package coms.Groups.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import coms.Groups.model.FileDB;

public interface FileService {

	FileDB store(MultipartFile file, int groupId) throws IOException;

	

	Stream<FileDB> getAll(int groupId);

	FileDB getFile(String id);

}
