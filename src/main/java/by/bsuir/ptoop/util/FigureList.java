package by.bsuir.ptoop.util;

import by.bsuir.ptoop.model.Figure;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class FigureList implements List<Figure> {
    private List<Figure> list;

    public FigureList() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public Iterator<Figure> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    public boolean add(Figure figure) {
        return list.add(figure);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends Figure> c) {
        return list.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Figure> c) {
        return list.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public void replaceAll(UnaryOperator<Figure> operator) {
        list.replaceAll(operator);
    }

    public void sort(Comparator<? super Figure> c) {
        list.sort(c);
    }

    public void clear() {
        list.clear();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FigureList && list.equals(o);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    public Figure get(int index) {
        return list.get(index);
    }

    public Figure set(int index, Figure element) {
        return list.set(index, element);
    }

    public void add(int index, Figure element) {
        list.add(index, element);
    }

    public Figure remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    public ListIterator<Figure> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Figure> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Figure> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    public Spliterator<Figure> spliterator() {
        return list.spliterator();
    }

    public boolean removeIf(Predicate<? super Figure> filter) {
        return list.removeIf(filter);
    }

    public Stream<Figure> stream() {
        return list.stream();
    }

    public Stream<Figure> parallelStream() {
        return list.parallelStream();
    }

    public void forEach(Consumer<? super Figure> action) {
        list.forEach(action);
    }
}
