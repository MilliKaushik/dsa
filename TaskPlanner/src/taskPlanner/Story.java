package taskPlanner;

import java.util.ArrayList;
import java.util.List;

public class Story extends Task {

	private String summary;

	private List<SubTrack> subTracks;

	public Story() {
		subTracks = new ArrayList<>();
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<SubTrack> getSubTracks() {
		return subTracks;
	}

	public void setSubTracks(List<SubTrack> subTracks) {
		this.subTracks = subTracks;
	}

}
