package taskPlanner;

import java.util.List;
import java.util.Map;

public class TaskService {

	private TaskTypeToAllowedStatusChecker taskTypeToAllowedStatusChecker;

	private TaskDAO taskDAO;

	public TaskService(TaskTypeToAllowedStatusChecker taskTypeToAllowedStatusChecker, TaskDAO taskDAO) {
		this.taskTypeToAllowedStatusChecker = taskTypeToAllowedStatusChecker;
		this.taskDAO = taskDAO;
	}

	public Task createTask(Task task) throws TaskStatusNotAllowedForTaskTypeException {
		// if (taskTypeToAllowedStatusChecker.isAllowedStatusForTaskType(task,
		// task.getTaskStatus())) {
		return taskDAO.createTask(task);
		// } else
		// throw new TaskStatusNotAllowedForTaskTypeException();
	}

	public Task changeTaskStatus(String taskName, TaskStatus finalStatus)
			throws TaskStatusNotAllowedForTaskTypeException {
		Task task = getTaskByName(taskName);
		if (taskTypeToAllowedStatusChecker.isAllowedStatusForTaskType(task, finalStatus)) {
			return taskDAO.updateTask(task);
		} else
			throw new TaskStatusNotAllowedForTaskTypeException();

	}

	public void changeAssigneeName(String taskName, String newAssigneeName) {
		Task task = getTaskByName(taskName);
		task.setAssigneeName(newAssigneeName);
		taskDAO.updateTask(task);
	}

	public Map<TaskType, List<Task>> displayTasks(String assigneeName) {
		return taskDAO.getTasksForUserByTaskType(assigneeName);
	}

	public Task getTaskByName(String name) {
		return taskDAO.getTask(name);
	}
}
