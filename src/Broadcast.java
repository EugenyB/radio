import java.util.Arrays;

public class Broadcast {
    private final int id;
    private Part[] parts;
    private final int length;
    private int partsCount;
    private int allPartsLength;
    private int paidPartsLength;
    private final Person person;
    private static int broadcastID = 0;

    public Broadcast(int length, Person person) {
        this.length = length;
        this.person = person;
        parts = new Part[10];
        partsCount = 0;
        allPartsLength = 0;
        paidPartsLength = 0;
        id = ++broadcastID;
    }

    public static int getLastBroadcastID() {
        return broadcastID;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public void addPart(Part p) throws TooManyPaidPartsException, TooLongPartsException {
        if (p instanceof Priceable) {
            if (paidPartsLength + p.getLength() <= length / 2) {
                addPartInternal(p);
                paidPartsLength += p.getLength();
            } else throw new TooManyPaidPartsException();
        } else {
            if (allPartsLength + p.getLength() <= length) {
                addPartInternal(p);
            } else throw new TooLongPartsException();
        }
    }

    private void addPartInternal(Part p) {
        if (partsCount == parts.length) parts = Arrays.copyOf(parts, parts.length * 2);
        parts[partsCount] = p;
        partsCount++;
        allPartsLength += p.getLength();
    }

    public int getProfit() {
        int profit = 0;
        for (int i = 0; i < partsCount; i++) {
            if(parts[i] instanceof Priceable) {
                profit += ((Priceable) parts[i]).getPrice();
            }
        }
        return profit;
    }

    public Person getPerson() {
        return person;
    }
}
