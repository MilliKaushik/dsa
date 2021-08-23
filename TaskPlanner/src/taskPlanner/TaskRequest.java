package taskPlanner;

import java.util.Date;
import java.util.List;

public class TaskRequest {

	private String title;

	private Date dueDate;

	private String assigneeName;

	private TaskStatus taskStatus;

	private TaskType TaskType;

	private Impact impact;

	private Severity severity;

	private String summary;

	private List<SubTrack> subTracks;

	public Impact getImpact() {
		return impact;
	}

	public void setImpact(Impact impact) {
		this.impact = impact;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public TaskType getTaskType() {
		return TaskType;
	}

	public void setTaskType(TaskType taskType) {
		TaskType = taskType;
	}

}
