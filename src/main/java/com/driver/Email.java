package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        boolean uflag=true;
        boolean lflag=true;
        boolean dflag=true;
        boolean sflag=true;
        boolean nflag=true;
        if(oldPassword.equals(this.getPassword())){
            if(newPassword.length()<8) nflag=false;

            for(int i=0;i<newPassword.length();i++){
                if(Character.isUpperCase(newPassword.charAt(i))){
                    uflag=true;
                    break;
                }else{
                    uflag=false;
                }

            }
            for(int i=0;i<newPassword.length();i++){
                if(!Character.isUpperCase(newPassword.charAt(i))){
                    lflag=true;
                    break;
                }else{
                    lflag=false;
                }

            }
            for(int i=0;i<newPassword.length();i++){
                if(Character.isDigit(newPassword.charAt(i))){
                    dflag=true;
                    break;
                }else{
                    dflag=false;
                }

            }
            for(int i=0;i<newPassword.length();i++){
                if(!Character.isDigit(newPassword.charAt(i)) && !Character.isLetter(newPassword.charAt(i))){
                    sflag=true;
                    break;
                }else{
                    sflag=false;
                }

            }
            if(uflag && sflag && lflag && dflag && nflag){
                this.password=newPassword;
                System.out.println("passChange");
            }

        }
    }
}
