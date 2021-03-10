package dai;

import javafx.application.Application;
import numberlist.IndexException;
import numberlist.objectlist.Money;

/**
 *
 * @author feny4
 */
public class Launcher {

    public static void main(String[] args) {
        //BakedGoodsUI app = new BakedGoodsUI();
        // Application.launch(BakedGoodsUI.class);

        BakedGoods bakedGoods = new BakedGoods();

        bakedGoods.addGood("Pie", 5, new Temperature(375, 'F'), 50, new Money(12, (byte) 50));
        bakedGoods.addGood("Banana Bread", 6, new Temperature(420, 'F'), 12, new Money(10, (byte) 50));
        bakedGoods.addGood("Muffin", 7, new Temperature(355, 'F'), 30, new Money(8, (byte) 50));
        bakedGoods.sortByName();
        try {
            for (int i = 0; i < bakedGoods.getNames().size(); i++) {
                System.out.println(bakedGoods.getNames().get(i) + ", " + bakedGoods.getBatches().getValue(i) + ", " + bakedGoods.getTemps().getValue(i)
                        + ", " + bakedGoods.getDurations().getValue(i)
                        + ", " + bakedGoods.getCosts().getValue(i));
            }
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
        }

        /*
        bakedGoods.sortByBatches();
        System.out.println(bakedGoods.getNames());
        System.out.println(bakedGoods.getBatches());
        
        bakedGoods.sortByTemps();
        System.out.println(bakedGoods.getTemps());
        
        bakedGoods.sortByDuration();
        System.out.println(bakedGoods.getDurations());
        
        bakedGoods.sortByCosts();
        System.out.println(bakedGoods.getCosts());
         */
    }
}
