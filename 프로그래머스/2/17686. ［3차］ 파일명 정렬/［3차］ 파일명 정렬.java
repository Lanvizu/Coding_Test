import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<FileInfo> fileInfos = new ArrayList<>();
        
        for (String file : files) {
            fileInfos.add(parseFile(file));
        }
        
        fileInfos.sort((f1, f2) -> {
            int headCompare = f1.head.compareToIgnoreCase(f2.head);
            if (headCompare != 0) return headCompare;
            return Integer.compare(Integer.parseInt(f1.number), Integer.parseInt(f2.number));
        });
        
        String[] answer = new String[files.length];
        for (int i = 0; i < fileInfos.size(); i++) {
            answer[i] = fileInfos.get(i).toString();
        }
        
        return answer;
    }

    private FileInfo parseFile(String file) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        
        int stage = 0;
        
        for (char c : file.toCharArray()) {
            if (stage == 0 && Character.isDigit(c)) {
                stage = 1;
                number.append(c);
            } else if (stage == 1 && !Character.isDigit(c)) {
                stage = 2;
                tail.append(c);
            } else if (stage == 0) {
                head.append(c);
            } else if (stage == 1) {
                number.append(c);
            } else {
                tail.append(c);
            }
        }
        
        return new FileInfo(head.toString(), number.toString(), tail.toString());
    }

    private static class FileInfo {
        String head;
        String number;
        String tail;

        FileInfo(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return head + number + tail;
        }
    }
}
