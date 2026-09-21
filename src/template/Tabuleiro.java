

package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import static br.com.davidbuzatto.jsge.core.engine.EngineFrame.KEY_SPACE;
import java.awt.Color;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private int posx;
    private int posy;
    private Color colorContorno;
    private Color colorFill;
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

    
    void draw(EngineFrame engine){
        int novaPosX = posx;
        int novaPosY = posy;
        for(int linha = 0; linha < linhas; linha++){
            
            for(int coluna = 0; coluna < colunas; coluna++){
                novaPosY = posy + coluna*LARGURA_BLOCO;
                novaPosX = posx + linha*ALTURA_BLOCO;
                engine.drawRectangle(novaPosX, novaPosY, LARGURA_BLOCO, ALTURA_BLOCO, colorContorno);
                
                if(gradeDeCores[linha][coluna] != null){
                    
                    engine.fillRectangle(novaPosX, novaPosY, LARGURA_BLOCO, ALTURA_BLOCO, gradeDeCores[linha][coluna]);
                    engine.drawRectangle(novaPosX, novaPosY, LARGURA_BLOCO, ALTURA_BLOCO, colorContorno);
                    
                    
                    
                }
                
                
               
            }
            
            
          
        }
    }
    void estaPreenchido(int linhas, int colunas){
        if(gradeDeCores[linhas][colunas] == null){
            System.out.println("oi");
        }else{
            System.out.println("tchau");
        }
    }
    void ocupar(int linha, int coluna, Color cor){
        
        gradeDeCores[linha][coluna] = cor;
        
    }
    
}



/*TODO fazer com que eu consigo me comunicar com a classe principal la no main no sentido de que
eh necessario eu saber a posicao da matriz se esta ou nao ocupada no metodo estaPreenchido */
//TODO Refazer estaPreenchido: recebe linha e coluna, sem laço, checa limites primeiro, retorna boolean
