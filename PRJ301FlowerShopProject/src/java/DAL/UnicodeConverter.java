/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class UnicodeConverter {
    
    public static String UnicodeToAscii(String text) {
        text = text.toLowerCase();
        String output = "";
        Map<Character, Character> data = ConversionMap();
        //access every value of text
        for(int i=0;i<text.length();i++){
            //check if the text contains unicode character or not
            if(data.containsKey(text.charAt(i))){
                output += data.get(text.charAt(i));
            }else
                output += text.charAt(i);
        }
        return output;
    }
    
    public static final Map<Character, Character> ConversionMap() {
        Map<Character, Character> conversionMap = new HashMap<>();

        // Danh sách chuyển đổi ký tự tiếng Việt sang ASCII
        conversionMap.put('á', 'a');
        conversionMap.put('à', 'a');
        conversionMap.put('ả', 'a');
        conversionMap.put('ã', 'a');
        conversionMap.put('ạ', 'a');
        conversionMap.put('ă', 'a');
        conversionMap.put('ắ', 'a');
        conversionMap.put('ằ', 'a');
        conversionMap.put('ẳ', 'a');
        conversionMap.put('ẵ', 'a');
        conversionMap.put('ặ', 'a');
        conversionMap.put('â', 'a');
        conversionMap.put('ấ', 'a');
        conversionMap.put('ầ', 'a');
        conversionMap.put('ẩ', 'a');
        conversionMap.put('ẫ', 'a');
        conversionMap.put('ậ', 'a');

        conversionMap.put('é', 'e');
        conversionMap.put('è', 'e');
        conversionMap.put('ẻ', 'e');
        conversionMap.put('ẽ', 'e');
        conversionMap.put('ẹ', 'e');
        conversionMap.put('ê', 'e');
        conversionMap.put('ế', 'e');
        conversionMap.put('ề', 'e');
        conversionMap.put('ể', 'e');
        conversionMap.put('ễ', 'e');
        conversionMap.put('ệ', 'e');

        conversionMap.put('í', 'i');
        conversionMap.put('ì', 'i');
        conversionMap.put('ỉ', 'i');
        conversionMap.put('ĩ', 'i');
        conversionMap.put('ị', 'i');

        conversionMap.put('ó', 'o');
        conversionMap.put('ò', 'o');
        conversionMap.put('ỏ', 'o');
        conversionMap.put('õ', 'o');
        conversionMap.put('ọ', 'o');
        conversionMap.put('ô', 'o');
        conversionMap.put('ố', 'o');
        conversionMap.put('ồ', 'o');
        conversionMap.put('ổ', 'o');
        conversionMap.put('ỗ', 'o');
        conversionMap.put('ộ', 'o');
        conversionMap.put('ơ', 'o');
        conversionMap.put('ớ', 'o');
        conversionMap.put('ờ', 'o');
        conversionMap.put('ở', 'o');
        conversionMap.put('ỡ', 'o');
        conversionMap.put('ợ', 'o');

        conversionMap.put('ú', 'u');
        conversionMap.put('ù', 'u');
        conversionMap.put('ủ', 'u');
        conversionMap.put('ũ', 'u');
        conversionMap.put('ụ', 'u');
        conversionMap.put('ư', 'u');
        conversionMap.put('ứ', 'u');
        conversionMap.put('ừ', 'u');
        conversionMap.put('ử', 'u');
        conversionMap.put('ữ', 'u');
        conversionMap.put('ự', 'u');

        return conversionMap;
    }
}
