import java.util.Arrays;

public class RegularPerson extends Person {
    private Broadcast[] broadcasts;
    private int broadcastCount;

    public RegularPerson(String name) {
        super(name);
        broadcastCount = 0;
        broadcasts = new Broadcast[10];
    }

    public void addBroadcast(Broadcast broadcast) {
        if (broadcastCount == broadcasts.length) broadcasts = Arrays.copyOf(broadcasts, broadcasts.length * 2);
        broadcasts[broadcastCount] = broadcast;
        broadcastCount++;
    }
}
