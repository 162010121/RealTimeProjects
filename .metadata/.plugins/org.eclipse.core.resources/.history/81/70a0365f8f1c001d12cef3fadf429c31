package com.akhm.controller;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akhm.utility.FileDownloadUtil;
@RestController
public class FileDownloadController {
	
	@GetMapping("/downloadfile/{filecode}")
	public ResponseEntity<?> dowloadFile(@PathVariable ("filecode") String filecode)
	{
		FileDownloadUtil util=new FileDownloadUtil();
		Resource resource=null;
		
		try {
			
			resource=util.getFileAsResource(filecode);
			
		} catch (IOException ioe) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			if(resource==null)
			{
				return new ResponseEntity<>("File Not Found",HttpStatus.NOT_FOUND);
				
			}
			String contentType="application/octet-stream";
			String headerValue="attachment;filename=\""+resource.getFilename()+"\"";
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION, headerValue).body(resource);
		
		
	}

}
