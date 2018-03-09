<%@include file="Header.jsp" %>

<form action="perform_login" method="post">

<h3>${error}</h3>
<table align="center" border="1">
	<tr bgcolor="cyan">
		<td colspan="2"><center>Enter Credential</center></td>
	</tr>
	<tr>
		<td>User Name </td>
		<td><input type="text" name="username" /></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" /></td>
	</tr>
	<tr bgcolor="cyan">
		<td colspan="2">
		<center><input type="submit" value="Login"/></center>
		</td>
	</tr>
</table>
</form>

<%@include file="Footer.jsp" %>




