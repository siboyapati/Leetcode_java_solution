import java.util.*;
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        /*
            def fullJustify(self, words, L):
                r=[]
                line=words[0]
                for i in range(1,len(words)):
                    w=words[i]
                    if len(line)+1+len(w)<=L:
                        line+=" "+w
                    else:
                        r.append(self.dist(line, L))
                        line=w
                r.append(line+' '*(L-len(line)))
                return r
            def dist(self, line, L):
                if not line.__contains__(' '):
                    return line+' '*(L-len(line))
                sc = line.count(' ')+L-len(line) # space count
                ws = line.split(' ')
                for i in range(len(ws)-1):
                    ws[i] += ' '*(sc/line.count(' '))
                    if i<sc%line.count(' '):
                        ws[i]+=' '
                return ''.join(ws)
        */
        List<String> r = new ArrayList<String>();
        String line = words[0];
        for (int i=1; i<words.length; i++) {
            String w = words[i];
            if(line.length()+1+w.length()<=L) line+=" "+w;
            else {
                r.add(dist(line, L));
                line = w;
            }
        }
        int tmp = line.length();
        for(int i=0;i<L-tmp;i++) line+=" ";
        r.add(line);
        return r;
    }
    private String dist(String line, int L) {
        if(!line.contains(" ")) {
            int tmp = line.length();
            for(int i=0;i<L-tmp;i++) line+=" ";
            return line;
        }
        String[] ws = line.split(" ");
        int sc = ws.length-1+L-line.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sc/(ws.length-1);i++) {
            sb.append(' ');
        }
        for(int i=0; i<ws.length-1;i++) {
            ws[i]+=sb.toString();
            if(i<sc%(ws.length-1)) ws[i]+=" ";
        }
        sb = new StringBuilder();
        for(int i=0; i<ws.length;i++) sb.append(ws[i]);
        return sb.toString();
    }
}
