package pk_lotto01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CLotto01 {
    public static final int RAND_NUMS = 100;
    public static List<Integer> randomList = new ArrayList<>();

    public static void fillRandomList(){
        Random random = new Random();
        for(int i = 0; i < RAND_NUMS; i++){
            int rand = random.nextInt(49)+1;
            randomList.add(rand);
        }
        //System.out.println(randomList);
    }

    public static void doOneLottoDrawing(){
        List<Integer> lottoList = new ArrayList<>();
        List<Integer> uniqueRandomList = randomList
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("UniqueRandomList: " + uniqueRandomList); //1-49
        int size = uniqueRandomList.size(); //UBound()+1
        int counter = 0;
        Random random = new Random();
        while(counter < 6){
            int randomIndex = random.nextInt(size); //0 to (size-1)
            Integer randomValue = uniqueRandomList.get(randomIndex);
            if (!lottoList.contains(randomValue)){
                lottoList.add(randomValue);
                counter+=1;
            }
        }
        lottoList.sort(Integer::compareTo);
        System.out.println("LottoDrawingResult: " + lottoList);
    }

    public static void main(String[] args) {
        fillRandomList();
        doOneLottoDrawing();
    }
}
