package lockerManagementSystem;

public class PackageService {

	private LockerService lockerService;

	public void returnPackage(ReturnPackageRequest returnPackageRequest) throws NoLockerAvailableException {

		AllocateLockerRequest allocateLockerRequest = new AllocateLockerRequest();
		allocateLockerRequest.setPackageId(returnPackageRequest.getPackageId());
		allocateLockerRequest.setPackageSize(returnPackageRequest.getPackageSize());
		allocateLockerRequest.setUserId(returnPackageRequest.getUserId());

		lockerService.allocateLocker(allocateLockerRequest);

	}

}
