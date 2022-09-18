<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Properties</title>

</head>

<body>

	<table>
		<tr>
			<th>SNO</th>
			<th>PropertyType</th>
			<th>HouseNumber</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>PinCode</th>
			
		</tr>
		<c:forEach items="${requestScope.properties}" var="property" varStatus="ST">
				
			<tr>
				<td>${ST.count}</td>
				
				<td> ${property.propertyType}</td>
				<td> ${property.houseNumber}</td>
				<td> ${property.address}</td>
				<td> ${property.city}</td>
				<td> ${property.state}</td>
				<td> ${property.pincode}</td>
				<td> <a href="editproperty?propertyId=${property.propertyId}">Edit</a>
					<a href="deleteproperty/${property.propertyId}">DeleteProperty</a>
						
				</td>
				
				
				
			</tr>	
		
		
		</c:forEach>
					
		
		
	</table>
<tr><th><a href="return"><-Return To HomePage</a></th></tr>


</body>


</html>