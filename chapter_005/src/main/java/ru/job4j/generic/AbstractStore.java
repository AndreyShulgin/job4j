package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> {
    private SimpleArray<T> list = new SimpleArray<>(100);


    public void add(T model) {
        list.add(model);
    }

    public boolean replace(String id, T model) {
        boolean result = false;
        int index = 0;
        for (T t : list) {
            if (t.getId().contains(id)) {
                list.set(index, model);
                result = true;
                break;
            }
            index++;
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
            if (t.getId().contains(id)) {
                result = t;
                break;
            }
        }
        return result;
    }

}
