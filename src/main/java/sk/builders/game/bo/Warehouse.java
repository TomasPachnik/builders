package sk.builders.game.bo;
/**
 * skladisko
 * @author Tomas
 *
 */
public class Warehouse {
    private int wood; // drevo
    private int lumber; // dosky
    private int stone; // kamenie
    private int iron; // zelezo

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getLumber() {
        return lumber;
    }

    public void setLumber(int lumber) {
        this.lumber = lumber;
    }

    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

}
