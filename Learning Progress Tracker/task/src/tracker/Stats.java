package tracker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Stats {
    static final int JAVA_FINISH_POINT = 600;
    static final int DSA_FINISH_POINT = 400;
    static final int DATABASE_FINISH_POINT = 480;
    static final int SPRING_FINISH_POINT = 550;
    static final String[] courseNameByIndex = {"JAVA", "DSA", "Databases", "Spring"};
    int[] studentCount = new int[4]; // java, dsa, database & spring
    int[] activityCount = new int[4]; // java, dsa, database & spring
    int[] totalScore = new int[4];

    ArrayList<Student> studentData;

    public Stats(HashMap<String, Student> studentHashMap) {
        this.studentData = new ArrayList<>();
        for (Map.Entry<String, Student> entry :
                studentHashMap.entrySet()) {
            totalScore[0] += entry.getValue().getJavaPoints();
            totalScore[1] += entry.getValue().getDsaPoints();
            totalScore[2] += entry.getValue().getDatabasePoints();
            totalScore[3] += entry.getValue().getSpringPoints();
            if (entry.getValue().getJavaPoints() > 0) {
                studentCount[0]++;
                activityCount[0] += entry.getValue().getJavaTaskCompleted();
            }
            if (entry.getValue().getDsaPoints() > 0) {
                studentCount[1]++;
                activityCount[1] += entry.getValue().getDsaTaskCompleted();
            }
            if (entry.getValue().getDatabasePoints() > 0) {
                studentCount[2]++;
                activityCount[2] += entry.getValue().getDatabaseTaskCompleted();
            }
            if (entry.getValue().getSpringPoints() > 0) {
                studentCount[3]++;
                activityCount[3] += entry.getValue().getSpringTaskCompleted();
            }
            this.studentData.add(entry.getValue());
        }

    }

    public void outputSummary() {
        ArrayList<String> mostPopular = getMostPopularCourseLabels();
        ArrayList<String> leastPopular = getLeastPopularCourseLabels();
        for (String course : mostPopular) {
            if (leastPopular.contains(course)) {
                leastPopular.remove(course);
            }
        }
        outputListWithTitle("Most popular", mostPopular);
        outputListWithTitle("Least popular", leastPopular);

        ArrayList<String> mostActive = getMostActiveCourseLabels();
        ArrayList<String> leastActive = getLeastActiveCourseLabels();
        for (String course : mostActive) {
            if (leastActive.contains(course)) {
                leastActive.remove(course);
            }
        }
        outputListWithTitle("Highest activity", mostActive);
        outputListWithTitle("Lowest activity", leastActive);

        ArrayList<String> easiest = getEasiestCourseLabels();
        ArrayList<String> hardest = getHardestCourseLabels();
        for (String course : easiest) {
            if (hardest.contains(course)) {
                hardest.remove(course);
            }
        }
        outputListWithTitle("Easiest course", easiest);
        outputListWithTitle("Hardest course", hardest);
    }

    private ArrayList<String> getMostPopularCourseLabels() {
        ArrayList<String> result = new ArrayList<>();

        int maxStudentCount = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            if ((studentCount[i] > 0) && (studentCount[i] > maxStudentCount)) {
                maxStudentCount = studentCount[i];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (studentCount[i] == maxStudentCount) {
                result.add(courseNameByIndex[i]);
            }
        }

        return result;
    }

    private ArrayList<String> getLeastPopularCourseLabels() {
        ArrayList<String> result = new ArrayList<>();
        int minStudentCount = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            if ((studentCount[i] > 0) && (studentCount[i] < minStudentCount)) {
                minStudentCount = studentCount[i];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (studentCount[i] == minStudentCount) {
                result.add(courseNameByIndex[i]);
            }
        }

        return result;
    }

    private ArrayList<String> getMostActiveCourseLabels() {
        ArrayList<String> result = new ArrayList<>();

        int maxActivityCount = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            if ((activityCount[i] > 0) && (activityCount[i] > maxActivityCount)) {
                maxActivityCount = activityCount[i];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (activityCount[i] == maxActivityCount) {
                result.add(courseNameByIndex[i]);
            }
        }

        return result;
    }

    private ArrayList<String> getLeastActiveCourseLabels() {
        ArrayList<String> result = new ArrayList<>();

        int minActivityCount = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            if ((activityCount[i] > 0) && (activityCount[i] < minActivityCount)) {
                minActivityCount = activityCount[i];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (activityCount[i] == minActivityCount) {
                result.add(courseNameByIndex[i]);
            }
        }

        return result;
    }

    private ArrayList<String> getEasiestCourseLabels() {
        ArrayList<String> result = new ArrayList<>();

        double minAverageScore = Double.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            if ((activityCount[i] > 0) && (totalScore[i] / activityCount[i] > minAverageScore)) {
                minAverageScore = totalScore[i] / activityCount[i];
            }
        }

        for (int i = 0; i < 4; i++) {
            if ((activityCount[i] > 0) && (totalScore[i] / activityCount[i] == minAverageScore)) {
                result.add(courseNameByIndex[i]);
            }
        }

        return result;
    }

    private ArrayList<String> getHardestCourseLabels() {
        ArrayList<String> result = new ArrayList<>();

        double minAverageScore = Double.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            if ((activityCount[i] > 0) && (totalScore[i] / activityCount[i] < minAverageScore)) {
                minAverageScore = totalScore[i] / activityCount[i];
            }
        }

        for (int i = 0; i < 4; i++) {
            if ((activityCount[i] > 0) && (totalScore[i] / activityCount[i] == minAverageScore)) {
                result.add(courseNameByIndex[i]);
            }
        }

        return result;
    }

    private void outputListWithTitle(String title, ArrayList<String> list) {
        System.out.print(title + ": ");
        if (list.size() == 0) {
            System.out.print("n/a\n");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("\n");
        }
    }

    public void outputCourseRank(String courseName) {
        if (courseName.toLowerCase(Locale.ROOT).equals("java")) {
            System.out.println("Java");
            System.out.println("id\tpoints\tcompleted");
            studentData.sort(Comparator.comparing(Student::getJavaPoints).reversed().thenComparing(Student::getStudentId));
            for (Student student : studentData) {
                if (student.getJavaPoints() > 0) {
                    System.out.printf("%d\t%d\t%s%%\n", student.getStudentId(), student.getJavaPoints(), new BigDecimal((double) student.getJavaPoints() / (double) JAVA_FINISH_POINT * 100)
                            .setScale(1, RoundingMode.HALF_UP));
                }
            }
        } else if (courseName.toLowerCase(Locale.ROOT).equals("dsa")) {
            System.out.println("DSA");
            System.out.println("id\tpoints\tcompleted");
            studentData.sort(Comparator.comparing(Student::getDsaPoints).reversed().thenComparing(Student::getStudentId));
            for (Student student : studentData) {
                if (student.getDsaPoints() > 0) {
                    System.out.printf("%d\t%d\t%s%%\n", student.getStudentId(), student.getDsaPoints(), new BigDecimal((double) student.getDsaPoints() / (double) DSA_FINISH_POINT * 100)
                            .setScale(1, RoundingMode.HALF_UP));
                }
            }
        } else if (courseName.toLowerCase(Locale.ROOT).equals("databases")) {
            System.out.println("Databases");
            System.out.println("id\tpoints\tcompleted");
            studentData.sort(Comparator.comparing(Student::getDatabasePoints).reversed().thenComparing(Student::getStudentId));
            for (Student student : studentData) {
                if (student.getDatabasePoints() > 0) {
                    System.out.printf("%d\t%d\t%s%%\n", student.getStudentId(), student.getDatabasePoints(), new BigDecimal((double) student.getDatabasePoints() / (double) DATABASE_FINISH_POINT * 100)
                            .setScale(1, RoundingMode.HALF_UP));
                }
            }
        } else if (courseName.toLowerCase(Locale.ROOT).equals("spring")) {
            System.out.println("Spring");
            System.out.println("id\tpoints\tcompleted");
            studentData.sort(Comparator.comparing(Student::getSpringPoints).reversed().thenComparing(Student::getStudentId));
            for (Student student : studentData) {
                if (student.getSpringPoints() > 0) {
                    System.out.printf("%d\t%d\t%s%%\n", student.getStudentId(), student.getSpringPoints(), new BigDecimal((double) student.getSpringPoints() / (double) SPRING_FINISH_POINT * 100)
                            .setScale(1, RoundingMode.HALF_UP));
                }
            }
        } else {
            System.out.println("Unknown course.");
        }
    }

}
