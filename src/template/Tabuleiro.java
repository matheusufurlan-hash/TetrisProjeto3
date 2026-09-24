

package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.awt.Color;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private int posx;
    private int posy;
    private Color colorContorno;
    private Color[][] gradeDeCores;
    private static final int ALTURA_BLOCO = 20;
    private static final int LARGURA_BLOCO = 20;
    
    

    public Tabuleiro(int linhas, int colunas, int posx, int posy, Color colorContorno) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.posx = posx;
        this.posy = posy;
        this.colorContorno = colorContorno;
        this.gradeDeCores = new Color[linhas][colunas];
        
        
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }
    

    
    void draw(EngineFrame engine){
        int novaPosX = posx;
        int novaPosY = posy;
        for(int linha = 0; linha < linhas; linha++){
            
            for(int coluna = 0; coluna < colunas; coluna++){
                novaPosY = posy + coluna*LARGURA_BLOCO;
                novaPosX = posx + linha*ALTURA_BLOCO;
                engine.drawRectangle(novaPosY, novaPosX, LARGURA_BLOCO, ALTURA_BLOCO, colorContorno);
                
                if(gradeDeCores[linha][coluna] != null){
                    
                    engine.fillRectangle(novaPosY, novaPosX, LARGURA_BLOCO, ALTURA_BLOCO, gradeDeCores[linha][coluna]);
                    engine.drawRectangle(novaPosY, novaPosX, LARGURA_BLOCO, ALTURA_BLOCO, colorContorno);
                    
                      
                }             
            }          
        }
    }
    boolean estaPreenchido(int linha, int coluna){
        
        if((linha >= linhas || linha < 0) || (coluna >= colunas || coluna < 0)){
            System.out.println("Peca fora da grade");
            return true;
        }
        return gradeDeCores[linha][coluna] != null;
        
    }
    void ocupar(int linha, int coluna, Color cor){
        
        gradeDeCores[linha][coluna] = cor;
        
    }
    
}




