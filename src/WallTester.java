import java.util.ArrayList;

public class WallTester
{
//    public static void main (String[] args)
//    {
//        //take the "khuon" and bring it here
//        Wall ghostWall;
//        Wall brickWall = new Wall();
//        Wall concreteWall = new Wall();
//
//        //Trỏ cùng vào 1 vùng nhớ
//        //Effective Java
//        ghostWall = brickWall;
//
//        ghostWall.x = 10;
//
//        System.out.println(ghostWall.x);
//        System.out.println(brickWall.x);
//        System.out.println(concreteWall.x);
//    }
    public static void main (String[] args)
    {
        // 1. ArrayList toan wall
        ArrayList<Wall> walls = new ArrayList<>();

        // 2. Tao ra wall
//        Wall newWall =
//
//        Wall newWall2 = ;

        // 3. Add vao List
        walls.add(new Wall(3,2));
        walls.add(new Wall(0, 3));
        walls.add(new Wall(2,3));
        walls.add(new Wall(3, 3));
        walls.add(new Wall(0, 2));
        walls.add(new Wall(0, 1));

//        Wall temp = walls.get(0);
////        if (temp.match( 2, 2))
////        {
////            System.out.println("Hura");
////        }



        System.out.println(walls);
//        System.out.println(newWall);
    }
}
