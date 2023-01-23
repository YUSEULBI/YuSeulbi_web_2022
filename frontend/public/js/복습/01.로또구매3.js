
console.log('js실행')
function buyBtn(){
	let html = '' 
	for ( let i = 1 ; i <= 45 ; i++ ){
		html += `<button onclick="selectBtn(${i})"> ${i} </button>`
		if ( i % 5 == 0 ){ html += `<br>`	}
	}
	document.querySelector('.btnsDiv').innerHTML = html
	document.querySelector('.cancelClass').style.display ='inline'
}

let selectArray = [ ]

function cancelF(){
	document.querySelector('.btnsDiv').innerHTML = ''
	document.querySelector('.cancelClass').style.display ='none'
	selectArray.splice(0);
	document.querySelector('.selectBox').innerHTML = selectArray
	numbers.splice(0);
	document.querySelector('.comN').innerHTML = numbers
	
	drawBtnTest()
}

function selectBtn(i){
	if ( selectArray.indexOf(i) >= 0 ){
		alert('이미 선택한 번호입니다.')
		selectArray.splice( selectArray.indexOf(i) , 1);
		console.log('선택번호배열'+ selectArray)
		document.querySelector('.selectBox').innerHTML = selectArray
		drawBtnTest()
		return;
	}
	if ( selectArray.length == 6 ){
		alert('이미 6개의 번호를 모두 선택했습니다.')
		return;
	}
	selectArray.push(i);
	document.querySelector('.selectBox').innerHTML = selectArray
	drawBtnTest()
}

function drawBtnTest(){
	if ( selectArray.length == 6 ){
		document.querySelector('.drawClass').style.display = 'inline'
	}else{		
		document.querySelector('.drawClass').style.display = 'none'
	}
}

let numbers = []
function drawingBtn(){
	
	for ( let i = 1 ; i <= 6 ; i++){
		let num = parseInt(Math.random()*45+1 )
		if ( numbers.indexOf(num) >= 0 ){
			i--
		}else { 
			numbers.push(num)
			console.log('selectArray : '+selectArray)
			console.log('6개추첨숫자배열'+numbers)
			document.querySelector('.comN').innerHTML = numbers
			 
		}
	}
	let count = 0;
	for ( let i = 0 ; i < selectArray.length ; i++ ){
		if ( numbers.indexOf(selectArray[i])>=0 ){
				count++
				
			
		}
	}
	  	
	document.querySelector('.result').innerHTML = count+'개 맞췄습니다'
	document.querySelector('.drawClass').style.display = 'none'
	
}