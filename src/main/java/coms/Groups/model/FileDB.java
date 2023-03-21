package coms.Groups.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="file_info")
public class FileDB {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String fileId;
	
	public String name;
	public String type;
	
	@Lob
	public byte[] data;
	
	public int groupId;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public FileDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileDB(String fileId, String name, String type, byte[] data, int groupId) {
		super();
		this.fileId = fileId;
		this.name = name;
		this.type = type;
		this.data = data;
		this.groupId = groupId;
	}

	public FileDB(String name, String type, byte[] data, int groupId) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.groupId = groupId;
	}
	
	
	
	
	

}
