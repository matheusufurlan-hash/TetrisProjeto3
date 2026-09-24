

package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.awt.Color;

public class Peca {
    private int linhas;
    private int colunas;
    private int queda = 0;
    private static final double INTERVALO = 0.5;
    private double tempoAcumulado = 0;
    private Color corPecaFundo;
    private Color corPecaContorno;
    private int posicaoPecax;
    private int posicaoPecay;
    private static final int ALTURA_BLOCO = 20;
    private static final int LARGURA_BLOCO = 20;
    private Tabuleiro tabuleiro;
    private int linha =0;
    private int coluna = colunas/2;
   
    
    public Peca(int linhas, int colunas, int posicaoPecax, int posicaoPecay, Color corPecaFundo, Color corPecaContorno, Tabuleiro tabuleiroPeca) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.posicaoPecax = posicaoPecax;
        this.posicaoPecay = posicaoPecay;
        this.corPecaFundo = corPecaFundo;
        this.corPecaContorno = corPecaContorno;
        this.tabuleiro = tabuleiroPeca;
    }

    

    
    void update( double delta){
         tempoAcumulado += delta;
         if(tempoAcumulado >= INTERVALO){
             tempoAcumulado -= INTERVALO;
             if(!tabuleiro.estaPreenchido(linha + 1, coluna)){
                 linha++;
             }
         }
   
    }
    void drawPeca(EngineFrame engine){
        
            int posx = tabuleiro.getPosx();
            int posy = tabuleiro.getPosy();
            posx += coluna*LARGURA_BLOCO;
            posy += linha*ALTURA_BLOCO;
        
        
            
            engine.fillRectangle(posx, posy, LARGURA_BLOCO, ALTURA_BLOCO, corPecaFundo);
            engine.drawRectangle(posx, posy, LARGURA_BLOCO, ALTURA_BLOCO, corPecaContorno);
            
            
         
    }
    
}

// TODO fazer os limites para a peca
// TODO fazer a peca com seis espacos que se movimentam;

