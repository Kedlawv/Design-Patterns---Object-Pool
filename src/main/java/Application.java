import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Countdown> countdownList = new ArrayList<Countdown>();


        for (int i = 20; i >= 0; i--, System.out.println("Loop => " + i)) {
            while (countdownList.size() < 5) {
                countdownList.add(ObjectPool.getInstance().acquireCountdown());
            }

            Iterator<Countdown> iter = countdownList.iterator();
            while (iter.hasNext()) {
                Countdown countdown = iter.next();
                if (countdown.getCount() < 0) {
                    ObjectPool.getInstance().reclaimCountdown(countdown);
                    iter.remove();
                    continue;
                }
                System.out.println("Application => " + countdown.toString());
                countdown.decrement();
            }
        }

        ObjectPool.getInstance().clearPool();
    }
}
