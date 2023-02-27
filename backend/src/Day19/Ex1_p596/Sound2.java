package Day19.Ex1_p596;

import java.awt.Toolkit;

public class Sound2 implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for ( int i = 0 ; i < 5 ; i++ ) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
			} // catch end
		}// for end
	}

}
