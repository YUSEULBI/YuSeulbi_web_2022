//alert('js열림');

// 1. JS 열렸을때

// 2. 특정 행동[이벤트] 있을 때 코드집합소[함수] 실행
function ex1(){ // 함수 정의
	// 변수10개 ----> 객체{ }1개
	let info = {
		data1 : document.querySelector('.data1').value ,
		data2 : document.querySelector('.data2').value ,
		data3 : document.querySelector('.data3').value ,
		data4 : document.querySelector('.data4').value ,
		data5 : document.querySelector('.data5').value ,
		data6 : document.querySelector('.data6').value ,
		data7 : document.querySelector('input[name="data7"]:checked').value , // radio에서 선택된 버튼의 valu
		data8 : document.querySelector('.data8').checked , // check여부 [true/false]
		data9 : document.querySelector('.data9').value ,
		data10 : document.querySelector('.data10').value 
	}
	//console.log(info); // data7 외에 모두 문자열 -> 추후 형변환
	
	// 비동기 통신
	$.ajax({ 
         url : "/jspweb/Ex2" , 		// 주소 [ /프로젝트명/서블릿주소 --> 서블릿파일에 @WebServlet("/Ex2")] 
         method : "post" , 		// 메소드방식 [ doGet doPost]
         data : info  , 	// 보낼 데이터 [객체 vs {}]
         success : function( result ){ // 받을데이터
            alert('통신');
            console.log(result);
            if ( result == 'true'){ //문자열 true를 받음
				alert('등록성공');
				getData();
				
			}else{
				alert('등록실패');
			}
         }
    });
}// function end

getData();
function getData(){
	
	$.ajax({
		url : "/jspweb/Ex2" ,
		method : "get" ,
		success : function(result){
			//console.log(result);
			//document.querySelector('.ex1_box').innerHTML = result;
			let html = `<table border='1'>
							<tr>
								<th> data1 </th> <th> data2 </th> <th> data3 </th>
								<th> data4 </th> <th> data5 </th> <th> data6 </th>
								<th> data7 </th> <th> data8 </th> <th> data9 </th> <th> data10 </th>
								
							</tr>
						`
			result.forEach( (o,i)=>{ // 객체명.forEach( (반복변수,반복인덱스) => {실행문} )
				html += `
						<tr>
								<th> ${o.data1} </th> <th> ${o.data2} </th> <th> ${o.data3} </th>
								<th> ${o.data4} </th> <th> ${o.data5} </th> <th> ${o.data6} </th>
								<th> ${o.data7} </th> <th> ${o.data8} </th> <th> ${o.data9} </th> <th> ${o.data10} </th>
								
						</tr>
				
						`
			} )// end
			html += '</table>'
			document.querySelector(".ex1_box").innerHTML = html;
		}
	});	
		
}


function q1(){
	let data = {
		q1 : document.querySelector('.q1').value ,
		q2 : document.querySelector('.q2').value ,
		q3 : document.querySelector('.q3').value ,
		q4 : document.querySelector('.q4').value ,
		q5 : document.querySelector('.q5').value ,
		q6 : document.querySelector('input[name="q6"]:checked').value ,
		q7 : document.querySelector('.q7').checked ,
		q8 : document.querySelector('.q8').value ,
		q9 : document.querySelector('.q9').value , 
	}
	//console.log(data);
	
	$.ajax({
		url : "/jspweb/Q2" ,
		method : "post" ,
		data : data ,
		success : function ( result ){
			alert('통신')
			if ( result == 'true' ){
				alert('등록성공');
				q2();			
			}else{
				alert('등록실패');
			}
		}
	});
}

q2();
function q2(){
	console.log('q2실행')
	
	$.ajax({
		url : "/jspweb/Q2" ,
		method : "get" ,
		success : function(result){
			console.log(result);
			let html = `<table border='1'>
							<tr>
								<th> 이름 </th><th> 전화번호 </th><th> 키 </th>
								<th> 나이 </th><th> 등록일 </th><th> 성별 </th>
								<th> 개인정보동의 </th><th> 사는지역 </th><th> 자기소개 </th>
							</tr>
						`
			result.forEach( (o,i)=>{
				html +=`
							<tr>
								<th> ${o.name} </th><th> ${o.phone} </th><th> ${o.height} </th>
								<th> ${o.age} </th><th> ${o.registDate} </th><th> ${o.manwoman} </th>
								<th> ${o.privacy} </th><th> ${o.region} </th><th> ${o.introduce} </th>
							</tr>
						`
			} )
			html += '</table>'
			document.querySelector('.q2_box').innerHTML = html;
		}
	});
}


