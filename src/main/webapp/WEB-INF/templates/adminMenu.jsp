<%@ page isELIgnored="false"%>
	<div align="left" class="form-group">
		<table>
			<tr>
				<td><label for="adminCode">Code:</label></td>
				<td>${admin.code}</td>
			</tr>
			<tr>
				<td><label for="adminName">Name:</label></td>
				<td>${admin.name}</td>
			</tr>
			<tr>
				<td><label for="adminSurname">Surname:</label></td>
				<td>${admin.surname}</td>
			</tr>
		</table>
		<ul class="dropdown-menu-visible">
			<li ng-class="{'active':urlActive === '${pageContext.request.contextPath}/adminArea'}"><a href=""
				ng-click="href('${pageContext.request.contextPath}/adminArea');"><b>Admin Area</b></a></li>
			<li ng-class="{'active':urlActive === '${pageContext.request.contextPath}/logout'}"><a href=""
				ng-click="href('${pageContext.request.contextPath}/logout');"><b>Logout</b></a></li>
		</ul>
	</div>