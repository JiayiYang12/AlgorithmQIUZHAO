#
# @lc app=leetcode.cn id=146 lang=python3
#
# [146] LRU缓存机制
#

# @lc code=start

class Node:
    def __init__(self):
        self.key, self.value = 0, 0
        self.next, self.prev = None, None
    
class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.head, self.tail = Node(), Node()
        self.head.next = self.tail
        self.tail.prev = self.head
        self.size = 0
        self.cache = {}

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.moveToHead(node)
        return node.value


    def put(self, key: int, value: int) -> None:
        node = self.cache.get(key, None)
        if node is not None:
            node.value = value
            self.moveToHead(node)
        else:
            node = Node()
            node.key = key
            node.value = value
            self.addToHead(node)
            self.cache[key] = node
            self.size += 1
            if self.size > self.capacity:
                self.removeTail()
                self.size -= 1
    
    def addToHead(self, node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node
    
    def removeNode(self, node):
        pre = node.prev
        new = node.next
        pre.next = new
        new.prev = pre
    
    def moveToHead(self, node):
        self.removeNode(node)
        self.addToHead(node)
    
    def removeTail(self):
        node = self.tail.prev
        self.removeNode(node)
        del self.cache[node.key]
        
        
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end

