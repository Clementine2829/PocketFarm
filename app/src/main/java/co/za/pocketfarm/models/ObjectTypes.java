package co.za.pocketfarm.models;

public class ObjectTypes {
    private final int type; // type 0 = tips, type 1 = notifications
    private final Object object;

    public ObjectTypes(int type, Object object) {
        this.type = type;
        this.object = object;
    }

    public int getType() {
        return type;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "ObjectTypes{" +
                "type=" + type +
                ", object=" + object +
                '}';
    }
}
