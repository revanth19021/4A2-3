
//5.1.2
import java.util.*;

public class WarehouseInventory {
    static class ProductNode {
        int code;
        int quantity;
        ProductNode next;

        ProductNode(int code, int quantity) {
            this.code = code;
            this.quantity = quantity;
            this.next = null;
        }
    }

    static class HashTable {
        private final int SIZE = 10;
        private ProductNode[] table;

        public HashTable() {
            table = new ProductNode[SIZE];
        }

        private int hash(int code) {
            return code % SIZE;
        }

        public void insert(int code, int quantity) {
            int index = hash(code);
            ProductNode newNode = new ProductNode(code, quantity);
            // Insert at head for simplicity
            newNode.next = table[index];
            table[index] = newNode;
            System.out.println("Inserted: " + code + " " + quantity);
        }

        public boolean delete(int code) {
            int index = hash(code);
            ProductNode current = table[index];
            ProductNode prev = null;

            while (current != null) {
                if (current.code == code) {
                    if (prev == null) {
                        table[index] = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    System.out.println("Deleted " + code);
                    return true;
                }
                prev = current;
                current = current.next;
            }
            System.out.println("Not Found");
            return false;
        }

        public boolean search(int code) {
            int index = hash(code);
            ProductNode current = table[index];

            while (current != null) {
                if (current.code == code) {
                    System.out.println("Found");
                    return true;
                }
                current = current.next;
            }
            System.out.println("Not Found");
            return false;
        }

        public void display() {
            for (int i = 0; i < SIZE; i++) {
                System.out.print("Bucket " + i + ": ");
                ProductNode current = table[i];
                if (current == null) {
                    System.out.println("empty");
                } else {
                    while (current != null) {
                        System.out.print("(" + current.code + ", " + current.quantity + ")");
                        current = current.next;
                        if (current != null) System.out.print(" -> ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashTable hashTable = new HashTable();
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    int code = sc.nextInt();
                    int quantity = sc.nextInt();
                    hashTable.insert(code, quantity);
                    break;
                case 2:
                    code = sc.nextInt();
                    hashTable.delete(code);
                    break;
                case 3:
                    code = sc.nextInt();
                    hashTable.search(code);
                    break;
                case 4:
                    hashTable.display();
                    break;
            }
        }
        sc.close();
    }
}
