import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        Station station = new Station();
        int m;
        while ((m = menu())!=0) {
            switch (m) {
                case 1:
                    addPerson(station);
                    break;
                case 2:
                    addBroadcast(station);
                    break;
                case 3:
                    try {
                        addPart(station);
                    } catch (TooLongPartsException | TooManyPaidPartsException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    Person[] people = station.getPeople();
                    for (int i = 0; i < people.length; i++) {
                        Person person = people[i];
                        System.out.println(person);
                    }
                    break;
                case 5:
                    Broadcast[] broadcasts = station.getBroadcasts();
                    for (int i = 0; i < broadcasts.length; i++) {
                        System.out.println(broadcasts[i].getId() + " with profit: " + broadcasts[i].getProfit());
                    }
                    break;
            }
        }
    }

    private void addPart(Station station) throws TooLongPartsException, TooManyPaidPartsException {
        System.out.println("Which broadcast");
        Scanner in = new Scanner(System.in);
        int bId = in.nextInt(); in.nextLine();
        if (bId <= 0 || bId > Broadcast.getLastBroadcastID()) {
            System.out.println("Error broadcast");
        } else {
            Broadcast broadcast = station.getBroadcast(bId);
            int p = partMenu();
            switch (p) {
                case 1: {
                    System.out.print("Singer: ");
                    String singer = in.nextLine();
                    System.out.print("Title: ");
                    String title = in.nextLine();
                    System.out.print("length: ");
                    int length = in.nextInt();
                    in.nextLine();
                    Song song = new Song(singer, title, length);
                    broadcast.addPart(song);
                }
                    break;
                case 2: {
                    System.out.print("Product name: ");
                    String product = in.nextLine();
                    System.out.print("Adv length:");
                    int length = in.nextInt();
                    in.nextLine();
                    Advertising advertising = new Advertising(product, length);
                    broadcast.addPart(advertising);
                }
                    break;
                case 3: {
                    System.out.print("Guest name: ");
                    String guestName = in.nextLine();
                    System.out.print("Interview length: ");
                    int length = in.nextInt();
                    in.nextLine();
                    Interview interview = new Interview(guestName, length);
                    broadcast.addPart(interview);
                }
            }
        }
    }

    private int partMenu() {
        System.out.println("1. Song");
        System.out.println("2. Advertising");
        System.out.println("3. Interview");
        return new Scanner(System.in).nextInt();
    }

    private void addBroadcast(Station station) {
        System.out.println("Who is person? (name): ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        Person person = station.findPerson(name);
        if (person == null) {
            System.out.println("Guest!");
            System.out.println("Input resume: ");
            String resume = in.nextLine();
            person = new Guest(name, resume);
        }
        System.out.println("Input broadcast length: ");
        int length = in.nextInt();
        Broadcast broadcast = new Broadcast(length, person);
        if (person instanceof RegularPerson) {
            ((RegularPerson) person).addBroadcast(broadcast);
        }
        station.addBroadcast(broadcast);
    }

    private void addPerson(Station station) {
        System.out.println("Input Name:");
        String name = new Scanner(System.in).nextLine();
        station.addPerson(name);
    }

    private int menu() {
        System.out.println("1. Add Person");
        System.out.println("2. Add Broadcast");
        System.out.println("3. Add Part");
        System.out.println("4. Show station people");
        System.out.println("5. Broadcasts profit");
        System.out.println("0. Exit");
        return new Scanner(System.in).nextInt();
    }
}
