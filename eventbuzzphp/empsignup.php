<?php
require "conn.php";
$username=$_POST["user_name"];
$pass=$_POST["password"];
$empname=$_POST["empname"];
$email=$_POST["email_id"];
$phone=$_POST["phone_num"];
$position=$_POST["position"];
$department=$_POST["dpt"];


$qry="INSERT INTO `emp_info`(`emp_id`, `pass`,`empname`, `email`, `phone`, `position` , `dept`) VALUES ('$username','$pass','$empname','$email','$phone','$position','$department');";
if(mysqli_query($conn,$qry)===TRUE)
	echo "registered";
else
	echo "registration failed";
?>