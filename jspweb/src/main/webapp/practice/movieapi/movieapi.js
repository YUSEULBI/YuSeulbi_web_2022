/**
 * 
 */
console.log('movieapi 실행')

 $.ajax({
	 url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=e4bef537aa0ae3d7f267d6c813f6cbf3&targetDt=20230322",
	 method : "get" ,
	 success : (r)=>{
		 console.log(r)
		 console.log(r.boxOfficeResult.dailyBoxOfficeList)
		 html = `<tr>
		 			<th>누적관객수</th>
		 		</tr>`
		 r.boxOfficeResult.dailyBoxOfficeList.forEach((o,i)=>{
			 html += `
			 		<tr>
			 			<td>${o.audiAcc}</td>
			 		</tr>
			 		`
			 
		 })
		 document.querySelector('.movietable').innerHTML = html;
		 
	 }
	 
 })