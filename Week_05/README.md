# 学习笔记
## 单词搜索2问题中，算法的时间复杂度
- 该算法的时间复杂度，最坏情况下应为O(M(4*3^(L-1)))，其中M是words中的元素个数，L是单词的最大长度
- 4*3^(L-1)为每一个元素作为启动单元，需要的最大步骤数。即表示，在最开始时，每一个结点都有四个方向可以探索，并且对于之后的每一个元素，需要探索的元素的总数为3（已经访问过的元素不必再访问）。也就是说如果画出所有的递归状态，所有的递归状态构成一棵树，这棵树以第一个元素为根结点，除了第一层会有4个元素外，其余每层均有3个元素，这棵树的深度为L-1，所以综合下来，以每一个结点作为起始单元，需要探索的最大步数应为4 *3^(L-1). words中共有M个元素，倘若每个元素都有机会充当起始单元，那么M个元素探索的总次数即为M(4 *3^(L-1))
## 双向BFS模板
- 双向bfs使用范围比较窄，个人认为并不是所有适合用bfs解决的题目都可以用双向bfs去解决，它只能解决那些「首位对称」的问题，这类问题的特征是目标明确（目标字符串给定）、将头尾元素互换并不改变题目的解法
```python
front = [beginword]
back = [endword]
wordset = set(wordlist)
res = 1

while front:
    new = []
    # process words currently in front
    for word in front:
        nextwords = generate_related_words(word)
        for nextword in nextwords:
            if nextword in back:
                return res
            if nextword not in wordset:
                front.append(nextword)
                wordset.remove(nextword)
    
    # update state
    front = new
    if len(front) > len(back):
        front, back = back, front
    res += 1

return -1
```