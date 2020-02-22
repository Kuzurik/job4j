package generic.implementationSimpleArray;

public class AbstractStore<T extends Base> implements Store {
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
        Base base = this.findById(id);
        if (base.getId().equals(id)) {
            this.values.remove(this.getIndex(id));
            result = true;
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        Base base = null;
        for (int i = 0; i != this.values.length(); i++) {
            if (this.values.get(i).getId().equals(id)) {
                base = this.values.get(i);
                break;
            }
       }
        return base;
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
