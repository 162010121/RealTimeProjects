<!DOCTYPE html>

<html>
<head>
<title>ChangePassword</title>
</head>
<body>
<h1 style="text-align:center" >Please Change Your Password</h1>
	<form action="changepassword" method="post">
		<table>
			<tr>
				<th>OldPasswoed</th>
				<td><input type="password" name="oldpassword"></td>
			</tr>
			<tr>
				<th>NewPassword</th>
				<td><input type="password" name="newpassword"></td>
			</tr>
			<tr>
				<th>ConfirmPassword</th>
				<td><input type="password" name="confirmpassword"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="ChangePassword"></td>
			</tr>
			<br>
			<tr><th><a href="return">Return To HomePage</a></th></tr>
		</table>
	</form>
</body>
</html>