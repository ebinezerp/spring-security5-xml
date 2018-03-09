<%@ include file="Header.jsp" %>

<h3 align="center">Login Page</h3>
<form action="perform_Login" method="post" > 

<table align="center" border="1"> 
	<tr>
		<td colspan="2" bgcolor="#ff5252" ><center>Enter Credentail</center></td>
	</tr>
	<tr >
	<td>User Name </td>
	<td><input type="text" name="username" /> </td>
	</tr>
	<tr>
	<td bgcolor="#c5cae9" >Password </td>
	<td><input type="password" name="password" /> </td>
	
	</tr>
	<tr align="center"  >
	<td colspan="2"><center><input type="submit" value="Login" /> </center> </td>
	
	 </tr>
</table>
</form>

</body>
</html>
