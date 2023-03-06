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
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value = ''; 
				onread();
			}else{alert('등록실패');}
		}
	})
}

onread();
function onread(){
	console.log('onread 실행')
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "get" ,
		success : ( r )=>{
			console.log('get 응답성공');
			console.log(r);
			let html = `<table border='1'>
							<tr>
								<th>글번호</th> <th>내용</th> <th>작성자</th> <th>작성시간</th> <th>비고</th>
							</tr>
						`
			r.forEach( (o,i) => {
				html += `
						<tr>
							<td>${o.bno}</td> <td>${o.bcontent}</td> <td>${o.bwriter}</td> 
							<td>${o.bdate}</td> 
							<td> 
								<button onclick="onupdate(${o.bno})" type="button"> 수정 </button>
								<button onclick="ondelete(${o.bno})" type="button"> 삭제 </button>
							</td> 
						</tr>
						`
			})
			html += `</table>`
			document.querySelector('.result_box').innerHTML = html;
		}
	});
}

function ondelete( bno ){
	console.log('ondelete 실행')
	console.log(bno);
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "delete" ,
		data : { "bno" : bno } ,
		success : ( r )=>{
			console.log('ondelete응답성공')
			console.log(r)
			if ( r == 'true' ){ alert('삭제성공');
				onread();
			}else{alert('삭제실패');}
		}
	});
}


function onupdate( bno ){
	console.log('onupdate 실행');
	console.log(bno);
	let newContent = prompt('수정할 내용');
	console.log ( newContent);
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "put" ,
		data : {"bno":bno , "newContent":newContent} ,
		success : ( r ) => {
			console.log('put응답성공')
			console.log(r)
			console.log(r)
			if ( r == 'true' ){ alert('수정성공');
				onread();
			}else{alert('수정실패');}
		}
	});
}

// -------------------------------------------------------

function onProduct(){
	console.log('onProduct 실행')
	let info = {
	pname : document.querySelector('.pname').value ,
	pprice : document.querySelector('.pprice').value
	}
	console.log(info);
	$.ajax({
		url : "/jspweb/Q3",
		method : "post" ,
		data : info ,
		success : (r) =>{
			console.log('post 응답성공')
			console.log(r)
			if ( r == 'true'){
				alert('등록성공');
				onP_Print();
				
			}else{alert('등록실패')}
			
		}
	})
	
}

onP_Print();
function onP_Print(){
	console.log('onP_Print 실행')
	$.ajax({
		url : "/jspweb/Q3",
		method : "get" ,
		success : ( r ) => {
			console.log('get 응답성공')
			console.log(r)
			html = `
					<tr>
						<th>제품번호</th> <th>제품명</th> <th>제품가격</th> <th>비고</th>
					</tr>
					`
			r.forEach( (o,i) => {
				html += `
						<tr>
							<td>${o.pno}</td> <td>${o.pname}</td> <td>${o.pprice.toLocaleString()}원</td>
							<td>
								<button onclick="pupdate(${o.pno})" type="button"> 수정 </button>
								<button onclick="pdelete(${o.pno})" type="button"> 삭제 </button>
							</td>
						</tr>
						`
			}) // forEach end
			
			document.querySelector('.product_Box').innerHTML = html;
		}
	})
}

function pupdate ( pno ){
	console.log('pupdate 실행');
	console.log('pno : '+ pno);
	let newPname = prompt('수정할 제품명');
	let newPprice = prompt('수정할 제품가격');
	$.ajax({
		url : "/jspweb/Q3" ,
		method : "put" ,
		data : { "pno" : pno , "newPname" : newPname , "newPprice" : newPprice} ,
		success : (r ) =>{
			console.log('update응답성공')
			if ( r == 'true' ){ alert('수정성공');
				onP_Print();
			}else{alert('수정실패');}
		}
	})
}

function pdelete( pno ){
	console.log('pdelete 실행');
	console.log('pno : '+ pno);
	$.ajax({
		url : "/jspweb/Q3" ,
		method : "delete" ,
		data : {"pno" : pno} ,
		success : ( r )=>{
			console.log('delete응답성공')
			console.log(r)
			if ( r == 'true' ){ alert('삭제성공');
				onP_Print();
			}else{alert('삭제실패');}
		}
	})
}