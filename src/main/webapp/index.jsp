<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
<head>
  <meta charset="UTF-8">
  <title>Hello</title>
  
  
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>

      <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/animecss.css">

  
</head>

<body>

<div class="button1">
					<a href><div class="round1"><span><img src="images/reminder2.png" height="150"></span></div></a>
					<div class="round2"></div>
					<div class="block1 block"></div>
					<div class="block2 block"></div>
					<div class="block3 block"></div>	
					<div class="block4 block"></div>				
				</div>
				
  <div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
		<div class="login-form">
			<div class="sign-in-htm">
			<form action="LoginServlet" method="post">
				<div class="group">
					<label for="login" class="label">Login</label>
					<input id="login" type="text" class="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<input id="pass" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<input id="check" type="checkbox" class="check" checked>
					<label for="check"><span class="icon"></span> Keep me Signed in</label>
				</div>
				<div class="group">
					<input type="submit" class="button" value="Sign In">
				</div>
				</form>
				<div class="hr"></div>
				<div class="foot-lnk">
					<label for ="tab-2">Forgot Password?</a>
				</div>
			</div>
			<div class="sign-up-htm">
				<form action="RegistrationServlet" method="post">
				<div class="group">
					<label for="user" class="label">Username</label>
					<input id="user" type="text" class="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Surname</label>
					<input id="pass" type="text" class="input" data-type="input">
				</div>
				<div class="group">
					<label for="pass" class="label">Password</label>
					<input id="pass" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<label for="pass" class="label">Repeat Password</label>
					<input id="pass" type="password" class="input" data-type="password">
				</div>
				<div class="group">
					<label for="pass" class="label">Phone number</label>
					<input id="pass" type="text" class="input">
				</div>
				<div class="group">
					<input type="submit" class="button" value="Sign Up">
					</form>
				</div>
				<div class="foot-lnk">
					<label for="tab-1">Already Member?</a>
				</div>
			</div>
		</div>
	</div>
</div>
  
  
</body>
</html>
