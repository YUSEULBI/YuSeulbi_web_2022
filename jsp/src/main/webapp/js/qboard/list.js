console.log('js실행')

//객체 : 번호 , 제목 , 작성자 , 작성일 , 조회수 , 문의상태 [접수/완료] , 처리일

let qboardList = [
	{ no: 5 , title: '문의사항5' , writer: '유재석' , date: '2023-01-30' , view: 100 , state: '접수' , complete: '2023-01-30' } ,
	{ no: 4 , title: '문의사항4' , writer: '강호동' , date: '2023-01-29' , view: 123 , state: '완료' , complete: '2023-01-30' } ,
	{ no: 3 , title: '문의사항3' , writer: '신동엽' , date: '2023-01-29' , view: 456 , state: '완료' , complete: '2023-01-30' } ,
	{ no: 2 , title: '문의사항2' , writer: '서장훈' , date: '2023-01-28' , view: 789 , state: '완료' , complete: '2023-01-30' } ,
	{ no: 1 , title: '문의사항1' , writer: '김성주' , date: '2023-01-27' , view: 654 , state: '완료' , complete: '2023-01-30' }
	
]

qboard_print();

function qboard_print(){
	let html = ''
	for ( i = 0 ; i < qboardList.length ; i++ ){
		html += 
			`
			<tr>
				<td>${qboardList[i].no}</td> 
				<td><a href="/jsp/qboard/view.html">${qboardList[i].title}</a></td> 
				<td>${qboardList[i].writer}</td> 
				<td>${qboardList[i].date}</tD> 
				<td>${qboardList[i].view}</tD> 
				<td>${qboardList[i].state}</td> 
				<td>${qboardList[i].complete}</td>
			</tr>
			`
	}
	document.querySelector('.qTbody').innerHTML = html;
}