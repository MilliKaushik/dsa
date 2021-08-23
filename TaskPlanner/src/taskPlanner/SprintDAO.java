package taskPlanner;

import java.util.HashMap;
import java.util.Map;

public class SprintDAO {

	private Map<String, Sprint> sprints;

	public SprintDAO() {
		sprints = new HashMap<>();
	}

	public Sprint createSprint(Sprint sprint) {
		sprints.put(sprint.getName(), sprint);
		return sprint;
	}

	public Sprint getSprint(String name) {
		return sprints.get(name);
	}

}
