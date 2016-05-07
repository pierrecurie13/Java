//2 state, 2 symbol busy beaver
public class BusyBeaver {
  public static void main(String[] args) {
  	UTM utm = new UTM();
  	while (true) {
  		if (utm.state == 0) {
  			if (utm.ptr.bit) {
  				utm.moveLeft();
  			} else {
  				utm.ptr.bit = true;
  				utm.moveRight();
  			}
  			utm.state = 1;
  		} else {
  			if (utm.ptr.bit) {
  				break;
  			} else {
  				utm.ptr.bit = true;
  				utm.moveLeft();
  			}
  			utm.state = 0;
  		}
  		System.out.println(utm.tape);
  	}
  	System.out.println(utm.tape);
  }
}