class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if(words == null || words.length == 0 || maxWidth <= 0){
            result.add("");
            return result;
        }

        for(int i = 0; i < words.length;) {
            int w = i;

            // calculate how many word with one whitespace can be put in
            // since first word in a line has no space on the left
            int len = -1;
            while(w < words.length && len + words[w].length() + 1<= maxWidth) {
                // left has white space by defaut, so + 1
                len += words[w].length() + 1;
                w ++;
            }

            // set 1 for default as special case
            int evenSpace = 1;
            int extraSpace = 0;
            // n elements has n - 1 gaps
            int numberOfGaps = (w - i) - 1;

            // normal case: not one word and not last line
            if(w != i + 1 && w != words.length) {
                // add one for default space
                evenSpace = (maxWidth - len) / numberOfGaps + 1;
                extraSpace = (maxWidth - len) % numberOfGaps;
            }

            // build result for normal & part of special
            // satisfy one word begins with left or normal case begin
            StringBuilder sb = new StringBuilder(words[i]);
            // build word's left space and the word except the first word
            for(int j = i + 1; j < w; j ++) {
                for(int s = 0; s < evenSpace; s ++) {
                    sb.append(" ");
                }
                // for special case, extraSpace = 0
                if(extraSpace > 0) {
                    sb.append(" ");
                    extraSpace --;
                }
                sb.append(words[j]);
            }

            // special case: only one word in the line or it is the last line
            // build result for special's whitespace
            int remain = maxWidth - sb.length();
            while(remain > 0) {
                sb.append(" ");
                remain --;
            }
            result.add(sb.toString());
            // move to next line's words
            i = w;
        }
        return result;
    }
}
