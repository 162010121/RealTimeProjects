<!DOCTYPE html>

<html>
<head>
<title>Login</title>
</head>
<body>
<h1 style="text-align:center" >Please Enter Your Login Credintials</h1>

	<form action="userlogin" method="post" >
		<table>
			<tr>
				<th>EmailId</th>
				<td><input type="text" name="emailId">
				</td>
				
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password">
				
				</td>
				
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login">
				<a href="forgetpassword">ForGetPassword</a>
				
				
				</td>
			</tr>
		</table>
	</form>
</body>
</html>