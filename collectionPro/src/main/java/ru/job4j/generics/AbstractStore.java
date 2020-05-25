package ru.job4j.generics;

public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<Base> values;

    public AbstractStore(int size) {
        this.values = new SimpleArray(size);
    }
    @Override
    public void add(Base model) {
        this.values.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        int index = this.getIndex(id);
            if (index > -1) {
            this.values.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = this.getIndex(id);
        if (this.values.get(index).getId().equals(id)) {
            this.values.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        Base base = null;
        for (int i = 0; i != this.values.length(); i++) {
            if (this.values.get(i).getId().equals(id)) {
                base = this.values.get(i);
                break;
            }
       }
        return (T) base;
    }

    public int getIndex(String id) {
        int index = 0;
        for (int i = 0; i != this.values.length(); i++) {
            if (this.values.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
