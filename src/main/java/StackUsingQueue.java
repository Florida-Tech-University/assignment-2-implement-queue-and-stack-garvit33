import java.util.Objects;

public class StackUsingQueue<E> implements StackADT<E> {

    private final QueueADT<E> q;

    public StackUsingQueue(int capacity) {
        q = new ArrayQueue<>(capacity);
    }

    @Override
    public int size() {
        return q.size();
    }

    @Override
    public boolean isEmpty() {
        return q.isEmpty();
    }

    @Override
    public E top() {
        return q.first();
    }

    @Override
    public void push(E e) {
        Objects.requireNonNull(e, "Null elements are not supported in this assignment.");
        q.enqueue(e); // may throw IllegalStateException
        int rotations = q.size() - 1;
        for (int i = 0; i < rotations; i++) {
            q.enqueue(q.dequeue());
        }
    }

    @Override
    public E pop() {
        return q.dequeue();
    }
}
