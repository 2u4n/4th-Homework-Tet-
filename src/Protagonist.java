public class Protagonist {
    int x = 0;
    int y = 0;
    int atk = 0;
    int def = 0;
    int hp = 0;
    int dex = 0;

    public Protagonist(int x, int y, int atk, int def, int hp, int dex) {
        this.x = x;
        this.y = y;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        this.dex = dex;
    }

    public boolean match(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        } else {
            return false;
        }
    }

    public int goUp() {
        return y--;
    }

    public int goDown() {
        return y++;
    }

    public int goLeft() {
        return x--;
    }

    public int goRight() {
        return x++;
    }

    public int checkWallX() {
        if (x < 0) {
            x = 0;
        } else if (x >= 5) {
            x = 4;
        }
        return x;
    }

    public int checkWallY() {
        if (y < 0) {
            y = 0;
        } else if (y >= 5) {
            y = 4;
        }
        return y;
    }
}