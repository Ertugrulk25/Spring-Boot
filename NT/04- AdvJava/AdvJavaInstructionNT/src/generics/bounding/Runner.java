package generics.bounding;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {

        Integer[]integers={2,3,5,7,9,11};
        Double[]doubles={1.2,2.3,3.4,4.5,5.6};
        String[]strings={"Generic","Üstten","Sınırlandırılabilir"};

        //GenericUpperBound<String>obj=new GenericUpperBound();//T : String X
        GenericUpperBound<Integer>obj=new GenericUpperBound<>();
        obj.numberArray=integers;

        System.out.println(obj.countAvarage());

        GenericUpperBound<Double>obj2=new GenericUpperBound<>();
        obj2.numberArray=doubles;

        System.out.println(obj2.countAvarage());
    }
}










