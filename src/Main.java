import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Customer[] kunden = new Customer[10];
        Project[] projekte = new Project[10];
        Task[] tasks = new Task[10];

        // Menü aufruf
        int menueEingabe;
        do {
            menueAufruf();
            menueEingabe = scanner.nextInt();

            if (menueEingabe == 1) {
                System.out.println("Sie haben Kund:in anlegen gewählt.");
                createCustomer(kunden);
            } else if (menueEingabe == 2) {
                System.out.println("Sie haben Projekt anlegen gewählt.");
                createProject(projekte, kunden);
            } else if (menueEingabe == 3) {
                System.out.println("Sie haben Projekt anzeigen gewählt.");
                showProject(projekte, tasks);
            } else if (menueEingabe == 4) {
                System.out.println("Sie haben Aufgabe zu Projekt hinzufuegen gewählt.");
                createTask(tasks, projekte);
            } else if (menueEingabe == 5) {
                System.out.println("Sie haben Aufgabe in Projekt erledigen gewählt");
                finishTask(projekte, tasks);
            } else if (menueEingabe == 6) {
                System.out.println("Sie haben das Programm beendet.");
            } else {
                System.out.println("Bitte geben Sie einen gültigen Menuepunkt an.");
            }
        } while (menueEingabe != 6);

    }

    private static void finishTask(Project[] projekte, Task[] tasks) {

        if (tasks[0] == null) {
            System.out.println("Sie haben noch keinen Aufgaben angelegt.");
            return;
        }

        System.out.println("Bitte wählen Sie das Projekt aus in dem Sie eine Aufgabe erledigt haben:");
        int j = 0;
        while ((j < projekte.length) && (projekte[j] != null)) {
            System.out.println(projekte[j]);
            j++;
        }

        anzeiger(projekte, tasks);


    }

    private static void createTask(Task[] tasks, Project[] projekte) {

        if (projekte[0] == null) {
            System.out.println("Sie haben noch keinen Projekte angelegt.");
            return;
        }

        // Prüfen ob bereits 10 Aufgaben angelegt wurden
        int i = 0;

        while ((i < tasks.length) && (tasks[i] != null)) {
            i++;
        }

        if (tasks[i] != null) {
            System.out.println("Es wurden bereits 10 Aufgaben angelegt.");
            return;
        }

        // Projekt auswählen mit einer Übersicht wie bei showProject
//         System.out.println("Zu welchem Projekt wollen Sie die Aufgabe hinzufügen?");
//         int j = 0;
//         while ((j < projekte.length) && (projekte[j] != null)) {
//             System.out.println(projekte[j]);
//             j++;
//         }

        anzeiger(projekte, tasks);

        // Aufforderung eine neue Aufgabe hinzuzufügen mit Aufgabennamen und optionale Beschreibung
        System.out.println("Fügen Sie nun eine neue Aufgabe hinzu.");
        System.out.println("Geben Sie der Aufgabe einen Namen:");
        String taskName = userInput();
        System.out.println("Geben Sie eine optionale Beschreibung ein:");
        String description = userInput();

        int taskNumber = i + 1;
        Task task = new Task(taskName, description, taskNumber);

        // Neue Aufgaben haben den Status offen
        String status = "Offen";
        task.setStatus(status);

        boolean projektnummerEingabeFehlerhaft = true;
        do {
            anzeiger(projekte, tasks);
            System.out.println("Geben Sie die Projektnummer ein, der Sie die Aufgabe zuweisen wollen:");
            String aufgabenZuweisung = userInput();
            int p = 0;
            while ((p < projekte.length) && (projekte[p] != null)) {
                if (projekte[p].getProjectNumber().equals(aufgabenZuweisung)) {
                    task.setProject(projekte[p]);
                    projektnummerEingabeFehlerhaft = false;
                }
                p++;
            }
        } while (projektnummerEingabeFehlerhaft);
        tasks[i] = task;

    }

    private static void showProject(Project[] projekte, Task[] tasks) {

        if (projekte[0] == null) {
            System.out.println("Sie haben noch keinen Projekte angelegt.");
            return;
        }

        System.out.println("Welches Projekt wollen Sie sich anzeigen lassen?");

        int i = 0;
        while ((i < projekte.length) && (projekte[i] != null)) {
            System.out.println(projekte[i]);
            i++;
        }

        anzeiger(projekte, tasks);

    }

    private static void anzeiger(Project[] projekte, Task[] tasks) {
        boolean benutzerEingabeFehlerhaft = false;

        do {
            benutzerEingabeFehlerhaft = true;
            String userInput = userInput();

            int e = 0;
            while ((e < projekte.length) && (projekte[e] != null)) {
                if (projekte[e].getProjectNumber().equals(userInput)) {
                    System.out.println("Projekt: '" + projekte[e].getName() + "'");
                    System.out.println("Kunde: " + projekte[e].getKunde().getFirstName() + " " + projekte[e].getKunde().getLastName() + ", " + projekte[e].getAddress().getStreet() + " " + projekte[e].getAddress().getStreetNumber() + ", " + projekte[e].getAddress().getZipcode() + " " + projekte[e].getAddress().getCity());
                    System.out.println("Geplantes Installationsdatum: " + projekte[e].getEstimatedDate());
                    System.out.println(" ");
                    System.out.println("Aufgaben:");

                    int j = 0;
                    while ((j < tasks.length) && (tasks[j] != null)) {
                        System.out.println(tasks[j]);
                        j++;
                    }
                    e++;
                }
                benutzerEingabeFehlerhaft = false;
            }
        } while (benutzerEingabeFehlerhaft);
    }

    private static void createProject(Project[] projekte, Customer[] kunden) {

        if (kunden[0] == null) {
            System.out.println("Sie haben noch keinen Kunden angelegt.");
            return;
        }

        int i = 0;
        while ((i < projekte.length) && (projekte[i] != null)) {
            i++;
        }

        if (projekte[i] != null) {
            System.out.println("Es wurden bereits 10 Projekte angelegt.");
            return;
        }

        System.out.println("Geben Sie den Projektnamen an:");
        String name = userInput();
        Address address = addressInput();
        System.out.println("Geben Sie das voraussichtiliche Datum:");
        String estimatedDate = userInput();

        String projectNumber = "P" + (1000 + i);
        Project project = new Project(name, estimatedDate);
        project.setProjectNumber(projectNumber);
        project.setAddress(address);

        System.out.println("Zu welchem Kunden wollen Sie das Projekt hinzufügen?");
        int j = 0;
        while ((j < kunden.length) && (kunden[j] != null)) {
            System.out.println(kunden[j]);
            j++;
        }


        boolean kundennummerEingabeFehlerhaft = true;
        do {
            System.out.println("Geben Sie die Kundennummer ein:");
            String projektZuweisung = userInput();
            int p = 0;
            while ((p < kunden.length) && (kunden[p] != null)) {
                if (kunden[p].getCustomerNumber().equals(projektZuweisung)) {
                    project.setKunde(kunden[p]);
                    kundennummerEingabeFehlerhaft = false;
                }
                p++;
            }
        } while (kundennummerEingabeFehlerhaft);
        projekte[i] = project;
    }

    private static void createCustomer(Customer[] kunden) {


        int i = 0;
        while ((i < kunden.length) && (kunden[i] != null)) {
            i++;
        }
        if (kunden[i] != null) {
            System.out.println("Es wurden bereits 10 Kunden angelegt.");
            return;
        }

        System.out.println("Geben Sie den Vornamen ein:");
        String firstName = userInput();
        System.out.println("Geben Sie den Nachnamen ein:");
        String lastName = userInput();
        Address address = addressInput();

        String customerNumber = "K" + (100 + i);
        Customer customer = new Customer(firstName, lastName);
        customer.setCustomerNumber(customerNumber);
        customer.setAddress(address);
        kunden[i] = customer;

    }

    private static Address addressInput() {
        System.out.println("Geben Sie die Straße an:");
        String street = userInput();
        System.out.println("Geben Sie die Hausnummer an:");
        String streetNumber = userInput();
        System.out.println("Geben Sie die Postleitzahl an:");
        String zipcode = userInput();
        System.out.println("Geben Sie den Ort an:");
        String city = userInput();
        Address address = new Address(street, streetNumber, zipcode, city);
        return address;
    }

    public static void menueAufruf() {
        System.out.println("Herzlich Willkommen bei dem Projektmanager, was wollen Sie machen?");
        System.out.println("1. Kund:in anlegen");
        System.out.println("2. Projekt anlegen");
        System.out.println("3. Projekt anzeigen");
        System.out.println("4. Aufgabe zu Projekt hinzufügen");
        System.out.println("5. Aufgabe in Projekt erledigen");
        System.out.println("6. Programm beenden");
    }

    public static String userInput() {
        String userInput;
        do {
            userInput = scanner.nextLine();
        } while (userInput.equals(""));
        return userInput;

    }
}