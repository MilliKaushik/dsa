package taskPlanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskDAO {

	private Map<String, Task> tasks;
	// string -> user name
	private Map<String, Map<TaskType, List<Task>>> userToTasksByTaskType;

	public TaskDAO() {
		tasks = new HashMap<>();
		userToTasksByTaskType = new HashMap<>();
	}

	public Task createTask(Task task) {
		tasks.put(task.getTitle(), task);

		if (userToTasksByTaskType.containsKey(task.getAssigneeName())) {
			Map<TaskType, List<Task>> taskTypeToTask = userToTasksByTaskType.get(task.getAssigneeName());
			List<Task> tasks = taskTypeToTask.get(task.getTaskType());
			if (tasks == null || tasks.isEmpty()) {
				tasks = new ArrayList<>();
				tasks.add(task);
			}
			taskTypeToTask.put(task.getTaskType(), tasks);
			userToTasksByTaskType.put(task.getAssigneeName(), taskTypeToTask);
		} else {
			Map<TaskType, List<Task>> taskTypeToTask = new HashMap<>();
			List<Task> tasks = new ArrayList<>();
			tasks.add(task);

			taskTypeToTask.put(task.getTaskType(), tasks);
			userToTasksByTaskType.put(task.getAssigneeName(), taskTypeToTask);
		}
		return task;
	}

	public Task updateTask(Task task) {
		tasks.put(task.getTitle(), task);
		return task;
	}

	public List<Task> getAllTasks() {
		return new ArrayList<>(tasks.values());
	}

	public Map<TaskType, List<Task>> getTasksForUserByTaskType(String name) {
		System.out.println(userToTasksByTaskType.get(name));
		return userToTasksByTaskType.get(name);
	}

	public Task getTask(String name) {
		return tasks.get(name);
	}

}
