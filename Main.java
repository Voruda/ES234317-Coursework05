/**
 * Main class of the Java program.
 */

public class Main {

    public static void main(String[] args) {
        
        int data [] = {100, -2, 99, -99, 2, 22, 1, 3, 4, -1, 5,1000};
        System.out.println("Test Buble Sort:");
        Sorting b = new Sorting(data);
        b.bubleSort();
        System.out.println(b);
        
        System.out.println("Test Selection Sort:");
        Sorting s = new Sorting(data);
        s.selectionSort();
        System.out.println(s);
        
        System.out.println("Test Insertion Sort:");
        Sorting i = new Sorting(data);
        i.insertionSort();
        System.out.println(i);
        
        System.out.println("Test Merge Sort:");
        Sorting m = new Sorting(data);
        m.mergeSort();
        System.out.println(m);
        
        System.out.println("Reverse:");
        m.reverse();
        System.out.println(m);
        
        m.reverse();
        int k = 99;
        
        System.out.println("Linear Search:");
        int id = m.linearSearch(k);
        if(id==-1) System.out.println(k+ " is not found");
        else System.out.println(k+ " is found at index "+ id);
        
        System.out.println("Binary Search:");
        id = m.binarySearch(k);
        if(id==-1) System.out.println(k+ " is not found");
        else System.out.println(k+ " is found at index "+ id);
        
    }
}
