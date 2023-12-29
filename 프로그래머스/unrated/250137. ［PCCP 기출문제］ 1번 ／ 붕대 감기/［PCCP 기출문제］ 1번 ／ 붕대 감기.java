class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = 1, cnt = 0, maxHp = health;
        while(t <= attacks[attacks.length - 1][0] && health > 0){
            boolean isAttacked = false;
            for(int[] attack: attacks){
                if(t == attack[0]){
                    health -= attack[1];
                    isAttacked = true;
                    break;
                }
            }
            if(!isAttacked){
                health += bandage[1];
                cnt++;
                if(cnt >= bandage[0]){
                    health += bandage[2];
                    cnt = 0;
                }
                health = Math.min(health, maxHp);
            }
            else
                cnt = 0;
            t++;
        }
        if(health <= 0)
            return -1;
        return health;
    }
}