public enum Priority {

    RED(1),
    YELLOW(2),
    BLUE(3),
    GREEN(4);

    private final int order;

    Priority(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
