package 과제.과제9.인터페이스1;

public class 사람 implements 이동 {
	@Override
	public void 동쪽이동() {
		System.out.println("[동쪽 이동] 속도 : 5km/h"  );
		
	}
	@Override
	public void 서쪽이동() {
		System.out.println("[서쪽 이동] 속도 : 5km/h"  );
		
	}
}
