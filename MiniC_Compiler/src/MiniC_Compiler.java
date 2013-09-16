import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MiniC_Compiler {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/WINRAWR/NetBeansProjects/MiniC-Compiler/file.txt"));
        Syntax syn  = new Syntax();
        String everything = "";
        
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append('\n');
                line = br.readLine();
            }
            everything = sb.toString();
        } 
        finally {
            br.close();
        }
        //split line
        String[] splited = everything.split("\\s+");
        String[] wellFormed = new String[splited.length+10];
        int i = 0;
        int j = 0;
        while(i<splited.length) {
            if("{".equals(splited[i])) {
                while(!"}".equals(splited[i])) {
                    i++;
                }
                i++;
            }
            /*else if(splited[i].contains("{")){
                String[] commentSplt = everything.split("\\a");
                while(!"{".equals(commentSplt[i])) {
                    while(!"}".equals(commentSplt[i])) {
                        
                    }
                }
            }
            else if(splited[i].contains("repeat")){
                String repeatCommand = "";
                while(!"until".equals(splited[i])) {
                    //i++;
                    repeatCommand = repeatCommand + splited[i];
                }
                //System.out.println("sss " + repeatCommand);
            }*/
            
            wellFormed[j] = splited[i++];
            if(wellFormed[j].contains(":=")) {
                String[] countSplt = wellFormed[j].split(":=");
            }
            System.out.println("index " + (j+1) + " " + wellFormed[j++]);
        }
        System.out.println("\n");
        //syn.compile(wellFormed);
    }
}