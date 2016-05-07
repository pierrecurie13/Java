//4 state, 2 symbol busy beaver
public class BusyBeaver2 {
  public static void main(String[] args) {
  	UTM utm = new UTM();
  	int step = 0;
  	while (true) {
  		if (utm.state == 0) {
  			if (utm.ptr.bit) {
  				utm.moveLeft();
  			} else {
  				utm.ptr.bit = true;
  				utm.moveRight();
  			}
  			utm.state = 1;
  		} else if (utm.state == 1) {
  			utm.invert();
  			if (utm.ptr.bit) {
  				utm.state = 0;
  			} else {
  				utm.state = 2;
  			}
  			utm.moveLeft();
  		} else if (utm.state == 2) {
  			if (utm.ptr.bit) {
  				utm.moveLeft();
  				utm.state = 3;
  			} else {
  				utm.ptr.bit = true;
  				step++;
  				break;
  			}
  		} else {
  			if (utm.ptr.bit) {
  				utm.state = 0;
  			}
  			utm.invert();
  			utm.moveRight();
  		}
  		System.out.println(utm.tape);
  		step++;
  	}
  	System.out.println(utm.tape + " " + step);
  }
}