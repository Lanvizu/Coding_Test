import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int turn = 1;
        int stage = n / 3;
        Set<Integer> getCard = new HashSet<>();

        for (int i = 0; i < stage; i++) {
            getCard.add(cards[i]);
        }

        List<Integer> keepCard = new ArrayList<>();

        while (stage + turn * 2 -1 < n) {
            
            keepCard.add(cards[stage + (turn - 1) * 2]);
            keepCard.add(cards[stage + (turn - 1) * 2 + 1]);

            boolean success = false;

            success = findAndRemovePair(getCard, keepCard, n + 1, 0);
            if (success) {
                turn++;
                continue;
            }
            if (coin >= 1) {
                success = findAndRemovePair(getCard, keepCard, n + 1, 1);
                if (success) {
                    turn++;
                    coin--;
                    continue;
                }
            }

            if (coin >= 2) {
                success = findAndRemovePair(getCard, keepCard, n + 1, 2);
                if (success) {
                    turn++;
                    coin -= 2;
                    continue;
                }
            }
            break;
        }

        return turn;
    }

    private boolean findAndRemovePair(
        Set<Integer> first, List<Integer> second, int target, int mode) {
        if (mode == 0) {
            for (int a : first) {
                if (first.contains(target - a) && a != target - a) {
                    first.remove(a);
                    first.remove(target - a);
                    return true;
                }
            }
        } else if (mode == 1) {
            for (int a : first) {
                for (int b : second) {
                    if (a + b == target) {
                        first.remove(a);
                        second.remove(Integer.valueOf(b));
                        return true;
                    }
                }
            }
        } else if (mode == 2) {
            for (int i = 0; i < second.size(); i++) {
                int a = second.get(i);
                for (int j = i + 1; j < second.size(); j++) {
                    int b = second.get(j);
                    if (a + b == target) {
                        second.remove(Integer.valueOf(a));
                        second.remove(Integer.valueOf(b));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
