import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;


// DCST, GOA UNIVERSITY
// CST DISCIPLINE - NIRF REPORTING SYSTEM
//displating all the oop concepts

public class Main {

    public static void main(String[] args) {

        System.out.println("       DCST CST - NIRF REPORTING SYSTEM");
        System.out.println("             Goa University");

       
        //  CONSTRUCTORS AND OBJECT REFERENCING
        

        System.out.println("\nSTUDENT RECORD MANAGEMENT");

        Student s1 = new Student(
                "CST2026-01",
                "Wolverine",
                2026,
                "MCA",
                "wolv123@gmail.com"
        );

        Student s2 = new Student(
                "CST2024-02",
                "Aachal Wadekar",
                2024,
                "MSc IT",
                "aach@gmail.com"
        );

        // Two variables refer to the same student record.
        // this shows two department users sharing one record.
        Student sharedRecord = s1;

        sharedRecord.setEmail("wolverine.updated@gmail.com");

        System.out.println("Student: " + s1.getName());
        System.out.println("Email through original reference: "
                + s1.getEmail());
        System.out.println("Email through shared reference: "
                + sharedRecord.getEmail());

        System.out.println(" Are botht the Same object " + (s1 == sharedRecord));

       
        //  STATIC MEMBERS AND ENUMS
       

        System.out.println("\n DEPARTMENT MEMBER STATISTICS");

        Staff teacher = new Staff(
                "T001", "Dr.Leena Fernandes",
                "Assistant Professor", StaffType.TEACHING
        );

        Staff administrator = new Staff(
                "NT001", "Sunil Kumar",
                "Office Assistant", StaffType.NON_TEACHING
        );

        System.out.println("Students and staff objects created: "
                + DepartmentMember.getMemberCount());

        System.out.println("Staff category: " + teacher.getStaffType());
        System.out.println("Staff category: " + administrator.getStaffType());

       
        //  MULTIPLE INTERFACES AND INHERITANCE
       
        System.out.println("\n MULTIPLE INTERFACE IMPLEMENTATION");

        DepartmentCoordinator coordinator =
                new DepartmentCoordinator("DCST Coordinator");

        coordinator.publishReport();

        coordinator.sendNotice(
                "Teaching staff must verify the NIRF data."
        );

        System.out.println(
                "The coordinator implements two interface contracts."
        );

        // Java does not allow extending two concrete classes.
        // Multiple interface implementation is allowed.
        //multiple inheritance is not allowed in java as it violates the conceptg of oop

       
        //  ACCESS MODIFIERS
        

        System.out.println("\n ACCESS MODIFIERS");

        AccessDemo access = new AccessDemo();
        access.showInternalAccess();

        System.out.println("Public information: " + access.publicInfo);

        // access.privateInfo;   // Compile-time error
        // access.protectedInfo; // Not accessible here
        
        
        //  ABSTRACT CLASSES, INTERFACES AND OVERRIDING

        System.out.println("\n DEPARTMENT ACTIVITIES");

        List<Activity> activities = new ArrayList<>();

        
        activities.add(new AcademicActivity(
                "ISA, Midpoint and SEA",
                "Continuous and semester assessment"
        ));

        activities.add(new AcademicActivity(
                "Research Conclave",
                "Research presentations and expert interaction"
        ));

        activities.add(new AcademicActivity(
                "Study Tour",
                "Industry exposure and practical learning"
        ));

        activities.add(new AcademicActivity(
                "Placement Training",
                "Employability and interview preparation"
        ));

        activities.add(new AcademicActivity(
                "Guest Lectures",
                "Interaction with industry professionals"
        ));

       
        activities.add(new NonAcademicActivity(
                "InfoFest",
                "Technology events, quizzes and coding challenges"
        ));

        activities.add(new NonAcademicActivity(
                "Plateaunia",
                "Cultural and creative student activities"
        ));

        activities.add(new NonAcademicActivity(
                "Play-on",
                "Sports and recreational activities"
        ));

        // A single list stores different subclasses.
       
        for (Activity activity : activities) {
            activity.describe();
        }
        

        System.out.println("\n MESSAGE PASSING");
        
        processReport(s1);
        processReport(teacher);
        processReport(activities.get(0));

        
        //  POLYMORPHISM: OVERLOADING
        

        System.out.println("\n REPORT GENERATION");

        ReportPrinter printer = new ReportPrinter();

        printer.print("Annual NIRF Summary");

        printer.print("Annual NIRF Summary", 2025);

        
        //  GENERICS AND COLLECTION FRAMEWORK
    

        System.out.println("\n STUDENTS, STAFF, COURSES AND TASKS");

        
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        
        List<Staff> staffMembers = new ArrayList<>();
        staffMembers.add(teacher);
        staffMembers.add(administrator);

        List<Course> courses = new ArrayList<>();

        courses.add(new Course(
                "MCA",
                "Object-Oriented Programming",
                "Linux Lab"
        ));

        courses.add(new Course(
                "MCA",
                "Database Management Systems",
                "Data Science and ML"
        ));

        courses.add(new Course(
                "MSc IT",
                "Computer Networks",
                "Network architecture and protocols"
        ));

        System.out.println("\nStudents:");
        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName()
                    + " - " + s.getProgram());
        }

        System.out.println("\nStaff:");
        for (Staff member : staffMembers) {
            System.out.println(member.getName() + " - "
                    + member.getDesignation());
        }

        System.out.println("\nCourses and example subjects:");
        for (Course course : courses) {
            System.out.println(course);
        }

        // Set prevents duplicate activity names.
        Set<String> activityNames = new LinkedHashSet<>();

        for (Activity activity : activities) {
            activityNames.add(activity.getName());
        }

        System.out.println("\nUnique activities: " + activityNames);

        // Queue models a department's reporting workflow.
        Queue<String> tasks = new LinkedList<>();

        tasks.add("Verify student enrolment");
        tasks.add("Verify teaching and non-teaching staff");
        tasks.add("Check academic activities and placements");
        tasks.add("Prepare and review NIRF report");

        System.out.println("\nNext reporting task: " + tasks.peek());

        // Map associates each academic year with an illustrative count.
        
        Map<String, Integer> StudentCounts =
                new LinkedHashMap<>();

        StudentCounts.put("2023-24", 100);
        StudentCounts.put("2024-25", 110);
        StudentCounts.put("2025-26", 120);

        System.out.println("\Three-year student counts:");
        System.out.println(StudentCounts);

        // Generic class
        Repository<Student> studentRepository =
                new Repository<>();

        studentRepository.add(s1);
        studentRepository.add(s2);

        System.out.println("Students in generic repository: "
                + studentRepository.getAll().size());

        // Generic method
        System.out.println("First course: "
                + firstItem(courses));

        
        // EXCEPTION HANDLING
       

        System.out.println("\n REPORT VALIDATION");

        try {
            validateReportingYear(2027);
            System.out.println("Reporting year accepted.");

        } catch (InvalidReportingYearException ex) {

            System.out.println("Validation error: "
                    + ex.getMessage());

        } finally {
            System.out.println("Year validation completed.");
        }

        System.out.println("\n STUDENT RECORD LOOKUP");

        Scanner scanner = new Scanner(System.in);

        System.out.print(
                "Enter student ID: "
        );

        String searchId = scanner.nextLine().trim();

        if (searchId.isEmpty()) {
            searchId = "CST2026-01";
        }

        Student found = null;

        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(searchId)) {
                found = s;
                break;
            }
        }

        if (found != null) {
            System.out.println("Student found: " + found.getName());
            System.out.println("Programme: " + found.getProgram());
            System.out.println("Email: " + found.getEmail());
        } else {
            System.out.println("No student found with ID: " + searchId);
        }

        
        //  REFLECTION, PERSISTENCE, FILE I/O AND CLONING
        

        System.out.println("\n REFLECTION AND PERSISTENCE");

        try {
            // Reflection / RTTI: inspect Student fields at runtime.
            System.out.println("Student class fields:");

            Field[] fields = Student.class.getDeclaredFields();

            for (Field field : fields) {
                System.out.println(" - " + field.getName());
            }

            
            String report = buildNIRFReport(
                    students,
                    staffMembers,
                    courses,
                    activities,
                    StudentCounts
            );

            // Text persistence: write report to a file.
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter("dcst_nirf_report.txt"))) {

                writer.write(report);
            }

            System.out.println("Text report saved: dcst_nirf_report.txt");

            // Object persistence: serialize a student record.
            try (ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("student_record.ser"))) {

                out.writeObject(s1);
            }

            System.out.println("Student saved: student_record.ser");

            // Shallow cloning: nested profile remains shared.
            Student shallowCopy = s1.clone();

            // Deep cloning: nested profile is copied as well.
            Student deepCopy = s1.deepClone();

            System.out.println("Shallow clone shares profile: "
                    + (s1.getProfile() == shallowCopy.getProfile()));

            System.out.println("Deep clone shares profile: "
                    + (s1.getProfile() == deepCopy.getProfile()));

            // a deep-copy side effect test.
            deepCopy.getProfile().setEmail("copy@example.com");

            System.out.println("Original profile email: "
                    + s1.getProfile().getEmail());

            System.out.println("Deep-copy profile email: "
                    + deepCopy.getProfile().getEmail());

        } catch (IOException ex) {
            System.out.println("File operation failed: "
                    + ex.getMessage());
        }

        System.out.println("\nNIRF REPORT");
        
        scanner.close();
    }

   
    static void processReport(Reportable item) {
        item.publishReport();
    }

    // Generic method: works with lists of different data types.
    static <T> T firstItem(List<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }

        return items.get(0);
    }

    //  custom exception for an invalid reporting year.
    static void validateReportingYear(int year)
            throws InvalidReportingYearException {

        if (year < 2000 || year > LocalDate.now().getYear()) {
            throw new InvalidReportingYearException(
                    "Year " + year + " is not a valid reporting year."
            );
        }
    }

    // Builds the report using the application records.
    static String buildNIRFReport(
            List<Student> students,
            List<Staff> staff,
            List<Course> courses,
            List<Activity> activities,
            Map<String, Integer> yearCounts) {

        StringBuilder report = new StringBuilder();

        report.append("DCST - CST DISCIPLINE NIRF REPORT\n");
        report.append("Goa University\n");
        report.append("Generated on: ").append(LocalDate.now()).append("\n\n");

        report.append("STUDENTS\n");

        for (Student s : students) {
            report.append(s.getId()).append(" | ")
                  .append(s.getName()).append(" | ")
                  .append(s.getProgram()).append("\n");
        }

        report.append("\nTEACHING AND NON-TEACHING STAFF\n");

        for (Staff member : staff) {
            report.append(member.getName()).append(" | ")
                  .append(member.getDesignation()).append(" | ")
                  .append(member.getStaffType()).append("\n");
        }

        report.append("\nPROGRAMMES AND SUBJECTS\n");

        for (Course c : courses) {
            report.append(c).append("\n");
        }

        report.append("\nACADEMIC AND NON-ACADEMIC ACTIVITIES\n");

        for (Activity activity : activities) {
            report.append(activity.getName()).append(" | ")
                  .append(activity.getPurpose()).append("\n");
        }

        report.append("\n YEAR-WISE COUNTS\n");

        for (Map.Entry<String, Integer> entry : yearCounts.entrySet()) {
            report.append(entry.getKey()).append(": ")
                  .append(entry.getValue())
                  .append(" students (illustrative)\n");
        }

        report.append("\nPlease do  Verify all records before official submission.\n");

        return report.toString();
    }
}


enum StaffType {
    TEACHING,
    NON_TEACHING
}


interface Reportable {
    void publishReport();
}


interface Notifiable {
    void sendNotice(String message);
}

// An interface can inherit from multiple interfaces.
// This is multiple inheritance of interface 
interface DepartmentCommunicator extends Reportable, Notifiable {
}



abstract class DepartmentMember implements Serializable {

    private static final long serialVersionUID = 1L;

    // Static means shared by all Student and Staff objects.
    private static int memberCount = 0;

    private final String id;
    private final String name;

    public DepartmentMember(String id, String name) {
        this.id = id;
        this.name = name;
        memberCount++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static int getMemberCount() {
        return memberCount;
    }
}

class Student extends DepartmentMember
        implements Reportable, Cloneable {

    private static final long serialVersionUID = 1L;

    private final int admissionYear;
    private final String program;
    private String email;

    
    private StudentProfile profile;

    public Student(
            String id,
            String name,
            int admissionYear,
            String program,
            String email) {

        super(id, name);

        this.admissionYear = admissionYear;
        this.program = program;
        this.email = email;
        this.profile = new StudentProfile(email);
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public String getProgram() {
        return program;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.profile.setEmail(email);
    }

    public StudentProfile getProfile() {
        return profile;
    }

    @Override
    public void publishReport() {
        System.out.println(
                "Student report: " + getName()
                + "  " + getId()
                + "  " + program
        );
    }

   
    @Override
    public Student clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError(ex);
        }
    }

    
    public Student deepClone() {
        Student copy = this.clone();
        copy.profile = this.profile.copy();
        return copy;
    }
}


class StudentProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;

    public StudentProfile(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentProfile copy() {
        return new StudentProfile(email);
    }
}



class Staff extends DepartmentMember implements Reportable {

    private static final long serialVersionUID = 1L;

    private final String designation;
    private final StaffType staffType;

    public Staff(
            String id,
            String name,
            String designation,
            StaffType staffType) {

        super(id, name);

        this.designation = designation;
        this.staffType = staffType;
    }

    public String getDesignation() {
        return designation;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    @Override
    public void publishReport() {
        System.out.println(
                "Staff report: " + getName()
                + "  " + designation
                + "  " + staffType
        );
    }
}



class DepartmentCoordinator implements DepartmentCommunicator {

    private final String role;

    public DepartmentCoordinator(String role) {
        this.role = role;
    }

    @Override
    public void publishReport() {
        System.out.println(role + " generated the department report.");
    }

    @Override
    public void sendNotice(String message) {
        System.out.println("Department notice: " + message);
    }
}


// ACCESS MODIFIERS

class AccessDemo {

    public String publicInfo = "Public department information";

    private String privateInfo = "Confidential information";

    protected String protectedInfo = "Information for package/subclass access";

    public void showInternalAccess() {
       // System.out.println("Inside AccessDemo:");
        System.out.println(publicInfo);
        System.out.println(privateInfo);
        System.out.println(protectedInfo);
    }
}


// ABSTRACT  CLASS


abstract class Activity implements Reportable {

    private final String name;
    private final String purpose;

    public Activity(String name, String purpose) {
        this.name = name;
        this.purpose = purpose;
    }

    public String getName() {
        return name;
    }

    public String getPurpose() {
        return purpose;
    }

    public abstract void describe();
}


class AcademicActivity extends Activity {

    public AcademicActivity(String name, String purpose) {
        super(name, purpose);
    }

    @Override
    public void describe() {
        System.out.println(
                "ACADEMIC: " + getName()
                + "  " + getPurpose()
        );
    }

    @Override
    public void publishReport() {
        System.out.println(
                "Academic activity recorded: " + getName()
        );
    }
}


class NonAcademicActivity extends Activity {

    public NonAcademicActivity(String name, String purpose) {
        super(name, purpose);
    }

    @Override
    public void describe() {
        System.out.println(
                "NON-ACADEMIC: " + getName()
                + "  " + getPurpose()
        );
    }

    @Override
    public void publishReport() {
        System.out.println(
                "Non-academic activity recorded: " + getName()
        );
    }
}

class Course {

    private final String program;
    private final String subject;
    private final String description;

    public Course(String program, String subject, String description) {
        this.program = program;
        this.subject = subject;
        this.description = description;
    }

    @Override
    public String toString() {
        return program + "  " + subject + "  " + description;
    }
}

// METHOD OVERLOADING


class ReportPrinter {

    public void print(String title) {
        System.out.println("Report: " + title);
    }

    public void print(String title, int year) {
        System.out.println("Report: " + title + " | Year: " + year);
    }
}

// GENERIC REPOSITORY

class Repository<T> {

    private final List<T> records = new ArrayList<>();

    public void add(T record) {
        records.add(record);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(records);
    }
}

// CUSTOM EXCEPTION

class InvalidReportingYearException extends Exception {

    public InvalidReportingYearException(String message) {
        super(message);
    }
}
