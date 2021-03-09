package dai;

import java.util.ArrayList;
import numberlist.IndexException;
import numberlist.objectlist.Money;
import numberlist.objectlist.NumericArrayList;
import numberlist.primitivelist.IntegerArrayList;

/**
 *
 * @author feny4
 */
public class BakedGoods {

    private ArrayList<String> names;
    private IntegerArrayList batches;
    private NumericArrayList temps;
    private IntegerArrayList durations;
    private NumericArrayList costs;

    public BakedGoods() {
        this.names = new ArrayList<String>();
        this.batches = new IntegerArrayList();
        this.temps = new NumericArrayList();
        this.durations = new IntegerArrayList();
        this.costs = new NumericArrayList();
    }

    public void addGood(String name, int batches, Temperature temp, int duration, Money cost) {
        try {
            names.add(name);
            this.batches.add(batches);
            temps.add(temp);
            durations.add(duration);
            costs.add(cost);
        } catch (IndexException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public IntegerArrayList getBatches() {
        return batches;
    }

    public NumericArrayList getTemps() {
        return temps;
    }

    public IntegerArrayList getDurations() {
        return durations;
    }

    public NumericArrayList getCosts() {
        return costs;
    }
    
    // Problems:
    // UI Guy: "I don't have an array of primitive integers to pass in. I only have an IntegerArrayList"
    // Robert: "Why do I have to pass in the data. Your BakedGoods instance already has the data"
    public void sortByName() {
        for (int i = 1; i < names.size(); i++) {
            int position = i;
            while (position > 0 && (names.get(position - 1).compareTo(names.get(position)) > 0)) {
                swapNames(names, position, position - 1);
                position--;
            }
        }
    }

    public void swapNames(ArrayList<String> names, int i, int j) {
        String temp = names.get(i);
        names.set(i, names.get(j));
        names.set(j, (temp));
    }

}


























