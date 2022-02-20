import java.util.Comparator;
import java.util.Random;

public enum Priority {
    HIGH("High" , 1),
    NORMAL("Normal", 2),
    LOW("Low", 3);


    private final String _enumName;
    private final int _enumOrder;

    Priority(String enumName, int enumOrder) {
        _enumName = enumName;
        _enumOrder = enumOrder;
    }

    public String get_enumName() {
        return _enumName;
    }

    public int get_enumOrder() {
        return _enumOrder;
    }





    public static Priority getRandomPriority() {
        Priority[] priorities = Priority.values();
        Random random = new Random();
        int index = random.nextInt(priorities.length);
        return priorities[index];
    }



    Comparator<Priority> priorityComparator = Comparator.comparing(Priority::get_enumOrder);



    public int compare(Priority p) {
        return priorityComparator.compare(this, p);
    }




    @Override
    public String toString() {
        return "Name: " + get_enumName() + ", order: " + get_enumOrder();
    }
}
