<?php
require "conn.php";
	
$name=$_POST["name"];
$descr=$_POST["description"];
$venue=$_POST["venue"];
$startdate=$_POST["s_date"];
$starttime=$_POST["s_time"];
$enddate=$_POST["e_date"];
$endtime=$_POST["e_time"];

 
 //$abc="abc";

 
/*$empid="201639";
$descr="dhshii";
$date="1997-04-08";
$time="3";
$semester="1";
$branch="ECE";
*/
$qry="INSERT INTO `studentconduct`(`name`, `description`,`venue`, `sdate`, `stime`, `edate`, `etime`)
 VALUES ('$name','$descr','$venue','$startdate','$starttime','$enddate','$endtime');";
if(mysqli_query($conn,$qry)===TRUE)
	echo "post sent";
else
	echo "post failed";
    
?>