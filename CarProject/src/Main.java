public class Main {
    public static void main(String[] args) {
        Driver unlicensed = new Driver("unlicensed", 0);
        Driver me = new Driver("me",1);
        CarInterface car = new GoCart();
        car.setDriver(me);
        car.setDriver(unlicensed);

        car = new SmallCar();
        car.setDriver(me);
//        car.setDriver(unlicensed); // 오류 뜸
    }
}