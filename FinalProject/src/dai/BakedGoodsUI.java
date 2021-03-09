package dai;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import numberlist.objectlist.Money;
import numberlist.primitivelist.IntegerArrayList;

/**
 *
 * @author feny4
 */
public class BakedGoodsUI extends Application{

    private BakedGoods bakedGoods;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void giveInputToBakedGoods( ){
        
        bakedGoods.addGood( "Pie", 5, new Temperature(375, 'F'), 60, new Money(12, (byte) 50));
    }
}