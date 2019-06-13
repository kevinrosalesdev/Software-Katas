package kata4.model;

public class Mail {
    
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }
    
    public String getDomain() {
        int arroba = mail.indexOf("@") + 1;
        if (arroba == -1){
            return null;
        }else {
            return mail.substring(arroba);
        }
    }
    
}
