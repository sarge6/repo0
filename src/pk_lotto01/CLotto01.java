package pk_lotto01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CLotto01 {
    public static final int RAND_NUMS = 100;
    public static List<Integer> randomList = new ArrayList<>();
    public static void fillRandomList(){
        Random random = new Random();
        for(int i = 0; i < RAND_NUMS; i++){
            int rand = random.nextInt(49)+1;
            randomList.add(rand);
        }
        System.out.println(randomList);
    }
    public static void main(String[] args) {
        fillRandomList();
    }
}
