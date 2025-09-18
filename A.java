import java.util.LinkedList;

public class A {
    static String codewordTrigram(String s) {

        // part 1 : count the number of messages and put All messages in Array

        int countMessages = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '.') {
                countMessages++;
            }
        }

        String[] Messages = new String[countMessages];
        for (int x = 0; x < countMessages; x++) {
            Messages[x] = "";
        }

        int column = 0;
        for (int j = 0; j < size; j++) {
            if (s.charAt(j) != '.') {

                Messages[column] += s.charAt(j);
                continue;
            }
            Messages[column] += '.';

            ++column;
        }

        // part 2

        LinkedList<String> list = new LinkedList();
        List trigram = new List();

        for (int top = 0; top < countMessages; top++) {
            String demo = Messages[top];
            String word = "";

            for (int i = 0; i < demo.length(); i++) {
                if ((demo.charAt(i) == ' ' || demo.charAt(i) == '.') && !word.isEmpty()) {
                    word = word.trim();
                    list.add(word);
                    word = "";
                    continue;
                }
                word += demo.charAt(i);
            }

            int length = list.size();
            int index;
            String sum = "";
            // length - 2 : Because codewordTrigram = number of words - 2
            for (int i = 0; i < length - 2; i++) {
                index = i;
                for (int j = 0; j < 3 && index < length; j++) {
                    // System.out.print(list.get(index)+" ");
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
        System.out.println(trigram.toString());
        int max = 1;
        int goal = 0;
        int num = 0;
        Node i = trigram.head;
        while (i != null) {
            if (i.count > max) {
                max = i.count;
                goal = num;
            }
            if(i.count == max){
                max = 1;
                goal = 0;
            }

            num++;
            i = i.next;
        }
        return trigram.get(goal);
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
        String s = " I came from the moon. He went to the other room. She went to the drawing room. I came from.";
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
