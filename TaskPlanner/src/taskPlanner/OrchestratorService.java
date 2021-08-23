package taskPlanner;

public class OrchestratorService {

	private TaskService taskService;

	private SprintService sprintService;

	public OrchestratorService(TaskService taskService, SprintService sprintService) {
		this.taskService = taskService;
		this.sprintService = sprintService;
	}

	public void createSprint(String[] in) {
		String name = in[2];
		sprintService.createSprint(name);
	}

	public void endSprint(String[] in) {
		String name = in[2];
		sprintService.endSprint(name);
	}

	public void addTaskSprint(String[] in) {
		String spName = in[2];
		String taskName = in[4];
		try {
			sprintService.addTaskToSprint(spName, taskName);
		} catch (TaskAlreadyAssignedToSprintException | TaskAssignedToOldSprintException e) {
			System.out.println("Task cannot be assigned to the sprint");
			e.printStackTrace();
		}
	}

	public void removeTaskFromSprint(String[] in) {
		String spName = in[2];
		String taskName = in[4];

		try {
			sprintService.removeTaskFromSprint(spName, taskName);
		} catch (TaskNotAssignedToSprintException e) {
			System.out.println("Task cannot be removed from the sprint");
			e.printStackTrace();
		}
	}

	public void changeTaskStatus(String[] in) {
		String taskStatusStr = in[4];
		TaskStatus taskStatus = null;
		switch (taskStatusStr) {
		case "open":
			taskStatus = TaskStatus.OPEN;
			break;
		case "in_progress":
			taskStatus = TaskStatus.IN_PROGRESS;
			break;
		case "testing":
			taskStatus = TaskStatus.TESTING;
			break;
		case "fixed":
			taskStatus = TaskStatus.FIXED;
			break;
		case "completed":
			taskStatus = TaskStatus.COMPLETED;
			break;
		case "deployed":
			taskStatus = TaskStatus.DEPLOYED;
			break;

		}
		try {
			taskService.changeTaskStatus(in[2], taskStatus);
		} catch (TaskStatusNotAllowedForTaskTypeException e) {
			System.out.println("Cannot change task status");
			e.printStackTrace();
		}
	}

	public void changeAssignee(String[] in) {
		String taskName = in[2];
		String assignee = in[4];
		taskService.changeAssigneeName(taskName, assignee);
	}

	public void displayTaskByUser(String[] in) {
		String assignee = in[1];
		taskService.displayTasks(assignee);
	}

	public void createTask(String[] in) throws TaskStatusNotAllowedForTaskTypeException {
		TaskRequest taskRequest = new TaskRequest();
		taskRequest.setAssigneeName(in[2]);
		String taskTypeStr = in[4];
		switch (taskTypeStr) {
		case "FEATURE":
			taskRequest.setTaskType(TaskType.FEATURE);
			break;
		case "BUG":
			taskRequest.setTaskType(TaskType.BUG);
			break;
		case "STORY":
			taskRequest.setTaskType(TaskType.STORY);
			break;
		}

		taskRequest.setTitle(in[6]);

		String taskStatusStr = in[8];
		TaskStatus taskStatus = null;
//		switch (taskStatusStr) {
//		case "open":
//			taskStatus = TaskStatus.OPEN;
//			break;
//		case "in_progress":
//			taskStatus = TaskStatus.IN_PROGRESS;
//			break;
//		case "testing":
//			taskStatus = TaskStatus.TESTING;
//			break;
//		case "fixed":
//			taskStatus = TaskStatus.FIXED;
//			break;
//		case "completed":
//			taskStatus = TaskStatus.COMPLETED;
//			break;
//		case "deployed":
//			taskStatus = TaskStatus.DEPLOYED;
//			break;
//
//		}
		taskRequest.setTaskStatus(TaskStatus.OPEN);

//		String impactStr = in[10];
//		Impact impact = null;
//		switch (taskTypeStr) {
//		case "LOW":
//			impact = Impact.LOW;
//			break;
//		case "MODERATE":
//			impact = Impact.MODERATE;
//			break;
//		case "HIGH":
//			impact = Impact.HIGH;
//			break;
//		}
		taskRequest.setImpact(Impact.LOW);

//		if (in.length >= 13) {
//			String severityStr = in[12];
//			Severity severity = null;
//			switch (taskTypeStr) {
//			case "P0":
//				severity = Severity.P0;
//				break;
//			case "P1":
//				severity = Severity.P2;
//				break;
//			case "P2":
//				severity = Severity.P2;
//				break;
//			}
//			taskRequest.setSeverity(severity);
//		}
//		if (in.length >= 14) {
//			taskRequest.setSummary(in[14]);
//		}
		TaskType taskType = taskRequest.getTaskType();

		switch (taskType) {
		case FEATURE:
			Feature task1 = new Feature();
			task1.setImpact(taskRequest.getImpact());
			setBasicParameters(taskRequest, taskType, task1);
			taskService.createTask(task1);
			break;
		case BUG:
			Bug task2 = new Bug();
			task2.setSeverity(taskRequest.getSeverity());
			setBasicParameters(taskRequest, taskType, task2);
			taskService.createTask(task2);
			break;
		case STORY:
			Story task3 = new Story();
			task3.setSummary(taskRequest.getSummary());
			task3.setSubTracks(taskRequest.getSubTracks());
			setBasicParameters(taskRequest, taskType, task3);
			taskService.createTask(task3);
			break;
		}
	}

	private void setBasicParameters(TaskRequest taskRequest, TaskType taskType, Task task) {
		task.setAssigneeName(taskRequest.getAssigneeName());
		task.setTaskType(taskType);
		task.setTitle(taskRequest.getTitle());
		task.setTaskStatus(TaskStatus.OPEN);
	}

}
