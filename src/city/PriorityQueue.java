package city;

public class PriorityQueue {
    private int currentSize;
    private Node first;
    private Node last;
    private Node what = null; //An object that is always null, because Java complained if I did otherwise.

    private class Node{
        private String name;
        private double distance;
        private Node next;

        public Node(String name, double distance, Node next) {
            this.name = name;
            this.distance = distance;
            this.next = next;
        }
        public Node(String name, double distance) {
            this.name = name;
            this.distance = distance;
        }
    }


    public PriorityQueue(){
        first = null;
        last = null;
        currentSize = 0;
    }

    public boolean isEmpty(){
        if(currentSize == 0){
            return true;
        }else return false;
    }
    public int size(){
        return currentSize;
    }

    //I don't know if it is important but I'll write this method anyway
    public double getFirst(){
        if(currentSize>0) {
            return first.distance;
        }else System.out.println("The priority queue is empty, you unintelligent human being! No, this 0 is not the actual first value.");
        return 0;
    }
    public double minDistance(){
        if (currentSize>0){
            return first.distance;
        }else{
            System.out.println("The priority queue is empty.");
            return 0;
        }
    }
    public double maxValue(){
        if (currentSize>0){
            return last.distance;
        }else{
            System.out.println("The priority queue is empty.");
            return 0;
        }
    }
    public void enqueue(String n, double d){
        Node current = first;
        if(first == null){
            first = new Node(n,d,null);
            last = first;

            currentSize++;
        }else if(first.distance > d){
            Node temp = first;
            first = new Node(n,d);
            first.next = temp;
            currentSize++;
        } else{
            while(current.next != what && current.next.distance < d){
                current = current.next;
            }
            Node added = new Node(n,d,current.next);
            current.next = added;
            currentSize++;
        }



        /*Older version that might have worked a bit better or not.
        else if(d<first.distance){
            Node temp = first;
            first = new Node(n,d,temp);
            if(temp.next == what){
                last = temp;
            }
            currentSize++;
            System.out.println(first.distance);
            return;
        } else{
            Node current = first;
            while(current.next != what && d>current.next.distance ){
                    current = current.next;
            }
            if(current.next == what){
                current.next = new Node(n,d,null);
                last = current.next;
                currentSize++;
                System.out.println(last.distance);
                return;
            }else {
                Node temp = current;
                current.next = new Node(n, d, temp);
                currentSize++;
                System.out.println(current.next.distance);
                return;
            }
        }*/
    }

    public Node pop(){
        Node temp = first;
        first = first.next;
        currentSize--;
        return temp;
    }
    public void deleteEntireQueue(){
        Node current = first.next;
        first = null;
        while(current.next != what){
            Node temp = current.next;
            current = null;
            current = temp;
        }
        last = null;
        currentSize = 0;
    }
    public void deleteEntireQueueRecursively(){
        deleteEntireQueueRecursively(first);
    }
    private void deleteEntireQueueRecursively(Node x){
        if(x.next != null){
            Node temp = x.next;
            x = null;
            currentSize--;
            deleteEntireQueueRecursively(temp);
        }else{
            x = null;
            last = null;
            currentSize--;
        }

    }

    public String toString(){
        String string = "";
        Node current = first;
        for (int i = 0; i < currentSize; i-=-1) {
            string = string + current.name + ": " + current.distance + "km \n";
            current = current.next;
        }
        return string;
    }

}
