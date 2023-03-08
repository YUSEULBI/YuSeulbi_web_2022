
console.log('infojs 열림')

getMemberList();
function getMemberList(){
	console.log('getMemberList 실행')
	
	$.ajax({
		url: "/jspweb/pppmember",
		method: "get",
		success:(r)=>{
			console.log("ajax응답")
		 	console.log(r)
		 	html = `<tr>
		 				<th>번호</th> <th>프로필</th> <th>아이디</th> <th>비번</th>
		 			</tr>
		 			`
		 	r.forEach((o,i)=>{
				 html += `<tr>
		 						<th>${o.mno}</th> 
		 						<th><img src="/jspweb/practice/signupadmin/mimg/${o.mimg == null ? 'default.webp' : o.mimg}"></th> 
		 						<th>${o.mid}</th>  
		 						<th>${o.memail}</th> 
		 					</tr>
		 					`
			 })
		 	document.querySelector('.memberTable').innerHTML =  html;
		}
		
	})
	
}