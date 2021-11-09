import java.util.Random;

public class Countdown {

    private final int id;
    private int count;
    private final Random random;

    public Countdown(){
        random = new Random();
        id = IdGenerator.getId();
        System.out.printf("Creating a new Countdown object id:%d\n",id);
        initialize();
    }

    public void initialize(){
        System.out.printf("Initializing Countdown object id:%d \n",id);
        count = random.nextInt(7) + 3;
    }

    public void decrement() {
        count--;
    }

    public int getCount(){
        return count;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Countdown{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }
}
