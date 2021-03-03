package sample;

public class StudentRecord {
    private String studentID;
    private char letterGrade;
    private float assignments, midterm, exam;

    StudentRecord(String s, float a, float m, float e){
        studentID = s;
        assignments = a;
        midterm = m;
        exam = e;
    }

    public String getStudentID(){
        return studentID;
    }

    public float getAssignments(){
        return assignments;
    }

    public float getMidterm(){
        return midterm;
    }

    public float getExam(){
        return exam;
    }

    public float getFinalGrade(){
        float a, m, e;
        a = getAssignments()*0.2f;
        m = getMidterm()*0.3f;
        e = getExam()*0.5f;

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
