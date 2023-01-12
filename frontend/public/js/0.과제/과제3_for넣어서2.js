

let contentArray = [ ]

function addContent(){
	let table = ' <tr> <th> 번호 </th> <th> 방문록 </th> </tr> '
	contentArray.push(document.querySelector('.textBox').value)
	//contentArray배열에 HTML 클래스.textBox의 value를 넣는다.
	
	for( let 번호 = 1 ; 번호 <= contentArray.length ; 번호++)
		// 번호를 선언, 번호 초기값은 1이고, 배열의 길이와 같거나 크지않고 , 1씩 증가한다.
	{ table +=  //테이블에 추가한다.
		' <tr> <th> '+ 번호 +' </th> <th>' + contentArray[번호-1] + '</th> </tr> '
		// 첫번째 열에 선언한 번호 추가 , 
		// 두번째 열에 배열의 인덱스 번호에 해당하는 데이터 호출 
		// (인덱스번호는 '번호'-1)
		
	}
	document.querySelector('.vTable').innerHTML = table
	
	
	
	}