package generics.bounding;

public class Runner {
    public static void main(String[] args) {

        Integer[] integers={2,3,6,9,8,7};
        Double[] doubles={0.3,99.3,10.0,2.3};
        String[] strings={"generics","üstten","sınırlandıralabilir"};

       // GenericUpperBound<String> obj=new GenericUpperBound<>();//T:String X
        GenericUpperBound<Integer> obj=new GenericUpperBound<>();//T:Integer extends Number
        obj.numberArray=integers;

        System.out.println(obj.countAverage());

        GenericUpperBound<Double> obj2=new GenericUpperBound<>();//T:Double
        obj2.numberArray=doubles;

        obj2.countAverage();

    }
}
