public class Wall
{
    //khuon vien gach
    int x = 0;
    int y = 0;

    //constructor
    public Wall(int x, int y)
    {
        //Tro len x va y o tren
        this.x = x;
        this.y = y;
    }

    public boolean match (int x, int y)
    {
        if(this.x == x && this.y == y)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toString()
    {
        return String.format("{x = %s, y = %s}", x, y);
    }
}
