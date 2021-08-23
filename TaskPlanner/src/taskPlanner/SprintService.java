package taskPlanner;

import java.util.Date;

public class SprintService {

	private TaskService taskService;

	private SprintDAO sprintDAO;

	public SprintService(TaskService taskService, SprintDAO sprintDAO) {

		this.taskService = taskService;
		this.sprintDAO = sprintDAO;
	}

	public Sprint createSprint(String name) {
		Sprint sprint = new Sprint();
		sprint.setName(name);
		sprint.setStartDate(new Date());
		sprint.setSprintStatus(SprintStatus.OPEN);
		return sprintDAO.createSprint(sprint);
	}

	public void endSprint(String sprintName) {
		Sprint sprint = getSprint(sprintName);
		sprint.setEndDate(new Date());
	}

	public void addTaskToSprint(String sprintName, String taskName)
			throws TaskAlreadyAssignedToSprintException, TaskAssignedToOldSprintException {
		Sprint sprint = getSprint(sprintName);
		Task task = taskService.getTaskByName(taskName);
		if (task.getSprint() == null) {
			if (sprint.getEndDate().before(new Date()))
				throw new TaskAssignedToOldSprintException();
			task.setSprint(sprint);
		} else
			throw new TaskAlreadyAssignedToSprintException();
	}

	public void removeTaskFromSprint(String sprintName, String taskName) throws TaskNotAssignedToSprintException {
		Sprint sprint = getSprint(sprintName);
		Task task = taskService.getTaskByName(taskName);
		if (task.getSprint() == null) {
			throw new TaskNotAssignedToSprintException();
		} else
			task.setSprint(null);
	}

	public Sprint getSprint(String name) {
		return sprintDAO.getSprint(name);
	}

}
