/*
	-출력
		1. 콘솔에 출력 : console.log( )
		2. 알람메시지 출력 : alert()
		3. html 출력 : 
				1. document.write( ) 
				2. document.querySelector( ).innerHTML // 특정부분에 출력
	-입력
		1. 알람메시지 입력 : prompt( )
		2. html 입력 : document.querySelector().value 
		 
*/
/*let output = '' //출력 변수
// 예시1) 입력받은 수 만큼 * 출력
let s1 = Number( prompt(' 예시1 별 개수 ') )
for( let i = 1 ; i<=s1 ; i++ ){ // for s
	// i는 1부터 입력받은 수 까지 1씩 증가 반복
	output += '*' // = : 대입[기존데이터 없어짐] / =+ : 누적대입[기존데이터에 추가]
	//1씩 증가할 때마다 output이 *이 하나씩 추가됨
}// for e

console.log( output )*/


/*
	만약에 5를 입력했을 때 s1 = 5
	
	for( let i = 1 ; i<=s1 ; i++ )
	
		i			조건[i<=s1]				실행문				[output]				증감식
	i = 1일때 		1<=5 			T		output += '*'		output = '*'			i++
	i = 2일때 		2<=5 			T		output += '*'		output = '**'			i++
	i = 3일때 		3<=5 			T		output += '*'		output = '***'			i++
	i = 4일때 		4<=5 			T		output += '*'		output = '****'			i++
	i = 5일때 		4<=5 			T		output += '*'		output = '*****'		i++
	i = 6일때 		6<=5 			F		실행안됨
	
*/


//예시2) 입력받은 수 만큼 * 출력 [ 3줄마다(3의배수마다) 줄바꿈 ]
/*output = ''  // 앞전에서 사용한 output 변수를 다시 '' 공백으로 // let 다시쓰지 말기 선언은 처음에 한번만
let s2 = Number(prompt('예시2 별 개수 '))
for (let i = 1 ; i<=s2 ; i++ ){ // for s
	//1. 별출력
	output += '*'
	//2. 줄바꿈 출력
	if( i % 3 == 0 ) {output += '\n'}
}// for e

console.log( output )*/

/*
	만약에 5를 입력했을 때 s2 = 5
	output = '' 깡통
	for (let i = 1 ; i<=s2 ; i++ ){}
	if( i % 3 == 0 ) {output += '\n'}
	
		i			조건[i<=s1]				실행문			조건1[i%3==0]			[output]				증감식
	i = 1일때 		1<=5 			T		output += '*'	1%3==1				output = '*'				i++
	i = 2일때 		2<=5 			T		output += '*'	2%3==2				output = '**'				i++
//	i = 3일때 		3<=5 			T		output += '*'	3%3==0				output = '***\n'			i++
	i = 4일때 		4<=5 			T		output += '*'	4%3==1				output = '***\n*'			i++
	i = 5일때 		4<=5 			T		output += '*'	5%3==2				output = '***\n**'			i++
	i = 6일때 		6<=5 			F		실행안됨

*/


//문제1)

	/*
		i line \n출력			s [star]
*		1						s = 1
**		2						s = 1 2
***		3						s = 1 2 3
****	4						s = 1 2 3 4
*****	5						s = 1 2 3 4 5
		i는 1부터 입력받은 수까지 1씩 증가 = for ( let i = 1 ; i <= line ; i++ )
		-s는 1부터 1까지
		-s는 1부터 2까지
		-s는 1부터 3까지
		-s는 1부터 4까지
		-s는 1부터 5까지
		-s는 1부터 i까지					= for ( let s = 1 ; s<=i ; s++ )
		
	*/
	
//문제1)

output = ''
let line = Number(prompt('문제1 줄수'))
for (let i =1 ; i<=line ; i++ ){
	// i는 1부터 입력값까지 1씩 증가할 때마다
	for( let s = 1 ; s<=i ; s++ ){ //1. 별찍기
		// s는 1부터 i까지 1씩 증가할때마다
		output += '*' // *추가
	} //for e
	
	output += '\n'
} //for e

console.log(output)


/*
	
	입력값이 3 
	
	i = 1일떄			첫번재 줄 
		s = 1일때			* 
	i = 2 일때		\n 두번째 줄 
		s = 1일때			*
		s = 2일때			*
	i = 3 일때		\n 세번째 줄 
		s = 1일떄			*
		s = 2일때			*
		s = 3일때			*
		
		*
		**
		***
		
*/


//문제2)

	/*
		i line \n출력			s [star]			
*****		1				s = 1 2 3 4 5			입력받은 줄수 - 현재줄수 +1 [ 5 - 1 +1 = 5
****		2				s = 1 2 3 4				입력받은 줄수 - 현재줄수 +1 [ 5 - 2 +1 = 4
***			3				s = 1 2 3				입력받은 줄수 - 현재줄수 +1 [ 5 - 3 +1 = 3 
**			4				s = 1 2 				입력받은 줄수 - 현재줄수 +1 [ 5 - 4 +1 = 2 
*			5				s = 1					입력받은 줄수 - 현재줄수 +1 [ 5 - 5 +1 = 1
			i는 1부터 입력받은 수까지 1씩 증가 = for ( let i = 1 ; i <= line2 ; i++ )
			-s는 1부터  for (let s = 1; s<=line2-i+1 ; s++ )
			-s는 1부터 5까지
			-s는 1부터 4까지
			-s는 1부터 3까지			
			-s는 1부터 2까지
			-s는 1부터 1까지
	*/


output =''
let line2 = Number(prompt('문제2번 줄수'))
for ( let i = 1 ; i<=line2 ; i++ ){ // 줄마다 별 출력 / 줄마다 줄바꿈
		
		// 1. 별
		for( let s = 1 ; s<= line2-i+1 ; s++ ){
							
																				
			output += '*';
		}
		// 2. 줄바꿈
		output += '\n'
}

console.log( output )




//문제3)

	/*
		i line \n출력			b[공백]				s [star]			
    *		1				b = 1 2 3 4			s = 1
   **		2				b = 1 2 3			s = 1 2	
  ***		3				b = 1 2 			s = 1 2 3
 ****		4				b = 1				s = 1 2 3 4
*****		5				b = 				s = 1 2 3 4 5
			i는 1부터 입력받은 수까지 1씩 증가 = for ( let i = 1 ; i <= line2 ; i++ )
			b는 1부터 (입력받은줄-현재줄수)까지 1씩증가 = for ( let b = 1 ; b <=line3-i ; b++)
			s는 1부터 현재 줄수 까지 1씩 증가		= for ( let s = 1 ; s <=1 ; s++ )
			!!! 줄마다 공백과 별 줄바꿈 출력
			for (let i = 1 ; i<=line3 ; i++ ){ 
				for (let b = 1 ; b<=line3-i ; b++ ){}
				for (let s = 1 ; s<=i ; s++ ){ }
			}
	*/

//문제3 
output = ''
let line3 = Number( prompt('문제3 줄수 '))
for( let i = 1 ; i<=line3 ; i++ ){ // for s 
	// 1. 공백출력
	for( let b = 1 ; b <= line3-i ; b++ ){
		output += ' '
	}
	// 2. 별출력
	for( let s = 1 ; s <= i ; s++ ){
		output += '*'
	}
	// 3. 줄바꿈
	output += '\n'
} // for end 
console.log( output )


//문제4
output = ''
let line4 = Number(prompt('문제4번 줄수'))
for ( let i = 1 ; i <=line4 ; i++  ){ //줄수
	//공백
	for ( let b = 1 ; b <= i-1 ; b++){
		output +=' '
	}
	//별
	for ( let s = 1 ; s <= line4-i+1 ; s++ ){
		output += '*'
	}
	output += '\n'
}
console.log(output)
/*
		i line \n출력			b[공백]				s [star]			
*****		1				b = 				s = 1 2 3 4 5
 ****		2				b = 1				s = 1 2 3 4	
  ***		3				b = 1 2 			s = 1 2 3
   **		4				b = 1 2 3		    s = 1 2 
    *		5				b = 1 2 3 4			s = 1
			i는 1부터 입력받은 수까지 1씩 증가 = for ( let i = 1 ; i <= line2 ; i++ )
			현재줄수 - 1
			1 -1
			2 -1
			3 -1
			4 -1
			5- 1
			for ( let )
			b는 1부터 (입력받은줄-현재줄수)까지 1씩증가 = for ( let b = 1 ; b <=line3-i ; b++)
			s는 1부터 현재 줄수 까지 1씩 증가		= for ( let s = 1 ; s <=1 ; s++ )
			!!! 줄마다 공백과 별 줄바꿈 출력
			for (let i = 1 ; i<=line3 ; i++ ){ 
				for (let b = 1 ; b<=line3-i ; b++ ){}
				for (let s = 1 ; s<=i ; s++ ){ }
			}
	*/




/*
	만약 줄수가 3을 입력 
//	i = 1일때
		b = 1일때  b<=i-1 			1<=1-1 		F
		
		s = 1일때  s<=line4-i+1		1<=3-1+1  	T	output = '*'
		s = 2일때  s<=line4-i+1		2<=3-1+1  	T	output = '**'
		s = 3일때  s<=line4-i+1		3<=3-1+1  	T	output = '***'
		
		output = '/n'								output = '***\n'
		
	i = 2일때
//		b = 1일때 b<=i-1				1<=2-1		T	output = '***\n'
		b = 2일때 b<=i-1				2<=2-1		F
		
		s = 1일때  s<=line4-i+1		1<=3-2+1  	T	output = '*'
		s = 2일때  s<=line4-i+1		2<=3-2+1  	T	output = '**'
		s = 3일때  s<=line4-i+1		3<=3-2+1  	F
		
		output = '/n'
		
	i = 3일때
		b = 1일때 b<=i-1				1<=3-1		T	output = ' '
		b = 2일때 b<=i-1				2<=3-1		T	output = '  '
		b = 2일때 b<=i-1				3<=3-1		F
		
		s = 1일때  s<=line4-i+1		1<=3-3+1  	T	output = '*'
		s = 2일때  s<=line4-i+1		2<=3-3+1  	F
		
		output = '/n'
*/


// 문제5
/*				i		b공백				s별
    *			i=1		b= 1 2 3 4		s = 1
   ***			i=2		b= 1 2 3		s = 1 2 3
  *****			i=3		b= 1 2			s = 1 2 3 4 5
 *******		i=4		b= 1			s = 1 2 3 4 5 6 7
*********		i=5		b= 				s = 1 2 3 4 5 6 7 8 9

				b는 1부터 (입력받은줄수-현재줄수) for(let b = 1 ; b<=line5-i ; b++ )
				s는 1부터 (현재줄수*2-1)까지 1씩증가	= for (let s=1 ; s<=i*2-1 ; s++ ) 
					1부터 1
					1부터 3	+2
					1부터 5	+2
					1부터 7	+2
					1부터 9	+2
					
					1부터 i 	i*2
					1부터 1	2까지
					1부터 2	4까지
					1부터 3	6까지
					1부터 4	8까지
					1부터 5	10까지
					
					1부터 i 	i*2-1
					1부터 1	1까지
					1부터 2	3까지
					1부터 3	5까지
					1부터 4	7까지
					1부터 5	9까지

*/

output=''
let line5 = Number(prompt('문제5 줄수'))
for( let i = 1 ; i<=line5 ; i++ ){
	// i는 1부터 입력값까지 1씩 증가 반복
	//공백
	for( let b = 1 ; b<=line5-i ; b++ ){
		output += ' '
		//i가 1일때 b는 1부터 입력값-1(i)까지 1씩 증가반복
		//i가 2일때 3일때... 입력값일때 까지 b반복
	}
	
	//별
	for( let s = 1 ; s<=i*2-1 ; s++ ){
		output += '*'
	}
	
	output+= '\n'
}
console.log(output)


//6. 입력받은 홀수 줄수[line] 만큼 출력 예시 

/*

6. 입력받은 홀수 줄수[line] 만큼 출력 예시 ) 7
					i		s별
*          *		1		
  *      *			2		
    *  *			3		
      *				4		
    *   *			5		
  *       *			6		
*           *		7		

*/

output = ''
let 입력값 = Number(prompt('X자문제 홀수'))
for( let i = 1 ; i <= 입력값 ; i++){
	for(let j = 1 ; j <= 입력값 ; j++ ){
		if( i == j || i == 입력값-j+1){
			output += '*'
		}else{
			output += ' '
		}
			
	}
	output += '\n'
}
console.log(output)

//과제1

/*				i		b공백				s별
    *			1		1 2 3 4			1							
   ***			2		1 2 3			3
  *****			3		1 2				5
 *******		4		1				7
*********		5						9

*********		1						9
 *******		2		1				7
  *****			3		1 2				5
   ***			4		1 2 3			3
    *			5		1 2 3 4 		1

				 

*/

output=''
let line6 = Number(prompt('과제1입력'))
for(let i = 1 ; i <= line6 ; i++ ) {
	//공백
	for(let b = 1 ; b<=line6-i ; b++ ){
		output+=' '
	}
	for(let s = 1 ; s<=i*2-1 ; s++ ){
		output+= '*'
	}
	output+='\n'
}
console.log(output)


