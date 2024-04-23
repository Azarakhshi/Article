package entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfo {

    private int id;

    private String userName;

    private String nationalCode;

    private String birthday;

    private String password;

}
