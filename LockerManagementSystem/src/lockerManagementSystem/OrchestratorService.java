package lockerManagementSystem;

public class OrchestratorService {

	private OTPGenerationService otpGenerationService;

	private LockerService lockerService;

	private NotificationService notificationService;

	private PackageService packageService;

	public void allocateLocker(AllocateLockerRequest allocateLockerRequest) {

		try {
			Booking booking = lockerService.allocateLocker(allocateLockerRequest);
		} catch (NoLockerAvailableException e) {
			e.printStackTrace();
		}

		OTP otp = otpGenerationService.generateOTP();

		Notification notification = new Notification();
		notificationService.notify(notification);

	}

	public void returnPackage(ReturnPackageRequest request) {
		try {
			packageService.returnPackage(request);
		} catch (NoLockerAvailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Notification notification = new Notification();
		notificationService.notify(notification);

	}

}
