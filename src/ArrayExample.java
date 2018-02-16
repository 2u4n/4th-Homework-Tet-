import java.util.ArrayList;
import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        //Array
        //type?
        //array indicator
        //variable name

        String[] badHabits = new String[]
                {
                        "Hoc ngoai gioi",
                        "Xem mai nha hang xom",
                        "Xem phim tren giang duong",
                        "Mua cung doan mua voi co giao"
                };
        ArrayList<String> badHabitsList = new ArrayList<>();
        badHabitsList.add("Mua cung doan voi co giao");
        badHabitsList.add("Hoc ngoai troi");
        badHabitsList.set(0, "Nhin tu cau thang len tren");
        System.out.println(badHabitsList);
    }
}
