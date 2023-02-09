package Day07.Ex5;

import java.util.ArrayList;
import java.util.Arrays;

public class 실행 { // 클래스 시작
	
	public static void main(String[] args) {
		Member m1 = new Member();
		m1.id = "qwe" ; m1.password = "qwe";
		
		Member m2 = new Member();
		m2.id = "adf" ; m2.password = "adf";
		
		Member m3 = new Member();
		m3.id = "dfg" ; m3.password = "dfg";
		
		// 1. 배열 [ 언어 문법 : c , java , js , python ] if for 원래 프로그래밍 문법 , 고정길이!!
		Member[] memberList1 = new Member[3]; // 멤버 객체 3개 저장 하는 배열
		memberList1[0] = m1;
		memberList1[1] = m2;
		memberList1[2] = m3;
		
		System.out.println(Arrays.toString(memberList1)); //배열정보출력 클래스
		memberList1[1] = null; // 1번 인덱스를 공백으로  , 고정
		System.out.println(Arrays.toString(memberList1)); ////////////////////// null이됨 안없어짐
		
		// 2. 컬렉션[수집] 프레임워크[API ,미리 만들어진 클래스] = 미리 만들어진 클래스 , 자바에서만 사용 , 가변길이!!!
		ArrayList<Member> memberList2 = new ArrayList<>(); // JDK8이상 , import시켜야함 , 제네릭 , 초기길이10 , add하면 길어짐
		
		memberList2.add(m1); // js push와 같음 , 배열 마지막에 들어감
		memberList2.add(m2);
		memberList2.add(m3);
		
		System.out.println(memberList2);
		memberList2.remove(1); // js splice랑 똑같음 , 1번 인덱스 삭제 , 가변
		System.out.println(memberList2); ////////////////////// 1번이 아예사라짐
	}
	
	
	
	
} // 클래스 끝
