package taskPlanner;

import java.util.HashMap;
import java.util.Map;

public class SubTrackDAO {

	private Map<String, SubTrack> subtracks;

	public SubTrackDAO() {
		subtracks = new HashMap<>();
	}

	public SubTrack createSubTrack(SubTrack subTrack) {
		subtracks.put(subTrack.getTitle(), subTrack);
		return subTrack;
	}

	public SubTrack getSubTrackByName(String name) {
		return subtracks.get(name);
	}

}
