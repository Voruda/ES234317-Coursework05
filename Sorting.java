/**
 * Step by Step Problem Solving:
 * Input        : An array of integers (data) and a target integer to search (k)
 * 
 * Steps        :   
 *  [Merge Sort]
 *  call split for the array from index 0 to data length - 1
 *  
 *  [split]
 *  check if left index < right index -> calculate middle index (m) <-- (l + r) / 2
 *      call split for left half (l to m)
 *      call split for right half (m + 1 to r)
 *      call merge to combine both halves
 *  
 *  [merge]
 *  create temporary left (L) and right (M) arrays
 *  copy data into L and M
 *  compare elements of L and M -> place the smaller element back into the main array
 *  copy any remaining elements from L or M into the main array
 *  
 *  [Reverse]
 *  create a new temporary array (r) of the same length
 *  loop i from 0 to data length - 1:
 *      r[i] <-- data[data length - 1 - i]
 *  data <-- r
 *  
 *  [Linear Search]
 *  check if current index i == data length -> return -1
 *  check if data[i] == k -> return i
 *  otherwise -> call linearSearch for k at index i + 1
 *  
 *  [Binary Search]
 *  check if low index l > high index h -> return -1
 *  calculate middle index (m) <-- (l + h) / 2
 *  check if data[m] == k -> return m
 *  check if k < data[m] -> call binarySearch for left half (l to m - 1)
 *  otherwise -> call binarySearch for right half (m + 1 to h)
 * 
 * Output       : The sorted arrays (ascending and descending) and the exact index of the searched element (or -1 if not found)
 */

class Sorting{
    int data [];
    
    Sorting(int []a){
        this.data = a;
    }
    
    public String toString(){
        String output="";
        for(int d:data) output+=" "+d;
        return output;
    }
    
    void bubleSort(){
        for(int s=this.data.length-2;s>=0;s--){
            for(int p=0;p<=s;p++){
                if(this.data[p+1]<this.data[p]){
                    int temp = this.data[p+1];
                    this.data[p+1] = this.data[p];
                    this.data[p] =temp;
                }
            }
        }
    }
    
    void selectionSort(){
        for (int p=0; p<this.data.length-1;p++){
            int min=Integer.MAX_VALUE;
            int minIdx=p+1;
            
            for(int i=p+1;i<this.data.length;i++){
                if(this.data[i] < min) {
                    min= this.data[i];
                    minIdx=i;
                }
            }
            
            if (min<this.data[p]){
                int t=this.data[p];
                this.data[p] = min;
                this.data[min] = t;
            }
            
        }
    }
    
    void insertionSort(){
        for(int p=1;p<this.data.length;p++){
            int temp = this.data[p];
            boolean stop = false;
            for(int i=p-1;i>=0 && !stop;i--){
                if(this.data[i]>temp){
                    this.data[i+1] = this.data[i];
                    this.data[i] = temp;
                } else{
                    stop =true;
                }
            }
        }
    }
    
    void mergeSort(){
        split(this.data, 0, this.data.length - 1);
    }
    
    void split(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            split(arr, l, m);
            split(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
  
    void merge(int arr[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }
  
    void reverse(){
        int r [] = new int[this.data.length];
        int l = this.data.length-1;
        
        for(int i = 0; i <= l; i++) {
            r[i] = this.data[l - i];
        }
        
        this.data = r;
    }
    
    int linearSearch(int k){
       return linearSearch(k,0);
    }
    
    int linearSearch(int k, int i){
        if(i == this.data.length){
            return -1;
        }
        else if(this.data[i]==k){
            return i;
        }
        else{
            return linearSearch(k, i + 1);
        }
    }
    
    int binarySearch(int k){
        return binarySearch(k, 0, this.data.length-1);
    }
    
    int binarySearch(int k, int l, int h){
        if(l>h) return -1;
        else{
            int m = (l+h)/2;
            int v = this.data[m];
            
            if(v == k) {
                return m;
            } 
            else if (k < v) {
                return binarySearch(k, l, m - 1);
            } 
            else {
                return binarySearch(k, m + 1, h);
            }
        }
    }
}