package lockerManagementSystem;

public class Locker {

	private int id;

	private LockerSize lockerSize;

	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LockerSize getLockerSize() {
		return lockerSize;
	}

	public void setLockerSize(LockerSize lockerSize) {
		this.lockerSize = lockerSize;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
