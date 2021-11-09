import java.util.LinkedList;
import java.util.Queue;

public class ObjectPool {
    private static ObjectPool instance;
    private final Queue<Countdown> pool;

    private ObjectPool(){
        pool = new LinkedList<Countdown>();
    }

    public static ObjectPool getInstance(){
        if(instance == null){
            instance = new ObjectPool();
        }
        return instance;
    }

    public Countdown acquireCountdown(){
        if(!pool.isEmpty()){
            Countdown countdown = pool.poll();
            System.out.println("Acquiring Countdown from the pool id: " + countdown.getId());
            return countdown;
        }else{
            System.out.println();
            return new Countdown();
        }
    }

    public void reclaimCountdown(Countdown countdown){
        System.out.println("Reclaiming Countdown " + countdown.toString());
        countdown.initialize();
        pool.add(countdown);
    }

    public void clearPool(){
        System.out.println("End of execution, clearing Object Pool");
        pool.clear();
    }
}
