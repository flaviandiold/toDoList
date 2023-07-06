<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

.head{
text-align:center;
position:relative;
top:12px;
}




.container {
  padding: 16px;
}




/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
}



}
</style>
</head>
<body>

  
  <form class="modal-content" method="post">
    <div class="head">
      Login Page
    </div>

    <div class="container">
      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="username" required>
		
      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
        
      <input type="submit" class="btn btn-success" style="position:relative; left:470px;">
		<a href="/sign-up" class="btn btn-success" style="position:relative; left:490px;">Sign Up</a>
		<div>${umessage}</div><div>${pmessage}</div>
    </div>
  </form>
  
  


</body>
</html>