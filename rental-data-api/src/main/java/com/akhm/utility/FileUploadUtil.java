package com.akhm.utility;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static String saveFile(String fileName,MultipartFile multipartFile) throws IOException
	{
		Path uploadPath=Paths.get("FileUploads");
		
		if(!Files.exists(uploadPath))
		{
			Files.createDirectories(uploadPath);
			
			
		}
		String fileCode=RandomStringUtils.randomAlphanumeric(8);
		
		try(InputStream inputStream=multipartFile.getInputStream())
		{
			
				Path filePaths=uploadPath.resolve(fileCode+"_"+fileName);
				Files.copy(inputStream,filePaths,StandardCopyOption.REPLACE_EXISTING);
			
			
		} catch (IOException ioe) {
				
			throw new IOException("could not save file"+fileName,ioe);
		}
		
		return fileCode ;
		
	}
}
