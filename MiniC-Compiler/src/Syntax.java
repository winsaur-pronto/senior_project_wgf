public class Syntax extends MiniCCompiler { 
    Lexical lex = new Lexical();
    public void compile(String[] input) {
        program(input);
    }
    
    public void program(String[] input) {
        stmt_seq(input);
    }

    public void stmt_seq(String[] input) {
        stmt(input);
    }
    
    public void stmt(String[] input) {
        for(int i=0;i<input.length;i++) {
            //System.out.println(input);
            if("if".equals(input[i])) {
                //stmt_output = if_stmt(input);
            }
            else if("repeat".equals(input[i])) {
                //stmt_output = repeat_stmt(input);
            } 
            else if("count".equals(input[i])) {
                //System.out.println("dsadnjks");
                //System.out.println(assign_stmt(input[i+2]));
            } 
            else if("read".equals(input[i])) {
                System.out.println(read_stmt(input[i+1]));
            } 
            else if("write".equals(input[i])) {
                System.out.println(write_stmt(input[i+1]));
            } 
            i++;
        }
    }
    
    public String write_stmt(String input) {
        return "Write\n\t" + exp(input);
    }
    public String assign_stmt(String input) {
        return "Assign to: " + exp(input);
    }
     public String read_stmt(String input) {
        return "Read: " + input;
    }
    public String exp(String input) {
        return simple_exp(input);
    }
    
    public String simple_exp(String input) {
        return term(input);
    }
    
    public String term(String input) {
        return factor(input);
    }
    
    public String factor(String input) {
        String exp="";
        if(input.matches("\\-?\\d*\\.?\\d+")) {
            int num = lex.num(input);
            exp = "Const: " + num;
        }
        else {
            exp = "Id: " + input;
        }
        return exp;
    }  
}
