/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.joaolucas.projetoestruturadedados;

import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;

/**
 *
 * @author joao
 */
public class FrameArvore extends javax.swing.JFrame {
    
    //Implementação de Nos da arvore visual:
    public class No {
	JButton elemento;
        No esq;
        No dir;
        JSeparator separadorDosFilhos;

	
	public No(){
		esq = null;
		dir = null;
	}
	
	public JButton getConteudo() {
		return elemento;
	}
	
	public void setConteudo(JButton elemento) {
		this.elemento = elemento;
	}
	
	public No getEsq() {
		return esq;
	}
	
	public void setEsq(No esq) {
		this.esq = esq;
	}
	
	public No getDir() {
		return dir;
	}
	
	public void setDir(No dir) {
		this.dir = dir;
	}
    }
    public class NoInt {
            private int conteudo;
            private NoInt esq;
            private NoInt dir;

            public NoInt(){
                    esq = null;
                    dir = null;
            }

            public int getConteudo() {
                    return conteudo;
            }

            public void setConteudo(int conteudo) {
                    this.conteudo = conteudo;
            }

            public NoInt getEsq() {
                    return esq;
            }

            public void setEsq(NoInt esq) {
                    this.esq = esq;
            }

            public NoInt getDir() {
                    return dir;
            }

            public void setDir(NoInt dir) {
                    this.dir = dir;
            }
    }
    //Criando Uma arvoreBinaria para a arvore Visual:
    public class ArvBinDeBtn {
	private No raiz;

	public ArvBinDeBtn(){
            raiz = null;
	}
	
	/** Verifica se a árvore está vazia */
	public boolean vazia (){
		return (raiz == null);
	}

	/** Funcao de busca recursiva.
		Retorna o endereço do elemento se ele for encontrado.
		Caso contrario, retorna null*/
	private No busca(No T, JButton valor) {          
		// Condicao de parada
		if (T == null) 
			return null;  // Arvore Vazia

		// Condicao de parada
		if(T.getConteudo() == valor) { 
			return T; //Elem. encontrado na raiz
		}
		
		// Caso recursivo
		No aux = busca(T.getEsq(), valor);
		if (aux == null) { 
			aux = busca(T.getDir(), valor);
		}
		return aux;
	}
	
	/** Buscar um elemento na árvore
		Retorna o endereço se o elemento for encontrado, 
		Caso contrário retorna NULL*/
	public No busca(JButton valor) {          
		if (vazia())
			return null;
		
		//No res = busca(raiz, valor);
		//return res;
		return busca(raiz, valor);
	}
	
	
	/** Insere um nó raiz em uma árvore vazia 
	 	Retorna true se a inserção for com sucesso.
		Caso contrário, retorna false */   
	public boolean insereRaiz(JButton valor) {   
		if (raiz != null) 
			return false;  //Erro: Arvore não está vazia

		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setEsq(null);
		novoNo.setDir(null);
		
		raiz = novoNo;
		return true;
	}   

	/** Insere um filho à direita de um dado nó.
    		Retorna true se a inserção for com sucesso,
    		Caso contrário false  */
	public boolean insereDir(JButton vPai, JButton vFilho ) {
		
		// Verifica se o elemento já existe
		No filho = busca(vFilho);
		if (filho != null)
	        return false;  // Err: dado já existe
	
		// Busca o pai e verifica se possui filho direito
		No pai = busca(vPai);
	  	if (pai == null)
			return false;  // Err: pai não encontrado
		
	  	if (pai.getDir() != null)
			return false;  // Err: filho dir já existe
	
		No novoNo = new No();
		novoNo.setConteudo(vFilho);
		novoNo.setEsq(null);
		novoNo.setDir(null);
		
		pai.setDir(novoNo);
		
		return true;
	}

	/** Insere um filho à esquerda de um dado nó.
		Retorna true se a inserção for com sucesso,
		Caso contrário false  */
	public boolean insereEsq(JButton vPai, JButton vFilho ) {
		
		// Verifica se o elemento já existe 
		No filho = busca(vFilho);
		if (filho != null)
	        return false;  // Err: dado já existe
	
		// Busca o pai e verifica se possui filho da esq
		No pai = busca(vPai);
	  	if (pai == null)
			return false; // Err: pai não encontrado
	  	
		if (pai.getEsq() != null)
			return false; // Err: filho esq já existe
	
		No novoNo = new No();
		novoNo.setConteudo(vFilho);
		novoNo.setEsq(null);
		novoNo.setDir(null);
		
		pai.setEsq(novoNo);
		return true;
        }
        public No getNoRaiz(){
            return this.raiz;
        }
    }
    
    public class ABP {
            private NoInt raiz;
            public ABP(){
                raiz = null;
            }
            /** Verifica se a árvore está vazia */
            public boolean vazia (){
                    return (raiz == null);
            }

            /**Buscar recursivamente a partir da raiz.
                Retorna o endereço se o elemento for
                encontrado, caso contrário retorna NULL*/
            private NoInt busca(NoInt T, int valor) {
                    if (T == null)
                            return null;  // Arvore Vazia

                    if(T.getConteudo() == valor)
                            return T; 	// Elem. encontrado na raiz

                    if (valor < T.getConteudo())
                            return busca(T.getEsq(), valor);
                else
                            return busca(T.getDir(), valor);
            }

            /**Buscar um elemento na ABP
                    Retorna o endereço se o elemento for
                    encontrado, caso contrário retorna NULL*/
            public NoInt busca(int valor) {          
                    if (raiz != null) 
                            return busca(raiz, valor);

                    return null;
            }

            public NoInt buscaIterativa(int valor) {          
                    if (vazia())
                            return null;

                    NoInt aux = raiz;
                    while (aux != null) {
                            // Verificando se o conteudo do no atual 
                            // é igual ao valor procurado
                            if (aux.getConteudo() == valor) {
                                    return aux;
                            }

                            // Se o valor procurado for menor que raiz,
                            // continue pesquisando na sub-arv da esq.
                            if (valor < aux.getConteudo()){
                                    aux = aux.getEsq();
                            }
                            // Caso contratio, pesquise na sub-arv 
                            // da direita
                            else {
                                    aux = aux.getDir();
                            }
                    }

                    return null;
            }


            /**Exibe o conteúdo de uma árvore no formato in-ordem
                (preserva a ordenação)*/
            private void exibe (NoInt T, StringBuilder s){
                    if (T != null) {
                            exibe(T.getEsq(), s);
                            s.append(T.getConteudo()+" ");
                            exibe(T.getDir(),s);
                    }
            }

            public void exibe(StringBuilder s) {
                    if (raiz == null)
                        throw new InternalError();
                    else
                            exibe(raiz, s);
            }
            private void exibePre (NoInt T, StringBuilder s){
                    if (T != null) {
                            s.append(T.getConteudo()+" ");
                            exibe(T.getEsq(), s);
                            exibe(T.getDir(),s);
                    }
            }

            public void exibePre(StringBuilder s) {
                    if (raiz == null)
                        throw new InternalError();
                    else
                            exibePre(raiz, s);
            }
            private void exibePos (NoInt T, StringBuilder s){
                    if (T != null) {
                            
                            exibe(T.getEsq(), s);
                            exibe(T.getDir(),s);
                            s.append(T.getConteudo()+" ");
                    }
            }

            public void exibePos(StringBuilder s) {
                    if (raiz == null)
                        throw new InternalError();
                    else
                            exibePos(raiz, s);
            }

            /**Exibe o conteúdo de uma árvore no formato in-ordem
                (preserva a ordenação)*/
            private void exibeDec(NoInt T){
                    if (T != null) {
                            exibeDec(T.getDir());
                            System.out.print(" " + T.getConteudo());
                            exibeDec(T.getEsq());
                    }
            }

            public void exibeDec() {
                    if (raiz == null)
                            System.out.println("Arvore vazia");
                    else
                            exibeDec(raiz);
            }

            /**Insere um nó em uma árvore ABP
                Retorna 1 se a inserção for com sucesso.
                Caso contrário retorna 0*/
            public boolean insere(int valor, ArvBinDeBtn arvoreVisual){

                NoInt novoNo = new NoInt();
                novoNo.setConteudo(valor);
                novoNo.setEsq(null);
                novoNo.setDir(null);

                // Quando a arvore estiver vazia, o novoNó será a raiz da arv
                if (raiz == null){ 
                        raiz = novoNo;
                        arvoreVisual.getNoRaiz().elemento.setText(String.valueOf(valor));
                        return true;
                }

                // Procura a posicao correta pra inserir o novo no
                NoInt aux = raiz;
                NoInt p = null;
                No auxVisual = arvoreVisual.getNoRaiz();
                while (aux != null) {
                    p = aux;
               
                    // Se valor inserido for igual a um existente 
                    //na arvore, nao insira.
                    if (valor == aux.getConteudo())
                        return false;
                    
                    if (valor < aux.getConteudo()){
                        if(auxVisual.esq != null && aux != null){
                            auxVisual = auxVisual.getEsq();
                        }else{
                            throw new InternalError();
                        }
                        aux = aux.getEsq();

                    }else{
                        if(auxVisual.dir != null && aux != null){
                            auxVisual = auxVisual.getDir();
                        }else{
                            throw new InternalError();
                        }
                        aux = aux.getDir();
                        
                    }
                }

                // Encontrou um nó folha para inserir
                if (valor < p.getConteudo()){
                        p.setEsq(novoNo);
                        auxVisual.elemento.setText(String.valueOf(novoNo.getConteudo()));
                        if(auxVisual.esq != null){
                            auxVisual.esq.elemento.setVisible(true);
                            auxVisual.dir.elemento.setVisible(true);
                            auxVisual.separadorDosFilhos.setVisible(true);

                        }
//                        auxVisual.elemento.setVisible(true);

                }else{
                        p.setDir(novoNo);
                        auxVisual.elemento.setText(String.valueOf(novoNo.getConteudo()));
                        if(auxVisual.esq != null){
                            auxVisual.esq.elemento.setVisible(true);
                            auxVisual.dir.elemento.setVisible(true);
                            auxVisual.separadorDosFilhos.setVisible(true);

                        }
//                        auxVisual.elemento.setVisible(true);
                }
                return true;

          }


            private Integer sucessor( NoInt T){
                if(T.getEsq() != null) {
                    return sucessor(T.getEsq());
                }
                return T.getConteudo();
            }

            private NoInt remove(NoInt T, int valor) {

                    if(T == null) 
                            return T;

                    if(valor < T.getConteudo()) {
                            T.setEsq(remove(T.getEsq(), valor));
                    } else if(valor > T.getConteudo()) {
                            T.setDir(remove(T.getDir(), valor));
                    } else {
                                // Caso 1: Nó é uma folha (não tem filhos)
                        if(T.getEsq() == null && T.getDir() == null) {
                                        return null;
                        } else if(T.getEsq() == null) {
                                // Caso 2: Nó só tem o filho da esquerda
                                return T.getDir();
                        } else if(T.getDir() == null) {
                                // Caso 3: Nó só tem o filho da direita
                                return T.getEsq();
                        } else {
                                // Caso 3: Nó tem 2 filhos
                                // Procura o sucessor (valor mais próximo na sub-arv da direita
                                Integer minValue = sucessor(T.getDir());
                                T.setConteudo(minValue);
                                T.setDir(remove(T.getDir(), minValue));
                        }
                    }
                    return T;
            }

            /** Remove o nó com um dado valor e retorna a nova raiz */
        public void remove(Integer valor) {
                remove(raiz, valor);
        }
        
        public NoInt getRaiz(){
            return this.raiz;
        }

    }
        

    private final JButton[] listaDeelementos;
    private ArvBinDeBtn arvoreDeBtns;
    private ABP arvoreBinaria;
    private JSeparator[] listaDeSeparadores;
    public FrameArvore() {
        initComponents();
        this.listaDeelementos = new JButton[15];
        this.arvoreDeBtns = new ArvBinDeBtn();
        this.arvoreBinaria = new ABP();
        this.listaDeSeparadores = new JSeparator[7];

        //Construindo uma arvore na Mão
        // organizando como nós e seus filhos:
        
        //Criando a raiz:
        this.arvoreDeBtns.insereRaiz(this.elemento1);
        this.arvoreDeBtns.insereEsq(this.elemento1, this.elemento2);
        this.arvoreDeBtns.insereDir(this.elemento1, this.elemento3);
        this.arvoreDeBtns.busca(this.elemento1).separadorDosFilhos = this.separador1;//Separador dos filhos do no raiz

;
        
        
        //Criando a arovre da esquerda:
        //camada1: (abaixo da raiz)
        this.arvoreDeBtns.insereEsq(this.elemento2, this.elemento4);
        this.arvoreDeBtns.insereDir(this.elemento2,this.elemento5);
        this.arvoreDeBtns.busca(this.elemento2).separadorDosFilhos = this.separador2;//Separador dos filhos do no raiz

        
        this.arvoreDeBtns.busca(this.elemento4).separadorDosFilhos = this.separador5;//Separador dos filhos do no raiz

        this.arvoreDeBtns.busca(this.elemento5).separadorDosFilhos = this.separador7;//Separador dos filhos do no raiz

        
        //camada 2: (abaixo da raiz)
        this.arvoreDeBtns.insereEsq(this.elemento4, this.elemento8);
        this.arvoreDeBtns.insereDir(this.elemento4,this.elemento9);
        this.arvoreDeBtns.insereEsq(this.elemento5, this.elemento10);
        this.arvoreDeBtns.insereDir(this.elemento5,this.elemento11);
        //---------Não tem filhos
        
        //Criando a arvore da direita:
        //Camada 1: (abaixo da raiz)
        this.arvoreDeBtns.insereEsq(this.elemento3, this.elemento6);
        this.arvoreDeBtns.insereDir(this.elemento3,this.elemento7);
        this.arvoreDeBtns.busca(this.elemento3).separadorDosFilhos = this.separador4;//Separador dos filhos do no raiz


        
        //Camada 2: 
        this.arvoreDeBtns.insereEsq(this.elemento6, this.elemento12);
        this.arvoreDeBtns.insereDir(this.elemento6,this.elemento13);
        this.arvoreDeBtns.insereEsq(this.elemento7, this.elemento14);
        this.arvoreDeBtns.insereDir(this.elemento7,this.elemento15);
        
        
        this.arvoreDeBtns.busca(this.elemento6).separadorDosFilhos = this.separador9;//Separador dos filhos do no raiz

        
        this.arvoreDeBtns.busca(this.elemento7).separadorDosFilhos = this.separador11;//Separador dos filhos do no raiz


        
        this.listaDeelementos[0] = elemento1;
        this.listaDeelementos[1] = elemento2;
        this.listaDeelementos[2] = elemento3;
        this.listaDeelementos[3] = elemento4;
        this.listaDeelementos[4] = elemento5;
        this.listaDeelementos[5] = elemento6;
        this.listaDeelementos[6] = elemento7;
        this.listaDeelementos[7] = elemento8;
        this.listaDeelementos[8] = elemento9;
        this.listaDeelementos[9] = elemento10;
        this.listaDeelementos[10] = elemento11;
        this.listaDeelementos[11] = elemento12;
        this.listaDeelementos[12] = elemento13;
        this.listaDeelementos[13] = elemento14;
        this.listaDeelementos[14] = elemento15;
        
        this.listaDeSeparadores[0] = separador1;
        this.listaDeSeparadores[1] = separador2;
        this.listaDeSeparadores[2] = separador4;
        this.listaDeSeparadores[3] = separador5;
        this.listaDeSeparadores[4] = separador7;
        this.listaDeSeparadores[5] = separador9;
        this.listaDeSeparadores[6] = separador11;

        
       for(int i =0; i < this.listaDeelementos.length; i ++){
              this.listaDeelementos[i].setVisible(false);
        }
        for(int i =0; i <this.listaDeSeparadores.length; i ++){
            this.listaDeSeparadores[i].setVisible(false);
        }
        this.paintTree(arvoreBinaria, arvoreDeBtns);

}
    
 
    private void paintTree(ABP arvoreDePesquisa, ArvBinDeBtn arvoreVisual){
        NoInt auxAbp = arvoreDePesquisa.getRaiz();
        No auxVisual = arvoreVisual.getNoRaiz();
        if (auxAbp == null){
            auxVisual.elemento.setText("null");
            auxVisual.esq.elemento.setText("null");
            auxVisual.dir.elemento.setText("null");
            auxVisual.elemento.setVisible(true);
            auxVisual.esq.elemento.setVisible(true);
            auxVisual.dir.elemento.setVisible(true);
            auxVisual.separadorDosFilhos.setVisible(true);
        }else{
            for(int i=0; i < this.listaDeelementos.length; i++){
                this.listaDeelementos[i].setText("null");
                this.listaDeelementos[i].setVisible(false);

            }
            for(int i=1; i< this.listaDeSeparadores.length; i++){
                this.listaDeSeparadores[i].setVisible(false);
            }
            exibe(auxVisual, auxAbp);
        }  
    }
    private void exibe(No visual, NoInt noDarvore){
        if(visual != null ){
            if(noDarvore != null){
                exibe(visual.getEsq(), noDarvore.getEsq());
                visual.elemento.setText(String.valueOf(noDarvore.conteudo));
                visual.elemento.setVisible(true);
                visual.dir.elemento.setVisible(true);
                visual.esq.elemento.setVisible(true);
                visual.separadorDosFilhos.setVisible(true);
                exibe(visual.getDir(), noDarvore.getDir());
            }
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        painelMenu = new javax.swing.JPanel();
        btnListaSeq = new javax.swing.JButton();
        btnListaSe = new javax.swing.JButton();
        btnListaDe = new javax.swing.JButton();
        btnPilhas = new javax.swing.JButton();
        btnFilas = new javax.swing.JButton();
        btnArvore = new javax.swing.JButton();
        frameInterno = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxCaminhamento = new javax.swing.JComboBox<>();
        btnCaminhamento = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblRemover = new javax.swing.JLabel();
        fieldRemover = new javax.swing.JTextField();
        btnRemover = new javax.swing.JButton();
        painelInserir = new javax.swing.JPanel();
        fieldInserir = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        lblInserir = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        separador2 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        separador5 = new javax.swing.JSeparator();
        jPanel15 = new javax.swing.JPanel();
        elemento8 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        elemento9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        separador6 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        separador7 = new javax.swing.JSeparator();
        elemento10 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        elemento11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        elemento4 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        elemento5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        separador9 = new javax.swing.JSeparator();
        elemento13 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        elemento12 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        separador10 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        separador11 = new javax.swing.JSeparator();
        jPanel17 = new javax.swing.JPanel();
        elemento15 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        elemento14 = new javax.swing.JButton();
        separador4 = new javax.swing.JSeparator();
        jPanel28 = new javax.swing.JPanel();
        elemento6 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        elemento7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        elemento1 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        separador1 = new javax.swing.JSeparator();
        jPanel20 = new javax.swing.JPanel();
        elemento2 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        elemento3 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        painelMenu.setBackground(new java.awt.Color(0, 255, 255));

        btnListaSeq.setBackground(new java.awt.Color(0, 255, 255));
        btnListaSeq.setText("Lista Sequencial");
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

        btnPilhas.setBackground(new java.awt.Color(0, 255, 255));
        btnPilhas.setText("Pilhas");
        btnPilhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilhasActionPerformed(evt);
            }
        });

        btnFilas.setBackground(new java.awt.Color(0, 255, 255));
        btnFilas.setText("Filas");
        btnFilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilasActionPerformed(evt);
            }
        });

        btnArvore.setBackground(new java.awt.Color(0, 255, 255));
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
                .addContainerGap()
                .addComponent(btnListaSeq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaSe, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPilhas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1217, Short.MAX_VALUE))
        );
        painelMenuLayout.setVerticalGroup(
            painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPilhas, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnListaDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaSe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaSeq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFilas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnArvore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        frameInterno.setVisible(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Caminhamento");

        comboBoxCaminhamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pré-ordem", "in-ordem", "pós-ordem" }));

        btnCaminhamento.setBackground(new java.awt.Color(51, 255, 255));
        btnCaminhamento.setText("Caminhamento");
        btnCaminhamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaminhamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBoxCaminhamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnCaminhamento)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxCaminhamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCaminhamento)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        lblRemover.setText("Remover");

        btnRemover.setBackground(new java.awt.Color(51, 255, 255));
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldRemover)
                    .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemover)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        painelInserir.setBackground(new java.awt.Color(204, 204, 204));

        btnInserir.setBackground(new java.awt.Color(51, 255, 255));
        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        lblInserir.setText("Inserir");

        javax.swing.GroupLayout painelInserirLayout = new javax.swing.GroupLayout(painelInserir);
        painelInserir.setLayout(painelInserirLayout);
        painelInserirLayout.setHorizontalGroup(
            painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInserirLayout.createSequentialGroup()
                .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelInserirLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblInserir))
                    .addGroup(painelInserirLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelInserirLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(fieldInserir))))
                .addGap(23, 23, 23))
        );
        painelInserirLayout.setVerticalGroup(
            painelInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInserirLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInserir)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        elemento8.setBackground(new java.awt.Color(0, 255, 255));
        elemento8.setText("null");
        elemento8.setToolTipText("");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(elemento8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(elemento8)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        elemento9.setBackground(new java.awt.Color(0, 255, 255));
        elemento9.setText("null");
        elemento9.setToolTipText("");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(elemento9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(elemento9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separador5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(separador6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        elemento10.setBackground(new java.awt.Color(0, 255, 255));
        elemento10.setText("null");
        elemento10.setToolTipText("");

        elemento11.setBackground(new java.awt.Color(0, 255, 255));
        elemento11.setText("null");
        elemento11.setToolTipText("");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(elemento11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(elemento11))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(elemento10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separador7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elemento10))
                .addGap(43, 43, 43))
        );

        elemento4.setBackground(new java.awt.Color(0, 255, 255));
        elemento4.setText("null");
        elemento4.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(elemento4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(elemento4))
        );

        elemento5.setBackground(new java.awt.Color(0, 255, 255));
        elemento5.setText("null");
        elemento5.setToolTipText("");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(elemento5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(elemento5))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        elemento13.setBackground(new java.awt.Color(0, 255, 255));
        elemento13.setText("null");
        elemento13.setToolTipText("");

        elemento12.setBackground(new java.awt.Color(0, 255, 255));
        elemento12.setText("null");
        elemento12.setToolTipText("");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(elemento12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(elemento12)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(separador9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elemento13, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separador9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(elemento13)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(separador10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(separador10, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        elemento15.setBackground(new java.awt.Color(0, 255, 255));
        elemento15.setText("null");
        elemento15.setToolTipText("");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(elemento15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(elemento15))
        );

        elemento14.setBackground(new java.awt.Color(0, 255, 255));
        elemento14.setText("null");
        elemento14.setToolTipText("");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(elemento14, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(elemento14))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separador11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        elemento6.setBackground(new java.awt.Color(0, 255, 255));
        elemento6.setText("null");
        elemento6.setToolTipText("");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(elemento6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(elemento6))
        );

        elemento7.setBackground(new java.awt.Color(0, 255, 255));
        elemento7.setText("null");
        elemento7.setToolTipText("");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(elemento7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(elemento7)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separador4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separador4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        elemento1.setBackground(new java.awt.Color(0, 255, 255));
        elemento1.setText("null");
        elemento1.setToolTipText("");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        elemento2.setBackground(new java.awt.Color(0, 255, 255));
        elemento2.setText("null");
        elemento2.setToolTipText("");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(393, Short.MAX_VALUE)
                .addComponent(elemento2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(elemento2)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        elemento3.setBackground(new java.awt.Color(0, 255, 255));
        elemento3.setText("null");
        elemento3.setToolTipText("");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(elemento3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(elemento3)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frameInternoLayout = new javax.swing.GroupLayout(frameInterno.getContentPane());
        frameInterno.getContentPane().setLayout(frameInternoLayout);
        frameInternoLayout.setHorizontalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameInternoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(frameInternoLayout.createSequentialGroup()
                        .addGap(742, 742, 742)
                        .addComponent(elemento1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameInternoLayout.createSequentialGroup()
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(93, 93, 93)))
                    .addGroup(frameInternoLayout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        frameInternoLayout.setVerticalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameInternoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameInternoLayout.createSequentialGroup()
                        .addComponent(painelInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(frameInternoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(frameInternoLayout.createSequentialGroup()
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(elemento1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameInterno))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(frameInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListaSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaSeqActionPerformed
        FrameListaSeqTamanho frameListaSeqTamanho = new FrameListaSeqTamanho();
        this.dispose();
        frameListaSeqTamanho.setVisible(true);
    }//GEN-LAST:event_btnListaSeqActionPerformed

    private void btnListaSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaSeActionPerformed
        FrameListaSe frame = new FrameListaSe();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnListaSeActionPerformed

    private void btnListaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDeActionPerformed
        FrameListaDe frame = new FrameListaDe();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnListaDeActionPerformed

    private void btnPilhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilhasActionPerformed
        FramePilha frame = new FramePilha();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnPilhasActionPerformed

    private void btnFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilasActionPerformed
        FrameFila frame = new FrameFila();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnFilasActionPerformed

    private void btnArvoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArvoreActionPerformed
        FrameArvore frame = new FrameArvore();
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_btnArvoreActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        int valor;
        try{
            valor = Integer.parseInt(this.fieldInserir.getText());
            this.arvoreBinaria.insere(valor, arvoreDeBtns);

        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Erro na entrada de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }catch( InternalError e){
            JOptionPane.showMessageDialog(null, "Quantidade De nos visuais Esgotada", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int valor;
        try{
            valor = Integer.parseInt(this.fieldRemover.getText());
            this.arvoreBinaria.remove(valor);
            this.paintTree(arvoreBinaria, arvoreDeBtns);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Erro na entrada de dados", "Erro", JOptionPane.ERROR_MESSAGE);
        }
            
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnCaminhamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaminhamentoActionPerformed
        // TODO add your handling code here:
        StringBuilder s = new StringBuilder();
        try{
            switch (this.comboBoxCaminhamento.getSelectedIndex()) {
                case 0:
                    //pre ordem
                    this.arvoreBinaria.exibePre(s);
                    JOptionPane.showMessageDialog(null, "Os dados pre ordem são: "+ s.toString(), "Pre Ordem", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    //in ordem
                    this.arvoreBinaria.exibe(s);
                    JOptionPane.showMessageDialog(null, "Os dados in ordem são: "+ s.toString(), "In Ordem", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    this.arvoreBinaria.exibePos(s);
                    JOptionPane.showMessageDialog(null, "Os dados Pos ordem são: "+ s.toString(), "POs Ordem", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    break;
            }
        }catch( InternalError e){
            JOptionPane.showMessageDialog(null, "Arvore Vazia", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCaminhamentoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArvore;
    private javax.swing.JButton btnCaminhamento;
    private javax.swing.JButton btnFilas;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnListaDe;
    private javax.swing.JButton btnListaSe;
    private javax.swing.JButton btnListaSeq;
    private javax.swing.JButton btnPilhas;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> comboBoxCaminhamento;
    private javax.swing.JButton elemento1;
    private javax.swing.JButton elemento10;
    private javax.swing.JButton elemento11;
    private javax.swing.JButton elemento12;
    private javax.swing.JButton elemento13;
    private javax.swing.JButton elemento14;
    private javax.swing.JButton elemento15;
    private javax.swing.JButton elemento2;
    private javax.swing.JButton elemento3;
    private javax.swing.JButton elemento4;
    private javax.swing.JButton elemento5;
    private javax.swing.JButton elemento6;
    private javax.swing.JButton elemento7;
    private javax.swing.JButton elemento8;
    private javax.swing.JButton elemento9;
    private javax.swing.JTextField fieldInserir;
    private javax.swing.JTextField fieldRemover;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JInternalFrame frameInterno;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblInserir;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JPanel painelInserir;
    private javax.swing.JPanel painelMenu;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador10;
    private javax.swing.JSeparator separador11;
    private javax.swing.JSeparator separador2;
    private javax.swing.JSeparator separador4;
    private javax.swing.JSeparator separador5;
    private javax.swing.JSeparator separador6;
    private javax.swing.JSeparator separador7;
    private javax.swing.JSeparator separador9;
    // End of variables declaration//GEN-END:variables
}
