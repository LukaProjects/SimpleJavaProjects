package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companyEmailSuffix = "company.com";

    // Constructor that takes firstname and lastname
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Calling method for department
        this.department = setDepartment();

        // Calling method for random pass generate
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Fix this with method implementation..
        email = this.firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + this.companyEmailSuffix;
    }

    // Ask for department
    private String setDepartment() {
        System.out.println("New worker: " + firstName + ". Department Codes:\n1 for Developer\n2 for DevOps\n3 for SystemTester\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){return "Developer";}
        else if(depChoice == 2){return "DevOps";}
        else if(depChoice == 3){return "SystemTest";}
        else{return "";}
    }

    // Random password generator
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ1234567890@_#$%&/!";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int randomValue = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomValue);
        }
        return new String(password);
    }

    // Setting mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Setting alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() {return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
