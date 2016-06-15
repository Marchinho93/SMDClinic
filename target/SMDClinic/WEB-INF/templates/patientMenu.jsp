<%@ page isELIgnored="false"%>
	<div align="left" class="form-group">
		<table>
			<tr>
				<td><label for="patientCode">Code:</label></td>
				<td>${patient.code}</td>
			</tr>
			<tr>
				<td><label for="patientName">Name:</label></td>
				<td>${patient.name}</td>
			</tr>
			<tr>
				<td><label for="patientSurname">Surname:</label></td>
				<td>${patient.surname}</td>
			</tr>
			<tr>
				<td><label for="patientDateOfBirth">Date Of Birth:</label></td>
				<td>${patient.dateOfBirth}</td>
			</tr>
			<tr>
				<td><label for="patientAddress">Address:</label></td>
				<td>${patient.address}</td>
			</tr>
		</table>
		<ul class="dropdown-menu-visible">
			<li ng-class="{'active':urlActive === '${pageContext.request.contextPath}/patientArea'}"><a href=""
				ng-click="href('${pageContext.request.contextPath}/patientArea');"><b>Patient Area</b></a></li>
			<li ng-class="{'active':urlActive === '${pageContext.request.contextPath}/logout'}"><a href=""
				ng-click="href('${pageContext.request.contextPath}/logout');"><b>Logout</b></a></li>
		</ul>
	</div>