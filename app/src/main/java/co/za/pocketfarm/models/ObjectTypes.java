package co.za.pocketfarm.models;

public class ObjectTypes {
    private final int type;
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
}
