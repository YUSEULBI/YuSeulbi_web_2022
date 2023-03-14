let eno = 0;
function openModal(selecteno){
   document.querySelector('.updatemodal').style.display = 'flex';
   eno = selecteno;
   $.ajax({
	   url : "/jspweb/getUpdate",
		method : "get",
		data : {"eno" : eno} ,
		success : (r) => {
			console.log('통신')
			console.log(r)
			document.querySelector( '.chname' ).value = r.ename;
			document.querySelector( '.chrank' ).value = r.erank;
			document.querySelector( '.chtype' ).value = r.etype;
			document.querySelector( '.chdept' ).value = r.dept;
			document.querySelector( '.picpreview' ).src = `/jspweb/practice/과제1/img/${r.epic == null ? 'default.webp' : r.epic }`
			
			
			document.querySelector( '.chrdept' ).value = r.rdept;
			document.querySelector( '.dedate' ).value = r.dedate;
			document.querySelector( '.dereason' ).value = r.dereason;
		}
   })
}


function dopenModal(selecteno){
   document.querySelector('.deletemodal').style.display = 'flex';
   eno = selecteno;
   
}


function closeModal(){
   document.querySelector('.updatemodal').style.display = 'none';
   document.querySelector('.deletemodal').style.display = 'none';
   
}

function picpreview(object){
	console.log('새첨부파일 : ' + object);
	
	let file = new FileReader();
	file.readAsDataURL( object.files[0]);
	file.onload = (e)=>{
		document.querySelector('.picpreview').src=e.target.result;
	}
}






