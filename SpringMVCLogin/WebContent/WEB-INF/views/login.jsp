<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
	<title>Login</title>
</head>
<body>
<h1>
	Login  
</h1>
<form method="post">

    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit" >Login</button>
</form>
</body>
</html>