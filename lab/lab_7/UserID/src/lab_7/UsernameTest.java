package lab_7;

import java.util.ArrayList;

public class UsernameTest {

    public static void main(String[] args) {
	String[] names = {"Bo Ek", "Erik Edström", "Jörgen Svensson", "My andersson", "Carl Ek", "Jad Shahad", "Micke Löv", "Adam Temmel", "Fox Hamren", "alexander Norgren"};

    ArrayList<String> createdUsernames = Usernames.create(names);

    Usernames.list(names, createdUsernames);
    }
}
