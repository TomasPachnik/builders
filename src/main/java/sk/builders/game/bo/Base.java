package sk.builders.game.bo;

import sk.builders.game.enums.Type;

/**
 * zakladna budova
 * 
 * @author Tomas
 *
 */
public class Base extends Building {

    public Base() {
        super(Type.BUILDING);
    }

    private Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

}
