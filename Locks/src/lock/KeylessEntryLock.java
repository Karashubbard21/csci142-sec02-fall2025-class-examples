package lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class KeylessEntryLock extends KeyLock {

	public static final int MAX_NUM_USER_CODES = 10;
	public static final int USER_CODE_LENGTH = 4;
	public static final int MASTER_CODE_LENGTH = 6;

// "Last operation" indicators
	private boolean isReset = true;
	private boolean isNewUserCode = false;
	private boolean isDeletedUserCode = false;
	private boolean isChangedMasterCode = false;
	private boolean areAllUserCodesDeleted = false;
	
	
	private int[] masterCode;    // 6 digits (0-9)
	private final List<int[]> userCodes;   // up to 10 user codes (each 4 digits)
	// private int attempt;
	private final List<Integer> buffer;   // Current digits being typed
	
	private enum Mode {
		NORMAL,         // idle; collect possible 6DPC
		AWAIT_CMD,       // after "6DPC"
		ADD_NEW_4, ADD_REPEAT_4,
		DELL_ALL_CONFIRM_6,
		CHG_NEW_6, CHG_REPEAT_6
	}
	
	private Mode mode = Mode.NORMAL;
	private int [] temp4 = null;
	private int [] temp6 = null;
		

	public KeylessEntryLock(int keyValue) {
		super(keyValue);
	}

	public boolean pushButton(char button) {
		return false;
	}
	
	public boolean addedUserCode() {
		return false;
	}

	public boolean deletedUserCode() {
		return false;
	}

	public boolean deletedAllUserCodes() {
		return false;
	}

	public boolean changedMasterCode() {
		return false;
	}

	public int[] getMasterCode() {
		return null;
	}

}
