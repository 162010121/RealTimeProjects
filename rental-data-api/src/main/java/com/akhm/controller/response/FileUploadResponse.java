package com.akhm.controller.response;

import lombok.Data;

@Data
public class FileUploadResponse {
	
	private String fileName;
	private String dowloadURI;
	private long   size;
	
	

}
