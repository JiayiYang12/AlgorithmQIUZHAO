import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set <String> wordSet = new HashSet<String>(wordList);
        wordSet.remove(beginWord);

        // bfs queue
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // visited or not in a graph
        Set <String> visited = new HashSet<>();
        wordSet.add(beginWord);

        int step = 1;
        int wordLen = beginWord.length();
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int j = 0; j < size; j ++) {
                String tmp = queue.poll();
                char [] word = tmp.toCharArray();

                for (int i = 0; i < wordLen; i ++) {
    
                    char originalchar = word[i];
                    for (char c = 'a'; c <= 'z'; c ++) {
                        if (c == originalchar) {
                            continue;
                        }
                        word[i] = c;
                        String nextword = String.valueOf(word);
                        if (wordSet.contains(nextword)) {
                            if (nextword.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextword)) {
                                visited.add(nextword);
                                queue.add(nextword);
                            }
                        }

                    }
                    word[i] = originalchar;

                }
            }
            step ++;

        }
        return 0;

    }
}
// @lc c

