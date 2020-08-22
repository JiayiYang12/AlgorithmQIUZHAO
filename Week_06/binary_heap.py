import sys
class BinaryHeap:
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.Heap = [0] * (self.capacity + 1)
        self.Heap[0] = -1 * sys.maxsize
        self.front = 1
    
    def parent(self, i):
        return i // 2
    
    def leftchild(self, i):
        return 2*i
    
    def rightchild(self, i):
        return 2*i + 1
    
    def isLead(self, i):
        if i >= self.size // 2 and i <= self.size:
            return True
        return False
    
    def swap(self, fpos, spos):
        self.Heap[fpos], self.Heap[spos] = self.Heap[spos], self.Heap[fpos]
        
    def insert(self, item):
        if self.size >= self.capacity:
            return
        self.size += 1
        self.Heap[self.size] = item
        
        cur = self.size
        
        while self.Heap[cur] < self.Heap[self.parent(cur)]:
            self.swap(cur, self.parent(cur))
            cur = self.parent(cur)
    
    def Print(self):
        for i in range(1, (self.size // 2) + 1):
            print('parent: ' + str(self.Heap[i]) + 
                '\nleft child: ' + str(self.Heap[2*i]) +
                    '\nright child: ' + str(self.Heap[2*i+1]))
    
    def minHeap(self):
        for pos in range(self.size // 2, 0, -1):
            self.heapifyDown(pos)
    
    def delete(self):
        popped = self.Heap[self.front]
        self.Heap[front] = self.Heap[self.size]
        self.size -= 1
        self.heapifyDown(self.front)
        return popped
    
    def isEmpty(self):
        return self.size == 0
    
    def isFull(self):
        return self.size == self.capacity

minHeap = BinaryHeap(5)
minHeap.insert(5)
minHeap.insert(4)
minHeap.insert(9)
minHeap.insert(10)
minHeap.Print()
            