import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String st_Name;
    int age,id=0;
    String st_Gender,st_Class;
    float average_Score;
    Student(String name, int age, String st_Gender,float score,int id){
        this.st_Name = name;
        this.age = age;
        this.st_Gender = st_Gender;
        this.average_Score = score;
    }
    Student(){};
    public void input_Student_Information(){
        Scanner scanner = new Scanner(System.in);
        //st_name
        System.out.print("Insert student's name: ".toUpperCase());
        this.st_Name = scanner.nextLine();
        System.out.print(">> Press enter to continue <<".toUpperCase());
        scanner.nextLine();
        //insert age
        boolean check=false;
        do{
            String age;
            System.out.print("Insert student's age: ".toUpperCase());
            age = scanner.nextLine();
            try{
                this.age = Integer.parseInt(age);
                check = true;
                if(this.age>120){
                    check=false;
                    System.out.println(">> Inserted out of age <<".toUpperCase());
                }
            }catch (Exception e){
                System.out.println(">> Invalid inserted <<".toUpperCase());
            }
        }while (!check);
        //st_id
        do{
            check = false;
            String d;
            System.out.print("Insert student's id: ".toUpperCase());
            d = scanner.nextLine();
            try{
                this.id = Integer.parseInt(d);
                check = true;
            }catch (Exception e){
                System.out.println(">> Invalid inserted <<".toUpperCase());
            }
        }while (!check);
        //st_gender
        System.out.print("Insert student's gender: ".toUpperCase());
        this.st_Gender = scanner.nextLine();
        //st_Class
        System.out.print("Insert student's class: ".toUpperCase());
        this.st_Class = scanner.nextLine();
        System.out.print(">> Press enter to continue <<".toUpperCase());
        scanner.nextLine();
        //st_average_score
        do {
            check = false;
            String score;
            System.out.print("Insert Average score: ".toUpperCase());
            score = scanner.nextLine();
            try{
                this.average_Score = Float.parseFloat(score);
                check = true;
            }catch (Exception e){
                try {
                    this.average_Score = Integer.parseInt(score);
                    check=true;
                }catch (Exception E){
                    System.out.println(">> Invalid inserted <<".toUpperCase());
                }
            }
        }while (!check);
        //System.out.println("--------------------------------------------");
    }
    public void student_Show_Information(){
        System.out.println("Name: " + this.st_Name);
        System.out.println("Age: " + this.age);
        System.out.println("ID: " + this.id);
        System.out.println("Gender: " + this.st_Gender);
        System.out.println("Student's class: " + this.st_Class);
        System.out.println("Average score: " + this.average_Score);
        //System.out.println("--------------------------------------------");
    }
}
//program
public class Student_Management {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        int show=0;
        boolean check=false;
        label1:
        do{
            System.out.println("====================== Student management System =======================".toUpperCase());
            System.out.println("1. Add student infor_".toUpperCase());
            System.out.println("2. Update student infor_".toUpperCase());
            System.out.println("3. Delete student infor_".toUpperCase());
            System.out.println("4. Select student infor_".toUpperCase());
            System.out.println("5. Show student infor_".toUpperCase());
            System.out.println("6. Exit_");
            //System.out.println("--------------------------------------------");
            do{
                String choice;
                System.out.print(">> Insert choice: ".toUpperCase());
                choice = scanner.nextLine();
                try{
                    show = Integer.parseInt(choice);
                    check = true;
                }catch (Exception e){
                    System.out.println(">> Invalid inserted <<".toUpperCase());
                    System.out.print(">> Press enter to continue <<".toUpperCase());
                    scanner.nextLine();
                    continue label1;
                }
            }while (!check);
            switch (show){
                case 1:
                    System.out.println("------------------------------- Adding student -------------------------".toUpperCase());
                    Student student = new Student();
                    student.input_Student_Information();
                    students.add(student);
                    System.out.println(">> Added successfully <<".toUpperCase());
                    System.out.print(">> Press enter to continue <<".toUpperCase());
                    scanner.nextLine();
                    break;
                case 2:
                    label2:
                    do {
                        try{
                            if(students.get(0).id==0){};
                        }catch (Exception ppp){
                            System.out.println(">> no any student in the list yet for updating <<".toUpperCase());
                            System.out.print(">> Press enter to continue <<".toUpperCase());
                            scanner.nextLine();
                            break label2;
                        }
                        System.out.println("-------------------- Update student's info_ -----------------------".toUpperCase());
                        int ch__=0;
                        String ch_;
                        System.out.println(">> 1. Update by ID".toUpperCase());
                        System.out.println(">> 2. Update by name".toUpperCase());
                        do {
                            check = false;
                            System.out.print(">> Choose: ");
                            ch_ = scanner.nextLine();
                            try{
                                ch__ = Integer.parseInt(ch_);
                                check = true;
                            }catch (Exception h){
                                System.out.println(">> Invalid inserted".toUpperCase());
                                System.out.print(">> Press enter to continue <<".toUpperCase());
                                scanner.nextLine();
                            }
                        }while (!check);
                        switch (ch__){
                            case 1:
                                do{
                                    System.out.print(">> Update by student's ID: ".toUpperCase());
                                    ch_ = scanner.nextLine();
                                    try{
                                        ch__ = Integer.parseInt(ch_);
                                        check = true;
                                    }catch (Exception c){
                                        System.out.println(">> Invalid inserted << ".toUpperCase());
                                        System.out.print(">> Press enter to continue <<".toUpperCase());
                                        scanner.nextLine();
                                    }
                                }while (!check);
                                for(int i=0;i<students.size();i++){
                                    if(ch__==students.get(i).id){
                                        students.get(i).input_Student_Information();
                                        System.out.println(">> Update successfully <<".toUpperCase());
                                        System.out.print(">> Press enter to continue <<".toUpperCase());
                                        scanner.nextLine();
                                        check = false;
                                    }
                                }
                                if(check==true){
                                    System.out.println(">> Not match any ID <<".toUpperCase());
                                    System.out.print(">> Press enter to continue <<".toUpperCase());
                                    scanner.nextLine();
                                }
                                break label2;
                            case 2:
                                System.out.print(">> Update by student's name: ".toUpperCase());
                                ch_ = scanner.nextLine();
                                for(int i=0;i<students.size();i++){
                                    if(ch_.equals(students.get(i).st_Name)){
                                        students.get(i).input_Student_Information();
                                        System.out.println(">> Update successfully <<".toUpperCase());
                                        System.out.print(">> Press enter to continue <<".toUpperCase());
                                        scanner.nextLine();
                                        check = false;
                                    }
                                }
                                if(check==true){
                                    System.out.println(">> Not match any name <<".toUpperCase());
                                    System.out.print(">> Press enter to continue <<".toUpperCase());
                                    scanner.nextLine();
                                }
                                break label2;
                            default:
                                System.out.println(">> Not match any choice <<");
                                System.out.print(">> Press enter to continue <<".toUpperCase());
                                scanner.nextLine();
                        }
                    }while (true);
                    break;
                case 3:
                    label3:
                    do {
                        try{
                            if (students.get(0).id==0){};
                        }catch (Exception tt){
                            System.out.println(">> No any student in the list yet <<".toUpperCase());
                            System.out.print(">> Press enter to continue <<".toUpperCase());
                            scanner.nextLine();
                            break label3;
                        }
                        System.out.println("---------------------- Delete student's info_ ---------------------".toUpperCase());
                        int ch=0;
                        String chg;
                        System.out.println(">> 1. Delete by ID".toUpperCase());
                        System.out.println(">> 2. Delete by name".toUpperCase());
                        do {
                            check  =false;
                            System.out.print(">> Choose: ");
                            chg = scanner.nextLine();
                            try{
                                ch = Integer.parseInt(chg);
                                check  =true;
                            }catch (Exception g){
                                System.out.println(">> Invalid inserted <<".toUpperCase());
                                System.out.print(">> Press enter to continue <<".toUpperCase());
                                scanner.nextLine();
                            }
                        }while (!check);
                        switch (ch){
                            case 1:
                                do{
                                    System.out.print(">> Delete by student's ID: ".toUpperCase());
                                    chg = scanner.nextLine();
                                    try{
                                        ch = Integer.parseInt(chg);
                                        check = true;
                                    }catch (Exception c){
                                        System.out.println(">> Invalid inserted << ".toUpperCase());
                                        System.out.print(">> Press enter to continue <<".toUpperCase());
                                        scanner.nextLine();
                                    }
                                }while (!check);
                                check = false;
                                for(int i=0;i<students.size();i++){
                                    if(ch==students.get(i).id){
                                        students.remove(i);
                                        System.out.println(">> Deleted successfully <<".toUpperCase());
                                        System.out.print(">> Press enter to continue <<".toUpperCase());
                                        scanner.nextLine();
                                        check = true;
                                    }
                                }
                                if(check==false){
                                    System.out.println(">> THE ID " + ch + " NOT FOUND <<");
                                    System.out.print(">> Press enter to continue <<".toUpperCase());
                                    scanner.nextLine();
                                }
                                break label3;
                            case 2:
                                check = false;
                                System.out.print(">> Delete by student's name: ".toUpperCase());
                                chg = scanner.nextLine();
                                for (int i = 0; i < students.size(); i++) {
                                    if (chg.equals(students.get(i).st_Name)) {
                                        students.remove(i);
                                        System.out.println(">> Completely deleted <<".toUpperCase());
                                        System.out.print(">> Press enter to continue <<".toUpperCase());
                                        scanner.nextLine();
                                        check = true;
                                        break;
                                    }
                                    if(check==false){
                                        System.out.println("No match any name".toUpperCase());
                                        System.out.print(">> Press enter to continue <<".toUpperCase());
                                        scanner.nextLine();
                                    }
                                }
                                break label3;
                            default:
                                System.out.println(">> Not match any choice <<".toUpperCase());
                                System.out.print(">> Press enter to continue <<".toUpperCase());
                                scanner.nextLine();
                                break label3;
                        }
                    }while (true);
                    break;
                case 4:
                    label:
                    do {
                        try {
                            if(students.get(0).id==0){};
                        }catch (Exception p){
                            System.out.println(">> No any student in the list yet <<".toUpperCase());
                            System.out.print(">> Press enter to continue <<".toUpperCase());
                            scanner.nextLine();
                            break label;
                        }
                        System.out.println("--------------------- Select student's info_ ----------------------".toUpperCase());
                        int idch=0;
                        String idchg;
                        System.out.println(">> 1. Select by ID".toUpperCase());
                        System.out.println(">> 2. Select by name".toUpperCase());
                        System.out.println(">> 3. Select by gender".toUpperCase());
                        System.out.println(">> 4. Select by class".toUpperCase());
                        do {
                            check = false;
                            System.out.print(">> Choose: ");
                            idchg = scanner.nextLine();
                            try{
                                idch = Integer.parseInt(idchg);
                                check = true;
                            }catch (Exception h){
                                System.out.println(">> Invalid inserted".toUpperCase());
                                System.out.print(">> Press enter to continue <<".toUpperCase());
                                scanner.nextLine();
                            }
                        }while (!check);
                        switch (idch){
                            case 1:
                                check = false;
                                System.out.print(">> Select by student's ID: ".toUpperCase());
                                idchg = scanner.nextLine();
                                idch = 0;
                                try{
                                    idch = Integer.parseInt(idchg);
                                }catch (Exception c){
                                    System.out.println(">> Invalid inserted << ".toUpperCase());
                                    System.out.print(">> Press enter to continue <<".toUpperCase());
                                    scanner.nextLine();
                                }
                                for(int i=0;i<students.size();i++){
                                    if(idch==students.get(i).id){
                                        System.out.println("--------------------------------------------------------------------".toUpperCase());
                                        students.get(i).student_Show_Information();
                                        check = true;
                                        System.out.println("--------------------------------------------------------------------".toUpperCase());
                                        if(i==students.size()-1){
                                            System.out.println(">> Selected successfully <<".toUpperCase());
                                            System.out.print(">> Press enter to continue <<".toUpperCase());
                                            scanner.nextLine();
                                        }
                                    }
                                }
                                scanner.nextLine();
                                if(check==false){
                                    System.out.println(">> No id matched <<".toUpperCase());
                                    System.out.print(">> Press enter to continue <<".toUpperCase());
                                    scanner.nextLine();
                                }
                                break label;
                            case 2:
                                System.out.print(">> Select by student's name: ".toUpperCase());
                                idchg = scanner.nextLine();
                                check = false;
                                for (int i = 0; i < students.size(); i++) {
                                    if (idchg.equals(students.get(i).st_Name)) {
                                        System.out.println("--------------------------------------------------------------------".toUpperCase());
                                        students.get(i).student_Show_Information();
                                        check =true;
                                        System.out.println("--------------------------------------------------------------------".toUpperCase());
                                        if(i==students.size()-1){
                                            System.out.println(">> Selected successfully <<".toUpperCase());
                                            System.out.print(">> Press enter to continue <<".toUpperCase());
                                            scanner.nextLine();
                                        }
                                    }
                                }
                                if(check==false){
                                    System.out.println(">> No name matched <<".toUpperCase());
                                    System.out.print(">> Press enter to continue <<".toUpperCase());
                                    scanner.nextLine();
                                }
                                break label;
                            case 3:
                                System.out.print(">> Select by student's gender: ".toUpperCase());
                                idchg = scanner.nextLine();
                                check = false;
                                for (int i = 0; i < students.size(); i++) {
                                    if (idchg.equals(students.get(i).st_Gender)) {
                                        System.out.println("--------------------------------------------------------------------".toUpperCase());
                                        students.get(i).student_Show_Information();
                                        check = true;
                                        System.out.println("--------------------------------------------------------------------".toUpperCase());
                                        if(i==students.size()-1){
                                            System.out.println(">> Selected successfully <<".toUpperCase());
                                            System.out.print(">> Press enter to continue <<".toUpperCase());
                                            scanner.nextLine();
                                        }
                                    }
                                }
                                if(!check){
                                    System.out.println(">> Not match any type of gender <<".toUpperCase());
                                    System.out.print(">> Press enter to continue <<".toUpperCase());
                                    scanner.nextLine();
                                }
                                break label;
                            case 4:
                                System.out.print(">> Select by student's class: ".toUpperCase());
                                idchg = scanner.nextLine();
                                check = false;
                                for (int i = 0; i < students.size(); i++) {
                                    if (idchg.equals(students.get(i).st_Class)) {
                                        System.out.println("--------------------------------------------------------------------".toUpperCase());
                                        students.get(i).student_Show_Information();
                                        check = true;
                                        System.out.println("--------------------------------------------------------------------".toUpperCase());
                                        if(i==students.size()-1){
                                            System.out.println(">> Selected successfully <<".toUpperCase());
                                            System.out.print(">> Press enter to continue <<".toUpperCase());
                                            scanner.nextLine();
                                        }
                                    }
                                }
                                if(!check){
                                    System.out.println(">> No class matched <<".toUpperCase());
                                    System.out.print(">> Press enter to continue <<".toUpperCase());
                                    scanner.nextLine();
                                }
                                break label;
                            default:
                                System.out.println(">> Not match any choice".toUpperCase());
                                System.out.print(">> Press enter to continue <<".toUpperCase());
                                scanner.nextLine();
                                break label;
                        }
                    }while (true);
                    break;
                case 5:
                    label5:
                    do {
                        try{
                            if(students.get(0).id==0){};
                        }catch (Exception ttt){
                            System.out.println(">> no any student in the list yet <<".toUpperCase());
                            System.out.print(">> Press enter to continue <<".toUpperCase());
                            scanner.nextLine();
                            break label5;
                        }
                        System.out.println("----------------------   Showing student info_   -----------------------".toUpperCase());
                        check = false;
                        for(int i=0;i<students.size();i++){
                            students.get(i).student_Show_Information();
                            System.out.println("------------------------------------------------------------------------".toUpperCase());
                        }
                        System.out.println(">> Completely Shown <<".toUpperCase());
                        System.out.print(">> Press enter to continue <<".toUpperCase());
                        scanner.nextLine();
                        break label5;
                    }while (true);
                    break;

                case 6:
                    System.out.println(">>>>>>>>>>>>>>>>>>>>> The Program was closed <<<<<<<<<<<<<<<<<<<<<<<<<<<".toUpperCase());
                    System.exit(0);
                    break;
                default:
                    System.out.println(">> Invalid choice <<".toUpperCase());
                    System.out.print(">> Press enter to continue <<".toUpperCase());
                    scanner.nextLine();
                    break;
            }
        }while (true);
    }
}
