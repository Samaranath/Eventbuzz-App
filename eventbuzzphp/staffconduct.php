<?php
session_start();
require "conn.php";

/*$empid="2390";
$descr="dhrshii";
$date="2018-04-13";
$time="3";
$semester="1";
$branch="ALL";
*/

$empid=$_POST["emp_id"];
$descr=$_POST["descr"];
$date=$_POST["date"];
$time=$_POST["time"];
$semester=$_POST["semester"];
$branch=$_POST["bran"];



/*$empid="201639";
$descr="dhshii";
$date="1997-04-08";
$time="3";
$semester="1";
$branch="ECE";
*/
$qry="INSERT INTO `staffconduct`(`empid`, `descr`, `date`, `time`, `semester`, `branch`) VALUES ('$empid','$descr','$date','$time','$semester','$branch');";
if(mysqli_query($conn,$qry)===TRUE)
	echo "post sent";
else
	echo "post failed";
?>