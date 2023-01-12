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
5를입력
if(i%2==1)
5*2-i[1]=9
5*2-i[2]=9
				 

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
for(let i = 1 ; i <= line6 ; i++ ) {
	//공백
	for(let b = 1 ; b<=i-1 ; b++ ){
		output+=' '
	}
	for(let s = 1 ; s<=line6*2-i*2+1 ; s++ ){
		output+= '*'
	}
	output+='\n'
}
console.log(output)






