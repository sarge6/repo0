package pk_lotto01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CLotto01 {
    public static void doOneLottoDrawing_Simplified(){
        List<Integer> lottoNumbersList = new ArrayList<>();
        for(int i = 0; i < 49; i++){
            lottoNumbersList.add(i+1); //1-49
        }
        List<Integer> lottoDrawSixList = new ArrayList<>();
        Random random = new Random();
        int uniqueCounter = 0, randomIndex, randomLottoNumber;
        while(uniqueCounter < 6){
            randomIndex = random.nextInt(49); //0-48
            randomLottoNumber = lottoNumbersList.get(randomIndex);
            if(!lottoDrawSixList.contains(randomLottoNumber)){
                lottoDrawSixList.add(randomLottoNumber);
                uniqueCounter+=1;
            }
        }
        //Comparator<Integer> comp = (number1, number2) -> {return number1.compareTo(number2);};
        Comparator<Integer> comp = Comparator.naturalOrder();
        lottoDrawSixList.sort(comp);
        System.out.println("Lotto Numbers drawn: " + lottoDrawSixList);
    }
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            doOneLottoDrawing_Simplified();
        }
    }
}
