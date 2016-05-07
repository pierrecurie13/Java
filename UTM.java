//Universal Turing Machine with infinite tape.  Tape bits are stored as boolean,
//but displayed as 0/1.
public class UTM {
  public Tape tape;
  public TapeNode ptr;
  public int state;

  public UTM() {
  	tape = new Tape();
  	ptr = tape.head.next;
  	state = 0;
  }

  public UTM(int s) {
  	tape = new Tape();
  	ptr = tape.head.next;
  	state = s;
  }

  public void moveLeft() {
  	ptr = ptr.prev;
  	if (ptr == tape.head) {
  		tape.insertFront();
  	}
  }

  public void moveRight() {
  	ptr = ptr.next;
  	if (ptr == tape.tail) {
  		tape.insertBack();
  	}
  }

  public void invert() {
  	ptr.bit = !ptr.bit;
  }

  public void write(boolean b) {
  	ptr.bit = b;
  }

  public boolean read() {
  	return ptr.bit;
  }
}

class Tape {
  TapeNode head;
  TapeNode tail;

  Tape() {
    head = new TapeNode();
    TapeNode temp = new TapeNode();
    tail = new TapeNode();
    head.next = temp;
    temp.prev = head;
    temp.next = tail;
    tail.prev = temp;
  }

  void insertFront() {
    TapeNode temp = new TapeNode();
    head.prev = temp;
    temp.next = head;
    head = temp;
  }

  void insertBack() {
    TapeNode temp = new TapeNode();
    tail.next = temp;
    temp.prev = tail;
    tail = temp;
  }

  public String toString() {
    String result = "[  ";
    TapeNode current = head;
    while (current != null) {
    	if (current.bit) {
    		result = result + 1 + "  ";
    	} else {
    		result = result + 0 + "  ";
    	}
    	current = current.next;
    }
    return result + "]";
  }
}

class TapeNode {
  boolean bit;
  TapeNode prev;
  TapeNode next;

  TapeNode() {
    bit = false;
    prev = null;
    next = null;
  }
}