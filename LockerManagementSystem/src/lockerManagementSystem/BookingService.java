package lockerManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

	private Map<Integer, Booking> bookings;

	public BookingService() {
		bookings = new HashMap<>();
	}

	public Booking createBooking(BookingRequest bookingRequest) {
		Booking booking = new Booking();
		booking.setLockerId(bookingRequest.getLockerId());
		booking.setPackageId(bookingRequest.getPackageId());
		booking.setUserId(bookingRequest.getUserId());

		bookings.put(booking.getPackageId(), booking);

		// bookings.put(, arg1)
		return booking;
	}

	public void cancelBooking(Booking booking) {
		bookings.remove(booking.getPackageId());
	}

}
