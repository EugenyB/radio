import java.util.Objects;

public class Interview extends Part implements Priceable {

    private String guestName;

    public Interview(String guestName, int length) {
        super(length);
        this.guestName = guestName;
    }

    @Override
    public int getPrice() {
        return getLength() * 30;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interview interview = (Interview) o;
        return Objects.equals(guestName, interview.guestName);
    }

    @Override
    public int hashCode() {
        return guestName != null ? guestName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "guestName='" + guestName + '\'' +
                "} " + super.toString();
    }
}
