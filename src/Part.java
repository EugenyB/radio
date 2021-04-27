public abstract class Part {
    private int length;

    public Part(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Part{" +
                "length=" + length +
                '}';
    }
}
