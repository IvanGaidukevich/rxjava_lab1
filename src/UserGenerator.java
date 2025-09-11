import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class UserGenerator {
    private static final String[] names = {"Ivan", "Maria", "Ksenia", "Sergey", "Pavel", "Diana"};

    public static User generate() {
        String name = names[ThreadLocalRandom.current().nextInt(names.length)];;
        User.counter++;
        return new User(User.counter, name);
    }

    public static List<User> generateList(int amount){
        List<User> userList = new ArrayList<>();
        for (int i=0; i < amount; i++){
            userList.add(generate());
        }
        return userList;
    }

}
