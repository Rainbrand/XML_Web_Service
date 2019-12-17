package service;

import javax.jws.WebMethod;
import java.util.HashMap;

public interface TextServiceInterface {
    @WebMethod
    public int countOneWord(String text, String word);
    @WebMethod
    public String countCharacters(String text);
    @WebMethod
    public String countWords(String text);
    @WebMethod
    public String makeCaps(String text);
/*    @WebMethod
    public HashMap<String, Integer>countWordsOnWebPage(String URL);*/
}
