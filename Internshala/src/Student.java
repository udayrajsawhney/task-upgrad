/*
 * Student Class to create objects for Students to add in Serve Queue */
public class Student {

    private String name;
    private float cgpa;
    private int token;

    //Constructor
    public Student(String name, float cgpa, int token) {
        this.name = name;
        this.cgpa = cgpa;
        this.token = token;
    }

    // Getter and Setter Functions

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }
}
