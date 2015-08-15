package sk.builders.main;

import sk.builders.core.Core;
import sk.builders.core.ObjectConfig;
import sk.builders.core.exceptions.BeanNotFoundException;
import sk.builders.game.bl.GameApi;
import sk.builders.game.bo.Base;
import sk.builders.game.bo.Position;

public class Main {

    public static void main(String[] args) throws BeanNotFoundException {
        Core core = new Core(ObjectConfig.class);

        GameApi api = (GameApi) core.getByName("gameApi");
        Base base = new Base();
        Position position = new Position(0, 0);
        System.out.println(api.build(base, position).isResult());
        System.out.println(api.build(base, position).isResult());
    }

}
