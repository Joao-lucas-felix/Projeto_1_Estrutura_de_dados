package com.joaolucas.projetoestruturadedados;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author joao
 */


public class FrameListaDe extends javax.swing.JFrame {

    /**
     * Creates new form FrameListaDe
     */
    //codigo de listas LDE disponibilizado pelo professor com algumas modificações
    
    
public class LDE {
	
	class No {
		private No ant;
		private int conteudo;
		private No prox;
		
		public No(){
			setAnt(null);
			setProx(null);
		}

		public int getConteudo() {
			return conteudo;
		}

		public void setConteudo(int conteudo) {
			this.conteudo = conteudo;
		}

		public No getProx() {
			return prox;
		}

		public void setProx(No prox) {
			this.prox = prox;
		}

		public No getAnt() {
			return ant;
		}

		public void setAnt(No ant) {
			this.ant = ant;
		}
	}
	
	private No inicio;
	private No fim;
	private int tamanho;
	
	public LDE(){
		inicio = null;
		fim = null;		
		tamanho = 0;
	}
	
	/** Verifica se a Lista está vazia */
	public boolean vazia() {
	    if (tamanho == 0)
	        return true;
	    else
	        return false;
	}

	/**Obtém o tamanho da Lista*/
	public int tamanho() {
	    return tamanho;
	}

	/** Obtém o i-ésimo elemento de uma lista
	    Retorna o valor encontrado. */
	public int elemento (int pos) {
	    No aux = inicio;
	    int cont = 1;

	    if (vazia()) {
	        throw new IllegalAccessError();
	    }

	    if ((pos < 1) || (pos > tamanho())){
	       throw new IllegalAccessError();
	    }

	    // Percorre a lista do 1o elemento até pos 
	    while (cont < pos){
	        // modifica "aux" para apontar para o proximo elemento da lista 
	        aux = aux.getProx();
	        cont++;
	    }

	    return aux.getConteudo();
	}

	/**Retorna a posição de um elemento pesquisado.
	    Retorna 0 caso não seja encontrado */
	public int posicao (int dado) {
	    int cont = 1;
	    No aux;

	    /* Lista vazia */
	    if (vazia()) {
	       throw new IllegalAccessError();
	    }

	    /* Percorre a lista do inicio ao fim até encontrar o elemento*/
	    aux = inicio;
		while (aux != null) {
	        /* Se encontrar o elemento, retorna sua posicao n;*/
	        if (aux.getConteudo() == dado){
	            return cont;
	        }

	        /* modifica "aux" para apontar para o proximo elemento da lista */
	        aux = aux.getProx();
	        cont++;
	    }

	    throw new InternalError();
	}

	/** Insere nó em lista vazia */
	private boolean insereInicioLista(int valor) {
		// Aloca memoria para novo no 
	    No novoNo = new No();
	    
	    // Insere novo elemento na cabeca da lista
	    novoNo.setConteudo(valor);
	    novoNo.setProx(inicio);
	    
	    novoNo.setAnt(null); // Nova instrucao
	    if (vazia())
    			fim = novoNo; // Nova instrucao
	    else
    			inicio.setAnt(novoNo); // Nova instrucao	    
	    
	    inicio = novoNo;
	    tamanho++;
	    return true;
	}

	/** Insere nó no meio da lista */
	private boolean insereMeioLista(int pos, int dado){
	    int cont = 1;

	    // Aloca memoria para novo no
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    // Localiza a pos. onde será inserido o novo nó
	    No aux = inicio;
	    while ((cont < pos-1) && (aux != null)){
	          aux = aux.getProx();
	          cont++;
	    }

	    if (aux == null) {  // pos. inválida 
	    		return false;
	    }

	    // Insere novo elemento apos aux
	    novoNo.setAnt(aux); // Nova instrucao
	    novoNo.setProx(aux.getProx());
	    
	    aux.getProx().setAnt(novoNo); // Nova instrucao
	    
	    aux.setProx(novoNo);

	    tamanho++;
	    return true;
	}

	/** Insere nó no fim da lista */
	private boolean insereFimLista(int dado){
	    // Aloca memoria para novo no 
	    No novoNo = new No();
	    novoNo.setConteudo(dado);

	    // Procura o final da lista 
	    No aux = inicio;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    aux.setProx(novoNo);
	    
	    novoNo.setAnt(fim);  // Nova instrucao
	    fim.setProx(novoNo); // Nova instrucao
	    fim = novoNo; 		// Nova instrucao
	    
	    this.tamanho++;
	    return true;
	}

	/**Insere um elemento em uma determinada posição
	    Retorna true se conseguir inserir e 
	    false caso contrario */
	public boolean insere(int pos, int dado) {
		if ((vazia()) && (pos != 1)){
	        return false; /* lista vazia mas posicao inv*/
	    }

	 	/* inserção no início da lista (ou lista vazia)*/
	    if (pos == 1){
	        return insereInicioLista(dado);
	    }
	    /* inserção no fim da lista */
	    else if (pos == tamanho+1){
	        return insereFimLista(dado);
	   }
	   /* inserção no meio da lista */
	   else{
	        return insereMeioLista(pos, dado);
	   }
	}

	// Remove elemento do início de uma lista unitária
	private int removeInicioListaUnitaria(){          
	    int dado = inicio.getConteudo();
	    inicio = null;
	    fim = null; 
	    tamanho--;
	    return dado;
	}
	
	/** Remove elemento do início da lista */
	private int removeInicioLista(){
	    No p = inicio;

	    // Dado recebe o dado removido
	    int dado = p.getConteudo();

	    // Retira o 1o elemento da lista (p)
	    inicio = p.getProx();
	    p.getProx().setAnt(null);  // Nova instrucao
	    
	    tamanho--;

	    // Sugere ao garbage collector que libere a memoria
	    //  da regiao apontada por p
	    p = null;

	    return dado;
	}

	/** Remove elemento no meio da lista */
	private int removeMeioLista(int pos){
	     No p = inicio;
	     int n = 1;
	     
	     // Localiza o nó que será removido
	     while((n <= pos-1) && (p != null)){ 
	    	 	p = p.getProx();
	        n++;
	     }
	     
	     if (p == null) {
	    	 	throw new IllegalAccessError();
	     }
	     
	    	 int dado = p.getConteudo();
	    	 p.getAnt().setProx(p.getProx());
	    	 p.getProx().setAnt(p.getAnt());
			 
	     tamanho--;
	     
	     /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
	    p = null;
	    return dado;
	}
	
	/** Remove elemento do início da lista */
	private int removeFimLista(){          
	     No p = fim;
	     int dado = p.getConteudo();
	     
	     fim.getAnt().setProx(null);
	     fim = fim.getAnt();
	     tamanho--;
	     
	     p = null; 
	     return dado;
	}

	
	/**Remove um elemento de uma determinada posição
	    Retorna o valor a ser removido. 
	    -1 se a posição for inválida ou a lista estiver vazia*/
	public int remove(int pos) {
		// Lista vazia 
	    if (vazia()) {
	    	throw new IllegalAccessError();
	    }

	    // Remoção do elemento da cabeça da lista 
	    if ((pos == 1) && (tamanho() == 1)){ 
	 		 return removeInicioListaUnitaria();
	    }
	    else if (pos == 1){
	        return removeInicioLista();
	    }
	    // Remocao no fim da lista
	    else if (pos == tamanho()){ 
	 		 return removeFimLista();
	    }
	    // Remoção em outro lugar da lista
	    else{
	        return removeMeioLista(pos);
	    }
	}	
}
    
    private LDE lista;
    private int tamanhoDaLista;
    private final JPanel[] listaDeNos;
    private final JButton[][] listaDeElementos;
    private final JLabel[][] flechas;

    
    public FrameListaDe() {
        initComponents();
        this.listaDeNos = new JPanel[6];
        this.listaDeElementos = new JButton[3][6];
        this.flechas = new JLabel[2][5];
        this.lista = new LDE();
        this.tamanhoDaLista =0;
        
        //Organizando os elementos graficos que representam a lista:
        //Nós:
        this.listaDeNos[0] = this.no1;
        this.listaDeNos[1] = this.no2;
        this.listaDeNos[2] = this.no3;
        this.listaDeNos[3] = this.no4;
        this.listaDeNos[4] = this.no5;
        this.listaDeNos[5] = this.no6;


        
        //Elementos que representam os dados
        this.listaDeElementos[0][0] = this.dado1;
        this.listaDeElementos[1][0] = this.ponteiroAnt1;
        this.listaDeElementos[2][0] = this.ponteiroProx1;
        
        this.listaDeElementos[0][1] = this.dado2;
        this.listaDeElementos[1][1] = this.ponteiroAnt2;
        this.listaDeElementos[2][1] = this.ponteiroProx2;
        
        this.listaDeElementos[0][2] = this.dado3;
        this.listaDeElementos[1][2] = this.ponteiroAnt3;
        this.listaDeElementos[2][2] = this.ponteiroProx3;
        
        this.listaDeElementos[0][3] = this.dado4;
        this.listaDeElementos[1][3] = this.ponteiroAnt4;
        this.listaDeElementos[2][3] = this.ponteiroProx4;
        
        this.listaDeElementos[0][4] = this.dado5;
        this.listaDeElementos[1][4] = this.ponteiroAnt5;
        this.listaDeElementos[2][4] = this.ponteiroProx5;
        
        this.listaDeElementos[0][5] = this.dado6;
        this.listaDeElementos[1][5] = this.ponteiroAnt6;
        this.listaDeElementos[2][5] = this.ponteiroProx6;

        

        //flechas que representam o encadeamento dos Nós:
        this.flechas[0][0] = this.labelFlecha1;
        this.flechas[1][0] = this.labelFlecha2;
        
        this.flechas[0][1] = this.labelFlecha3;
        this.flechas[1][1] = this.labelFlecha4;
        
        this.flechas[0][2] = this.labelFlecha5;
        this.flechas[1][2] = this.labelFlecha6;
        
        this.flechas[0][3] = this.labelFlecha7;
        this.flechas[1][3] = this.labelFlecha8;
        
        this.flechas[0][4] = this.labelFlecha9;
        this.flechas[1][4] = this.labelFlecha10;
        
        
           
       //removendo os nos que não estão visiveis:
       for(int i =2; i < this.listaDeNos.length; i++){
           this.listaDeNos[i].setVisible(false);
       }
       //removendo as flechas que não estão visiveis:
       
       this.flechas[0][1].setVisible(false);
       this.flechas[1][1].setVisible(false);
       
       
       this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        painelMenu = new javax.swing.JPanel();
        btnListaSeq = new javax.swing.JButton();
        btnListaSe = new javax.swing.JButton();
        btnListaDe = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        painelInserir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        fieldValorInserir = new javax.swing.JTextField();
        fieldPosInserir = new javax.swing.JTextField();
        btnInsrir = new javax.swing.JButton();
        painelRemover = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblRemover = new javax.swing.JLabel();
        fieldPosRemover = new javax.swing.JTextField();
        btnRemover = new javax.swing.JButton();
        painelBuscar = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        fieldBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        comboBoxBuscar = new javax.swing.JComboBox<>();
        no1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ponteiroProx1 = new javax.swing.JButton();
        dado1 = new javax.swing.JButton();
        ponteiroAnt1 = new javax.swing.JButton();
        labelFlecha1 = new javax.swing.JLabel();
        labelFlecha2 = new javax.swing.JLabel();
        no2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ponteiroProx2 = new javax.swing.JButton();
        dado2 = new javax.swing.JButton();
        ponteiroAnt2 = new javax.swing.JButton();
        labelFlecha3 = new javax.swing.JLabel();
        labelFlecha4 = new javax.swing.JLabel();
        no4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        ponteiroProx4 = new javax.swing.JButton();
        dado4 = new javax.swing.JButton();
        ponteiroAnt4 = new javax.swing.JButton();
        labelFlecha7 = new javax.swing.JLabel();
        labelFlecha8 = new javax.swing.JLabel();
        no5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        ponteiroProx5 = new javax.swing.JButton();
        dado5 = new javax.swing.JButton();
        ponteiroAnt5 = new javax.swing.JButton();
        labelFlecha9 = new javax.swing.JLabel();
        labelFlecha10 = new javax.swing.JLabel();
        no6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        ponteiroProx6 = new javax.swing.JButton();
        dado6 = new javax.swing.JButton();
        ponteiroAnt6 = new javax.swing.JButton();
        no3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        ponteiroProx3 = new javax.swing.JButton();
        dado3 = new javax.swing.JButton();
        ponteiroAnt3 = new javax.swing.JButton();
        labelFlecha5 = new javax.swing.JLabel();
        labelFlecha6 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        painelMenu.setBackground(new java.awt.Color(0, 255, 255));

        btnListaSeq.setBackground(new java.awt.Color(51, 255, 255));
        btnListaSeq.setText("Lista Seq");
        btnListaSeq.setToolTipText("");
        btnListaSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaSeqActionPerformed(evt);
            }
        });

        btnListaSe.setBackground(new java.awt.Color(51, 255, 255));
        btnListaSe.setText("Lista SE");
        btnListaSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaSeActionPerformed(evt);
            }
        });

        btnListaDe.setBackground(new java.awt.Color(51, 255, 255));
        btnListaDe.setText("Lista DE");
        btnListaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelMenuLayout = new javax.swing.GroupLayout(painelMenu);
        painelMenu.setLayout(painelMenuLayout);
        painelMenuLayout.setHorizontalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListaSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListaSe, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelMenuLayout.setVerticalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListaSeq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaSe, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(btnListaDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(325, 325, 325))
        );

        jInternalFrame2.setVisible(true);

        painelInserir.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Inserir:");

        lblValor.setText("Valor:");

        jLabel20.setText("Posição:");

        btnInsrir.setBackground(new java.awt.Color(0, 255, 255));
        btnInsrir.setText("Inserir");
        btnInsrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelInserirLayout = new javax.swing.GroupLayout(painelInserir);
        painelInserir.setLayout(painelInserirLayout);
        painelInserirLayout.setHorizontalGroup(
            painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInserirLayout.createSequentialGroup()
                .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelInserirLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblValor)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldValorInserir)
                            .addComponent(fieldPosInserir, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(painelInserirLayout.createSequentialGroup()
                        .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelInserirLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnInsrir))
                            .addGroup(painelInserirLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelInserirLayout.setVerticalGroup(
            painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInserirLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(fieldValorInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(fieldPosInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsrir)
                .addGap(0, 67, Short.MAX_VALUE))
        );

        painelRemover.setBackground(new java.awt.Color(204, 204, 204));

        jLabel21.setText("Remover:");

        lblRemover.setText("Posição:");

        btnRemover.setBackground(new java.awt.Color(51, 255, 255));
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelRemoverLayout = new javax.swing.GroupLayout(painelRemover);
        painelRemover.setLayout(painelRemoverLayout);
        painelRemoverLayout.setHorizontalGroup(
            painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRemoverLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRemoverLayout.createSequentialGroup()
                        .addComponent(lblRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldPosRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRemoverLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(48, 48, 48))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRemoverLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addGap(35, 35, 35))
        );
        painelRemoverLayout.setVerticalGroup(
            painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRemoverLayout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(36, 36, 36)
                .addGroup(painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRemover)
                    .addComponent(fieldPosRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addContainerGap())
        );

        painelBuscar.setBackground(new java.awt.Color(204, 204, 204));

        jLabel22.setText("Buscar:");

        btnBuscar.setBackground(new java.awt.Color(0, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        comboBoxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Posição", "Valor" }));

        javax.swing.GroupLayout painelBuscarLayout = new javax.swing.GroupLayout(painelBuscar);
        painelBuscar.setLayout(painelBuscarLayout);
        painelBuscarLayout.setHorizontalGroup(
            painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBuscarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBuscarLayout.createSequentialGroup()
                        .addGroup(painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldBuscar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(painelBuscarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnBuscar)
                .addGap(0, 48, Short.MAX_VALUE))
        );
        painelBuscarLayout.setVerticalGroup(
            painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscarLayout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(35, 35, 35)
                .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(21, 21, 21))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        ponteiroProx1.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroProx1.setText("null");

        dado1.setBackground(new java.awt.Color(51, 255, 255));
        dado1.setText("null");

        ponteiroAnt1.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroAnt1.setText("null");

        labelFlecha1.setText("   --->");

        labelFlecha2.setText("   <---");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ponteiroAnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dado1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiroProx1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelFlecha1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFlecha2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ponteiroProx1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dado1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiroAnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelFlecha1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout no1Layout = new javax.swing.GroupLayout(no1);
        no1.setLayout(no1Layout);
        no1Layout.setHorizontalGroup(
            no1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(no1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        no1Layout.setVerticalGroup(
            no1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, no1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        ponteiroProx2.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroProx2.setText("null");

        dado2.setBackground(new java.awt.Color(51, 255, 255));
        dado2.setText("null");

        ponteiroAnt2.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroAnt2.setText("null");

        labelFlecha3.setText("   --->");

        labelFlecha4.setText("   <---");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ponteiroAnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(dado2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiroProx2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelFlecha3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFlecha4)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ponteiroProx2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dado2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiroAnt2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelFlecha3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout no2Layout = new javax.swing.GroupLayout(no2);
        no2.setLayout(no2Layout);
        no2Layout.setHorizontalGroup(
            no2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(no2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        no2Layout.setVerticalGroup(
            no2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(no2Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        ponteiroProx4.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroProx4.setText("null");

        dado4.setBackground(new java.awt.Color(51, 255, 255));
        dado4.setText("null");

        ponteiroAnt4.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroAnt4.setText("null");

        labelFlecha7.setText("   --->");

        labelFlecha8.setText("   <---");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ponteiroAnt4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dado4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiroProx4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelFlecha7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFlecha8)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ponteiroProx4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dado4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiroAnt4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelFlecha7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout no4Layout = new javax.swing.GroupLayout(no4);
        no4.setLayout(no4Layout);
        no4Layout.setHorizontalGroup(
            no4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(no4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        no4Layout.setVerticalGroup(
            no4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, no4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        ponteiroProx5.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroProx5.setText("null");

        dado5.setBackground(new java.awt.Color(51, 255, 255));
        dado5.setText("null");

        ponteiroAnt5.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroAnt5.setText("null");

        labelFlecha9.setText("   --->");

        labelFlecha10.setText("   <---");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ponteiroAnt5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(dado5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiroProx5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelFlecha9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFlecha10)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ponteiroProx5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dado5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiroAnt5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelFlecha9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout no5Layout = new javax.swing.GroupLayout(no5);
        no5.setLayout(no5Layout);
        no5Layout.setHorizontalGroup(
            no5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(no5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        no5Layout.setVerticalGroup(
            no5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, no5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        ponteiroProx6.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroProx6.setText("null");

        dado6.setBackground(new java.awt.Color(51, 255, 255));
        dado6.setText("null");

        ponteiroAnt6.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroAnt6.setText("null");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ponteiroAnt6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dado6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiroProx6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ponteiroProx6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dado6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiroAnt6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout no6Layout = new javax.swing.GroupLayout(no6);
        no6.setLayout(no6Layout);
        no6Layout.setHorizontalGroup(
            no6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(no6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        no6Layout.setVerticalGroup(
            no6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, no6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        ponteiroProx3.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroProx3.setText("null");

        dado3.setBackground(new java.awt.Color(51, 255, 255));
        dado3.setText("null");

        ponteiroAnt3.setBackground(new java.awt.Color(51, 255, 255));
        ponteiroAnt3.setText("null");

        labelFlecha5.setText("   --->");

        labelFlecha6.setText("   <---");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ponteiroAnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dado3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiroProx3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(labelFlecha5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFlecha6)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ponteiroProx3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dado3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiroAnt3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelFlecha5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout no3Layout = new javax.swing.GroupLayout(no3);
        no3.setLayout(no3Layout);
        no3Layout.setHorizontalGroup(
            no3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(no3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        no3Layout.setVerticalGroup(
            no3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(no3Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(no1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(no2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(no3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(no4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(no5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(no6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(no5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(no2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(painelInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(painelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(no1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(no4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(no6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(no3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jInternalFrame2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaSeqActionPerformed
        // TODO add your handling code here:
        FrameListaSeqTamanho frame = new FrameListaSeqTamanho();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnListaSeqActionPerformed

    private void btnListaSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaSeActionPerformed
        // TODO add your handling code here:
        FrameListaSe frame = new FrameListaSe();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnListaSeActionPerformed

    private void btnListaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDeActionPerformed
        // TODO add your handling code here:
        FrameListaDe frame = new FrameListaDe();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnListaDeActionPerformed

    private void btnInsrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsrirActionPerformed
        try{
            if(this.tamanhoDaLista <=5){
                int valor = Integer.parseInt(this.fieldValorInserir.getText());
                int pos = Integer.parseInt(this.fieldPosInserir.getText());
                if(this.lista.insere(pos, valor)){
                    this.tamanhoDaLista++;
                    for(int i =0; i < this.listaDeNos.length; i++){
                        this.listaDeNos[i].setVisible(false);
                    }
                    for(int i=0; i < this.tamanhoDaLista; i++){

                        this.listaDeElementos[0][i].setText(String.valueOf(this.lista.elemento(i+1)));
                        this.listaDeElementos[1][i].setText("ant");
                        this.listaDeElementos[2][i].setText("prox");
                        if(i ==0){
                            this.listaDeElementos[1][i].setText("null");
                        }
                        if(i < 5){
                            this.flechas[0][i].setVisible(true);
                            this.flechas[1][i].setVisible(true);
                        }
                        this.listaDeNos[i].setVisible(true);    
                    }
                    if(this.tamanhoDaLista < 6){
                        this.listaDeElementos[0][this.tamanhoDaLista].setText("null");
                        this.listaDeElementos[1][this.tamanhoDaLista].setText("null");
                        this.listaDeElementos[2][this.tamanhoDaLista].setText("null");
                        this.listaDeNos[this.tamanhoDaLista].setVisible(true);
                        if(this.tamanhoDaLista < 5){
                            this.flechas[0][this.tamanhoDaLista].setVisible(false);
                            this.flechas[1][this.tamanhoDaLista].setVisible(false);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possivel inserir o valor nesta posição\nInforme apenas posições validas", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Lista Cheia", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
        }catch(IllegalAccessError e){
            JOptionPane.showMessageDialog(null, "Posição Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnInsrirActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try{
            if(this.tamanhoDaLista >0){
                int pos = Integer.parseInt(this.fieldPosRemover.getText());
                this.lista.remove(pos);
                this.tamanhoDaLista--;
                if(tamanhoDaLista ==0){
                    //Removendo da tela os no que não estão visiveis
                    for(int i =2; i < this.listaDeNos.length; i++){
                        this.listaDeNos[i].setVisible(false);
                    }
                    //Removendo manualmente a segunda flecha:
                    this.flechas[0][1].setVisible(false);
                    this.flechas[1][1].setVisible(false);
                    this.listaDeElementos[0][0].setText("null");
                    this.listaDeElementos[1][0].setText("null");
                    this.listaDeElementos[2][0].setText("null");

                }else{
                        for(int i =0; i < this.listaDeNos.length; i++){
                            this.listaDeNos[i].setVisible(false);
                        }
                        for(int i=0; i < this.tamanhoDaLista; i++){

                            this.listaDeElementos[0][i].setText(String.valueOf(this.lista.elemento(i+1)));
                            this.listaDeElementos[1][i].setText("ant");
                            this.listaDeElementos[2][i].setText("prox");
                            if(i ==0){
                                this.listaDeElementos[1][i].setText("null");
                            }
                            if(i < 5){
                                this.flechas[0][i].setVisible(true);
                                this.flechas[1][i].setVisible(true);
                            }
                            this.listaDeNos[i].setVisible(true);    
                        }
                        if(this.tamanhoDaLista < 6){
                            this.listaDeElementos[0][this.tamanhoDaLista].setText("null");
                            this.listaDeElementos[1][this.tamanhoDaLista].setText("null");
                            this.listaDeElementos[2][this.tamanhoDaLista].setText("null");
                            this.listaDeNos[this.tamanhoDaLista].setVisible(true);
                            if(this.tamanhoDaLista < 5){
                                this.flechas[0][this.tamanhoDaLista].setVisible(false);
                                this.flechas[1][this.tamanhoDaLista].setVisible(false);
                            }
                        }
                } 
            }else{
                JOptionPane.showMessageDialog(null, "Lista vazia", "Erro", JOptionPane.ERROR_MESSAGE);

            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
        }catch(IllegalAccessError e){
            JOptionPane.showMessageDialog(null, "Posição Invalida!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        if(this.comboBoxBuscar.getSelectedIndex() ==0){
          try{
              int pos = Integer.parseInt(this.fieldBuscar.getText());
              int elemento = this.lista.elemento(pos);
              JOptionPane.showMessageDialog(null, "Na posição "+pos+" está o elemento: "+elemento, "Elemento", JOptionPane.INFORMATION_MESSAGE);
          }catch( NumberFormatException e){
              JOptionPane.showMessageDialog(null, "Digite apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
              
          }catch(IllegalAccessError e){
              JOptionPane.showMessageDialog(null, "Posição invalida", "Erro", JOptionPane.ERROR_MESSAGE);
          }
       }
       if(this.comboBoxBuscar.getSelectedIndex() ==1){
          try{
              int elemento = Integer.parseInt(this.fieldBuscar.getText());
              int pos = this.lista.posicao(elemento);
              JOptionPane.showMessageDialog(null, "O elemento "+elemento+" está na Posição: "+pos, "Posição", JOptionPane.INFORMATION_MESSAGE);
          }catch( NumberFormatException e){
              JOptionPane.showMessageDialog(null, "Digite apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
              
          }catch(IllegalAccessError e){
              JOptionPane.showMessageDialog(null, "Posição invalida", "Erro", JOptionPane.ERROR_MESSAGE);
          }catch(InternalError e){
              JOptionPane.showMessageDialog(null, "Elemento Não Encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
          }
       }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInsrir;
    private javax.swing.JButton btnListaDe;
    private javax.swing.JButton btnListaSe;
    private javax.swing.JButton btnListaSeq;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> comboBoxBuscar;
    private javax.swing.JButton dado1;
    private javax.swing.JButton dado2;
    private javax.swing.JButton dado3;
    private javax.swing.JButton dado4;
    private javax.swing.JButton dado5;
    private javax.swing.JButton dado6;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JTextField fieldPosInserir;
    private javax.swing.JTextField fieldPosRemover;
    private javax.swing.JTextField fieldValorInserir;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel labelFlecha1;
    private javax.swing.JLabel labelFlecha10;
    private javax.swing.JLabel labelFlecha2;
    private javax.swing.JLabel labelFlecha3;
    private javax.swing.JLabel labelFlecha4;
    private javax.swing.JLabel labelFlecha5;
    private javax.swing.JLabel labelFlecha6;
    private javax.swing.JLabel labelFlecha7;
    private javax.swing.JLabel labelFlecha8;
    private javax.swing.JLabel labelFlecha9;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel no1;
    private javax.swing.JPanel no2;
    private javax.swing.JPanel no3;
    private javax.swing.JPanel no4;
    private javax.swing.JPanel no5;
    private javax.swing.JPanel no6;
    private javax.swing.JPanel painelBuscar;
    private javax.swing.JPanel painelInserir;
    private javax.swing.JPanel painelMenu;
    private javax.swing.JPanel painelRemover;
    private javax.swing.JButton ponteiroAnt1;
    private javax.swing.JButton ponteiroAnt2;
    private javax.swing.JButton ponteiroAnt3;
    private javax.swing.JButton ponteiroAnt4;
    private javax.swing.JButton ponteiroAnt5;
    private javax.swing.JButton ponteiroAnt6;
    private javax.swing.JButton ponteiroProx1;
    private javax.swing.JButton ponteiroProx2;
    private javax.swing.JButton ponteiroProx3;
    private javax.swing.JButton ponteiroProx4;
    private javax.swing.JButton ponteiroProx5;
    private javax.swing.JButton ponteiroProx6;
    // End of variables declaration//GEN-END:variables
    


}
