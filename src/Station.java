import java.util.Arrays;

public class Station {
    private Broadcast[] broadcasts;
    private int broadcastCount = 0;
    private RegularPerson[] people;
    private int personCount = 0;

    public Station() {
        broadcasts = new Broadcast[10];
        people = new RegularPerson[10];
    }


    public void addPerson(String name) {
        RegularPerson person = new RegularPerson(name);
        if (people.length == personCount) people = Arrays.copyOf(people, people.length*2);
        people[personCount++] = person;
    }

    public Person[] getPeople() {
        return Arrays.copyOf(people, personCount);
    }

    public Person findPerson(String name) {
        for (int i = 0; i < personCount; i++) {
            if (people[i].getName().equals(name)) return people[i];
        }
        return null;
    }

    public void addBroadcast(Broadcast broadcast) {
        if (broadcasts.length == broadcastCount) broadcasts = Arrays.copyOf(broadcasts, broadcasts.length*2);
        broadcasts[broadcastCount++] = broadcast;
    }

    public Broadcast getBroadcast(int bId) {
        for (int i = 0; i < broadcastCount; i++) {
            if (broadcasts[i].getId() == bId) return broadcasts[i];
        }
        return null;
    }

    public Broadcast[] getBroadcasts() {
        return Arrays.copyOf(broadcasts, broadcastCount);
    }
}
