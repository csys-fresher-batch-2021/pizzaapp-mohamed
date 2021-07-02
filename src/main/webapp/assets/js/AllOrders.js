/**
 *This method used to fetch all details  
 */
$(document).ready( function () {
    let content="";	
    let data = [];
	let url = "AllOrderServlet";
	fetch(url).then(res=>res.json()).then(res=>{
	data = res;
	console.log(data);	
	let j=0;
	 for(i = 0; i < data.length; i++){
		 if(data.length != 0){
		content+="<tr><td>"+ ++j + "</td><td>" + data[i].user.name + "<td>" + data[i].date + "</td>";
		content+= "<td>" + data[i].time + "</td><td>" + data[i].pizzaName + "</td>" ; 
		content+="<td>" + data[i].Quantity + "</td><td>" + data[i].price + "</td>";
		content+="<td>" + data[i].gstAmount + "</td><td>" + data[i].totalAmount + "</td>";
		content+="<td>" + data[i].deliveryDate + "</td><td>" + data[i].deliveryTime + "</td>";
		 } else{
				content+="<tr><td>" + "No Records Found" + "</td></tr>";
			}
			}
			$("#userTable tbody").append(content);
            //DataTable - pagination , sorting and searching
            $('#userTable').DataTable();
			/*document.querySelector("#booking").innerHTML= content;*/
	       });
	        });