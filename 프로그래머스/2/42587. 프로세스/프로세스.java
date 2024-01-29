import java.util.*;

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        int[] a = new int[10];

        int count = 0;
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Node(priorities[i], i));
            a[priorities[i]] += 1;
        }

        outer:
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 9; i >= 1; i--) {
                if (a[i] == 0) continue;
                if (node.getX() == i) {
                    count++;
                    a[i]--;
                    if (node.getY() == location) {
                        break outer;
                    }
                } else {
                    q.offer(node);
                }
                break;
            }
        }
        return count;
    }
}