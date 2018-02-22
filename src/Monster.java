public class Monster {
    int x = 0;
    int y = 0;
    int atk = 0;
    int def = 0;
    int hp = 0;
    int dex = 0;
    public Monster (int x, int y, int atk, int def, int hp, int dex) {
        this.x = x;
        this.y = y;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        this.dex = dex;
    }
    public boolean match (int x, int y) {
        if(this.x == x && this.y == y) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean hasMonster(){
        if(this.hp == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
