console.log('js실행')

let btnList = [ null , null , null , null , null , null , null , null , null ]

function btn(number){
	let board = document.querySelectorAll('.btnClass')
	
	board[number-1].innerHTML = '0'
	btnList[number-1] = '0'
	console.log('btnList'+ btnList)
}