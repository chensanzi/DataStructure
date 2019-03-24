package Solution;

/**
 * Created by Administrator on 2019/2/16.
 */
import java.util.TreeSet;

public class LeedCood_804UniqueMorse {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set = new TreeSet<String>();
        for (String word:words){
            StringBuilder res = new StringBuilder();
            for (int i=0;i<word.length();i++){
                res.append(codes[word.charAt(i)-'a']);
            }
            set.add(res.toString());
        }
        return set.size();
    }
}
