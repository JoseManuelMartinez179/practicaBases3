package dominio;

public class Scraper {
    
    int columnas;
    char coma = ',';
    
    public int analisisSelect(String select) {
        columnas = 1;
        
        for(int i=0; i<select.length(); i++) {
            if(select.charAt(i) == coma) {
                columnas++;
            }
        }
        return columnas;
    }
}
