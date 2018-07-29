/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spc_conv;


/**
 * Klasa konwertuje reprezentację SPC.
 * 
 * Dla zachowania możliwości rozszerzenia do ANSI liczba bitów musi być 
 * nie mniejsza niż 24. Dlatego wykorzystano int.
 * 
 * @author damian
 */
public class Convert {
    
    // mask3-mask2-mask1: 3-8-3
    private int mask1 = 0x7;
    private int mask2 = 0x7f8;
    private int mask3 = 0x3800;
    
    /**
     * 3-8-3 ITU-T.
     * 
     * First mask: 111 = 7;
     * Second mask: 111 1111 1000 = 7F8 hex, next shift it three times right
     * Third mask: 11 1000 0000 0000 = 3800 hex
     * next shift right 8+3 times =11       
     * first = SPC & 0x7
     * second = (SPC & 0x7f8)>>3
     * third = (SPC & 0x3800)>>11;
     * @param spcode
     * @return ITU-T Signalling Point Code
     */
    String toITU(int spcode){
        
        // brak obsługi przypadku gdy liczba będzie za duża
        if(spcode < 0 || spcode >= 16384)
            return "0-0-0";
        // dodatkowe nawiasy bo konwertowało shifty na String
        
        return ((spcode & mask3)>>11) + "-" + ((spcode & mask2)>>3) + "-" + (spcode & mask1);
    }
    
    /**
     * Returns 8-8-8 ANSI SPC for given decimal SPC.
     * 
     * @param spcode
     * @return ANSI formatted Signalling Point Code
     */
    String toANSI(int spcode){
        // mask3-mask2-mask1: 8-8-8
        int byte1 = 0xff;    
        int byte2 = 0xff00;
        int byte3 = 0xff0000;
        
        // Sprawdź zakres
        if (spcode < 0 || spcode >= 0xffffff)
            return "0-0-0";
        
        return ((byte3 & spcode)>>16) + "-" + ((byte2 & spcode)>>8) + "-" + (byte1 & spcode);
    }
    
    /**
     * Metoda konwertuje SPC w formacie 3-8-3 ITU-T na DEC.
     * 
     * @param SPC wartość punktu kodowego w formacie 3-8-3.
     * @return 
     */
    int ItuToDec(String SPC){
        
        itu_conv validator = new itu_conv();
        Integer result=-1;
        
        if(!validator.is_valid_383(SPC, result))
            return -1;
        
        System.out.println("DEC SPC: " + result);
        
        return 0;
    }
}
