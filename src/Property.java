public class Property {

    private Address address;
    private int numbersOfRooms;
    private int price;
    private String type;
    private boolean ForRent;
    private int numberOfHouse;
    private int numberOfFloor;
    private String nameOfSeller;


    public Address getAddress () {
        return this.address;
    }

   public int getNumbersOfRooms () {
       return this.numbersOfRooms;
   }
    public int getPrice () {
        return this.price;
    }
    public String getType () {
        return this.type;
    }
    public boolean isForRent() {
       return this.ForRent;
    }
    public int getNumberOfHouse () {
       return this.numberOfHouse;
    }
    public int getNumberOfFloor () {
       return this.numberOfFloor;
    }
    public String getNameOfSeller () {
       return this.nameOfSeller;
    }

    public void setAddress (Address address) {
        this.address = address;
    }

    public void setNumbersOfRooms (int numbersOfRooms) {
        this.numbersOfRooms= numbersOfRooms;
    }
    public void setPrice (int price) {
       this.price=price;
    }
    public void setType (String type) {
       this.type=type;
    }
    public void setForRent (boolean forRent) {
       this.ForRent=forRent;
    }
    public void setNumberOfHouse (int numbersOfHouse) {
       this.numberOfHouse= numbersOfHouse;
    }
    public void setNumberOfFloor (int numberOfFloor) {
       this.numberOfFloor=numberOfFloor;
    }
    public void setNameOfSeller (String nameOfSeller) {
       this.nameOfSeller= nameOfSeller;
    }








}

