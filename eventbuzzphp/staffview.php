<?php
	require "conn.php";
	 $sql="SELECT * FROM studentconduct where edate>=CURDATE();";
	 $result = mysqli_query($conn,$sql);
	 echo mysqli_error($conn);
	$response=array();
	//echo $result;
	while($row=mysqli_fetch_array($result)){
		array_push($response,array('name'=>$row[0],'description'=>$row[1],'venue'=>$row[2],'sdate'=>$row[3],'stime'=>$row[4],'edate'=>$row[5],'etime'=>$row[6]));
	}
	
	mysqli_close($conn);
	echo json_encode(array('server_response'=>$response));
?>