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
	console.log(info); // data7 외에 모두 문자열 -> 추후 형변환
	
	// 비동기 통신
	$.ajax({ 
         url : "/jspweb/Ex2" , 		// 주소 [ /프로젝트명/서블릿주소 --> 서블릿파일에 @WebServlet("/Ex2")] 
         method : "post" , 		// 메소드방식 [ doGet doPost]
         data : info  , 	// 보낼 데이터 [객체 vs {}]
         success : function( result ){ // 받을데이터
            alert('통신');
            console.log(result);
            if ( result == 'true'){
				alert('등록성공');
			}else{
				alert('등록실패');
			}
         }
    });
}
