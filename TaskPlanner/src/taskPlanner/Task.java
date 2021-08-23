package taskPlanner;

public class Task {

	private String title;

	private TaskType taskType;

	private String assigneeName;

	private TaskStatus taskStatus;

	private Sprint sprint;

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

}
