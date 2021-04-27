public class Guest extends Person {
    private String resume;

    public Guest(String name, String resume) {
        super(name);
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }
}
