console.log('setInterval.js실행')

function btnclick(){
	console.log('click함수 실행')
	let html = `
				<div class="timebox">02:00</div>
				`
	document.querySelector('.box').innerHTML = html;
	timer = 5;
	settimer();
}

let timer = 0;
function settimer(){
	console.log('settimer 실행')
	timerInterval = setInterval( ()=>{
		let minutes = parseInt(timer/60);
		let seconds = parseInt(timer%60);
		
		minutes = minutes<10 ? "0"+minutes : minutes;
		seconds = seconds<10 ? "0"+seconds : seconds;
		
		let timeHTML = minutes +":"+seconds;
		console.log(timeHTML);
		
		document.querySelector('.timebox').innerHTML = timeHTML;
		
		timer--;
		console.log(timer);
		
		if ( timer < 0 ){
			clearInterval(timerInterval);
			document.querySelector('.timebox').innerHTML = "";
		}
	} , 1000 );
}