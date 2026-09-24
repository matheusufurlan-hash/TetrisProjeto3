

package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.awt.Color;

public class Peca {
    private int linhas;
    private int colunas;
    private int queda = 0;
    private double tempo;
    private Color corPecaFundo;
    private Color corPecaContorno;
    private int posicaoPecax;
    private int posicaoPecay;
    private static final int ALTURA_BLOCO = 20;
    private static final int LARGURA_BLOCO = 20;
    private Tabuleiro tabuleiroPeca;
    
    public Peca(int linhas, int colunas, int posicaoPecax, int posicaoPecay, Color corPecaFundo, Color corPecaContorno, Tabuleiro tabuleiroPeca) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.posicaoPecax = posicaoPecax;
        this.posicaoPecay = posicaoPecay;
        this.corPecaFundo = corPecaFundo;
        this.corPecaContorno = corPecaContorno;
        this.tabuleiroPeca = tabuleiroPeca;
    }

    

    
    void update( double delta){
        tempo = delta*5;
        queda += tempo;
        posicaoPecay += queda;
        
        
    }
    void drawPeca(int linha, int coluna, EngineFrame engine){
        
            int posx = posicaoPecax;
            int posy = posicaoPecay;
        
        
            engine.drawRectangle(posx, posy, LARGURA_BLOCO, ALTURA_BLOCO, corPecaContorno);
            engine.fillRectangle(posx, posy, LARGURA_BLOCO, ALTURA_BLOCO, corPecaFundo);
            
         
    }
    
}
