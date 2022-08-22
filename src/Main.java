import java.util.*;

public class Main {
    public static void main(String[] args) {
      MyStack myStack=new MyStack();
        System.out.println(myStack.peek());
        myStack.push(5);
        System.out.println(myStack.peek());
        myStack.push(7);
        System.out.println(myStack.peek());
        myStack.push(79);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        myStack.push(7);
        System.out.println(myStack.peek());

    }

    //finds common element in two arrays , and returns true
    public static boolean containsCommonItemEfficient(String [] arr1, String[] arr2){
        Map map= new HashMap();

        for(int i=0; i<arr1.length ; i++){
            if(!map.containsKey(arr1[i])){
                map.put(arr1[i],true);
            }}


        for(int j=0; j<arr2.length ; j++){
            if(map.containsKey(arr2[j])){
                System.out.println("Common element found");
                return true;
            }
        }
        return false;

    }
    //reversing a string
    public static String reverseString1(String string){

        char[] stringArray=string.toCharArray();//space complexity(O(n))

        char temp;
        for (int i = 0; i <= (stringArray.length / 2)-1; i++) {
                temp = stringArray[i];
                stringArray[i] = stringArray[stringArray.length - 1 - i];
                stringArray[stringArray.length - 1 - i] = temp;
            }
        return new String(stringArray);
            //time complexity O(n)
        }
    //merging sorted arrays and sorting the new array ATTEMPT FAILED
    public static ArrayList<Integer> mergeSortedArray(Integer[] arr1, Integer[] arr2){
       ArrayList<Integer> mergedArray = new ArrayList<Integer>();

       int counter1=0;
       int counter2=0;
       Integer arr1Item=arr1[counter1];
       Integer arr2Item=arr2[counter2];
       while(true){
           if(arr1Item<arr2Item){
               mergedArray.add(arr1Item);
               System.out.println("adding in 1"+mergedArray+" "+counter1);
               if((counter1+1)!=arr1.length){
                    counter1++;
                    arr1Item=arr1[counter1];
                   System.out.println(counter1);
                   continue;
               }
           }else{
               mergedArray.add(arr2Item);
               System.out.println("adding in 2"+mergedArray+" "+counter2);
               if((counter2+1)!=arr2.length){
                    counter2++;
                    arr2Item=arr2[counter2];
                   System.out.println(counter2);
                   continue;
               }
           }
           if(counter1+1==arr1.length && counter2+1==arr2.length){
               System.out.println(counter1+" "+counter2);
               break;
           }
       }

        System.out.println(mergedArray);
       return mergedArray;
    }
    //merging sorted arrays and sorting the new array solution
    public static int[] MargeTwoSortedArray(int[] array1, int[] array2) {
        final int[] mergedArray = new int[array1.length + array2.length];
        int j = 0, k = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (j != array1.length && (k == array2.length || array1[j] < array2[k])) {
                mergedArray[i] = array1[j];
                j++;
            } else {
                mergedArray[i] = array2[k];
                k++;
            }
        }
        return mergedArray;
    }
    //returns first recurring character in an array O(n)
    public static int firstRecurringCharacter(int[] nums){
        HashMap<Integer, Boolean> numsMap = new HashMap<>();
        for(int num:nums){
            if(!numsMap.containsKey(num)){
                numsMap.put(num,true);
            }
            else{
                return num;
            }
        }
        return -1;
    }

}



//own linked list
class MyDoublyLinkedList{
    MyDoublyLinkedListNode head;
    MyDoublyLinkedListNode tail;
    int length;
    private class MyDoublyLinkedListNode{
        int value;
        MyDoublyLinkedListNode next;
        MyDoublyLinkedListNode prev;
        MyDoublyLinkedListNode(int value, MyDoublyLinkedListNode next,MyDoublyLinkedListNode prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }
        @Override
        public String toString(){
            return ""+value;
        }
    }
    MyDoublyLinkedList(int value){
        this.head=new MyDoublyLinkedListNode(value,null,null);
        this.tail=head;
        this.length=1;
    }
    void print(){
        MyDoublyLinkedListNode temp=head;
        while(temp!=null){
            System.out.print(temp+"-->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }
    void prepend(int value){
       MyDoublyLinkedListNode node=new MyDoublyLinkedListNode(value,head,null);
       head.prev=node;
        head=node;
        length++;
    }
    void append(int value){
        MyDoublyLinkedListNode node=new MyDoublyLinkedListNode(value,null,tail);
        tail.next=node;
        tail=node;
        length++;
    }
    void insert(int index,int value){

        if(index>length){
            System.out.println("MyLinkedList.insert :Invalid index");
            return;
        }
        if(index==length){
            this.append(value);
            return;
        }
        if(index==0){
            this.prepend(value);
            return;
        }
       MyDoublyLinkedListNode temp=head;
       MyDoublyLinkedListNode node=new MyDoublyLinkedListNode(value,null,null);
        int indexCount=0;
        while(temp!=null){
            if(indexCount==index){
                node.prev=temp.prev;
                temp.prev.next=node;
                node.next=temp;
                temp.prev=node;

                length++;
                break;
            }
            indexCount++;
            temp=temp.next;
        }
    }
    void remove(int index){

        if(index>=length){
            System.out.println("MyLinkedList.insert :Invalid index");
            return;
        }
        if(index==0){
            head=head.next;
            head.prev=null;
            length--;
            return;
        }

        MyDoublyLinkedListNode temp=head;
        int indexCount=0;
        while(temp!=null){
            if(indexCount==index){
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
                length--;
                break;
            }
            indexCount++;
            temp=temp.next;
        }

    }
    @Override
    public String toString(){
        return "MyDoublyLinkedList {"+"head :"+head.value+", tail :"+tail.value+", length :"+length+"}";
    }
}
class MyLinkedListNode{
    int value;
    MyLinkedListNode next;
    MyLinkedListNode(int value, MyLinkedListNode node){
        this.value=value;
        this.next=node;
    }
    @Override
    public String toString(){
        return ""+value;
    }
}
class MyLinkedList{

    MyLinkedListNode head;
    MyLinkedListNode tail;
    int length;

    MyLinkedList(int value){
        this.head=new MyLinkedListNode(value,null);
        this.tail=head;
        this.length=1;
    }
    void print(){
        MyLinkedListNode temp=head;
        while(temp!=null){
            System.out.print(temp+"-->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }
    void prepend(int value){
        MyLinkedListNode node=new MyLinkedListNode(value,head);
        head=node;
        length++;
    }
    void append(int value){
        MyLinkedListNode node=new MyLinkedListNode(value,null);
        tail.next=node;
        tail=node;
        length++;
    }
    void insert(int index,int value){

        if(index>length){
            System.out.println("MyLinkedList.insert :Invalid index");
            return;
        }
        if(index==0){
          this.prepend(value);
          return;
        }
        MyLinkedListNode temp=head;
        MyLinkedListNode node=new MyLinkedListNode(value,null);
        int indexCount=0;
        while(temp!=null){
            if(indexCount==index-1){
                node.next=temp.next;
                temp.next=node;
                length++;
                break;
            }
            indexCount++;
            temp=temp.next;
        }
    }
    void remove(int index){

        if(index>=length){
            System.out.println("MyLinkedList.insert :Invalid index");
            return;
        }
        if(index==0){
           head=head.next;
            length--;
            return;
        }
        MyLinkedListNode temp=head;
        int indexCount=0;
        while(temp!=null){
            if(indexCount==index-1){
                temp.next=temp.next.next;
                length--;
                break;
            }
            indexCount++;
            temp=temp.next;
        }

    }
    //reverse values
    void reverse(){
        MyLinkedListNode temp=head;
        int tempInt=0;
        for(int i=0;i<length/2;i++){
            tempInt=temp.value;
            temp.value=traverseToIndex(head,length-i-1).value;
            this.traverseToIndex(head,length-i-1).value=tempInt;
            temp=temp.next;
        }
    }
    //reverse nodes
    public void reverse2() {
        MyLinkedListNode first = head;
        tail = head;
        MyLinkedListNode second = first.next;
        for (int i = 0; i < length - 1; i++) {
            MyLinkedListNode temp = second.next;
            second.next=first;
            first = second;
            second = temp;
        }
        head.next=null;
        head = first;
    }
    MyLinkedListNode traverseToIndex(MyLinkedListNode node,int index){
        int indexCount=0;
        if(index>=length){
           index=length-1;
        }

        while(indexCount!=index){

            node=node.next;

            indexCount++;
        }
        return node;
    }
    @Override
    public String toString(){
        return "MyLinkedList {"+"head :"+head.value+", tail :"+tail.value+", length :"+length+"}";
    }
}

//own stack using arrays
class MyStackUsingArray {
    private List<Integer> array = new ArrayList<>();

    public MyStackUsingArray() {
    }

    public int peak() {
        if (array.size() == 0) {
            throw new EmptyStackException();
        }
        return array.get(this.array.size() - 1);
    }

    public int pop() {
        if (array.size() == 0) {
            throw new EmptyStackException();
        }
        return array.remove(array.size() - 1);
    }

    public void push(int valueToPush) {
        array.add(valueToPush);
    }

    public void printStack() {
        for (int value : array) {
            System.out.println(value);
        }
}
}
//creating own stack class
class MyStack{
    MyLinkedListNode top;
    MyLinkedListNode bottom;
    int length;

    MyStack(){
        this.top=null;
        this.bottom=null;
        this.length=0;
    }
     MyLinkedListNode peek(){
        return top;
    }
    MyLinkedListNode pop(){
        MyLinkedListNode temp=top;
        if(top==bottom){
            bottom=null;
        }
        top=top.next;
        length--;

        return top;
    }
    void push(int value){
        MyLinkedListNode node=new MyLinkedListNode(value,top);
        if(length==0){
            bottom=node;
        }
        top=node;
        length++;

    }
    boolean isEmpty(){
        return length==0;
    }
}
//creating own array class
class ArrayOwn{
    private Object[] data;
    private int capacity;
    private int length;

    public ArrayOwn () {
        capacity = 1;
        length = 0;
        data = new Object[1];
    }

    public Object get(int index) {
        return data[index];
    }

    public void push(Object obj) {
        if(capacity == length) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
        data[length] = obj;
        length++;
    }

    public Object pop() {
        Object popped = data[length - 1];
        data[length - 1] = null;
        length--;
        return popped;
    }

    public Object delete(int index) {
        Object itemToDelete = data[index];
        shiftItems(index);
        return itemToDelete;
    }

    public void shiftItems(int index) {
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[length - 1] = null;
        length--;
    }

    public static void main(String[] args) {
        ArrayOwn m = new ArrayOwn();
        m.push("Hello");
        m.push("World");

        for (int i = 0; i < m.length; i++) {
            System.out.println(m.get(i));
        }
    }
}
//creating own HashTable
class HashTable{
    private int size;
    private HashNode[] data;
    private class HashNode{
        private String key;
        private int value;
        HashNode(String key, int value){
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString(){
            return "HashNode{"+"key :"+key+", value :"+value+"}";
        }
    }
    HashTable(int size){
        this.size=size;
        this.data=new HashNode[size];
    }
    int _hash(String key){
        int hash=0;
        char[] keyArray=key.toCharArray();
        for(int i=0;i<key.length();i++){
            hash =(hash+(int)keyArray[i]*i)%this.data.length;
        }
        return hash;
    }
    ArrayList<String> keys(){
        ArrayList<String> keysArray = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            if(data[i]!=null){
                    keysArray.add(data[i].key);
                }
            }
        System.out.println(keysArray);
        return keysArray;
        }

    void set(String key, int value){
        int address =this._hash(key);
        if(data[address]==null){
            data[address]=new HashNode(key,value);

        }else{

            data[address]=new HashNode(key,value);
        }
    }
    int get(String key){
        int address =this._hash(key);
        return data[address].value;
    }
}
class Solution {//LEETCODE
    //returning index of two elements in an array which add up to the given target
    //complexity O(n2)
    public int[] twoSum(int[] nums, int target) {
        int[] result={};
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                   result=  new int[]{nums[i], nums[j]};
                }
            }
        }
        return result;
    }
    //returning index of two elements in an array which add up to the given target
    //complexity O(n)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    //returning largest sum possible in an array with any number of elements FAILED
    public int maxSubArray(int[] nums) {
        boolean onlyNegative=true;
        int sum=0;
        ArrayList<Integer> sumArr = new ArrayList<>();

        for(int num:nums){
            if(num>0){
                System.out.println("num>0time");
                onlyNegative=false;
                sum+=num;
            }else if(num<0){
                System.out.println("num<0time   :"+sum);
               sumArr.add(sum);
                sum=0;
            }
        }
        System.out.println(sumArr);
        if (onlyNegative){

            int max=nums[0];
            for(int num:nums){
                if(num>max){
                    max=num;
                }
            }
           return max;
        }else{
        Collections.sort(sumArr);
        return sumArr.get(sumArr.size() - 1);
        }

    }
    //returning largest sum possible in an array with any number of elements O(n)
    public int maxSubArray2(int[] nums){
        int currentSum=nums[0];
        int globalSum=nums[1];
        for (int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            if (currentSum > globalSum) {globalSum = currentSum;}
        }
        return globalSum;
    }

    //movezeroes to end of array O(n)
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> numsArr= new ArrayList<>();
        for(int num:nums) {
            numsArr.add(num);
        }
        for(int i=0;i<numsArr.size();i++){
            if(numsArr.get(i) ==0){
                numsArr.remove(i);
                numsArr.add(0);
            }
        }
        for(int i=0;i<numsArr.size();i++){
            nums[i]= numsArr.get(i);

        }
    }
    //contains duplicate O(n)
    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> numsCopy= new ArrayList<>();

        for(int num:nums){
            if(numsCopy.contains(num))
                return true;
            else
                numsCopy.add(num);

        }
        return false;
    }
    //rotating array k times O(n)
    public void rotate(int[] nums, int k) {
        for(int i=0;i<k;i++){
            shift(nums);
        }
    }
    public void shift(int[] nums){
        int temp = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            nums[i+1]=nums[i];
        }
        nums[0]=temp;
    }
}




