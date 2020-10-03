package org.jomaveger.structures;

public interface IList<T> extends Iterable<T> {

    void addFirst(final T elem);

    void addLast(final T elem);

    T getFirst();

    T getLast();

    void removeFirst();

    void removeLast();

    Boolean contains(final T elem);

    void remove(final T elem);

    void clear();

    T get(Integer index);

    void set(Integer index, final T elem);

    void add(Integer index, final T elem);

    void remove(Integer index);

    Integer indexOf(final T elem);

    Integer lastIndexOf(final T elem);

    Boolean isEmpty();

    Integer size();

    IList<T> deepCopy();
}
