package coms.Groups.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.Groups.model.FileDB;

@Repository
public interface FileDao extends JpaRepository<FileDB,String> {

	List<FileDB> findByGroupId(int groupId);

	

}
