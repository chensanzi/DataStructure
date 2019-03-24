package Solution;

import Stack.LinkedListStackByCQ;

/**
 * Created by Administrator on 2019/2/16.
 */
public class StackSolutionByCQ {
    private LinkedListStackByCQ<Character> stack = new LinkedListStackByCQ();

    public boolean isValid(String str){
        for (int i =0;i<str.length();i++){
            char c = str.charAt(i);

            if (c=='('||c=='['|| c=='{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char d = stack.pop();
                if (c == '('&& d!=')'){
                    return false;
                }
                if (c == '['&& d!=']'){
                    return false;
                }
                if (c == '{'&& d!='}'){
                    return false;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "({}[()()()])";
        boolean flag = new StackSolutionByCQ().isValid(s);
        System.out.println(flag);
    }
}
