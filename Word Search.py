class Solution:
    # @param board, a list of lists of 1 length string
    # @param word, a string
    # @return a boolean
    def exist(self, board, word):
        found=False
        used=set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.search(board,i,j,word,used):
                    found=True
        return found
    def search(self,board,m,n,word,used):
        if len(word)==0:
            return True
        if board[m][n]!=word[0]:
            return False
        used.add((m,n))
        if  (m+1<len(board)    and (not used.__contains__((m+1,n))) and self.search(board,m+1,n,word[1:],used)) or \
            (m-1>=0            and (not used.__contains__((m-1,n))) and self.search(board,m-1,n,word[1:],used)) or \
            (n+1<len(board[0]) and (not used.__contains__((m,n+1))) and self.search(board,m,n+1,word[1:],used)) or \
            (n-1>=0            and (not used.__contains__((m,n-1))) and self.search(board,m,n-1,word[1:],used)):
            return True
        used.remove((m,n))
        return False
