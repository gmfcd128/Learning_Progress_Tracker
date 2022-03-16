package tracker;

public class Student {
    private static int autoIncrementID = 10000;
    private int studentId;
    private String firstName, lastName;

    public int getJavaPoints() {
        return javaPoints;
    }

    public int getDsaPoints() {
        return dsaPoints;
    }

    public int getDatabasePoints() {
        return databasePoints;
    }

    public int getSpringPoints() {
        return springPoints;
    }

    public int getJavaTaskCompleted() {
        return javaTaskCompleted;
    }

    public int getDsaTaskCompleted() {
        return dsaTaskCompleted;
    }

    public int getDatabaseTaskCompleted() {
        return databaseTaskCompleted;
    }

    public int getSpringTaskCompleted() {
        return springTaskCompleted;
    }

    private int javaPoints;
    private int javaTaskCompleted;
    private int dsaPoints;
    private int dsaTaskCompleted;
    private int databasePoints;
    private int databaseTaskCompleted;
    private int springPoints;
    private int springTaskCompleted;

    public boolean javaFinishNotified() {
        return javaFinishNotified;
    }

    public void setJavaFinishNotified() {
        javaFinishNotified = true;
    }
    public boolean dsaFinishNotified() {
        return dsaFinishNotified;
    }

    public void setDsaFinishNotified() {
        dsaFinishNotified = true;
    }

    public boolean databaseFinishNotified() {
        return databaseFinishNotified;
    }

    public void setDatabaseFinishNotified() {
        databaseFinishNotified = true;
    }

    public boolean springFinishNotified() {
        return springFinishNotified;
    }

    public void setSpringFinishNotified() {
        springFinishNotified = true;
    }

    private boolean javaFinishNotified;
    private boolean dsaFinishNotified;
    private boolean databaseFinishNotified;
    private boolean springFinishNotified;

    public Student(String firstName, String lastName) {
        this.studentId = autoIncrementID;
        this.javaPoints = 0;
        this.javaTaskCompleted = 0;
        this.dsaPoints = 0;
        this.dsaTaskCompleted = 0;
        this.databasePoints = 0;
        this.databaseTaskCompleted = 0;
        this.springPoints = 0;
        this.springTaskCompleted = 0;
        this.javaFinishNotified = false;
        this.dsaFinishNotified = false;
        this.databaseFinishNotified = false;
        this.springFinishNotified = false;
        this.firstName = firstName;
        this.lastName = lastName;
        autoIncrementID++;
    }

    public String getStudentName() {
        return this.firstName + " " + this.lastName;
    }

    public void addPoints(int javaAddPoints, int dsaAddPoints, int databaseAddPoints, int springAddPoints) {
        this.javaPoints += javaAddPoints;
        if (javaAddPoints > 0) {
            this.javaTaskCompleted++;
        }
        this.dsaPoints += dsaAddPoints;
        if (dsaAddPoints > 0) {
            this.dsaTaskCompleted++;
        }
        this.databasePoints += databaseAddPoints;
        if (databaseAddPoints > 0) {
            this.databaseTaskCompleted++;
        }
        this.springPoints += springAddPoints;
        if (springAddPoints > 0) {
            this.springTaskCompleted++;
        }
    }

    public int getStudentId() {
        return this.studentId;
    }

    @Override
    public String toString() {
        return String.format("%d points: Java=%d; DSA=%d; Databases=%d; Spring=%d", this.studentId, this.javaPoints, this.dsaPoints, this.databasePoints, this.springPoints);
    }
}
