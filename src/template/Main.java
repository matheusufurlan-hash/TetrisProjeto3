package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.math.Vector2;
import java.awt.Color;
import java.util.HashSet;


/**
 * Modelo de projeto básico da JSGE.
 * 
 * JSGE basic project template.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Main extends EngineFrame {
    private static final int POSX = 20;
    private static final int POSY = 20;
    
    private int linhasTabuleiro = 20;
    private int colunasTabuleiro = 10;
    private Tabuleiro tabuleiro;
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
        tabuleiro = new Tabuleiro(10, 20, POSX, POSY, BLACK); 
        tabuleiro.ocupar(9, 8, GOLD);
        tabuleiro.ocupar(3, 5, GOLD);
        tabuleiro.ocupar(2, 19, GOLD);
        for(int linha = 0; linha < linhasTabuleiro; linha++){
            for(int coluna = 0; coluna< colunasTabuleiro; coluna++){
                tabuleiro.estaPreenchido(linha, coluna);
            }
        }
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
