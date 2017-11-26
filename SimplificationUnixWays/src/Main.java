import java.util.Stack;
import java.util.StringJoiner;

public class Main {

    public static final void main(String []args){
        String way = "/ab/cd/../ef";
        System.out.println(simplify(way));
    }


    public static String simplify(String way){

        char x;
        String str= "", result = "";
        Stack <String> stack = new Stack<>();

        for(int i = 0; i<way.length(); ++i){
            x = way.charAt(i);
            if(x == '/') {
                if(str != "") stack.push(str);
                str = "";
            }
            else str += x;
        }
        stack.push(str);


        while(stack.size() > 0){
            String s = stack.pop();
            //..
            if(s.length() == 2 && s.charAt(0) == '.' && s.charAt(1) == '.'){
                if(stack.size() > 1) stack.pop();
            }
            else {
                if(result.length() == 0) result += s;
                else result = s + '/' + result;
            }
        }

        return '/' + result;
    }

}
