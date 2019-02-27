package ru.job4.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> list = new SimpleArray<>(100);

    @Override
    public void add(T model) {
        list.add(model);
    }

    public boolean replace(String id, T model) {
        boolean result = false;
        for (T t : list) {
            if (t.getId().contains(id)) {
                t = model;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = 0;
        for (T role : list) {
            if (role.getId().contains(id)) {
                list.remove(index);
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    public T findById(String id) {
        T result = null;
        for (T t : list) {
            if (t != null && t.getId().contains(id)) {
                result = t;
                break;
            }
        }
        return result;
    }

}
