// 모달띄우기
function modal_open(){
	document.querySelector('.modal_wrap').style.display = 'flex';
}

// 모달취소버튼
document.querySelector('.modal_close').addEventListener('click',(e)=>{
	document.querySelector('.modal_wrap').style.display = 'none';
})