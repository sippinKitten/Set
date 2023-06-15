//Выполнил студент группы 2А Иванов Данил

public class Set {
    private Node head;  // Голова списка

    // Внутренний класс, представляющий узел списка
    private class Node {
        int data;     // Значение узла
        Node next;    // Следующий узел

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Проверка, является ли множество пустым
    public boolean isEmpty() {
        return head == null;
    }

    // Проверка, содержится ли элемент в множестве
    public boolean contains(int element) {
        Node current = head;
        while (current != null) {
            if (current.data == element) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Добавление элемента в множество
    public void add(int element) {
        if (!contains(element)) {
            Node newNode = new Node(element);
            if (isEmpty()) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
    }

    // Удаление элемента из множества
    public void remove(int element) {
        if (isEmpty()) {
            return;
        }

        if (head.data == element) {
            head = head.next;
            return;
        }

        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.data == element) {
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Вывод содержимого множества
    public void printSet() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Пример использования класса Set
    public static void main(String[] args) {
        Set set = new Set();

        // Добавляем элементы в множество
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(2);

        // Выводим содержимое множества
        set.printSet();  // Вывод: 5 3 8 2

        // Проверяем наличие элемента в множестве
        System.out.println(set.contains(3));  // Вывод: true
        System.out.println(set.contains(6));  // Вывод: false

        // Удаляем элемент из множества
        set.remove(3);
        set.remove(6);  // Ничего не произойдет, так как элемента нет в множестве

        // Выводим содержимое множества после удаления
        set.printSet();  // Вывод: 5 8 2
    }
}
