package FILE_IO;

import java.io.Serializable;
import java.time.LocalDate;

public class STUDENT implements Serializable {
    private static final long serialVersionUID = 1L;
    private String rollNo;
    private String name;
    private LocalDate dob;
    private SUBJECT subject;
    private double GPA;

    public STUDENT(String rollNo, String name, LocalDate dob, SUBJECT subject, double GPA) {
        this.rollNo = rollNo;
        this.name = name;
        this.dob = dob;
        this.subject = subject;
        this.GPA = GPA;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public SUBJECT getSubject() {
        return subject;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "STUDENT{" +
                "rollNo='" + rollNo + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", subject=" + subject +
                ", GPA=" + GPA +
                '}';
    }
}
