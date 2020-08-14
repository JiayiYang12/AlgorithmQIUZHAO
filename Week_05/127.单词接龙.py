#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#

# @lc code=start
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        beginset = []
        endset = []
        beginset.append(beginWord)
        endset.append(endWord)
        wordset = set(wordList)
        wordset.remove(endWord)
        wordlen = len(beginWord)
        res = 1
        
        while beginset:
            new = []
            for word in beginset:
                for i in range(wordlen):
                    for k in [chr(j) for j in range(97, 97+26)]:
                        if k != word[i]:
                            nextword = word[: i] + k + word[i+1:]
                            if nextword in endset:
                                return res + 1
                            if nextword in wordset:
                                wordset.remove(nextword)
                                new.append(nextword)
            beginset = new
            if len(beginset) > len(endset):
                beginset, endset = endset, beginset
            res += 1
        return 0
          
# @lc code=end

