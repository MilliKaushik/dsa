package taskPlanner;

public class SubTrackService {

	private SubTrackDAO subTrackDAO;

	public SubTrack getSubTrackByName(String name) {
		return subTrackDAO.getSubTrackByName(name);
	}

	public SubTrack createSubTrack(SubTrack subTrack) {
		return subTrackDAO.createSubTrack(subTrack);
	}

}
