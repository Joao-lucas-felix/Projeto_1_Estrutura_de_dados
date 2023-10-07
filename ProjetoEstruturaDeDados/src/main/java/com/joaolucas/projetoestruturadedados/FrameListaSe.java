package com.joaolucas.projetoestruturadedados;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author joao
 */
public class FrameListaSe extends javax.swing.JFrame {

    /**
     * Creates new form FrameListaSe
     */
    // codigo de listas SE disponibilizado pelo porfessor com algumas modificações:
    public class LSE2 {
	
	class No {
		private int conteudo;
		private No prox;
		
		public No(){
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
	}
	
	private No cabeca;
	private int tamanho;
	
	public LSE2(){
		cabeca = null;
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
		/*No p = cabeca;
		int cont = 0;
		while(p != null){
			p = p.getProx();
			cont++;
		}
		return cont;*/
	}

	/** Obtém o i-ésimo elemento de uma lista
	    Retorna o valor encontrado. */
	public int elemento (int pos) {
	    No aux = cabeca;
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
	    aux = cabeca;
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
	    novoNo.setProx(cabeca);
	    cabeca = novoNo;
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
	    No aux = cabeca;
	    while ((cont < pos-1) && (aux != null)){
	          aux = aux.getProx();
	          cont++;
	    }

	    if (aux == null) {  // pos. inválida 
	    		return false;
	    }

	    // Insere novo elemento apos aux
	    novoNo.setProx(aux.getProx());
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
	    No aux = this.cabeca;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    aux.setProx(novoNo);

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

	/** Remove elemento do início da lista */
	private int removeInicioLista(){
	    No p = cabeca;

	    // Dado recebe o dado removido
	    int dado = p.getConteudo();

	    // Retira o 1o elemento da lista (p)
	    cabeca = p.getProx();
	    tamanho--;

	    // Sugere ao garbage collector que libere a memoria
	    //  da regiao apontada por p
	    p = null;

	    return dado;
	}

	/** Remove elemento no meio da lista */
	private int removeNaLista(int pos){
	     No atual = null, antecessor = null;
	     int dado = -1;
	     int cont = 1;

	     /* Localiza o nó que será removido*/
	     atual = cabeca;
	     while((cont < pos) && (atual != null)){
	           antecessor = atual;
	           atual = atual.getProx();
	           cont++;
	     }

	     if (atual == null) { /* pos. inválida */
	        throw new IllegalAccessError();
	     }

	    /* retira o elemento da lista */
	    dado = atual.getConteudo();
	    antecessor.setProx(atual.getProx());
	    tamanho--;

	    /* sugere ao garbage collector que libere a memoria
	     *  da regiao apontada por p*/
	    atual = null;
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
	    if (pos == 1){
	        return removeInicioLista();
	    }
	    // Remoção em outro lugar da lista
	    else{
	        return removeNaLista(pos);
	    }
	}	
}

    
    
    private final LSE2 lista;
    private int tamanhoDaLista; 
    private final JPanel[] listaDeNos;
    private final JButton[][] listaDeElementos;
    private final JLabel[] flechas;
    
    
    public FrameListaSe() {
        initComponents();
        this.listaDeNos = new JPanel[10];
        this.listaDeElementos = new JButton[2][10];
        this.flechas = new JLabel[9];
        this.lista = new LSE2();
        this.tamanhoDaLista =0;
        //Organizando os elementos graficos que representam a lista:
       
       //oraginazando a lista de  nos
       this.listaDeNos[0] = this.No1;
       this.listaDeNos[1] = this.No2;
       this.listaDeNos[2] = this.No3;
       this.listaDeNos[3] = this.No4;
       this.listaDeNos[4] = this.No5;
       this.listaDeNos[5] = this.No6;
       this.listaDeNos[6] = this.No7;
       this.listaDeNos[7] = this.No8;
       this.listaDeNos[8] = this.No9;
       this.listaDeNos[9] = this.No10;
       
       //organizando os elementos:
       this.listaDeElementos[0][0] = this.elemento1;
       this.listaDeElementos[1][0] = this.ponteiro1;
       
       this.listaDeElementos[0][1] = this.elemento2;
       this.listaDeElementos[1][1] = this.ponteiro2;

       this.listaDeElementos[0][2] = this.elemento3;
       this.listaDeElementos[1][2] = this.ponteiro3;
       
       this.listaDeElementos[0][3] = this.elemento4;
       this.listaDeElementos[1][3] = this.ponteiro4;
       
       this.listaDeElementos[0][4] = this.elemento5;
       this.listaDeElementos[1][4] = this.ponteiro5;
       
       this.listaDeElementos[0][5] = this.elemento6;
       this.listaDeElementos[1][5] = this.ponteiro6;
       
       this.listaDeElementos[0][6] = this.elemento7;
       this.listaDeElementos[1][6] = this.ponteiro7;
       
       this.listaDeElementos[0][7] = this.elemento8;
       this.listaDeElementos[1][7] = this.ponteiro8;
       
       this.listaDeElementos[0][8] = this.elemento9;
       this.listaDeElementos[1][8] = this.ponteiro9;
       
       this.listaDeElementos[0][9] = this.elemento10;
       this.listaDeElementos[1][9] = this.ponteiro10;
       
       
       //organizando as felchas que representam a ligação entre os nos:
       this.flechas[0] = this.labelFlecha1;
       this.flechas[1] = this.labelFlecha2;
       this.flechas[2] = this.labelFlecha3;
       this.flechas[3] = this.labelFlecha4;
       this.flechas[4] = this.labelFlecha5;
       this.flechas[5] = this.labelFlecha6;
       this.flechas[6] = this.labelFlecha7;
       this.flechas[7] = this.labelFlecha8;
       this.flechas[8] = this.labelFlecha9;       
            
       //Removendo da tela os no que não estão visiveis
       for(int i =2; i < this.listaDeNos.length; i++){
           this.listaDeNos[i].setVisible(false);
       }
       //Removendo manualmente a segunda flecha:
       this.flechas[1].setVisible(false);
       
       
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

        painelMenu = new javax.swing.JPanel();
        btnListaSeq = new javax.swing.JButton();
        btnLIstaSe = new javax.swing.JButton();
        btnListaDe = new javax.swing.JButton();
        btnPilha = new javax.swing.JButton();
        btnFila = new javax.swing.JButton();
        btnArvore = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        painelInserir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldValorInserir = new javax.swing.JTextField();
        fieldPosInserir = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        painelRemover = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldPosRemover = new javax.swing.JTextField();
        btnRemover = new javax.swing.JButton();
        painelBuscar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        fieldBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        comboBoxBuscar = new javax.swing.JComboBox<>();
        No1 = new javax.swing.JPanel();
        elemento1 = new javax.swing.JButton();
        ponteiro1 = new javax.swing.JButton();
        labelFlecha1 = new javax.swing.JLabel();
        No2 = new javax.swing.JPanel();
        elemento2 = new javax.swing.JButton();
        ponteiro2 = new javax.swing.JButton();
        labelFlecha2 = new javax.swing.JLabel();
        No3 = new javax.swing.JPanel();
        elemento3 = new javax.swing.JButton();
        ponteiro3 = new javax.swing.JButton();
        labelFlecha3 = new javax.swing.JLabel();
        No4 = new javax.swing.JPanel();
        elemento4 = new javax.swing.JButton();
        ponteiro4 = new javax.swing.JButton();
        labelFlecha4 = new javax.swing.JLabel();
        No5 = new javax.swing.JPanel();
        elemento5 = new javax.swing.JButton();
        ponteiro5 = new javax.swing.JButton();
        labelFlecha5 = new javax.swing.JLabel();
        No6 = new javax.swing.JPanel();
        elemento6 = new javax.swing.JButton();
        ponteiro6 = new javax.swing.JButton();
        labelFlecha6 = new javax.swing.JLabel();
        No7 = new javax.swing.JPanel();
        elemento7 = new javax.swing.JButton();
        ponteiro7 = new javax.swing.JButton();
        labelFlecha7 = new javax.swing.JLabel();
        No8 = new javax.swing.JPanel();
        elemento8 = new javax.swing.JButton();
        ponteiro8 = new javax.swing.JButton();
        labelFlecha8 = new javax.swing.JLabel();
        No9 = new javax.swing.JPanel();
        elemento9 = new javax.swing.JButton();
        ponteiro9 = new javax.swing.JButton();
        labelFlecha9 = new javax.swing.JLabel();
        No10 = new javax.swing.JPanel();
        elemento10 = new javax.swing.JButton();
        ponteiro10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        painelMenu.setBackground(new java.awt.Color(0, 255, 255));

        btnListaSeq.setBackground(new java.awt.Color(0, 255, 255));
        btnListaSeq.setText("Lista Seq");
        btnListaSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaSeqActionPerformed(evt);
            }
        });

        btnLIstaSe.setBackground(new java.awt.Color(0, 255, 255));
        btnLIstaSe.setText("Lista SE");
        btnLIstaSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIstaSeActionPerformed(evt);
            }
        });

        btnListaDe.setBackground(new java.awt.Color(0, 255, 255));
        btnListaDe.setText("Lista DE");
        btnListaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDeActionPerformed(evt);
            }
        });

        btnPilha.setBackground(new java.awt.Color(51, 255, 255));
        btnPilha.setText("Pilhas");
        btnPilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilhaActionPerformed(evt);
            }
        });

        btnFila.setBackground(new java.awt.Color(51, 255, 255));
        btnFila.setText("Filas");
        btnFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilaActionPerformed(evt);
            }
        });

        btnArvore.setBackground(new java.awt.Color(51, 255, 255));
        btnArvore.setText("Arvore");
        btnArvore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArvoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelMenuLayout = new javax.swing.GroupLayout(painelMenu);
        painelMenu.setLayout(painelMenuLayout);
        painelMenuLayout.setHorizontalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnListaSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLIstaSe, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPilha, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFila, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelMenuLayout.setVerticalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPilha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLIstaSe, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnListaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnListaSeq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnArvore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jInternalFrame1.setVisible(true);

        painelInserir.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Inserir:");

        jLabel4.setText("Valor:");

        jLabel5.setText("Posição:");

        btnInserir.setBackground(new java.awt.Color(0, 255, 255));
        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
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
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldValorInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(fieldPosInserir)))
                    .addGroup(painelInserirLayout.createSequentialGroup()
                        .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelInserirLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1))
                            .addGroup(painelInserirLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnInserir)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelInserirLayout.setVerticalGroup(
            painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInserirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldValorInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldPosInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnInserir)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        painelRemover.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Remover:");

        jLabel6.setText("Posição:");

        btnRemover.setBackground(new java.awt.Color(0, 255, 255));
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
                .addGroup(painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRemoverLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldPosRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                    .addGroup(painelRemoverLayout.createSequentialGroup()
                        .addGroup(painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelRemoverLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnRemover))
                            .addGroup(painelRemoverLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelRemoverLayout.setVerticalGroup(
            painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRemoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldPosRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addGap(16, 16, 16))
        );

        painelBuscar.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Buscar");

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
                .addGroup(painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelBuscarLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3))
                    .addGroup(painelBuscarLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnBuscar))
                    .addGroup(painelBuscarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fieldBuscar))
                    .addGroup(painelBuscarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboBoxBuscar, 0, 118, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        painelBuscarLayout.setVerticalGroup(
            painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(comboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(13, 13, 13))
        );

        elemento1.setBackground(new java.awt.Color(0, 255, 255));
        elemento1.setText("null");

        ponteiro1.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro1.setText("null");

        labelFlecha1.setText("------>");

        javax.swing.GroupLayout No1Layout = new javax.swing.GroupLayout(No1);
        No1.setLayout(No1Layout);
        No1Layout.setHorizontalGroup(
            No1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha1)
                .addContainerGap())
        );
        No1Layout.setVerticalGroup(
            No1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha1))
                .addGap(229, 229, 229))
        );

        elemento2.setBackground(new java.awt.Color(0, 255, 255));
        elemento2.setText("null");

        ponteiro2.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro2.setText("null");

        labelFlecha2.setText("------>");

        elemento3.setBackground(new java.awt.Color(0, 255, 255));
        elemento3.setText("null");

        ponteiro3.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro3.setText("null");

        labelFlecha3.setText("------>");

        javax.swing.GroupLayout No3Layout = new javax.swing.GroupLayout(No3);
        No3.setLayout(No3Layout);
        No3Layout.setHorizontalGroup(
            No3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha3)
                .addContainerGap())
        );
        No3Layout.setVerticalGroup(
            No3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha3))
                .addGap(229, 229, 229))
        );

        javax.swing.GroupLayout No2Layout = new javax.swing.GroupLayout(No2);
        No2.setLayout(No2Layout);
        No2Layout.setHorizontalGroup(
            No2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(No3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        No2Layout.setVerticalGroup(
            No2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha2))
                .addGap(229, 229, 229))
            .addComponent(No3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        elemento4.setBackground(new java.awt.Color(0, 255, 255));
        elemento4.setText("null");

        ponteiro4.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro4.setText("null");

        labelFlecha4.setText("------>");

        javax.swing.GroupLayout No4Layout = new javax.swing.GroupLayout(No4);
        No4.setLayout(No4Layout);
        No4Layout.setHorizontalGroup(
            No4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha4)
                .addContainerGap())
        );
        No4Layout.setVerticalGroup(
            No4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha4))
                .addGap(223, 223, 223))
        );

        elemento5.setBackground(new java.awt.Color(0, 255, 255));
        elemento5.setText("null");

        ponteiro5.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro5.setText("null");

        labelFlecha5.setText("------>");

        elemento6.setBackground(new java.awt.Color(0, 255, 255));
        elemento6.setText("null");

        ponteiro6.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro6.setText("null");

        labelFlecha6.setText("------>");

        javax.swing.GroupLayout No6Layout = new javax.swing.GroupLayout(No6);
        No6.setLayout(No6Layout);
        No6Layout.setHorizontalGroup(
            No6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha6)
                .addContainerGap())
        );
        No6Layout.setVerticalGroup(
            No6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha6))
                .addGap(223, 223, 223))
        );

        javax.swing.GroupLayout No5Layout = new javax.swing.GroupLayout(No5);
        No5.setLayout(No5Layout);
        No5Layout.setHorizontalGroup(
            No5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(No6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        No5Layout.setVerticalGroup(
            No5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha5))
                .addGap(223, 223, 223))
            .addComponent(No6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        elemento7.setBackground(new java.awt.Color(0, 255, 255));
        elemento7.setText("null");

        ponteiro7.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro7.setText("null");

        labelFlecha7.setText("------>");

        javax.swing.GroupLayout No7Layout = new javax.swing.GroupLayout(No7);
        No7.setLayout(No7Layout);
        No7Layout.setHorizontalGroup(
            No7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha7)
                .addContainerGap())
        );
        No7Layout.setVerticalGroup(
            No7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha7))
                .addGap(223, 223, 223))
        );

        elemento8.setBackground(new java.awt.Color(0, 255, 255));
        elemento8.setText("null");

        ponteiro8.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro8.setText("null");

        labelFlecha8.setText("------>");

        javax.swing.GroupLayout No8Layout = new javax.swing.GroupLayout(No8);
        No8.setLayout(No8Layout);
        No8Layout.setHorizontalGroup(
            No8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha8)
                .addContainerGap())
        );
        No8Layout.setVerticalGroup(
            No8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha8))
                .addGap(223, 223, 223))
        );

        elemento9.setBackground(new java.awt.Color(0, 255, 255));
        elemento9.setText("null");

        ponteiro9.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro9.setText("null");

        labelFlecha9.setText("------>");

        javax.swing.GroupLayout No9Layout = new javax.swing.GroupLayout(No9);
        No9.setLayout(No9Layout);
        No9Layout.setHorizontalGroup(
            No9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFlecha9)
                .addContainerGap())
        );
        No9Layout.setVerticalGroup(
            No9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFlecha9))
                .addGap(223, 223, 223))
        );

        elemento10.setBackground(new java.awt.Color(0, 255, 255));
        elemento10.setText("null");

        ponteiro10.setBackground(new java.awt.Color(0, 255, 255));
        ponteiro10.setText("null");

        javax.swing.GroupLayout No10Layout = new javax.swing.GroupLayout(No10);
        No10.setLayout(No10Layout);
        No10Layout.setHorizontalGroup(
            No10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(No10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elemento10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ponteiro10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        No10Layout.setVerticalGroup(
            No10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, No10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(No10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elemento10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ponteiro10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(223, 223, 223))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelInserir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(No1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(No2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(No4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(No5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(No7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(No8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(No9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(No10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(No1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(No2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(No10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(No9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(No8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(No7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(No5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(painelInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(No4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaSeqActionPerformed
        // TODO add your handling code here:
        FrameListaSeqTamanho frame = new FrameListaSeqTamanho();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnListaSeqActionPerformed

    private void btnListaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDeActionPerformed
        // TODO add your handling code here:
        FrameListaDe frame = new FrameListaDe();
        this.dispose();
        frame.setVisible(true);
     
    }//GEN-LAST:event_btnListaDeActionPerformed

    private void btnLIstaSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIstaSeActionPerformed
        // TODO add your handling code here:
        FrameListaSe frame = new FrameListaSe();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnLIstaSeActionPerformed

// Implementação das operações da lista
    
    //Inserção:
    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        int valor;
        int pos;
        
        try{
            valor = Integer.parseInt(this.fieldValorInserir.getText());
            pos = Integer.parseInt(this.fieldPosInserir.getText());
            if(this.lista.insere(pos, valor) && this.tamanhoDaLista <10){
                if( tamanhoDaLista >= 1 && tamanhoDaLista < 10 ){
                    for(int i=0; i < tamanhoDaLista+1; i++){
                        this.listaDeNos[i].setVisible(true);
                        if(i < 9){
                            this.flechas[i].setVisible(true);
                        }
                    }
                    if(tamanhoDaLista+1 < 10){
                        this.listaDeNos[tamanhoDaLista+1].setVisible(true);
                    }
                    if(tamanhoDaLista+1 < 9 ){
                         this.flechas[tamanhoDaLista+1].setVisible(false);
                    }
                    
                    
                }
                
                this.tamanhoDaLista++;
                //percorre todos os elementos que foram preenchidos
                //Atualizando seus valores para o valor atual da lista
                for(int i =0; i <this.tamanhoDaLista; i++){
                    this.listaDeElementos[0][i].setText(
                           String.valueOf(this.lista.elemento(i+1))
                    );
                    if(this.tamanhoDaLista >=2){
                        this.listaDeElementos[1][i].setText("prox");
                    }
                }
                
            }else{
                if(this.tamanhoDaLista ==10){
                    JOptionPane.showMessageDialog(null, "Lista Cheia", "Erro", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possivel inserir o valor nesta posição\nInforme apenas posições validas", "Erro", JOptionPane.ERROR_MESSAGE);

                }
            }
           
            
        }catch( NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnInserirActionPerformed

    
    //Remoção:
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try{
            if(this.tamanhoDaLista > 0){    
                int pos = Integer.parseInt(this.fieldPosRemover.getText());
                int intemRemovido = this.lista.remove(pos);
                this.tamanhoDaLista--;
                if(tamanhoDaLista ==0){
                    //Removendo da tela os no que não estão visiveis
                    for(int i =2; i < this.listaDeNos.length; i++){
                        this.listaDeNos[i].setVisible(false);
                    }
                    //Removendo manualmente a segunda flecha:
                    this.flechas[1].setVisible(false);
                    this.listaDeElementos[0][0].setText("null");
                    this.listaDeElementos[1][0].setText("null");

                }else{
                    for(int i=0; i < this.listaDeNos.length; i++){
                        this.listaDeNos[i].setVisible(false);
                    }
                    for(int i=0; i < this.tamanhoDaLista; i++){
                        this.listaDeElementos[0][i].setText(String.valueOf(this.lista.elemento(i+1)));
                        this.listaDeElementos[1][i].setText("prox");
                        this.listaDeNos[i].setVisible(true);
                    }
                    this.listaDeElementos[0][this.tamanhoDaLista].setText("null");
                    this.listaDeElementos[1][this.tamanhoDaLista].setText("null");
                    this.listaDeNos[this.tamanhoDaLista].setVisible(true);
                    if(this.tamanhoDaLista <this.flechas.length){
                        this.flechas[this.tamanhoDaLista].setVisible(false);
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

    private void btnPilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilhaActionPerformed
        FramePilha frame = new FramePilha();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnPilhaActionPerformed

    private void btnFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilaActionPerformed
        FrameFila frame = new FrameFila();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnFilaActionPerformed

    private void btnArvoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArvoreActionPerformed
        FrameArvore frame = new FrameArvore();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnArvoreActionPerformed
     
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel No1;
    private javax.swing.JPanel No10;
    private javax.swing.JPanel No2;
    private javax.swing.JPanel No3;
    private javax.swing.JPanel No4;
    private javax.swing.JPanel No5;
    private javax.swing.JPanel No6;
    private javax.swing.JPanel No7;
    private javax.swing.JPanel No8;
    private javax.swing.JPanel No9;
    private javax.swing.JButton btnArvore;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFila;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLIstaSe;
    private javax.swing.JButton btnListaDe;
    private javax.swing.JButton btnListaSeq;
    private javax.swing.JButton btnPilha;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> comboBoxBuscar;
    private javax.swing.JButton elemento1;
    private javax.swing.JButton elemento10;
    private javax.swing.JButton elemento2;
    private javax.swing.JButton elemento3;
    private javax.swing.JButton elemento4;
    private javax.swing.JButton elemento5;
    private javax.swing.JButton elemento6;
    private javax.swing.JButton elemento7;
    private javax.swing.JButton elemento8;
    private javax.swing.JButton elemento9;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JTextField fieldPosInserir;
    private javax.swing.JTextField fieldPosRemover;
    private javax.swing.JTextField fieldValorInserir;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelFlecha1;
    private javax.swing.JLabel labelFlecha2;
    private javax.swing.JLabel labelFlecha3;
    private javax.swing.JLabel labelFlecha4;
    private javax.swing.JLabel labelFlecha5;
    private javax.swing.JLabel labelFlecha6;
    private javax.swing.JLabel labelFlecha7;
    private javax.swing.JLabel labelFlecha8;
    private javax.swing.JLabel labelFlecha9;
    private javax.swing.JPanel painelBuscar;
    private javax.swing.JPanel painelInserir;
    private javax.swing.JPanel painelMenu;
    private javax.swing.JPanel painelRemover;
    private javax.swing.JButton ponteiro1;
    private javax.swing.JButton ponteiro10;
    private javax.swing.JButton ponteiro2;
    private javax.swing.JButton ponteiro3;
    private javax.swing.JButton ponteiro4;
    private javax.swing.JButton ponteiro5;
    private javax.swing.JButton ponteiro6;
    private javax.swing.JButton ponteiro7;
    private javax.swing.JButton ponteiro8;
    private javax.swing.JButton ponteiro9;
    // End of variables declaration//GEN-END:variables
}
