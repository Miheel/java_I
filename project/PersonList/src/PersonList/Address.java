package PersonList;

public class Address {
    private String postalAddress;
    private String zipCode;
    private String postOffice;

    public Address(String postalAddress, String zipCode, String postOffice) {
        this.postalAddress = postalAddress;
        this.zipCode = zipCode;
        this.postOffice = postOffice;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalAddress='" + postalAddress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", postOffice='" + postOffice + '\'' +
                '}';
    }
}
