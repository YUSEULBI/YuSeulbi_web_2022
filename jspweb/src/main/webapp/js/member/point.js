let pay= 0;
function setpay( p ){
	pay = p;
	alert('결제금액 선택')
}

// 포트원 가맹점 [관리자회원] 식별번호
var IMP = window.IMP; 
IMP.init("imp76160122"); 
    
function requestPay() {
	if ( pay == 0 ){
		alert('결제금액 선택하세요')
		return;
	}
    IMP.request_pay({
        pg : 'kakaopay',
	    pay_method : 'card', //생략 가능
	    merchant_uid: "order_no_0001", // 상점에서 관리하는 주문 번호
	    name : '주문명:결제테스트',
	    amount : pay,
	    buyer_email : 'iamport@siot.do',
	    buyer_name : '구매자이름',
	    buyer_tel : '010-1234-5678',
	    buyer_addr : '서울특별시 강남구 삼성동',
	    buyer_postcode : '123-456'
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
        } else {
            console.log(rsp);
            // 결제취소가 결제성공이라고 가정
            let	info = { 
				mpcomment : '포인트충전' ,
				mpamount : pay ,
				mno : memberInfo.mno
			}
			
			$.ajax({
				url : "/jspweb/point" ,
				data : info , 
				method : "post" ,
				success : (r)=>{
					if ( r == 'true' ){
						alert('포인트충전완료')
					}
				}
			})
        }
    });
}



/*------------------------------------------------------- */

