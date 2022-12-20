public class Car {

    private final Integer tank = 50;

    public boolean moveTo(Integer distance, Integer fuel) {
        if (fuel > tank) {
            return true;
        }
        else if (!(fuel < 0)) {
            return fuel*30>distance?true:false;
        }
        else {
            ArithmeticException exception = new ArithmeticException();
            throw exception;
        }
    }
}