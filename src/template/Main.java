package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.awt.Color;


/**
 * Modelo de projeto básico da JSGE.
 * 
 * JSGE basic project template.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Main extends EngineFrame {
    private static final int POS_PIXEL_X = 20;
    private static final int POS_PIXEL_Y = 20;
    private static final int LINHAS_TABULEIRO = 20;
    private static final int COLUNAS_TABULEIRO = 10;
    
    private Tabuleiro tabuleiro;
    private Peca peca;
    private Color[][] cores;
    
    
    public Main() {
        
        
        super(
            600,                 // largura                      / width
            450,                 // algura                       / height
            "Window Title",      // título                       / title
            60,                  // quadros por segundo desejado / target FPS
            true,                // suavização                   / antialiasing
            false,               // redimensionável              / resizable
            false,               // tela cheia                   / full screen
            false,               // sem decoração                / undecorated
            false,               // sempre no topo               / always on top
            false                // fundo invisível              / invisible background
        );
        
    }
    
    /**
     * Cria o mundo do jogo.
     * Esse método executa apenas uma vez durante a inicialização da engine.
     * 
     * Creates the game world.
     * This method runs just one time during engine initialization.
     */
    @Override
    public void create() {
        tabuleiro = new Tabuleiro(20, 10, POS_PIXEL_X, POS_PIXEL_Y, BLACK); 
        
        peca = new Peca(1, 1, POS_PIXEL_X, POS_PIXEL_Y, GOLD, BLACK, tabuleiro);
        
        
        
        
    }

    /**
     * Lê a entrada do usuário e atualiza o mundo do jogo.
     * Os métodos de entrada devem ser usados aqui.
     * Atenção: Você NÃO DEVE usar nenhum dos métodos de desenho da engine aqui.
     * 
     * Reads user input and update game world.
     * Input methods should be used here.
     * Warning: You MUST NOT use any of the engine drawing methods here.
     * 
     * @param delta O tempo passado, em segundos, de um quadro para o outro.
     * Time passed, in seconds, between frames.
     */
    @Override
    public void update( double delta ) {  
        peca.update(delta);
    }
    
    /**
     * Desenha o mundo do jogo.
     * Todas as operações de desenho DEVEM ser feitas aqui.
     * 
     * Draws the game world.
     * All drawing related operations MUST be performed here.
     */
    @Override
    public void draw() {
      tabuleiro.draw(this);
      peca.drawPeca(this);
      
    }
    
    /**
     * Instancia a engine e a inicia.
     * 
     * Instantiates the engine and starts it.
     */
    
    
    public static void main( String[] args ) {
        new Main();
    }
    
    
}
