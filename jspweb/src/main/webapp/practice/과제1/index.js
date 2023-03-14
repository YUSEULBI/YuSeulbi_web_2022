console.log('js실행')

function signupbtn(){
		
		let ename = document.querySelector('.ename').value;
		let edate = document.querySelector('.edate').value;
		console.log("edate :"+edate)
		if( ename=="" ){ alert('사원명을 입력하세요.') }
		else if( edate=="" ){ alert('입사일을 입력하세요.') }
		else{
		
			console.log('버튼실행')
			let form = document.querySelectorAll('.form')[0]
			let formData = new FormData(form);
			console.log(formData)
			
			$.ajax({
				url : "/jspweb/employee",
				method : "post",
				data : formData ,
				contentType : false ,      // true : 매개변수형식{파라미터}의 문자열타입[기본값] 
		                              // form-urlencoded 형식으로 전송
		                           // false : 해제
		                               // multipart/form 형식으로 전송    
		     	processData : false ,  
				success : (r)=>{
					console.log('통신')
					console.log(r)
					if ( r == 'true'){
						alert('인사등록성공')
						allprint();
					}else{
						alert('인사등록실패')
					}
				}
			})
		}
}


// 전체출력버튼
function allprint(){
	employee_table();
}

// 퇴사자 출력버튼
function deprint(){
	console.log('deprint 실행')
	$.ajax({
		url : "/jspweb/print" ,
		method : "get",
		success: (r)=>{
			console.log('통신')
			console.log(r)
			let html =	`<tr>
							<th>사번</th> <th>이름</th> <th>직급</th> 
							<th>고용형태</th> <th>소속부서</th> <th>입사일</th> 
							<th>프로필사진</th> <th>담당부서</th> <th>퇴사일</th> <th>퇴사사유</th> <th>비고</th>
						</tr>`
			r.forEach((o,i)=>{
				html += `
						<tr>
							<td>${o.eno}</td> <td>${o.ename}</td> <td>${o.erank}</td> 
							<td>${o.etype}</td> <td>${o.dept}</td> <td>${o.edate}</td> 
							<td>
								<img src="/jspweb/practice/과제1/img/${o.epic == null ? 'default.webp' : o.epic }" width="50%">
							</td> 
							<td>${o.rdept}</td> <td>${o.dedate}</td> <td>${o.dereason}</td>
							<td>
								<button onclick="openModal(${o.eno})" type="button">수정</button>
								<button onclick="dopenModal(${o.eno})" type="button">삭제</button>
							</td> 
						</tr>
						`
			});
			document.querySelector('.employee_table').innerHTML = html;s
		}
	})
}

// 근무자 출력버튼
function workprint(){
	console.log('workprint 실행')
	$.ajax({
		url : "/jspweb/wprint" ,
		method : "get",
		success: (r)=>{
			console.log('통신')
			console.log(r)
			let html =	`<tr>
							<th>사번</th> <th>이름</th> <th>직급</th> 
							<th>고용형태</th> <th>소속부서</th> <th>입사일</th> 
							<th>프로필사진</th> <th>담당부서</th> <th>비고</th>
						</tr>`
			r.forEach((o,i)=>{
				html += `
						<tr>
							<td>${o.eno}</td> <td>${o.ename}</td> <td>${o.erank}</td> 
							<td>${o.etype}</td> <td>${o.dept}</td> <td>${o.edate}</td> 
							<td>
								<img src="/jspweb/practice/과제1/img/${o.epic == null ? 'default.webp' : o.epic }" width="50%">
							</td> 
							<td>${o.rdept}</td> 
							<td>
								<button onclick="openModal(${o.eno})" type="button">수정</button>
								<button onclick="dopenModal(${o.eno})" type="button">삭제</button>
							</td> 
						</tr>
						`
			});
			document.querySelector('.employee_table').innerHTML = html;
		}
	})
}

allprint();
// 전체출력함수
function allprint(){
	console.log('employee_table 실행')
	$.ajax({
		url : "/jspweb/employee",
		method : "get",
		success : (r)=>{
			console.log('통신')
			console.log(r)
			let html = `<tr>
							<th>사번</th> <th>이름</th> <th>직급</th> 
							<th>고용형태</th> <th>소속부서</th> <th>입사일</th> 
							<th>프로필사진</th> <th>담당부서</th> <th>퇴사일</th> <th>퇴사사유</th> <th>비고</th>
						</tr>
						`	
			r.forEach((o,i)=>{
				html += `<tr>
							<td>${o.eno}</td> <td>${o.ename}</td> <td>${o.erank}</td> 
							<td>${o.etype}</td> <td>${o.dept}</td> <td>${o.edate}</td> 
							<td>
								<img src="/jspweb/practice/과제1/img/${o.epic == null ? 'default.webp' : o.epic }" width="50%">
							</td> 
							<td>${o.rdept}</td> <td>${o.dedate}</td> <td>${o.dereason}</td> 
							<td>
								<button onclick="openModal(${o.eno})" type="button">수정</button>
								<button onclick="dopenModal(${o.eno})" type="button">삭제</button>
							</td> 
						</tr>
						`	
			});
			document.querySelector('.employee_table').innerHTML = html;
			
		}
	})
}



// 사원수정
function updatebtn(){
	console.log('버튼실행')
	let updateform = document.querySelectorAll('.updateform')[0]
	let formData = new FormData(updateform);
	formData.set("eno",eno);
	console.log(formData)
	
	//let defaultimg = document.querySelector('.defaultimg').checked
	//updateFormData.set( "defaultimg" , defaultimg );
	
	
	$.ajax({
		url : "/jspweb/employee",
		method : "put",
		data : formData ,
		contentType : false ,    
     	processData : false ,  
		success : (r)=>{
			console.log('통신')
			console.log(r)
			if ( r == 'true'){
				alert('수정성공')
				document.querySelector( '.chname' ).value = '';
				document.querySelector( '.chrank' ).value = '';
				document.querySelector( '.chtype' ).value = '';
				document.querySelector( '.chdept' ).value = '';
				//document.querySelector( '.chepic' ).value = r.epic;
				document.querySelector( '.chrdept' ).value = '';
				document.querySelector( '.dedate' ).value = '';
				document.querySelector( '.dereason' ).value = '';
				closeModal();
				allprint();
				
			}else{
				alert('수정실패')
			}
		}
	})
}

//직원 삭제
function deleteEmploye(){
	let input_eno = document.querySelector('.input_eno').value
	if ( input_eno == eno ){
		$.ajax({
			url : "/jspweb/employee",
			method : "delete",
			data : {"eno":eno} ,
			success : (r)=>{
				console.log('통신')	
				console.log(r)	
				if ( r == 'true'){
					alert('삭제성공')
					closeModal();
					allprint();
				}else{
					alert('삭제실패')
				}
			}
		})
	}else{
		alert('사번이 틀렸습니다.')
	}
}	

// 검색
function searchEm(){
	let findEm = document.querySelector('.findEm').value;
	$.ajax({
			url : "/jspweb/searchEm",
			method : "get",
			data : {"findEm":findEm} ,
			success : (r)=>{
				console.log('통신')	
				console.log(r)
				if ( r == null ){
					allprint();
					document.querySelector('.searchnull').innerHTML = '결과값이 없습니다ㅠㅠ'
				}else{
					let html = `<tr>
								<th>사번</th> <th>이름</th> <th>직급</th> 
								<th>고용형태</th> <th>소속부서</th> <th>입사일</th> 
								<th>프로필사진</th> <th>담당부서</th> <th>퇴사일</th> <th>퇴사사유</th> <th>비고</th>
								</tr>
								`	
					r.forEach((o,i)=>{
						html += `<tr>
									<td>${o.eno}</td> <td>${o.ename}</td> <td>${o.erank}</td> 
									<td>${o.etype}</td> <td>${o.dept}</td> <td>${o.edate}</td> 
									<td>
										<img src="/jspweb/practice/과제1/img/${o.epic == null ? 'default.webp' : o.epic }" width="50%">
									</td> 
									<td>${o.rdept}</td> <td>${o.dedate}</td> <td>${o.dereason}</td> 
									<td>
										<button onclick="openModal(${o.eno})" type="button">수정</button>
										<button onclick="dopenModal(${o.eno})" type="button">삭제</button>
									</td> 
								</tr>
								`	
					});
					document.querySelector('.employee_table').innerHTML = html;
					document.querySelector('.searchnull').innerHTML =  ''
					document.querySelector('.findEm').value = '';
				}
			}
		})
		
		
		
}
