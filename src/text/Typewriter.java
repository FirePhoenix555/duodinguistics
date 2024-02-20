package text;

class Typewriter {
    private final String s;
    private String current;
    private int currentIndex = 0;

    public Typewriter(String s_) {
        s = s_;
        current = "";
    }

    /*
     * Executed on an interval (e.g. every half second). Types out one more character of the string.
     */
    public void pulse() {
        if (isFinished()) return;

        current += s.charAt(currentIndex);
        currentIndex++;
    }

    public String getString() {
        return current;
    }

    public boolean isFinished() {
        return currentIndex >= s.length();
    }
}
