import java.util.ArrayList;

class Main {
    static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue(){
            data = new ArrayList<>();
        }

        private void swap(int i, int j){
            int dataAtI = data.get(i);
            int dataAtJ = data.get(j);

            data.set(i,dataAtJ);
            data.set(j,dataAtI);
        }

        private void upHeapify(int childIdx){
            int parentIdx = (childIdx - 1)/2;

            if(data.get(parentIdx) > data.get(childIdx)){
                swap(parentIdx, childIdx);
                upHeapify(parentIdx);
            }
        }

        public void add(int val){
            data.add(val);
            upHeapify(data.size()-1);
        }

        private void downHeapify(int parentIdx){
            int leftChildIdx = 2*parentIdx + 1;
            int rightChildIdx = 2*parentIdx + 2;

            int minIdx = parentIdx;

            if(leftChildIdx < data.size() && data.get(leftChildIdx) < data.get(minIdx)){
                minIdx = leftChildIdx;
            }

            if(rightChildIdx < data.size() && data.get(rightChildIdx) < data.get(minIdx)){
                minIdx = rightChildIdx;
            }

            if(parentIdx != minIdx){
                swap(parentIdx, minIdx);
                downHeapify(minIdx);
            }
        }

        public int remove(){
            if(data.size() == 0){
                System.out.println("PriorityQueue is empty!!");
                return -1;
            }

            swap(0,data.size()-1);
            int topElement = data.remove(data.size() -1);

            downHeapify(0);

            return topElement;
        }

        public int peek(){
            if(data.size() == 0){
                System.out.println("PriorityQueue is empty!!");
                return -1;
            }

            return data.get(0);
        }

        public int size(){
            return data.size();
        }
    }

    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue();
        pq.add(10);
        pq.add(5);
        pq.add(7);
        pq.add(15);

        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
    }
}