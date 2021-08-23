package taskPlanner;

public class Feature extends Task {

	private String summary;

	private Impact impact;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Impact getImpact() {
		return impact;
	}

	public void setImpact(Impact impact) {
		this.impact = impact;
	}

}
