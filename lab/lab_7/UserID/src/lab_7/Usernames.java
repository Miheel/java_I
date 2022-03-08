package lab_7;

import java.util.ArrayList;
import java.util.Locale;

public class Usernames {
    private static String IDPart1;
    private static String IDPart2;

    public static ArrayList<String> create(String[] names){
        ArrayList<String> userNameList = new ArrayList<String>();
        for (String name : names) {
            String[] splitName = name.toLowerCase(Locale.ROOT).split(" ");

            if (splitName[0].length() <= 3){
                IDPart1 = splitName[0];
            }else {
                IDPart1 = splitName[0].substring(0, 3);
            }
            if (splitName[1].length() <= 3){
                IDPart2 = splitName[1];
            }else {
                IDPart2 = splitName[1].substring(0, 3);
            }
            userNameList.add(IDPart1 + IDPart2);
        }
        return userNameList;
    }

    public static void list(String[] names, ArrayList<String> usernames){
        for (int i = 0; i < names.length; i++){
            System.out.println(names[i] + " (" + usernames.get(i) + ")");
        }
    }
}
