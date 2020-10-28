class HeaPDS {

	int []heap;
	int maxSize;
	int size;
	public HeaPDS(int maxSize) {
		this.maxSize = maxSize;
		heap = new int [maxSize];
		size=0;
		
	}
	public void insert(int x) {
		//System.out.println(" insert :"+x);
		if(size==maxSize)
			resize();
		int i=size;
		size++;
		//maxHeap 
		while(i>0 && heap[parentIndex(i)]<x) {
			heap[i] =heap[parentIndex(i)];
			i  = parentIndex(i);
		}
		heap[i] =x;
		
	}
	public int getMax() {
		return heap[0];
	}
	public int extract_Max() {
		int res = heap[0];
		heap[0] =heap[size-1];
		size--;
		heapify(0);
		return res;
	}
	
	public void DeleteKey(int key) {
		int i = findIndex(key);
//		if(key ==-1) {
//			for(int j=0;j<size;j++)
//			System.out.println("i "+heap[j]+" key :"+key);
//		
//		}
		//here we are inserting max int value as a dummy element  in the heap after this we will call extract_Max
		//to remove it.
		increaseKey(i,9999);
		extract_Max();
		
	}
	private void increaseKey(int i, int maxValue) {
		//System.out.println("increaseKey :"+i+" maxValue :"+maxValue);
		while(i>0 && heap[parentIndex(i)]<maxValue)
		{
			heap[i] = heap[parentIndex(i)];
			i = parentIndex(i);
		}
		//System.out.println("index :"+i);
		heap[i] = maxValue;
	}
	private int findIndex(int key) {
		for(int i=0;i<size;i++) {
			if(heap[i]==key)
				return i;
		}
		return -1;
	}
	private void heapify(int i) {

		int lchild = 2*i+1;
		int rChild = 2*i+2;
		int maxIndex =i;
		//for HaxHeap
		if(lchild<size && heap[lchild]>heap[i])
			i = lchild;
		//for HaxHeap
		if(rChild<size && heap[rChild]>heap[i])
			i = rChild;
		if(i!=maxIndex) {
			swap(i,maxIndex);
			heapify(i);
		}
		
	}
	private void swap(int i, int maxIndex) {
		int temp = heap[i];
		heap[i] = heap[maxIndex];
		heap[maxIndex] =temp;
		
	}
	private int parentIndex(int i) {
		
		return (i-1)/2;
	}
	private void resize() {
		int []copyHeap = new int[maxSize];
		heap = new int [maxSize*2];
		for(int i=0;i<maxSize;i++)
			heap[i] = copyHeap[i];
		maxSize*=2;
	}
	

}
