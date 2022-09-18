<!DOCTYPE html>

<html>
<head>
<title>EditProperty</title>
</head>
<body>
		<h1 style="text-align:center" >Please Enter About Your Property Information</h1>
	<form action="editproperty" method="post">
		<table>
		
			<tr>
				<th>Property Type</th>
				<td><select name="propertytype">
						<option value="${requestScope.property.propertyType}">${requestScope.property.propertyType}</option>
						<option value="residential">Residential</option>
						<option value="commercial">Commercial</option>
				</select></td>

			</tr>
			<tr>
				<th>HouseNumber</th>
				<td><input type="text" name="housenumber" value="${requestScope.property.houseNumber}"></td>

			</tr>
			<tr>
				<th>Address</th>
				<td><textarea rows="5" cols="20" name="address">${requestScope.property.address }</textarea> </td>

			</tr>
			<tr>
				<th>State</th>
				<td><select name="state">
						<option value="${requestScope.property.state}">${requestScope.property.state}</option>
						<option value="andhrapradesh">AndhraPradesh</option>
						<option value="telangana">Telangana</option>

				</select> </td>
			</tr>
			<tr>
				<th>City</th>
				<td><select name="city">
						<option value="${requestScope.property.city}">${requestScope.property.city}</option>
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
				<td><input type="number" name="pincode" value="${requestScope.property.pincode}"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="UpdateProperty"><input type="hidden" name="propertyId" value="${requestScope.property.propertyId}"></td>
			</tr>
			<br>
			<tr><th><a href="return"><-Return To HomePage</a></th></tr>
		</table>
	</form>
</body>
</html>