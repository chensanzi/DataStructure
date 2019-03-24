package Solution;

/**
 * Created by Administrator on 2019/1/30.
 *
 */
public class main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[{00}]"));
        solution.isValid("(){}[]");
    }
}
