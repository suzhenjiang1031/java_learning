import java.util.Scanner;

public class STUDENTS {
    final static  int STUDENT_NUM=6;
    final static  int COURSE_NUM=5;
    static String[] students={"zhang","wang","li","zhao","liu","song"};
    static String[] courses={"C","Java","mySQL","Linux","HTML"};
    static int[][] score=  new int[STUDENT_NUM][COURSE_NUM];
    public static void main(String[] args) {

        // TODO 自动生成的方法存根
        initScore();
        show();
        run();

    }
    private static void run() {
        Scanner scn = new Scanner(System.in);
        System.out.println("password:");
        String cmd1 = scn.next();
        if(!cmd1.equalsIgnoreCase("12345678")) {
            return;
        }
        // TODO 自动生成的方法存根
        while(true) {
            System.out.println("input command:");
            String cmd = scn.next();
            if(cmd.equalsIgnoreCase("avg")) {
                String parameter = scn.next();
                avg(parameter);
            }
            else if(cmd.equalsIgnoreCase("get")) {
                String stu = scn.next();
                String course = scn.next();
                get( stu,course);
            }
            else if(cmd.equalsIgnoreCase("sort")) {
                String parameter = scn.next();
                sort(parameter);
            }
            else if(cmd.equalsIgnoreCase("max")) {
                String parameter = scn.next();
                max(parameter);
            }
            else if(cmd.equalsIgnoreCase("exit")) {
                System.out.println(" bye~");
                System.exit(0);
            }
            else {
                System.out.println(" errrrrrr~");
            }

        }

    }
    private static void get(String parameter, String parameter1) {
        // TODO 自动生成的方法存根
        int j_index =-1;
        for( int j =0;j<courses.length;j++) {
            System.out.println("j:"+j+"|"+courses[j]);
            if(parameter1.equalsIgnoreCase(courses[j])) {  //true
                j_index =j;
                break;}
        }
        if (j_index ==-1)
            return;
        int i_index =-1;
        for(int i =0;i<students.length;i++) {
            System.out.println("i:"+i+"|"+students[i]);
            if(parameter.equalsIgnoreCase(students[i]))  {//true
                i_index =i;
                break;}
        }
        if(i_index!=-1&&j_index!=-1)
            System.out.println("get "+parameter+" "+parameter1+":"+score[i_index][j_index]);
        else
            System.out.println("void");



    }
    static void initScore( ) {
        for(int i =0;i<score.length;i++) {
            for(int j =0;j<score[0].length;j++) {
                score[i][j]= (int) (Math.random()*100);
            }
        }
    }
    static void show() {
        System.out.print("        ");
        for(int i=0;i<courses.length;i++){
            System.out.printf("%-8s",courses[i]);
        }
        System.out.println();
        for(int i =0;i<score.length;i++) {
            System.out.printf("%-8s",students[i]);
            for(int j =0;j<score[0].length;j++) {
                System.out.printf("%-8s",score[i][j]);
            }
            System.out.println();
        }
    }
    static void avg(String parameter){
        //avg java
        for(int j =0;j<courses.length;j++) {
            if(parameter.equalsIgnoreCase(courses[j])) { //true
                int sum = 0;//j=1
                for(int i =0;i<score.length;i++) {
                    sum+= score[i][j];
                }
                System.out.println("avg "+parameter+":" +sum/STUDENT_NUM);
                return;
            }
        }
        //avg zhang
        for(int j =0;j<students.length;j++) {
            if(parameter.equalsIgnoreCase(students[j])) { //true
                int sum = 0;//j=1
                for(int i =0;i<score[0].length;i++) {
                    sum+= score[j][i];
                }
                System.out.println("avg "+parameter+":" +sum/COURSE_NUM);
                return;
            }
        }

        //avg all
        if(parameter.equalsIgnoreCase("all")) {
            int sum = 0;
            for(int i =0;i<score.length;i++) {
                for(int j =0;j<score[0].length;j++) {
                    sum+= score[i][j];
                }
            }
            System.out.println("avg all:"+ sum/STUDENT_NUM/COURSE_NUM);
            return;
        }
        System.out.println("你输入的既不是课程名也还不是学生名");
    }
    static void max(String parameter){
        //max java
        for(int j =0;j<courses.length;j++) {
            if(parameter.equalsIgnoreCase(courses[j])) { //true
                int max = -1;
                for(int i =0;i<score.length;i++) {
                    if(score[i][j]>max) {
                        max=score[i][j];
                    }
                }
                System.out.println("max "+parameter+":" +max);
                return;
            }
        }
        //max zhang
        for(int j =0;j<students.length;j++) {
            if(parameter.equalsIgnoreCase(students[j])) { //true
                int max = -1;
                for(int i =0;i<score[0].length;i++) {
                    if(score[j][i]>max) {
                        max=score[j][i];
                    }
                }
                System.out.println("max "+parameter+":" +max);
                return;
            }
        }
        //max all
        if(parameter.equalsIgnoreCase("all")) {
            int max=-1;
            for(int i =0;i<score.length;i++) {
                for(int j =0;j<score[0].length;j++) {
                    if(score[i][j]>max) {
                        max=score[i][j];
                    }
                }
            }
            System.out.println("avg all:"+ max);
            return;
        }
        System.out.println("你输入的既不是课程名也还不是学生名");

    }
    static void sort(String parameter){
        //sort java
        for(int i =0;i<courses.length;i++) {
            if(parameter.equalsIgnoreCase(courses[i])) { //true
                String name[]=new String[students.length];
                int scores[]=new int[students.length];
                for(int j=0;j<students.length;j++) {
                    name[j]=students[j];
                    scores[j]=score[j][i];
                }
                int tmp;
                String n;
                int Increment;
                for(Increment=students.length/2;Increment>0;Increment/=2){
                    int p,j;
                    for(p=Increment;p<students.length;p++){
                        tmp=scores[p];
                        n=name[p];
                        for(j=p;j>=Increment;j-=Increment) {
                            if (tmp < scores[j - Increment]) {
                                name[j] = name[j - Increment];
                                scores[j] = scores[j - Increment];
                            }
                            else
                                break;
                        }
                        scores[j] = tmp;
                        name[j] = n;
                    }
                }
                for(int j=0;j<students.length;j++) {
                    System.out.printf("%-8s",name[j]);
                }
                System.out.println();
                for(int j=0;j<students.length;j++) {
                    System.out.printf("%-8s",scores[j]);
                }
                System.out.println();
                return;
            }
        }
        //sort zhang
        for(int i =0;i<students.length;i++) {
            if(parameter.equalsIgnoreCase(students[i])) { //true
                String name[]=new String[courses.length];
                int scores[]=new int[courses.length];
                for(int j=0;j<courses.length;j++) {
                    name[j]=courses[j];
                    scores[j]=score[i][j];
                }
                int tmp;
                String n;
                int Increment;
                for(Increment=courses.length/2;Increment>0;Increment/=2){
                    int p,j;
                    for(p=Increment;p<courses.length;p++){
                        tmp=scores[p];
                        n=name[p];
                        for(j=p;j>=Increment;j-=Increment) {
                            if (tmp < scores[j - Increment]) {
                                name[j] = name[j - Increment];
                                scores[j] = scores[j - Increment];
                            }
                            else
                                break;
                        }
                        scores[j] = tmp;
                        name[j] = n;
                    }
                }
                for(int j=0;j<courses.length;j++) {
                    System.out.printf("%-8s",name[j]);
                }
                System.out.println();
                for(int j=0;j<courses.length;j++) {
                    System.out.printf("%-8s",scores[j]);
                }
                System.out.println();
                return;
            }
        }
        System.out.println("你输入的既不是课程名也还不是学生名");
    }
}