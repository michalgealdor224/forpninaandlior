import java.util.Scanner;

public class RealEstate {
    private User[] users;
    private Property[] properties;
    private Address[] addresses;
    private User User;

    public RealEstate () {
        Address [] addresses = new Address[10];
        Address address1 = new Address();
        address1.setNameOfCity("tel aviv");
        Address address2 = new Address();
        address2.setNameOfCity("tel aviv");
        Address address3 = new Address();
        address3.setNameOfCity("haifa");
        Address address4 = new Address();
        address4.setNameOfCity("ashkelon");
        Address address5 = new Address();
        address5.setNameOfCity("ashdod");
        Address address6 = new Address();
        address6.setNameOfCity("tel aviv");
        Address address7 = new Address();
        address7.setNameOfCity("haifa");
        Address address8 = new Address();
        address8.setNameOfCity("jerusalem");
        Address address9 = new Address();
        address9.setNameOfCity("ashkelon");
        Address address10 = new Address();
        address10.setNameOfCity("natanya");
         int i=0;
         addresses[i] = address1;
         addresses[i+1] = address2;
         addresses[i+2] = address3;
         addresses[i+3] = address4;
         addresses[i+4] = address5;
         addresses[i+5] = address6;
         addresses[i+6] = address7;
         addresses[i+7] = address8;
         addresses[i+8] = address9;
         addresses[i+9] = address10;
        }

    public User[] getUsers(){
        return this.users;
    }
    public Property[] getProperties(){
        return this.properties;
    }
    public Address[] getAddresses(){
        return this.addresses;
    }
    public void setUsers (User[] users){
        this.users = users;
    }
    public void setProperties(Property[] properties){
        this.properties = properties;
    }
    public void setAddresses(Address[] addresses){
        this.addresses = addresses;
    }

    public void createUser () {
        Scanner scanner = new Scanner(System.in);
        boolean ifExists = false;
        String userName;
        do {
            System.out.println("enter userName");
            userName = scanner.nextLine();
            for (int i = 0; i < users.length; i++) {
                if (users[i].getUserName().equals(userName)) {
                    ifExists=true;
                    break;
                }

            }
        } while (ifExists);
        boolean ifChar =false;
        boolean ifNumber= false;
        String password;
        do {
            System.out.println("enter password");
            password = scanner.nextLine();
            for (int i=0; i<password.length(); i++) {
                if (password.charAt(i)== '_' ||password.charAt(i)== '%'
                        ||password.charAt(i)== '$' ) {
                    ifChar=true;
                }
                if (Character.isDigit(password.charAt(i))) {
                    ifNumber =true;
                }
            }
            if (!ifChar || !ifNumber) {
                System.out.println("password is not strong");
            }
        }while (!ifChar || !ifNumber);
        boolean ifLengthValid = false;
        boolean ifNumberValid=false;
        final int FIRST_NUMBER = 0;
        final int SECOND_NUMBER = 5 ;
        final int LENGTH_VALID =10;
        String phoneNumber;
        do {
            System.out.println("enter your phone number");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.length() == LENGTH_VALID) {
                ifLengthValid = true;
            }
            if (phoneNumber.charAt(0) == FIRST_NUMBER && phoneNumber.charAt(1) == SECOND_NUMBER) {
                ifNumberValid = true;
            }
            if (!ifNumberValid || !ifLengthValid) {
                System.out.println("the phone number is not valid");
            }
        } while (!ifNumberValid || !ifLengthValid);

        System.out.println("enter true for mediator, false for regular user");
        boolean type = scanner.hasNext();
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassword(password);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setIfMediator(type);
    }

    public User login () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter user name");
        String userName = scanner.nextLine();
        System.out.println("enter user password");
        String password = scanner.nextLine();
        boolean ifExistsUsername  = false;
        boolean ifExistsPassword =false;
        int location=0;
        for (int i=location; i< userName.length(); i++, location++) {
            if (users[i].getUserName().equals(userName)){
                ifExistsUsername =true;
                break;
            }
            if (users[i].getPassword().equals(password)) {
                ifExistsPassword=true;
                break;
            }
        }
        if (ifExistsPassword && ifExistsUsername) {
            return users[location];
        }
        else {
            return null;
        }
    }

    public boolean postNewProperty (User user) {
        boolean ifEverythingGood= false;
        int countOfMax = 0;
        int currentCount = 0;
        if (user.isIfMediator()) {
            countOfMax = 10;
        } else {
            countOfMax = 3;
        }
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getNameOfSeller().equals(user.getUserName())) {
                currentCount++;
            }
        }
        int possibleAmountOfPublication = countOfMax - currentCount;
        if (possibleAmountOfPublication == 0) {
            System.out.println("you have reached the possible amount of publications");
            ifEverythingGood=false;
        }
        boolean ifHave = false;
        String[] namesOfCities = new String[0];
        for (int i = 0; i < addresses.length; i++) {
            namesOfCities = new String[this.addresses.length + 1];
            for (int j = 0; j < this.addresses.length; j++) {
                if (namesOfCities[i] == addresses[j].getNameOfCity()) {
                    ifHave = true;
                    break;
                }
                if (!ifHave) {
                    namesOfCities[i] = addresses[j].getNameOfCity();
                    System.out.println(namesOfCities[i]);
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter city from the list");
        String city = scanner.nextLine();
        for (int i = 0; i < namesOfCities.length; i++) {
            if (!city.equals(namesOfCities[i])) {
                 ifEverythingGood=false;
            } else {
                for (int j = 0; j > addresses.length; j++) {
                    if (addresses[j].getNameOfCity().equals(city)) {
                        System.out.println(addresses[j].getNameOfStreet());
                    }
                }
                String[] namesOfStreet = new String[0];
                for (int j = 0; j < addresses.length; j++) {
                    namesOfStreet = new String[this.addresses.length + 1];
                    for (int k = 0; k < this.addresses.length; k++) {
                        namesOfStreet[i] = addresses[j].getNameOfStreet();
                        System.out.println(namesOfStreet[i]);
                    }
                }
                System.out.println("enter name of street");
                String street = scanner.nextLine();
                boolean ifExists = false;
                for (int j = 0; j <namesOfStreet.length; j++) {
                    if (namesOfCities[j].equals(street)) {
                        ifExists=true;
                        break;
                    }
                }
                if (!ifExists) {
                    ifEverythingGood=false;
                }
                else {
                    System.out.println("enter type of property-" +
                            "1 for ordinary apartment in a building" +
                            "2 for penthouse apartment in a building" +
                            "3 for private house");
                    int typeOfProperty = scanner.nextInt();
                    String newTypeOfProperty="";
                    if (typeOfProperty==1) {
                        newTypeOfProperty= "ordinary apartment in a building";
                    }
                    if (typeOfProperty==2) {
                        newTypeOfProperty= "penthouse apartment in a building";
                    }
                    if (typeOfProperty==3) {
                        newTypeOfProperty= " private house";
                    }

                    if (typeOfProperty==1) {
                        System.out.println("enter floor");
                        int floorOfProperty= scanner.nextInt();
                        System.out.println("enter amount of rooms");
                        int amountOfRooms = scanner.nextInt();
                        System.out.println("enter number of property");
                        int numberOfProperty = scanner.nextInt();
                        System.out.println("if the property to sell enter true else false");
                        boolean ifForSell = scanner.hasNext();
                        System.out.println("enter price of the property");
                        int priceOfProperty = scanner.nextInt();
                        Property property = new Property();
                        property.setType(newTypeOfProperty);
                        property.setNumberOfFloor(floorOfProperty);
                        property.setNumbersOfRooms(amountOfRooms);
                        property.setNumberOfHouse(numberOfProperty);
                        property.setForRent(ifForSell);
                        property.setPrice(priceOfProperty);
                        ifEverythingGood=true;
                    }
                }
            }
        }
        return ifEverythingGood;
    }
}
