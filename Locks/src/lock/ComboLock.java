package lock;

import java.util.Random;

public class ComboLock implements Lock{
	
	public final int COMBO_LENGTH = 3;
	public static final int MAX_NUMBER = 39;   // 0..39 inclusive (40 positions)
	
	private final int[] combination = new int[COMBO_LENGTH];
	private final int[] attempt = new int[COMBO_LENGTH];   // what the user has landed on
	private int attemptIndex = 0;
	
	private int position = 0;           // current dial position
	private boolean isLocked = true;    // padlock starts locked
	private boolean isReset = true;     // true after reset
	
	private enum Dir { RIGHT, LEFT, NONE }
	private Dir lastDir = Dir.NONE;
	
	public ComboLock() {
// build a valid combination following the remainder rule
// pick x in {0,1,2,3}; first = r0 s.t. r0 % 4 ==x; middle % 4 == (x+2); last %4 ==x
		Random r = new Random(System.nanoTime());
		int x = r.nextInt(4);
		
		combination[0] = randomWithRemainder(r, x);
		combination[1] = randomWithRemainder(r, (x+ 2) & 3);
		combination[2] = randomWithRemainder(r, x);
	}
	
	private int randomWithRemainder(Random r, int remMod4) {
		// pick any k in [0..9] then value = 4*k + reMod (then clamp to 0..MAX_NUMBER)
		// keep retrying until inside range
		int val;
		do {
			int k = r.nextInt((MAX_NUMBER + 4) / 4 + 1);
			val = 4 * k + remMod4;
		} while (val < 0 || val > MAX_NUMBER);
		return val;
	}
	
// turn right 'ticks' steps (decreasing numbers on a dial. Returns true	
	public boolean turnRight(int ticks) {
		if (ticks < 0) return false;
		isReset = false;
		lastDir = Dir.RIGHT;
		position = mod(position - ticks, MAX_NUMBER + 1);
		
		// expected order: RIGHT --> LEFT --> RIGHT
		int expectedIdx = attemptIndex;
		if ((expectedIdx == 0 || expectedIdx == 2) && position == combination[expectedIdx]) {
			attempt[attemptIndex++] = position;
			if (attemptIndex == COMBO_LENGTH) {
				isLocked = false;   // opened!
			}
			return true;
		}
		return false;
	}

	
// turn left 'ticks' steps (increasing numbers on a dial). Returns true if this lands on the expected number.	
	public boolean turnLeft(int ticks) {
		return false;
	}
	
	
	public void reset() {
	}
	
	public boolean isReset() {
		return false;
	}
	

	@Override
	public boolean lock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unlock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLocked() {
		// TODO Auto-generated method stub
		return false;
	}

}
