package generic.implementationSimpleArray;

public class AbstractStore<T extends Base> extends SimpleArray<T> implements Store {

    public AbstractStore(int size) {
        super(size);
    }
    @Override
    public void add(Base model) {
        super.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        int index = this.getIndex(id);
            if (index > -1) {
            super.set(index,(T) model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        Base base = this.findById(id);
        if (base.getId().equals(id)) {
            super.remove(this.getIndex(id));
            result = true;
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        Base base = null;
        for (int i = 0; i != super.length(); i++) {
            if (super.get(i).getId().equals(id)) {
                base = super.get(i);
                break;
            }
       }
        return base;
    }

    public int getIndex(String id) {
        int index = 0;
        for (int i = 0; i != super.length(); i++) {
            if (super.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
