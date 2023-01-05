public class Task {
    private String taskNumber;
    private String taskName;
    private String description;
    private String status;
    private Project Project;

    public Task(String taskName, String description, String taskNumber) {
        this.taskName = taskName;
        this.description = description;
        this.taskNumber = taskNumber;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
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
