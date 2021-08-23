package lockerManagementSystem;

import java.util.Stack;

public class LockerService {

	private BookingService bookingService;

	private Stack<Locker> small;

	private Stack<Locker> medium;

	private Stack<Locker> large;

	public LockerService(BookingService bookingService) {
		this.bookingService = bookingService;
		small = new Stack<>();
		medium = new Stack<>();
		large = new Stack<>();
	}

	public Booking allocateLocker(AllocateLockerRequest allocateLockerRequest) throws NoLockerAvailableException {
		Locker locker = getLockerBySize(allocateLockerRequest.getPackageSize());
		if (locker == null)
			throw new NoLockerAvailableException();

		BookingRequest bookingRequest = new BookingRequest();
		bookingRequest.setLockerId(locker.getId());
		bookingRequest.setPackageId(allocateLockerRequest.getPackageId());
		bookingRequest.setUserId(allocateLockerRequest.getUserId());

		Booking booking = bookingService.createBooking(bookingRequest);
		return booking;
	}

	public void unallocateLocker(Booking booking) {
		bookingService.cancelBooking(booking);
		returnLocker(booking.getLockerId());
	}

	private void returnLocker(int lockerId) {
		Locker locker = getLocker(lockerId);
		switch (locker.getLockerSize()) {
		case SMALL:
			small.push(locker);
			break;
		case MEDIUM:
			medium.push(locker);
			break;
		case LARGE:
			large.push(locker);
			break;
		}
	}

	public Locker getLocker(int lockerId) {
		return null;
	}

	public Locker getLockerBySize(PackageSize packageSize) {

		switch (packageSize) {
		case SMALL:
			if (!small.isEmpty())
				return small.pop();
		case MEDIUM:
			if (!medium.isEmpty())
				return medium.pop();
		case LARGE:
			if (!large.isEmpty())
				return large.pop();
		}
		return null;
		// handle no lockers available
	}

}
