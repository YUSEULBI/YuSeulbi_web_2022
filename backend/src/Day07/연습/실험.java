package Day07.연습;

public class 실험 {
	
	public static void main(String[] args) { // class start
		
		String[] str = { "가나다"+","+"호호호" , "라마바"+","+"호호호" , "사아자"+","+"호호호" };
		for ( int i = 0 ; i < str.length ; i++ ) {
			System.out.println(str[i].split(","));
			
			String[] str2 = str[i].split(",");
			for ( int j = 0 ; j < str2.length ; j++ ) {
				System.out.println(str2[j]);
			}
		}
		
		
		
	} // class end
	
}
