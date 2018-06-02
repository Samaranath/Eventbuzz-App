<?php
require "conn.php";
$username=$_POST["user_name"];
$pass=$_POST["password"];
$phone=$_POST["phone_num"];
$email=$_POST["email_id"];
$semester=$_POST["semester"];
$branch=$_POST["bran"];
$qry="INSERT INTO `student_info`(`regno`, `pass`, `phone`, `email`, `semester`, `branch`) VALUES ('$username','$pass','$phone','$email','$semester','$branch');";
if(mysqli_query($conn,$qry)===TRUE)
	echo "registered";
else
	echo "registration failed";
?>