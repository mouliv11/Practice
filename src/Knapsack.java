public class Knapsack {

    public class Item {
        private int weight;
        private int value;
    }

    private int findMaxValue(Item[] items, int W) {
        return findMaxValue(items, W, 0);
    }

    private int findMaxValue(Item[] items, int W, int i) {
        if (i == items.length)
            return 0;
        if (W - items[i].weight < 0)
            findMaxValue(items, W, i+1);
        return Math.max(findMaxValue(items, W - items[i].weight, i+1) + items[i].value,
                findMaxValue(items, W, i+1));
    }
}
