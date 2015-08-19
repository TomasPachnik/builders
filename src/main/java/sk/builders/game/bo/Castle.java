package sk.builders.game.bo;

import java.awt.Polygon;

import sk.builders.game.enums.Type;
import sk.builders.utils.Utils;

/**
 * zakladna budova
 * 
 * @author Tomas
 *
 */
public class Castle extends Building {
	private Polygon polygon;

	public Castle(Position position) {
		super(Type.BUILDING, position);
		System.out.println(super.getPosition());
		this.setPolygon(Utils.initPolygon(position));
	}

	private Warehouse warehouse;

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Polygon getPolygon() {
		return polygon;
	}

	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}

}
