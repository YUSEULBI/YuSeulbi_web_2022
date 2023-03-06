alert('JS열림')
//1/
function doPOST(){
	alert('http POST 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "post" ,
		success : ( result )=>{}
	})
}

// 2
function doGET(){
	alert('http GET 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "get" ,
		success : (result)=>{}
	})
}

// 3
function doPUT(){
	alert('http PUT 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "put" ,
		success : (result)=>{}
	})
}

// 4
function doDELETE(){
	alert('http DELETE 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "delete",
		success : (result)=>{}
	})
}

//----------------------------------

function onwrite(){
	console.log('onwrite 실행')
	let info = {
		content : document.querySelector('.content').value ,
		writer : document.querySelector('.writer').value 
	}
	console.log(info)
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "post" ,
		data : info ,
		success : ( r )=>{
			console.log( 'post 응답성공' );
			if ( r == 'true' ){ alert('등록성공');
			}else{alert('등록실패');}
		}
	})
}



