<?php
require "conn.php";
$response = array();
//$response["status"]="done";
//echo  json_encode($response);
if($_SERVER['REQUEST_METHOD']=='GET'){
	
	$json=json_decode($_GET['sendData']);
	
	$reg_no  = $json->username;
	$password = $json->password;
	
	//$reg_no  = "3567";
	//$password = "aaa";
	//echo $reg_no;
	//require_once('conn.php');
 
	$sql = "SELECT * FROM student_info WHERE regno='$reg_no' " ; 
	$r = mysqli_query($conn,$sql);
 
	$res = mysqli_fetch_array($r);
	//$k=0;
	$k=mysqli_num_rows($r);
	echo ($k);
	if($k==0)
	{
		// you reg no is not present in database
		$response["status"]=-1;
		echo json_encode($response);
	}
	else if($k>0)
	{
		if($res['pass']!= $password)
		{
			$response["status"]=0;
			echo json_encode($response);
			//mismatch
		}
		else if($res['updated']==0)
		{
			$response["status"]=1;
			echo json_encode($response);
		}
		else
		{
			//already updated profile
			$response["status"]=2;
			//$response["isTpo"] = $res['IsTpo'];
			echo json_encode($response);
		}
	}
}
?>