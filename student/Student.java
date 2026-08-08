public class Student {

    String studentId;
    String fullName;
    double attendanceScore;
    double midtermScore;
    double finalScore;
    double totalScore;
    String grade;
    

    public Student(String studentId, String fullName, 
                   double attendanceScore, double midtermScore, double finalScore) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.attendanceScore = attendanceScore;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
    }
}