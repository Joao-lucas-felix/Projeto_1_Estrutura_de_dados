package com.joaolucas.projetoestruturadedados;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author joao
 */
public class FrameListaSequencial extends javax.swing.JFrame {
    
    //Declaração da clase ListaSeq disponibilizada pelo professor com algumas modificações 
    
    private class ListaSeq {
	private int dados[]; // Vetor que contém os dados da lista 
	private int nElementos; 
    
    public ListaSeq(){
    		nElementos = 0;
    		dados = new int[10];
    }
    
    public ListaSeq(int tamMax){
    		nElementos = 0;
			dados = new int[tamMax];
    }

    /** Verifica se a Lista está vazia */
    public boolean vazia(){
	if (nElementos == 0 )
            return true;
	else
            return false;
    }
	
    /**Verifica se a Lista está cheia */
    public boolean cheia(){
	if (nElementos == dados.length)
            return true;
	else
            return false;
	}
	
    /**Obtém o tamanho da Lista*/
    public int tamanho(){
	return nElementos;
    }
    
    /** Obtém o i-ésimo elemento de uma lista.
    		Retorna -1 se a posição for inválida. */
    public int elemento(int pos){
        
    	/* Se posição estiver fora dos limites <= 0 
         * ou > tamanho da lista */
        if ((pos > nElementos) || (pos <= 0))
            throw new IllegalAccessError();

       return dados[pos-1];
	}

    /**	Retorna a posição de um elemento pesquisado.
    		Retorna -1 caso não seja encontrado */
	public int posicao (int valor){
	    /* Procura elemento a elemento, se o dado está na
	    	lista. Se estiver, retorna a sua posição no array+1 */
	    for (int i = 0; i < nElementos; i++){
	        if (dados[i] == valor){
	            return (i + 1);
	        }
	    }

	    throw new InternalError();
	}
	
	/**	Retorna a posição de um elemento pesquisado.
	Retorna -1 caso não seja encontrado */
	public int posicao (int valor, int desloc){
		/* Procura elemento a elemento, se o dado está na
		lista. Se estiver, retorna a sua posição no array+1 */
		for (int i = desloc; i < nElementos; i++){
		    if (dados[i] == valor){
		        return (i + 1);
		    }
		}
		return -1;
	}
	
	/**Insere um elemento em uma determinada posição
    		Retorna false se a lista estiver cheia ou
    		a posição for inválida. Caso contrário retorna true */
	public boolean insere (int pos, int valor){
	    /* Verifica se a lista está cheia ou se a posicao a ser
	    inserida eh invalida (i.e., > tamanho da lista+1*/
	    if (cheia() || (pos > nElementos+1) || (pos <=0)){
	        return false;
	    }

	    /* Desloca os elementos após pos, uma posicao a
	    direita. Isso serve para abrir espaço para insercao
	    do novo elemento */
	    for (int i = nElementos; i >= pos; i--){
	 		 dados[i] = dados[i-1];
	    }

	    /* Insere o dado na posicao correta */
	    dados[pos - 1] = valor;

	 	/* Incrementa o numero de elementos na lista */
	    nElementos++;
	    return true;
	}
	
	/**Remove um elemento de uma determinada posição
    Retorna o valor do elemento removido. -1 caso a remoção falhe  */
	public int remove(int pos){
	    /* Verifica se a posicao eh valida */
	    if ((pos > nElementos) || (pos < 1 ))
		throw new IllegalAccessError();

	    /* Armazena o dado a ser removido na var "dado" */
	    int aux = dados[pos-1];

	    /* Desloca todos os elementos após 'pos', uma
	    posicao a esquerda */
	    for (int i = pos - 1; i < nElementos - 1; i++){
	 		  dados[i] = dados[i+1];
		 }

	   /* Decrementa o numero de elementos na lista */
	    nElementos--;
	    return aux;
	}
    }



    
    //Variaveis:
    private final JButton[] listaDeElementos;
    private int tamanhoDaLista;
    private ListaSeq lista;
    
    /**
     * Creates new form FrameListaSequencial
     */
    public FrameListaSequencial(int tamanho) {
        this.tamanhoDaLista =0;
        this.lista = new ListaSeq(tamanho);
        initComponents();
        
        //Orgaizandos os elementos graficos que representão os elementos da lista em um array:
        this.listaDeElementos = new JButton[10];
        this.listaDeElementos[0] = elemento1;
        this.listaDeElementos[1] = elemento2;
        this.listaDeElementos[2] = elemento3;
        this.listaDeElementos[3] = elemento4;
        this.listaDeElementos[4] = elemento5;
        this.listaDeElementos[5] = elemento6;
        this.listaDeElementos[6] = elemento7;
        this.listaDeElementos[7] = elemento8;
        this.listaDeElementos[8] = elemento9;
        this.listaDeElementos[9] = elemento10;
        
        
        //Removendo do frame os elementos que não devem ser exibidos:
        for(int i=0; i < this.listaDeElementos.length; i++){
            if(i >= tamanho){
                this.listaDeElementos[i].setVisible(false);
            }
        }
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
        elemento1 = new javax.swing.JButton();
        elemento3 = new javax.swing.JButton();
        elemento2 = new javax.swing.JButton();
        elemento5 = new javax.swing.JButton();
        elemento4 = new javax.swing.JButton();
        elemento6 = new javax.swing.JButton();
        elemento7 = new javax.swing.JButton();
        elemento8 = new javax.swing.JButton();
        elemento9 = new javax.swing.JButton();
        elemento10 = new javax.swing.JButton();
        painelnserir = new java.awt.Panel();
        lblInserir = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        fieldValorInserir = new javax.swing.JTextField();
        lblPos = new javax.swing.JLabel();
        fieldPosInserir = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        painelRemover = new javax.swing.JPanel();
        lblRemover = new javax.swing.JLabel();
        lblPos2 = new javax.swing.JLabel();
        fieldPosRemover = new javax.swing.JTextField();
        btnRemover = new javax.swing.JButton();
        painelBuscar = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        fieldBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        comboBoxBuscar = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnListaSeq = new javax.swing.JButton();
        btnListaSe = new javax.swing.JButton();
        btnListaDe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jInternalFrame1.setVisible(true);

        elemento1.setBackground(new java.awt.Color(0, 255, 255));
        elemento1.setText("null");

        elemento3.setBackground(new java.awt.Color(0, 255, 255));
        elemento3.setText("null");

        elemento2.setBackground(new java.awt.Color(0, 255, 255));
        elemento2.setText("null");

        elemento5.setBackground(new java.awt.Color(0, 255, 255));
        elemento5.setText("null");

        elemento4.setBackground(new java.awt.Color(0, 255, 255));
        elemento4.setText("null");

        elemento6.setBackground(new java.awt.Color(0, 255, 255));
        elemento6.setText("null");

        elemento7.setBackground(new java.awt.Color(0, 255, 255));
        elemento7.setText("null");

        elemento8.setBackground(new java.awt.Color(0, 255, 255));
        elemento8.setText("null");

        elemento9.setBackground(new java.awt.Color(0, 255, 255));
        elemento9.setText("null");

        elemento10.setBackground(new java.awt.Color(0, 255, 255));
        elemento10.setText("null");

        painelnserir.setBackground(new java.awt.Color(204, 204, 204));

        lblInserir.setText("Inserir:");

        lblValor.setText("Valor:");

        lblPos.setText("Posição:");

        btnInserir.setBackground(new java.awt.Color(0, 255, 255));
        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelnserirLayout = new javax.swing.GroupLayout(painelnserir);
        painelnserir.setLayout(painelnserirLayout);
        painelnserirLayout.setHorizontalGroup(
            painelnserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelnserirLayout.createSequentialGroup()
                .addGroup(painelnserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelnserirLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnInserir))
                    .addGroup(painelnserirLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelnserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPos)
                            .addComponent(lblValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelnserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldValorInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(fieldPosInserir)))
                    .addGroup(painelnserirLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblInserir)))
                .addContainerGap())
        );
        painelnserirLayout.setVerticalGroup(
            painelnserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelnserirLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(lblInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelnserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldValorInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelnserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPos)
                    .addComponent(fieldPosInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnInserir)
                .addContainerGap())
        );

        painelRemover.setBackground(new java.awt.Color(204, 204, 204));

        lblRemover.setText("Remover:");

        lblPos2.setText("Posição:");

        btnRemover.setBackground(new java.awt.Color(0, 255, 255));
        btnRemover.setText("remover");
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
                .addComponent(lblPos2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPosRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRemoverLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addGap(27, 27, 27))
            .addGroup(painelRemoverLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelRemoverLayout.setVerticalGroup(
            painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRemoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRemover)
                .addGap(29, 29, 29)
                .addGroup(painelRemoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPos2)
                    .addComponent(fieldPosRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addContainerGap())
        );

        painelBuscar.setBackground(new java.awt.Color(204, 204, 204));

        lblBuscar.setText("Buscar:");

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
                .addGroup(painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBuscarLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnBuscar))
                    .addGroup(painelBuscarLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelBuscarLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelBuscarLayout.setVerticalGroup(
            painelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painelRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelnserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(elemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(painelnserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(painelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(elemento5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elemento4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elemento3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elemento2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elemento6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elemento7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elemento8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elemento9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(elemento10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(216, Short.MAX_VALUE))))
        );

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        btnListaSeq.setBackground(new java.awt.Color(0, 255, 255));
        btnListaSeq.setText("Lista Seq");
        btnListaSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaSeqActionPerformed(evt);
            }
        });

        btnListaSe.setBackground(new java.awt.Color(0, 255, 255));
        btnListaSe.setText("Lista SE");
        btnListaSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaSeActionPerformed(evt);
            }
        });

        btnListaDe.setBackground(new java.awt.Color(0, 255, 255));
        btnListaDe.setText("Lista DE");
        btnListaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListaSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaSe, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(446, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListaDe, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(btnListaSeq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaSe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Botões de navegação pelo sistema
    private void btnListaSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaSeqActionPerformed
        FrameListaSeqTamanho frameListaSeqTamanho = new FrameListaSeqTamanho();
        this.dispose();
        frameListaSeqTamanho.setVisible(true);
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
    





//Botão de inserir:
    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        int valor;
        int pos;
        
        try{
            valor = Integer.parseInt(this.fieldValorInserir.getText());
            pos = Integer.parseInt(this.fieldPosInserir.getText());
            if(this.lista.insere(pos, valor)){
                
                this.tamanhoDaLista++;
                //percorre todos os elementos que foram preenchidos
                //Atualizando seus valores para o valor atual da lista
                for(int i =0; i <this.tamanhoDaLista; i++){
                    this.listaDeElementos[i].setText(
                           String.valueOf(this.lista.elemento(i+1))
                    );
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
    



    //Botão de remover
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int pos;
        try{
            if(this.tamanhoDaLista >0){
                pos = Integer.parseInt(this.fieldPosRemover.getText());
                this.lista.remove(pos);    
                this.tamanhoDaLista--;
                    //percorre todos os elementos que foram preenchidos
                    //Atualizando seus valores para o valor atual da lista
                for(int i = 0; i <this.listaDeElementos.length; i++){
                    this.listaDeElementos[i].setText("null");
                }

                for(int i =0; i <this.tamanhoDaLista; i++){
                    this.listaDeElementos[i].setText(
                     String.valueOf(this.lista.elemento(i+1))
                        );

                }
            }else{
                JOptionPane.showMessageDialog(null, "Lista vazia", "Erro", JOptionPane.ERROR_MESSAGE);              
            }

        }catch( NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
        }catch( IllegalAccessError e){
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
          }catch(InternalError e ){
              JOptionPane.showMessageDialog(null, "Elemento não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
          }
       }
    }//GEN-LAST:event_btnBuscarActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnListaDe;
    private javax.swing.JButton btnListaSe;
    private javax.swing.JButton btnListaSeq;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblInserir;
    private javax.swing.JLabel lblPos;
    private javax.swing.JLabel lblPos2;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel painelBuscar;
    private javax.swing.JPanel painelRemover;
    private java.awt.Panel painelnserir;
    // End of variables declaration//GEN-END:variables
}
