package lockerManagementSystem;

public class ReturnPackageRequest {

	private int userId;

	private int packageId;

	private PackageSize packageSize;

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

	public PackageSize getPackageSize() {
		return packageSize;
	}

	public void setPackageSize(PackageSize packageSize) {
		this.packageSize = packageSize;
	}

}
