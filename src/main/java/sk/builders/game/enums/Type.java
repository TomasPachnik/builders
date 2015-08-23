package sk.builders.game.enums;

public enum Type {

    TERRAIN(0), WATER(1), FOREST(2), MOUNTAIN(3), CASTLE(4), WOODCUTTER(5);

    private int id;

    private Type(int id) {
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
