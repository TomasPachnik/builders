package sk.builders.game.bo;


import sk.builders.game.enums.Type;
import sk.builders.utils.Utils;

/**
 * zakladna budova
 * 
 * @author Tomas
 *
 */
public class Castle extends Building {

    public Castle(Position position){
        super(Type.BUILDING, position, Utils.getImage(Type.BUILDING));
    }

    private Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

}
