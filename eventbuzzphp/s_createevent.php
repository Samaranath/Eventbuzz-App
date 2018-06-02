<?php
  require "conn.php";
  $eventname="";
  $date="";
  $time="";
  $venue="";
  $desc="";
  $postedby="";
  $qry="INSERT INTO `s_createevent`(`eventname`, `date`, `time`, `venue`, `description`, `postedby`) VALUES ("$eventname","$date","$time","$venue","$desc","$postedby");";
  if(mysqli_query($conn,$qry)===TRUE)
	echo "posted!";
  else
	echo "entry failed";
?>