public class Project {
    private String projectNumber;
    private String name;
    private Address address;
    private String estimatedDate;
    private Customer Kunde;
    private Task[] tasks = new Task[10];

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public Customer getKunde() {
        return Kunde;
    }

    public void setKunde(Customer kunde) {
        Kunde = kunde;
    }

    public Project(String name, String estimatedDate) {
        this.name = name;
        this.estimatedDate = estimatedDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(String estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    @Override
    public String toString() {
        return projectNumber + " + " + name;
    }
}
