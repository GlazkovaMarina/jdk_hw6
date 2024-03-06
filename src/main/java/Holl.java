import org.apache.commons.math3.util.MathUtils;

import java.util.HashMap;
import java.util.Random;

public class Holl {
    private HashMap<Integer, String> result;
    private Integer carDoor;
    Random random;
    public Holl(){
        random = new Random();
        carDoor = random.nextInt(3);
        result = new HashMap<>();
    }

    public Integer ChooseDoorFirstly(){
        return random.nextInt(3);
    }
    public Integer openDoor(Integer choosenDoor){
        Integer openedDoor;
        do {
            openedDoor = random.nextInt(3);
        } while (openedDoor.equals(choosenDoor) || openedDoor.equals(carDoor));
        return openedDoor;
    }
    public Integer changeSelection(Integer choosenDoor, Integer openedDoor)
    {
        Integer secondChoosenDoor;
        do {
            secondChoosenDoor = random.nextInt(3);
        } while (secondChoosenDoor.equals(openedDoor) || secondChoosenDoor.equals(choosenDoor));
        return secondChoosenDoor;
    }

    public HashMap<Integer, String> startGames(Integer countGames){
        for (Integer i = 0; i < countGames; i++) {
            Integer choosenDoor = ChooseDoorFirstly();
            Integer openedDoor = openDoor(choosenDoor);
            Integer changedDoor = changeSelection(choosenDoor, openedDoor);
            if(choosenDoor.equals(carDoor)){
                result.put(i,"WinWithoutChange");
            } else if (changedDoor.equals(carDoor)){
                result.put(i, "WinWithChange");
            }
        }
        return result;
    }

    public void statistic(HashMap<Integer, String> result){
        Integer count = result.size();
        Long countWinWithChange = result.values().stream().filter(elem -> elem.equals("WinWithChange")).count();
        Long countWinWithoutChange = result.values().stream().filter(elem -> elem.equals("WinWithoutChange")).count();
//        Double percentageOfWinWithChange = countWinWithChange * 100.0/ count;
//        Double percentageOfWinWithoutChange = countWinWithoutChange * 100.0/count;
        Double percentageOfWinWithChange = countWinWithChange * 100.0/ count;
        Double percentageOfWinWithoutChange = countWinWithoutChange * 100.0/count;
        System.out.println("Count of wins without Change: " + percentageOfWinWithoutChange);
        System.out.println("Count of wins with Change: " + percentageOfWinWithChange);

    }

}
