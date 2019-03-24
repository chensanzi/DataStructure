package Solution;
import java.util.Stack;


import Stack.ArrayStack;

/**
 * Created by Administrator on 2019/1/30.
 *
 * leetcode 括号匹配
 */
public  class Solution {
    public boolean isValid(String s){
        ArrayStack<Character> stack = new ArrayStack();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if (c =='(' || c=='['||c=='{'){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar !='('){
                    return false;
                }
                if (c == ']' && topChar !='['){
                    return false;
                }
                if (c == '}' && topChar !='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
