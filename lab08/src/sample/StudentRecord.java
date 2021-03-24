package sample;

public class StudentRecord {
    private String studentID;
    private char letterGrade;
    private String assignments, midterm, exam;

    StudentRecord(String s, String a, String m, String e){
        studentID = s;
        assignments = a;
        midterm = m;
        exam = e;
    }

    public String getStudentID(){
        return studentID;
    }

    public String getAssignments(){
        return assignments;
    }

    public String getMidterm(){
        return midterm;
    }

    public String getExam(){
        return exam;
    }

    public float getFinalGrade(){
        float a, m, e;
        a = Float.parseFloat(getAssignments()) *0.2f;
        m = Float.parseFloat(getMidterm())*0.3f;
        e = Float.parseFloat(getExam())*0.5f;

        return (a+m+e);
    }

    public char getLetterGrade(){
        float grade;

        grade = getFinalGrade();

        if(grade >= 80){
            letterGrade = 'A';
        }    
        
        else if(grade >= 70 && grade <= 79){
            letterGrade = 'B';
        }  

        else if(grade >= 60 && grade <= 69){
            letterGrade = 'C';
        } 

        else if(grade >= 50 && grade <= 59){
            letterGrade = 'D';
        } 

        else{
            letterGrade = 'F';
        }
        return letterGrade;
    }
}
