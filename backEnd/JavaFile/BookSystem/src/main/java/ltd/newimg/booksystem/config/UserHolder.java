package ltd.newimg.booksystem.config;

import ltd.newimg.booksystem.model.dto.UserDTO;

public class UserHolder {
    private static final ThreadLocal<UserDTO> users = new ThreadLocal<>();

    public static void setUser(UserDTO user){
        users.set(user);
    }

    public static UserDTO getUser(){
        return users.get();
    }

    public static void remove(){
        users.remove();
    }
}
