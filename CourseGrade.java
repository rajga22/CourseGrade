
import java.util.*;
import java.io.*;
public class CourseGrade {
    public static void main (String args []){
        try {
            Scanner sc = new Scanner(System.in);
            File Read = new File("src/StudentInfo.tsv");
            Scanner re = new Scanner(Read);

            FileWriter myWriter = new FileWriter("report.txt");
            myWriter.write("------------------\n");
            String r;
            int tot1=0,tot2=0;
            int rec=0;
            while (re.hasNextLine()) {
                r = re.nextLine();
                //System.out.println(r);
                StringTokenizer stk= new StringTokenizer(r);
                int i = stk.countTokens();
                String Lname= stk.nextToken();
                String Fname= stk.nextToken();
                String Module1= stk.nextToken();
                String Module2= stk.nextToken();
                String FinalM= stk.nextToken();

                int m1= Integer.parseInt(Module1);
                int m2= Integer.parseInt(Module2);
                int t= m1+m2;
                tot1=tot1+m1;
                tot2=tot2+m2;
                rec=rec+1;
                double avg = (double) t/2.0;

                char ch;
                if (avg >= 90)
                    ch= 'A';
                else if (avg >= 80)
                    ch= 'B';
                else if (avg >= 70)
                    ch= 'C';
                else if (avg >= 60)
                    ch= 'D';
                else
                    ch= 'F';

                System.out.println(Lname+ "\t" + Fname +"\t" + t +  "\t" + FinalM +  "\t" + ch);

                myWriter.write(Lname+ "\t" + Fname +"\t" + t +  "\t" + FinalM +  "\t" + ch+"\n");
                //myWriter.write(Lname+ "\t" + Fname +"\n");
                myWriter.write("------------------\n");

            }
            double s1=(double)tot1/(double)rec;
            double s2=(double)tot2/(double)rec;
            myWriter.write("Avg marks of Module1=>"+s1+"\n");
           myWriter.write("Avg marks of module2=>"+s2);

            myWriter.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());


        }

    }

}


