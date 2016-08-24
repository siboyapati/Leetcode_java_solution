import java.util.*;

public class Solution {
    public void solve(char[][] board) {
        Set<Integer[]> outside = new HashSet<Integer[]>();
        Set<Integer[]> inside = new HashSet<Integer[]>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'O') {
                    if(i!=0 && j!=0 && i!=board.length-1 && j!=board[0].length-1) {
                        board[i][j] = '?';
                        inside.add(new Integer[]{i, j});
                    } else outside.add(new Integer[]{i, j});
                }
            }
        }
        for(Integer[] pair : outside) {
            penetrate(board, pair[0], pair[1]);
        }
        for(Integer[] pair : inside) {
            int i = pair[0];
            int j = pair[1];
            if(board[i][j]=='?') board[i][j]='X';
        }
    }
    private void penetrate(char[][] board, int i, int j) {
        if(board[i][j]!='O') return;
        if(i-1>=0 && board[i-1][j]=='?') {
            board[i-1][j] = 'O';
            penetrate(board, i-1, j);
        }
        if(i+1<board.length && board[i+1][j]=='?') {
            board[i+1][j] = 'O';
            penetrate(board, i+1, j);
        }
        if(j-1>=0 && board[i][j-1]=='?') {
            board[i][j-1] = 'O';
            penetrate(board, i, j-1);
        }
        if(j+1<board[0].length && board[i][j+1]=='?') {
            board[i][j+1] = 'O';
            penetrate(board, i, j+1);
        }
    }
}
/*
class Solution:
    # @param board, a 2D array
    # Capture all regions by modifying the input board in-place.
    # Do not return any value.
    def solve(self, board):
        outside=set()
        inside =set()
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]=='O':
                    if not (i==0 or j==0 or i==len(board)-1 or j==len(board[0])-1):
                        board[i][j]='?'
                        inside.add((i,j))
                    else:
                        outside.add((i,j))
        for (i,j) in outside:
            self.penetrate(board, i, j)
        for (i,j) in inside:
            if board[i][j]=='?':
                board[i][j]='X'
    def penetrate(self, board, i, j):
        #DFS
        if board[i][j]!='O':
            return
        if i-1>=0 and board[i-1][j]=='?':
            board[i-1][j]='O'
            self.penetrate(board, i-1, j)
        if i+1<len(board) and board[i+1][j]=='?':
            board[i+1][j]='O'
            self.penetrate(board, i+1, j)
        if j-1>=0 and board[i][j-1]=='?':
            board[i][j-1]='O'
            self.penetrate(board, i, j-1)
        if j+1<len(board[0]) and board[i][j+1]=='?':
            board[i][j+1]='O'
            self.penetrate(board, i, j+1)
*/
