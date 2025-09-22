package lock;

public class KeyLock implements Lock {
	private final int key;
	private boolean isLocked;
	private boolean isInserted;
	
	public KeyLock(int key) {
		this.key = key;
		this.isLocked = true;   // start locked
		this.isInserted = false;
	}
	
// try to insert a key. returns true if it matches and wasn't already inserted.	
	public boolean insertKey(int key) {
		if (isInserted) return false;	
		if (this.key != key) return false;
		isInserted = true;
		return true;
	}
	
// remove key if present	
	public boolean removeKey() {
		if (!isInserted) return false;
		isInserted = false;
		return true;
	}

// turn the key to toggle lock state. key must be inserted
	public boolean turn() {
		if (!isInserted) return false;
		isLocked = !isLocked;
		return true;
	}


	@Override
	public boolean lock() {
		isLocked = true;
		return true;
	}

	
	@Override
	public boolean unlock() {
		isLocked = false;
		return true;
	}

	@Override
	public boolean isLocked() {
		return isLocked;
	}

}
