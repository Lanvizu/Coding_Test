import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int testCase = 1; testCase <= T; ++testCase) {
            sc.nextLine();
            int N = sc.nextInt();
            sc.nextLine();

            int[] numberOfTeamMember = new int[201]; // 팀 인원 수
            int[] scoreOfTeam = new int[201]; // 팀 점수
            int[] scoreOfFifthPlayer = new int[201]; // 팀별 다섯 번째 선수 점수
            int[] raceResult = new int[N]; // 경기 결과

            for(int i = 0; i < N; ++i) {
                int teamNumber = sc.nextInt();

                ++numberOfTeamMember[teamNumber];
                raceResult[i] = teamNumber;
            }

            int score = 0;
            for(int i = 0; i < N; ++i) {
                if(numberOfTeamMember[raceResult[i]] < 6) {
                    continue;
                }

                ++score;
                // 다섯 번째 선수를 찾는 목적으로 팀인원수를 늘린다.
                ++numberOfTeamMember[raceResult[i]];

                // 팀 인원수가 11이 되면 해당 팀의 다섯 번째 선수를 의미한다.
                if(numberOfTeamMember[raceResult[i]] == 11) {
                    scoreOfFifthPlayer[raceResult[i]] = score;
                }

                // 점수는 팀 선두 네 명의 점수 합이므로 네 명까지만 더한다.
                if(numberOfTeamMember[raceResult[i]] < 11) {
                    scoreOfTeam[raceResult[i]] += score;
                }
            }

            int minScore = Integer.MAX_VALUE;
            int winner = 0;
            for(int i = 1; i < 201; ++i) {
                // 팀 점수가 0이면 참가하지 않은 팀이거나 인원이 부족한 팀이므로 넘어간다.
                if(scoreOfTeam[i] == 0) {
                    continue;
                }

                // 최소 점수인 팀이 우승팀이다.
                if(scoreOfTeam[i] < minScore) {
                    minScore = scoreOfTeam[i];
                    winner = i;
                } else if(scoreOfTeam[i] == minScore) {
                    // 점수가 같으면 다섯 번째 선수의 점수를 비교해 더 작은 팀이 우승팀이 된다.
                    if (scoreOfFifthPlayer[winner] > scoreOfFifthPlayer[i]) {
                        winner = i;
                    }
                }
            }

            sb
                .append(winner)
                .append("\n");
        }

        System.out.println(sb);

        sc.close();
    }
}