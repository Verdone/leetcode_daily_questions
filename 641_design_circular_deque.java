// 641. Design Circular Deque
// Difficulty: Medium
// Topics: Array, Linked List, Design, Queue

class MyCircularDeque {

    ArrayList<Integer> a;
    int sz;

    public MyCircularDeque(int k) {
        a = new ArrayList<>();
        sz = k;
    }
    
    public boolean insertFront(int value) {
        if(a.size()<sz){
            a.add(0,value);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean insertLast(int value) {
        if(a.size()<sz){
            a.add(value);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deleteFront() {
        if(a.size()>0){
            a.remove(0);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deleteLast() {
        if(a.size()>0){
            a.remove(a.size()-1);
            return true;
        }else{
            return false;
        }
    }
    
    public int getFront() {
        return (a.size()>0) ? a.get(0) : -1;
    }
    
    public int getRear() {
        return (a.size()>0) ? a.get(a.size()-1) : -1;
    }
    
    public boolean isEmpty() {
        return (a.size()==0) ? true : false;
    }
    
    public boolean isFull() {
        return (a.size()==sz) ? true : false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */