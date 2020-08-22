import mmh3
from bitarray import bitarray

class BloomFilter:
    def __init__(self, size, hash_num):
        self.size = size
        self.hash_num = hash_num
        self.bit_array = bitarray(size)
    
    def add(self, s):
        for seed in range(self.hash_num):
            res = mmh3.hash(s, seed) % self.size
            self.bit_array[res] = 1
    
    def lookup(self, s):
        for seed in range(self.hash_num):
            res = mmh3.hash(s, seed) % self.size
            if self.bit_array[res] == 0:
                print('False')
                return
        print('True')
    
bf = BloomFilter(1000, 3)
bf.add('foo')
bf.lookup('s')
