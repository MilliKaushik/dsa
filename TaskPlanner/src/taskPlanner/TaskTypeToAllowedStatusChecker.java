package taskPlanner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TaskTypeToAllowedStatusChecker {

	// Map<TaskType, Map<TaskStatus, Set<TaskStatus>>>
	private Map<TaskType, Set<TaskStatus>> taskTypeToStatus;

	public TaskTypeToAllowedStatusChecker() {
		taskTypeToStatus = new HashMap<>();
		Set<TaskStatus> featureStatus = new HashSet<>();
		featureStatus.add(TaskStatus.OPEN);
		featureStatus.add(TaskStatus.IN_PROGRESS);
		featureStatus.add(TaskStatus.TESTING);
		featureStatus.add(TaskStatus.DEPLOYED);

		taskTypeToStatus.put(TaskType.FEATURE, featureStatus);

		taskTypeToStatus = new HashMap<>();
		Set<TaskStatus> bugStatus = new HashSet<>();
		featureStatus.add(TaskStatus.OPEN);
		featureStatus.add(TaskStatus.IN_PROGRESS);
		featureStatus.add(TaskStatus.FIXED);

		taskTypeToStatus.put(TaskType.BUG, bugStatus);

		taskTypeToStatus = new HashMap<>();
		Set<TaskStatus> storyStatus = new HashSet<>();
		featureStatus.add(TaskStatus.OPEN);
		featureStatus.add(TaskStatus.IN_PROGRESS);
		featureStatus.add(TaskStatus.COMPLETED);

		taskTypeToStatus.put(TaskType.STORY, storyStatus);
	}

	public boolean isAllowedStatusForTaskType(Task task, TaskStatus taskStatus) {
		TaskType taskType = task.getTaskType();

		return (taskTypeToStatus.get(taskType)).contains(taskStatus);
	}

}
