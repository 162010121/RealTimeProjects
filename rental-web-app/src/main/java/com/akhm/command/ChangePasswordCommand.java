package com.akhm.command;

import lombok.Data;

@Data
public class ChangePasswordCommand {
	
	private String oldpassword;
	private String newpassword;
	private String confirmpassword;
	
	

}
