console.log('info JS 열림')

console.log(memberInfo)
// 1. header.js 에서 ajax 동기식으로 회원정보 가져온 상태 [memberInfo]
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.memail').innerHTML = memberInfo.memail;
document.querySelector('.mimg').src = `/jspweb/member/pimg/${memberInfo.mimg == null ? 'default.webp' : memberInfo.mimg}` ;
document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;