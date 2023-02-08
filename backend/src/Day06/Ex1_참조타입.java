package Day06; //패키지

public class Ex1_참조타입 { // 클래스 시작
	
	public static void main(String[] args) { // main s
		
		// [p148]
		
		// [ 스택영역에 변수 만들기 ]
		int[] arr1; // int형 배열 선언 
		int[] arr2; // int형 배열 선언
		int[] arr3; // int형 배열 선언
		
		arr1 = new int[] { 1 , 2 , 3 }; // [ 힙영역에 1,2,3 메모리 3개 만들기 ]
		arr2 = new int[] { 1 , 2 , 3 }; // [ 배열은 첫번째 메모리('1')주소를 스택영역에 대입 ]
		arr3 = arr2; 		// arr2가 가지고 있던 메모리주소를 arr3에 대입
		
		// == 을 써서 스택영역의 데이터를 비교 - 주소비교 (스택이 갖고있는 주소)
		//System.out.println( arr1 == arr2 ); // false 값이 같더라도 주소가 다름 메모리가 각각 생김
		//System.out.println( arr2 == arr3 ); // true 같은 주소 
		
		// [p151]
		// int[] inArray = null; 	// int형 배열 선언 [ 스택영역 변수 만들기 , 힙없음 ]
		//System.out.println( inArray[0] ); // 오류발생 : 집 , 주소가 없어서 호출이 안됨
		//inArray[0] = 10; // 오류발생 : 힙영역에 없기 때문에 저장불가능
		
		//String str = null;
		//System.out.println( str.length() ); // 힙영역에 데이터가 없기 때문에 힙영역의 길이확인은 불가능
		
		//[p153]
		String hobby = "여행"; 	// 스택영역에 hobby 이름으로 변수 선언하고 "여행" 힙의 메모리 주소 저장
		hobby = null;			// hobby변수의 null 변경하면 힙에 있던 "여행" 메모리는 제거
		String kind1 = "자동차";  // '자동차'힙의 메모리 32번지 주소만 스택 kind1에 저장 
		String kind2 = kind1;	// kind2는 kind1의 주소 대입 
		kind1 = null;			// kind1의 주소를 지움
		System.out.println(kind2);	// kind2는 주소를 갖고 있어서 자동차가 나옴
		
		
	} // main e
	
} // 클래스 끝


/*
 
 	스택영역 				힙영역
 	arr1 <---주소대입----	new int[] { 1 , 2 , 3 };
 	arr2 <---주소대입----	new int[] { 1 , 2 , 3 };
 	arr3
 	
 	*new : 힙영역에 메모리 생성하는 연산자 키워드
 	
 	*	스택영역			힙영역 [ 내가 직접 제가 불가 ]
 	*	유재석:안산주소		안산아파트 : 안산시 상록구 65번지
 	*	유재석:수원주소		수원아파트 : 수원시 구 100번지
 	*
 	*	안산 -> 수원	이사했기 때문에 스택이 이전주소를 버림, garbageCollector가 힙영역 안산아파트 삭제
 	*
 	*	유재석 : null 	안산아파트,수원아파트 삭제됨	
 	*
 	
 */