<?php
	require "conn.php";
	$user_name = $_POST["user_name"];
	//$user_name ="2014";
	 $sql="SELECT * FROM staffconduct,student_info where staffconduct.semester=student_info.semester and (staffconduct.branch=student_info.branch or staffconduct.branch='ALL') and student_info.regno=$user_name and date>=CURDATE();";
	 $result = mysqli_query($conn,$sql);
	 echo mysqli_error($conn);
	$response=array();
	//echo $result;
	
	while($row=mysqli_fetch_array($result)){
		array_push($response,array('empid'=>$row[0],'descr'=>$row[1],'date'=>$row[2],'time'=>$row[3],'semester'=>$row[4],'branch'=>$row[5]));
	}
	
	mysqli_close($conn);
	echo json_encode(array('server_response'=>$response));
?>