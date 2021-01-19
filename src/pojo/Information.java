package pojo;

import java.util.LinkedList;

public class Information {

    String acc;

//    private List<User> u;
    String pwd;
    String phone;
    public LinkedList<Information> list=new LinkedList<>();

    public LinkedList<Information> getList() {
        return list;
    }

    public void setList(LinkedList<Information> list) {
        this.list = list;
    }

    public Information(){}

    public Information(String acc,String pwd,String phone){
        this.acc=acc;
        this.pwd=pwd;
        this.phone=phone;
    }

    public String getPwd() {
        return pwd;
    }

    public String getAcc() {
        return acc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Information{" +
                "acc='" + acc + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

