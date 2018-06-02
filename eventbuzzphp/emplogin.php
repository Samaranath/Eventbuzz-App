<?php
require "conn.php";
$user_name = $_POST["user_name"];
$user_passw = $_POST["password"];
$mysql_qry = "Select * from emp_info where emp_id like '$user_name' and pass like '$user_passw';";
$result = mysqli_query($conn,$mysql_qry);
if(mysqli_num_rows($result) > 0){
echo "login success";
}
else{
echo "login not success";
}
?>