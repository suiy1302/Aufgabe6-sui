package main.goods;

public abstract class Pallet {

    private String description = "";
    private int id;
    private int width;
    private int depth;
    protected int height;
    private boolean cooling;
    private long incoming;
    private long outgoing;
    private int price;

    private static int nextid = 1;

    /**
     * Creates a pallet from given values
     * @param description - describes the content
     * @param width - width of the pallet
     * @param depth - depth of the pallet
     * @param height - height of the pallet
     * @param cooling - true, if the pallet requires cooling
     * @param duration - estimated duration of stocking in days
     * @param price - price per liter or unit
     */

    protected Pallet(String description, int width, int depth, int height, boolean cooling, int duration, int price) {
        this.id = nextid++;
        this.description = description;
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.cooling = cooling;
        this.incoming = System.currentTimeMillis();
        this.outgoing = this.incoming + (duration * 24 * 60 * 60 * 1000);
        this.price = price;
    }

    /**
     * Generates a human-readable string with basic information.
     * @return basic information about the pallet
     */
    public String getText() {
        StringBuffer result = new StringBuffer("[" + id + "] " + description + "(" + width + "x" + depth + "x" + height + ")");
        result.append(" " + getWeight()/1000 + "kg");
        result.append(" " + getValue() + "€");
        if (cooling) {
            result.append(" cooling");
        }
        return result.toString();
    }

    private String getValue() {
        return null;
    }

    private int getWeight() {
        return 0;
    }
    public int getPrice() {
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public boolean isCooling() {
        return cooling;
    }

    public long getIncoming() {
        return incoming;
    }

    public long getOutgoing() {
        return outgoing;
    }
}

class Fluesigkeit extends Pallet{
    protected Fluesigkeit(String description, int width, int depth, int height, boolean cooling, int duration, int price) {
        super(description, width, depth, height, cooling, duration, price);
    }
}
class Feststoffe extends Pallet {

    protected Feststoffe(String description, int width, int depth, int height, boolean cooling, int duration, int price) {
        super(description, width, depth, height, cooling, duration, price);
    }
}
class Stuekgueter extends Pallet{

    protected Stuekgueter(String description, int width, int depth, int height, boolean cooling, int duration, int price) {
        super(description, width, depth, height, cooling, duration, price);
    }
}
