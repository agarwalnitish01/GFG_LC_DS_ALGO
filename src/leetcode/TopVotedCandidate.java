package leetcode;

class TopVotedCandidate {
    int[] winners;
    int[] times;
    int len;
    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        this.winners = new int[n];
        this.times = times;
        this.len = n;


        int max = -1;

        int[] voteList = new int[n];
        for(int i=0;i<n;i++) {
            int x = voteList[persons[i]]++;
            winners[i] = (max <= x) ? persons[i] : winners[i-1];
            max = Math.max(max, x);
        }
    }

    public int q(int t) {
        int l = 1;
        int r = times.length;
        int mid;

        // Modified Binary search
        while (l < r) {
            mid = l + (r-l)/2;
            if(times[mid] <= t) {
                l = mid + 1;
            }
            else r = mid;
        }
        return winners[l-1];
    }

    public static void main(String args[]){
        int[] persons = {0,0,1,1,2};
        int[] times = {0,67,69,74,87};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons,times);
        System.out.print(topVotedCandidate.q(4));
        System.out.print(topVotedCandidate.q(62));
        System.out.print(topVotedCandidate.q(100));
        System.out.print(topVotedCandidate.q(88));
        System.out.print(topVotedCandidate.q(70));
        System.out.print(topVotedCandidate.q(73));
        System.out.print(topVotedCandidate.q(22));
        System.out.print(topVotedCandidate.q(72));
        System.out.print(topVotedCandidate.q(29));
        System.out.print(topVotedCandidate.q(10));
    }
}
