package taskPlanner;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws TaskStatusNotAllowedForTaskTypeException {
		Scanner sc = new Scanner(System.in);
		TaskTypeToAllowedStatusChecker checker = new TaskTypeToAllowedStatusChecker();
		TaskDAO taskDAO = new TaskDAO();
		TaskService taskService = new TaskService(checker, taskDAO);

		SprintDAO sprintDAO = new SprintDAO();
		SprintService sprintService = new SprintService(taskService, sprintDAO);
		OrchestratorService orchestratorService = new OrchestratorService(taskService, sprintService);
		while (true) {
			String in = sc.nextLine();
			String[] split = in.split(" ");
			switch (split[0]) {
			case "create_sprint":
				orchestratorService.createSprint(split);
				break;
			case "end_sprint":
				orchestratorService.endSprint(split);
				break;
			case "add_task_to_sprint":
				orchestratorService.addTaskSprint(split);
			case "remove_task_to_sprint":
				orchestratorService.removeTaskFromSprint(split);
				break;
			case "create_task":
				orchestratorService.createTask(split);
				break;
			case "display_task":
				orchestratorService.displayTaskByUser(split);
				break;
			case "change_assignee_name":
				orchestratorService.changeAssignee(split);
				break;
			case "change_task_status":
				orchestratorService.changeTaskStatus(split);
				break;
			case "exit":
				break;
			}
			// sc.close();
		}

	}

}
