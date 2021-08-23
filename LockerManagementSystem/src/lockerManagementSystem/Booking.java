package lockerManagementSystem;

public class Booking {

	private int lockerId;

	private int userId;

	private int packageId;

	private OTP otp;

	public int getLockerId() {
		return lockerId;
	}

	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public OTP getOtp() {
		return otp;
	}

	public void setOtp(OTP otp) {
		this.otp = otp;
	}

}
