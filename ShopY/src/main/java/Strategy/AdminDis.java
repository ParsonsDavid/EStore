package Strategy;

/**
 * Created by David on 16/04/2017.
 */
public class AdminDis implements Strategy {

    @Override
    public double doOperation(double price) {
        return price * 0.9;
    }
}
