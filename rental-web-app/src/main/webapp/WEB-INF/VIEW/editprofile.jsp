<!DOCTYPE html>

<html>
<head>
<title>EditProfile</title>
</head>
<body>
<h1 style="text-align:center" >Update Profile Page</h1>
	<form action="editprofile" method="post">
		<table>
			<tr>
				<th>FullName</th>
				<td><input type="text" name="fullName" value="${sessionScope.AUTH_USER.fullName}"></td>

			</tr>
			<tr>
				<th>MobileNumber</th>
				<td><input type="text" name="mobileNumber" value="${sessionScope.AUTH_USER.mobileNumber}"></td>
			</tr>
			<tr>
				<th>EmailId</th>
				<td><input type="text" name="emailId" value="${sessionScope.AUTH_USER.emailId}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password" value="${sessionScope.AUTH_USER.password}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Status</th>
				<td><input type="text" name="status" value="${sessionScope.AUTH_USER.status}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="UpdateProfile"></td>
			</tr>
			<br>
			<tr><th><a href="return"><-Return To HomePage</a></th></tr>
		</table>
	</form>
</body>
</html>