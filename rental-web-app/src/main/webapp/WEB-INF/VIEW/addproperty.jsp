<!DOCTYPE html>

<html>
<head>
<title>AddProperty</title>
</head>
<body>
		<h1 style="text-align:center" >Please Enter About Your Property Information</h1>
	<form action="addproperty" method="post">
		<table>
			<tr>
				<th>Property Type</th>
				<td><select name="propertytype">
						<option value="">SelectProperty</option>
						<option value="residential">Residential</option>
						<option value="commercial">Commercial</option>
				</select></td>

			</tr>
			<tr>
				<th>HouseNumber</th>
				<td><input type="text" name="housenumber"></td>

			</tr>
			<tr>
				<th>Address</th>
				<td><textarea rows="5" cols="20" name="address"></textarea> </td>

			</tr>
			<tr>
				<th>State</th>
				<td><select name="state">
						<option value="">SelectState</option>
						<option value="andhrapradesh">AndhraPradesh</option>
						<option value="telangana">Telangana</option>

				</select> </td>
			</tr>
			<tr>
				<th>City</th>
				<td><select name="city">
						<option value="">SelectCity</option>
						<option value="kurnool">Kurnool</option>
						<option value="kadapa">Kadapa</option>
						<option value="chittor">Cittor</option>
						<option value="ananthapur">Ananthapur</option>
						<option value="hyderabad">Hyderabad</option>
						<option value="varangal">Varangal</option>
						<option value="nalgonda">Nalgonda</option>
						<option value="mahaboobnagar">MahaboobNagar</option>
				</select> </td>
			</tr>
			<tr>
				<th>PinCode</th>
				<td><input type="number" name="pincode"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="AddProperty"></td>
			</tr>
			<br>
			<tr><th><a href="return"><-Return To HomePage</a></th></tr>
		</table>
	</form>
</body>
</html>