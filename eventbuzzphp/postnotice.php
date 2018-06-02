<?php
  require "conn.php";
  $sub="";
  $date="";
  $desc="";
  $sem="";
  $branch="";
  $abc="abc";
  $qry="INSERT INTO `post`(`subject`, `date`, `description`, `semester`, `branch`) VALUES ("$sub","$date","$desc","$sem","$branch");";
  if(mysqli_query($conn,$qry)===TRUE)
	echo "posted!";
  else
	echo "error in posting";
?>