package pk_lotto01;

import java.util.*;

class Statistic implements Comparable<Statistic>{
    private int number = 0;
    private int occurrence = 0;

    public Statistic(){}
    public Statistic(int number, int occurrence) {
        this.number = number;
        this.occurrence = occurrence;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getOccurrence() {
        return occurrence;
    }
    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }
    @Override
    public String toString() {
        return "Statistic{" +
                "number=" + number +
                ", occurrence=" + occurrence +
                '}';
    }
    @Override
    public int compareTo(Statistic o) {
        if (this.getOccurrence() != o.getOccurrence()) {
            return o.getOccurrence() - this.getOccurrence();
        }
        return 0;
    }
}

public class CLotto01 {
    public static Statistic[] lottoStatistics = new Statistic[49];

    public static void displayLottoStatistics(){
        Arrays.sort(lottoStatistics);
        Statistic elem;
        for(int i = 0; i < lottoStatistics.length; i++){
            elem = lottoStatistics[i];
            if(elem != null){
                System.out.printf("%02d times drawn: %02d %n", elem.getOccurrence(), elem.getNumber());
            }
        }
    }
    public static void initializeLottoStatisticsArray(){
        for(int i = 0; i < 49; i++){
            Statistic obj = new Statistic();
            obj.setNumber((i+1));
            obj.setOccurrence(0);
            lottoStatistics[i] = obj;
        }
    }
    public static void setStatisticsForOneLottoDrawing(List<Integer> li){
        if(li.isEmpty()) throw new RuntimeException("empty list error");
        for(Integer elem : li){
            int index = elem-1;
            Statistic obj = lottoStatistics[index];
            obj.setOccurrence(obj.getOccurrence()+1);
        }
    }
    public static List<Integer> doOneLottoDrawing_Simplified(){
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
        return lottoDrawSixList;
    }
    public static void main(String[] args) {

        initializeLottoStatisticsArray();
        System.out.println(Arrays.asList(lottoStatistics));

        for(int i = 0; i < 100; i++){
            List<Integer> li = doOneLottoDrawing_Simplified();
            setStatisticsForOneLottoDrawing(li);
        }
        displayLottoStatistics();
    }
}
