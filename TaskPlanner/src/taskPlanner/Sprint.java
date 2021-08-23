package taskPlanner;

import java.util.Date;

public class Sprint {

	private String name;

	private SprintStatus sprintStatus;

	private Date startDate;

	private Date endDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SprintStatus getSprintStatus() {
		return sprintStatus;
	}

	public void setSprintStatus(SprintStatus sprintStatus) {
		this.sprintStatus = sprintStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
