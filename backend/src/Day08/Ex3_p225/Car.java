package Day08.Ex3_p225;

public class Car {
	// 필드 -> 빈생성자,풀생성자 -> toString
	// 1.필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	
	
	// 2.생성자 [ 관례적으로 깡통생성자 풀생성자 미리 만들고 시작 ]
	// 빠른 생성자 만들기
	// 오른쪽클릭 -> source -> Generate Constructor Using Field -> 필드선택 생성자 생성
	
	// 빈 생성자 (메소드 목적으로 빈생성자가 필요한 경우가 있음) 매개변수X
	public Car() { 	} 
	
	// 오버로딩 : 매개변수 타입 , 개수 , 순서가 다르면 이름이 같은 생성자 여러개 생성가능.
	// [ 이름이 같아도 매개변수 개수가 달라서 식별 - 오버로딩 ]
	// 생성자 : 1개 매개변수
	public Car(String model) {
		super();
		this.model = model;
	}


	// 생성자 : 2개 매개변수
	public Car(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}


	// 생성자 : 3개 매개변수
	public Car(String model, String color, int maxSpeed) {
		super();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	
	
	// 생성자 : 모든필드를 받는 매개변수	
	public Car(String company, String model, String color, int maxSpeed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	// 3.메소드
	@Override
		public String toString() {
			return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
		}
	
	
}
