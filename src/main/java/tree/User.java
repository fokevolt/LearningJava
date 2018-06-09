package tree;

public class User implements Comparable<User>{
    private final int height;

    public User(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }

    @Override
    public CompareResult compare(User other) {
        if (height > other.height) return CompareResult.GREATER_THEN;
        if (height < other.height) return CompareResult.LESS_THEN;
        return CompareResult.EQUALS;
    }
}
