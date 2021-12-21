public class User {

    private String userName;
    private String password;
    private String phoneNumber;
    private boolean ifMediator;

    public String getUserName(){
        return this.userName;
    }
    public String getPassword(){
        return this.password;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public boolean isIfMediator(){
        return this.ifMediator;
    }
    public void setUserName(String userName){
        this.userName= userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber= phoneNumber;
    }
    public void setIfMediator(boolean ifMediator){
        this.ifMediator= ifMediator;
    }
}
