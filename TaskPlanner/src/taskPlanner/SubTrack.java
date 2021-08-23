package taskPlanner;

public class SubTrack {
	
	private String title;
	
	private SubTrackStatus subTackStatus;
	
	private Story parentStory;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SubTrackStatus getSubTackStatus() {
		return subTackStatus;
	}

	public void setSubTackStatus(SubTrackStatus subTackStatus) {
		this.subTackStatus = subTackStatus;
	}

	public Story getParentStory() {
		return parentStory;
	}

	public void setParentStory(Story parentStory) {
		this.parentStory = parentStory;
	}
	
	

}
