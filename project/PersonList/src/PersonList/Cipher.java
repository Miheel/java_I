package PersonList;

public class Cipher {

    private final char startChar;
    private final char endChar;
    private final int rangeCount;

    /**
     * creates a cipher object that holds a start char and end char representing the start and end of the ascii char range to use when encoding a message
     *
     * @param startChar a Printable ascii char to use as range start
     * @param endChar a Printable ascii char to use as range end
     * */
    Cipher(char startChar, char endChar){

        this.startChar = startChar;
        this.endChar = endChar;
        this.rangeCount =  endChar - startChar;
    }


    public String caesar(String str, int key) {

        int rangeCount = this.endChar - this.startChar;
        StringBuilder tempString = new StringBuilder();

        for(char ch : str.toCharArray()){
            char shiftedChar =  (char)((ch + key - this.startChar) % this.rangeCount + this.startChar);
            tempString.append(shiftedChar);
        }
        return tempString.toString();
    }

    public int getRangeCount(){
        return this.rangeCount;
    }
}

