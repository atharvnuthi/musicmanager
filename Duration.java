// Duração
class Duration {
    private int min;
    private int sec;

    public Duration(int min, int sec) {
        this.min = min;
        this.sec = sec;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
}