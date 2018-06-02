<?php
//session_start(); // to start session
require "conn.php";
$user_name = $_POST["user_name"];
$user_passw = $_POST["password"];



//$user_name = "356";
//$user_passw = "aaa";

$mysql_qry = "Select * from student_info where regno like '$user_name' and pass like '$user_passw';";
$branch=mysqli_query($conn,"SELECT branch FROM student_info WHERE regno=$user_name;");
$result=mysqli_fetch_row($branch);

//$_SESSION["res"] = $result[0];

    

$result = mysqli_query($conn,$mysql_qry);
if(mysqli_num_rows($result) > 0){
echo "login success";
}
else
{
echo "login not success";
}
?>