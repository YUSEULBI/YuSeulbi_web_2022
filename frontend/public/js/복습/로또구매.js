console.log('js실행')

let selectArray = [ ]


function firstBtn(){
	//로또구매하기 버튼을 누르면 함수 실행
	let html =  '';
	for ( let i = 1 ; i <= 45 ; i++ ){
		html += `<button onclick="buttonclick(${i})" > ${i} </button>`
		if ( i % 5 == 0 ){ html += '<br>' }
	}
	//document.querySelector('.cancelBtn').style.display = 'inline'
	document.querySelector('.cancelClass').style.display = 'inline'
	document.querySelector('.buttonsBox').innerHTML = html 
}

function cancelBtn(){
	document.querySelector('.buttonsBox').innerHTML = ''
	document.querySelector('.cancelClass').style.display = 'none'
	selectArray.splice(0);
	document.querySelector('.selectBox').innerHTML = selectArray
	parseIntArray.splice(0);
	document.querySelector('.drawBox').innerHTML = parseIntArray
	document.querySelector('.result').innerHTML = ''
	
}

function buttonclick (i){
	
	if ( selectArray.length == 6 ){
		alert('선택가능한 번호 개수는 6개 입니다. 선택실패.');
		return;
	}
	//if ( selectArray[i] == i ) //인덱스는 0부터 순차대로 만들어지기 때문에 잘못된코드
	if ( selectArray.indexOf(i) >= 0 ){
		alert('중복선택된 번호입니다. 선택실패.')
		return;
	}
	
	selectArray.push(i)
	document.querySelector('.selectBox').innerHTML = selectArray
	console.log('selectArray배열 : '+ selectArray)
	drawingTest()
	
}

function drawingTest(){
	if ( selectArray.length == 6  ){ 
		document.querySelector('.drawBtn').style.display = 'inline'
	}else { document.querySelector('.drawBtn').style.display = 'none'	}
}

parseIntArray = [ ]
function drawF(){
	
	for ( let i = 1 ; i <= 6 ; i++ ){
		let parseInt1 = parseInt(Math.random()*45+1)
		if ( parseIntArray.indexOf(parseInt1) >= 0 ){
			i--;
		}else{
			parseIntArray.push( parseInt1 )
			console.log(parseIntArray)
		}
		
	}
	
	document.querySelector('.drawBox').innerHTML = parseIntArray
	
	let winNum = 0;
	for ( let i = 0 ; i < selectArray.length ; i++  ){
		for ( let j = 0 ; j < parseIntArray.length ; j++ ){
			if ( selectArray[i] == parseIntArray[j] ){ 
				winNum ++
			}
			
		}
		
	}
	console.log('winNum : ' + winNum)
	if ( winNum == 6 ){ 
		document.querySelector('.result').innerHTML = '1등! (맞은개수6개)'
	}
	if ( winNum == 5 ){ 
		document.querySelector('.result').innerHTML = '2등! (맞은개수5개)'
	}
	if ( winNum == 4 ){ 
		document.querySelector('.result').innerHTML = '3등! (맞은개수4개)'
	}
	if ( winNum == 3 ){ 
		document.querySelector('.result').innerHTML = '4등! (맞은개수3개)'
	}
	if ( winNum == 2 ){ 
		document.querySelector('.result').innerHTML = '5등! (맞은개수 2개)'
	}
	if ( winNum == 1 ){ 
		document.querySelector('.result').innerHTML = '6등! (맞은개수 1개)'
	}
	if ( winNum == 0 ){ 
		document.querySelector('.result').innerHTML = '꽝! (맞은개수 0개)'
	}
	document.querySelector('.drawBtn').style.display = 'none'
}






