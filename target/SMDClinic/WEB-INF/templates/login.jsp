<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<form class="form container-fluid" method="post"
	action="${pageContext.request.contextPath}/login">
	<div align="center" class="form-group">
		<table>
			<tr>
				<td><label for="username">Username:</label></td>
				<td><input class="form-control input-sm" type="text"
					id="username" name="username" /></td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><input class="form-control input-sm" type="password"
					id="password" name="password" /></td>
			</tr>
		</table>
	</div>
	<ul>
		<li role="separator" class="divider"></li>
	</ul>
	<table>
		<tr>
			<td><input class="btn btn-default" value="Submit" type="submit"
				name="submit" /></td>
			<td><c:if test="${'fail' eq param.auth}">
					<font color="red"> Login error. <br /> Reason :
						${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</font>
				</c:if></td>
		</tr>
	</table>
</form>