import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        List<String> porIndice = new ArrayList<>();
        porIndice.add("Ana");
        porIndice.add("Luis");
        porIndice.get(0);

        LinkedList<String> cola = new LinkedList<>();
        cola.addFirst("Primero");
        cola.addLast("Ultimo");
        cola.getFirst();
        cola.get(1);

    }
}