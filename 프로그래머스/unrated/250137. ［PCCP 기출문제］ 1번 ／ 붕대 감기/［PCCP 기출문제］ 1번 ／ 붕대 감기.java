class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int healthNow = health;
        int totalTime = attacks.length;
        int termTime = 0;
        for (int i = 0; i < totalTime-1; i++) {
            healthNow -= attacks[i][1];
            if (healthNow <= 0) {
                healthNow = -1;
                break;
            }
            termTime = attacks[i + 1][0] - attacks[i][0]-1;

            healthNow += bandage[1] * termTime;
            if (termTime >= bandage[0]) {
                healthNow += bandage[2] * (termTime / bandage[0]);
            }
            if (healthNow > health) {
                healthNow = health;
            }
            
        }
        healthNow -= attacks[totalTime - 1][1];
        if (healthNow <= 0) {
            healthNow = -1;
        }
        return (healthNow);
    }
}