package java0725;

public class Key {
	public int number;
	
	public Key(int numer) {
		super();
		this.number = numer;
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Key) {
			Key ck = (Key) obj;
			if (number == ck.number) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return number;
	}
	
	
	
	
}
