import java.util.LinkedList;

public class A {
    static String codewordTrigram(String s) {

        // declaretion
        LinkedList<String> list = new LinkedList();
        List trigram = new List();
        int countMessages = 0, size = s.length(), max = 1, goal = 0, num = 0, column = 0, length,index;
        Node i = trigram.head;
        String[] Messages;
        String sum = "" ,demo , word;

        // part 1 : count the number of messages and put All messages in Array

        for (int j = 0; j < size; j++) {
            if (s.charAt(j) == '.') {
                countMessages++;
            }
        }

        Messages = new String[countMessages];
        for (int x = 0; x < countMessages; x++) {
            Messages[x] = "";
        }

        for (int j = 0; j < size; j++) {
            if (s.charAt(j) != '.') {

                Messages[column] += s.charAt(j);
                continue;
            }
            Messages[column] += '.';

            ++column;
        }

        // part 2

        for (int top = 0; top < countMessages; top++) {
             demo = Messages[top];
             word = "";

            for (int j = 0; j < demo.length(); j++) {
                if ((demo.charAt(j) == ' ' || demo.charAt(j) == '.') && !word.isEmpty()) {
                    word = word.trim();
                    list.add(word);
                    word = "";
                    continue;
                }
                word += demo.charAt(j);
            }

            // length - 2 : Because codewordTrigram = number of words - 2
            length = list.size();
            for (int ii = 0; ii < length - 2; ii++) {
                index = ii;
                for (int j = 0; j < 3 && index < length; j++) {
                    sum += list.get(index) + " ";
                    index++;
                }
                sum = sum.trim();
                int count = countOf(trigram, sum);
                trigram.add(sum, count);
                System.out.println();
                sum = "";
            }
            list.clear();
        }

        // part 3
        // System.out.println(trigram.toString());

        while (i != null) {
            if (i.count > max) {
                max = i.count;
                goal = num;
            }
            if (i.count == max) {
                max = 1;
                goal = 0;
            }

            num++;
            i = i.next;
        }
        return trigram.get(goal).toLowerCase();
    }






    static int countOf(List l, String d) {

        int c = 1;

        Node i = l.head;
        while (i != null) {

            if (d.equalsIgnoreCase(i.data)) {
                c++;
            }
            i = i.next;
        }

        return c;
    }

    public static void main(String[] args) {

        // put your text in S
        String s = "The plan is set. Set the plan now. The plan is on.";
        System.out.println(codewordTrigram(s));

    }

}

class Node {
    Node next;
    String data;
    int count = 0;
}

class List {
    Node head = null, last = null;
    int size = 0;
    String s = "";

    void add(String data, int count) {
        s += data + "(" + count + ")\n";
        Node box = new Node();
        box.data = data;
        box.count = count;
        if (head == null) {
            head = box;
            last = box;
            return;
        }
        last.next = box;
        last = box;
        last.next = null;
        size++;
    }

    String get(int index) {

        int count = 0;
        Node i = head;

        while (i != null) {
            if (count == index) {
                return i.data;
            }
            count++;
            i = i.next;
        }
        return "";
    }

    public String toString() {
        return s.trim();
    }

}
