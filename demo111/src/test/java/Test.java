import java.io.*;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        File file =new File("D:\\student.csv");
        BufferedReader br;
        ArrayList<Student> students =new ArrayList<Student>();
        try {
             br =new BufferedReader(new FileReader(file));
             String s= br.readLine();
             s= br.readLine();
              while (s!=null){

                  Student student =new Student(s);
                  students.add(student);
                  s= br.readLine();
                  System.out.println(student);
              }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i=0;i<students.size()-1;i++){
            for (int j=i+1;j>0;j--){
                int js=students.get(j).getZong();
                int js1=students.get(j-1).getZong();
                if(js>js1){
                    Student st=students.get(j);
                    students.set(j,students.get(j-1));
                    students.set(j-1,st);
                }else if (js==js1){
                     if (students.get(j).getId()<students.get(j-1).getId()){
                        Student st=students.get(j);
                        students.set(j,students.get(j-1));
                        students.set(j-1,st);
                    }
                }


            }
        }
        System.out.println(students);




    }
}
