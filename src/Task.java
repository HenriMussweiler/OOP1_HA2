public class Task {
    private int taskNumber;
    private String taskName;
    private String description;
    private String status;
    private Project Project;

    public Task(String taskName, String description, int taskNumber) {
        this.taskName = taskName;
        this.description = description;
        this.taskNumber = taskNumber;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public Project getProject() {
        return Project;
    }

    public void setProject(Project project) {
        Project = project;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return taskNumber + ". " + taskName + " [Status: " + status + "]";
    }
}
