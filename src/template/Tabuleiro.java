

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
    boolean estaPreenchido(int linha, int coluna){
        if((linha < linhas && linha > 0) || (coluna < colunas && coluna > 0)){
           if(gradeDeCores[linha][coluna] != null){
               System.out.printf("Esta preenchido linha %d na coluna %d\n", linha, coluna);
              return true;
           }
        }
        if(linha > linhas || coluna > colunas){
            System.out.println("Peca fora da grade");
        }
        else if(linha < 0 || coluna < 0){
            System.out.println("Peca vazia");
        }
        else{
            System.out.println("Nao esta preenchido");
            
        }
        return false;
    }
    void ocupar(int linha, int coluna, Color cor){
        
        gradeDeCores[linha][coluna] = cor;
        
    }
    
}




