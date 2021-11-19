/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectzeus.View;

import commons.Console;
import java.awt.Color;
import java.awt.Image;
import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import projectzeus.entities.Card;
import projectzeus.entities.GameOver;
import projectzeus.entities.Iterator;
import projectzeus.entities.Opcao;

/**
 *
 * @author Matheus Lima
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    private String finalCaminho = "C:\\Users\\Aluno\\Documents\\NetBeansProjects\\ProjectZeus2\\src\\projectzeus\\";
    private ArrayList<Card> listaCards = new ArrayList<>();
    private ArrayList<Integer> passed = new ArrayList<>();
    private Integer index = 0;
    private Integer check = 0;
    private Card cardAtual;

    public Card getCardAtual() {
        return cardAtual;
    }

    public void setCardAtual(Card cardAtual) {
        this.cardAtual = cardAtual;
    }

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
      
        initComponents();
        
        setLocationRelativeTo(this);

        progressoDinheiro.setValue(50);
        progressoEnergia.setValue(25);
        progressoImpacto.setValue(50);
        progressoOpiniao.setValue(50);

        labelDinheiro.setText("<html>Dinheiro</html>");
        labelEnergia.setText("<html>Energia</html>");
        labelImpacto.setText("<html>Impacto Ambiental</html>");
        labelOpiniao.setText("<html>Opinião Pública</html>");

        novasCartas();
        carregaCarta(cardAtual);
        
    }

    public void alterarProgressos(Integer a, Integer b, Integer c, Integer d) {
        progressoDinheiro.setValue(progressoDinheiro.getValue() + a);
        progressoEnergia.setValue(progressoEnergia.getValue() + b);
        progressoImpacto.setValue(progressoImpacto.getValue() + c);
        progressoOpiniao.setValue(progressoOpiniao.getValue() + d);
    }

    public void checkGameOver() {
        if (progressoDinheiro.getValue() <= 0 || progressoEnergia.getValue() <= 0
                || progressoImpacto.getValue() <= 0 || progressoOpiniao.getValue() <= 0) {
            gameOverMin();
        } else if (progressoDinheiro.getValue() >= 100 || progressoEnergia.getValue() >= 100
                || progressoImpacto.getValue() >= 100 || progressoOpiniao.getValue() >= 100) {
            gameOverMax();
            this.dispose();
        }

    }

    public void gameOverMin() {
       
        if(progressoDinheiro.getValue() <= 0){
            GameOver.setTitulo("Falência: Sua Conta está Negativa");
            GameOver.setDescricao("Você gastou todos os seus recursos. Seu secretário de finanças entrou correndo \n na sala com uma carta dos governos dizendo que o projeto será encerrado. \nVocê quebrou.");
            GameOver.setImagem(finalCaminho+"Gameover\\minDinheiro.jpg");
            this.setVisible(false);
            TelaFimDeJogo next = new TelaFimDeJogo();
            next.setVisible(true);
            this.dispose();
        }
        else if(progressoEnergia.getValue() <= 0){
            GameOver.setTitulo("Mundo sob Luz de Velas: Crise Energética");
            GameOver.setDescricao("A noite está escura pela primeira vez no século. A última fonte de energia perdeu sua força,\n o mundo está sob luz de velas. Você foi apagado.");
            GameOver.setImagem(finalCaminho+"Gameover\\minEnergia.jpeg");
            this.setVisible(false);
            TelaFimDeJogo next = new TelaFimDeJogo();
            next.setVisible(true);
            this.dispose();
        }
        else if(progressoImpacto.getValue() <= 0){
            GameOver.setTitulo("AFK: Tem alguém ai?");
            GameOver.setDescricao("Suas ações não ajudaram a resolver a crise. O governo está a muito tempo esperando \n resultados e estão desacreditados. A população acha que seus impostos estão \n sendo desperdiçados. Você ao menos tentou?");
            GameOver.setImagem(finalCaminho+"Gameover\\minImpacto.jpg");
            this.setVisible(false);
            TelaFimDeJogo next = new TelaFimDeJogo();
            next.setVisible(true);
            this.dispose();
        }
        else if(progressoOpiniao.getValue() <= 0){
            GameOver.setTitulo("Desaprovação da população: Manisfestações Hostis");
            GameOver.setDescricao("Revoltas estão acontecendo em todas as capitais, por todo o mundo. A polícia não foi capaz de impedir \n que os manifestantes invadissem a sede do projeto. Você foi linchado.");
            GameOver.setImagem(finalCaminho+"Gameover\\minOpiniao.jpg");
            this.setVisible(false);
            TelaFimDeJogo next = new TelaFimDeJogo();
            next.setVisible(true);
            this.dispose();
            
        }
      

    }

    public void gameOverMax() {
        if(progressoDinheiro.getValue() <= 0){
            GameOver.setTitulo("Escândalo Financeiro: Denuncia de Paraíso Fiscal");
            GameOver.setDescricao("A imprensa internacional descobriu que alguém envolvido no projeto estava desviando dinheiro \n para um paraíso fiscal. Sua capacidade de liderança foi questionada. \n Você foi demitido.");
            GameOver.setImagem(finalCaminho+"Gameover\\maxDinheiro.jpg");
            this.setVisible(false);
            TelaFimDeJogo next = new TelaFimDeJogo();
            next.setVisible(true);
            this.dispose();
        }
        else if(progressoEnergia.getValue() >= 100){
            GameOver.setTitulo("Blecaute: Sobrecarga da Matriz Energética Mundial");
            GameOver.setDescricao("Por todo o mundo clarões e estrondos foram relatados, pareciam trovões, mas eram as\n  últimas faíscais de energia vistas pela civilização moderna.\n Você levou a civilização ao colapso.");
            GameOver.setImagem(finalCaminho+"Gameover\\maxImpacto.jpg");
            this.setVisible(false);
            TelaFimDeJogo next = new TelaFimDeJogo();
            next.setVisible(true);
            this.dispose();
        }
        else if(progressoImpacto.getValue() >= 100){
            GameOver.setTitulo("Armagedom: Consequências Irreversíveis");
            GameOver.setDescricao("Você virou um símbolo do povo pelas suas atitudes sustentáveis e demonstrar maestria em resolver crises mundiais. \n As grandes potências estão com medo de sua influência. \n Você foi destituído.");
            GameOver.setImagem(finalCaminho+"Gameover\\maxImpacto.jpg");
            this.setVisible(false);
            TelaFimDeJogo next = new TelaFimDeJogo();
            next.setVisible(true);
            this.dispose();
        }
        else if(progressoOpiniao.getValue() >= 100){
            GameOver.setTitulo("Demissão: Líder da Revolução");
            GameOver.setDescricao("Revoltas estão acontecendo em todas as capitais, por todo o mundo. A polícia não foi capaz de impedir \n que os manifestantes invadissem a sede do projeto. Você foi linchado.");
            GameOver.setImagem(finalCaminho+"Gameover\\maxOpiniao.jpg");
            this.setVisible(false);
            TelaFimDeJogo next = new TelaFimDeJogo();
            next.setVisible(true);
            this.dispose();
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        progressoDinheiro = new javax.swing.JProgressBar(progressoDinheiro.VERTICAL);
        progressoEnergia = new javax.swing.JProgressBar(progressoDinheiro.VERTICAL);
        progressoOpiniao = new javax.swing.JProgressBar(progressoDinheiro.VERTICAL);
        progressoImpacto = new javax.swing.JProgressBar(progressoDinheiro.VERTICAL);
        labelDinheiro = new javax.swing.JLabel();
        labelEnergia = new javax.swing.JLabel();
        labelOpiniao = new javax.swing.JLabel();
        labelImpacto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelImagem = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelOpcaoA = new javax.swing.JButton();
        labelOpcaoB = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        labelDescricao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(110, 117, 168));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(110, 117, 168));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setEnabled(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 113));

        progressoDinheiro.setFocusTraversalPolicyProvider(true);
        progressoDinheiro.setPreferredSize(new java.awt.Dimension(146, 70));

        progressoEnergia.setFocusTraversalPolicyProvider(true);

        progressoOpiniao.setFocusTraversalPolicyProvider(true);

        progressoImpacto.setFocusTraversalPolicyProvider(true);

        labelDinheiro.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        labelDinheiro.setForeground(new java.awt.Color(255, 255, 255));
        labelDinheiro.setText("jLabel1");
        labelDinheiro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelEnergia.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        labelEnergia.setForeground(new java.awt.Color(255, 255, 255));
        labelEnergia.setText("jLabel2");
        labelEnergia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelOpiniao.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        labelOpiniao.setForeground(new java.awt.Color(255, 255, 255));
        labelOpiniao.setText("jLabel3");
        labelOpiniao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelImpacto.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        labelImpacto.setForeground(new java.awt.Color(255, 255, 255));
        labelImpacto.setText("jLabel4");
        labelImpacto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelImpacto.setPreferredSize(new java.awt.Dimension(50, 45));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressoEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(labelEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressoOpiniao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(labelOpiniao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressoImpacto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelImpacto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressoOpiniao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressoEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progressoImpacto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEnergia, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOpiniao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelImpacto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(110, 117, 168));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelImagem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Empresário misterioso te oferece uma quantia bilionária.");

        labelOpcaoA.setBackground(new java.awt.Color(62, 25, 41));
        labelOpcaoA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelOpcaoA.setForeground(new java.awt.Color(255, 255, 255));
        labelOpcaoA.setText("Reportar dinheiro duvidoso");
        labelOpcaoA.setRequestFocusEnabled(false);
        labelOpcaoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelOpcaoAActionPerformed(evt);
            }
        });

        labelOpcaoB.setBackground(new java.awt.Color(62, 25, 41));
        labelOpcaoB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelOpcaoB.setForeground(new java.awt.Color(255, 255, 255));
        labelOpcaoB.setText("Aceitar...");
        labelOpcaoB.setRequestFocusEnabled(false);
        labelOpcaoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelOpcaoBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelOpcaoA, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelOpcaoB, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelOpcaoA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOpcaoB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(110, 117, 168));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelDescricao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelDescricao.setForeground(new java.awt.Color(255, 255, 255));
        labelDescricao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelOpcaoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelOpcaoAActionPerformed
        check++;
        shuffleIndex();
        checkGameOver();
        checkwin();
        alterarProgressos(cardAtual.getOpcaoA().getDinheiro(), cardAtual.getOpcaoA().getEnergia(), cardAtual.getOpcaoA().getImpactoAmbiental(), cardAtual.getOpcaoA().getOpiniaoPublica());
        chamaCarta(); 
        
    }//GEN-LAST:event_labelOpcaoAActionPerformed

    private void labelOpcaoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelOpcaoBActionPerformed
        check++;
        shuffleIndex();
        checkGameOver();
        checkwin();
        alterarProgressos(cardAtual.getOpcaoB().getDinheiro(), cardAtual.getOpcaoB().getEnergia(), cardAtual.getOpcaoB().getImpactoAmbiental(), cardAtual.getOpcaoB().getOpiniaoPublica());
        chamaCarta();
    }//GEN-LAST:event_labelOpcaoBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaPrincipal.setVisible(true);
            }
        });

    }

    
    
    
    
    public void shuffleIndex(){

    }
            
    public void novasCartas() {
        
        Opcao opcaoA = new Opcao("Pronunciamento público: Promover um evento com os cientistas sobre o aquecimento global", -10, 0, 20, -10);
        Opcao opcaoB = new Opcao("Presidente de onde? Tenho mais o que fazer.", 3, -10, -10, 75);
        Card presidente = new Card("Aquecimento Global?", "Presidente de uma grande nação duvida do aquecimento global.", "Evento", opcaoA, opcaoB, finalCaminho+"Evento\\AquecimentoGlobal.jpg");

        Opcao opcaoC = new Opcao("Reportar dinheiro duvidoso para as autoridades.", 8, 0, 5, 0);
        Opcao opcaoD = new Opcao("Aceitar...", 25, 0, -15, 0);
        Card empresario = new Card("Empresário Misterioso", "Empresário misterioso te oferece uma quantia bilionária.", "Evento", opcaoC, opcaoD, finalCaminho+"Evento\\Suborno.jpg");

        Opcao opcaoE = new Opcao("Oferecer recursos para reconstrução da área.", -20, 0, 15, 5);
        Opcao opcaoF = new Opcao("Não posso abrir mão de recursos tão escassos.", 10, 0, -10, 13);
        Card vulcao = new Card("Vulcão em Erupção", "Erupção de vulcão em países subdesenvolvidos.", "Evento", opcaoE, opcaoF,finalCaminho+"Evento\\Volcano.jpg");
        
        Opcao opcaoG = new Opcao("Implantar o horáriro de verão para que povo economize energia", -5, -10, -5, 0);
        Opcao opcaoH = new Opcao(" Ter que ajustar meu relógio? Jamais...", 3, 10, -10, 0);
        Card horario = new Card("Horário de verão", "Vamos implementar o horário de verão?", "Evento", opcaoG, opcaoH, finalCaminho+"Evento\\horarioVerao.jpg");
        
        Opcao opcaoI = new Opcao("Não temos tempo para isso....", 5, 5, -10, 5);
        Opcao opcaoJ = new Opcao(" Vamos incentivar o povo, energia precisa ser economizada", -5, -5, 3, -2);
        Card palestra = new Card("Palestra de Concientização", "O povo está usando energia de forma desenfreada", "Evento", opcaoI, opcaoJ, finalCaminho+"Evento\\palestra.jpg");
        
        Opcao opcaoK = new Opcao("Estou satisfeitos com as fontes que temos", 5, 0, -10, 0);
        Opcao opcaoL = new Opcao("Claro, novas fontes são sempre bem vindas", -7, 5, 5, 0);
        Card financiamento = new Card("Financiamento", "Cientistas pedem financiamento para pesquisar novas fontes de energia.", "Evento", opcaoK, opcaoL, finalCaminho+"Evento\\financiamento.jpg");
        
        Opcao opcaoE1a = new Opcao("Nós ainda precisamos delas", 5, 0, -10, 5);
        Opcao opcaoE1b = new Opcao(" É melhor para o planeta",-5, -15, 5, -13);
        Card duvida = new Card("Desativar usinas não renováveis", "O planeta não aguenta mais as fontes não renovaveis", "Evento", opcaoE1a, opcaoE1b, finalCaminho+"Evento\\desativar.jpg");
        
        Opcao opcaoE2a = new Opcao("Cara, isso parece perigoso, volte quando ela estiver mais segura", 0, 0, 15, -5);
        Opcao opcaoE2b = new Opcao(" Aceitar nova fonte de energia",-15, 35, -25,5);
        Card jayce = new Card("Oferta Hextech", "Um ciêntista de apresenta uma fonte de energia nova, porém muito instável", "Evento", opcaoE2a, opcaoE2b, finalCaminho+"Evento\\novaFonte.jpg");
        
        Opcao opcaoE3a = new Opcao("Escolher um dos países", 3, 2, -15, -3);
        Opcao opcaoE3b = new Opcao("Energia limpa para todos!", 7, 4, 10, -7);
        Card diplomacia = new Card("Soluçao diplomatica", "Dois países da Europa estão brigando para receber as novas fontes de energia primeiro", "Evento", opcaoE3a, opcaoE3b, finalCaminho+"Evento\\diplomacia.jpg");
        
        Opcao opcaoCons1a = new Opcao("Construir", -15, 10, 5, 5);
        Opcao opcaoCons1b = new Opcao("Não temos os recursos", 7,-2, -5, -2);
        Card eolica = new Card("Parque Eólico", "Vamos construir novos parques eólicos", "Construçao", opcaoCons1a, opcaoCons1b, finalCaminho+"Construção\\Eolica.png");
        
        Opcao opcaoCons2a = new Opcao("Construir", -15, 10, -5, 8);
        Opcao opcaoCons2b = new Opcao("Não temos os recursos", 7,-2, 3, -2);
        Card geotermica = new Card("Usina Geotermica", "Vamos construir uma usina Geotermica", "Construçao", opcaoCons2a, opcaoCons2b, finalCaminho+"Construção\\Geotermica.png");
        
        Opcao opcaoCons3a = new Opcao("Construir", -20, 25, -13, 15);
        Opcao opcaoCons3b = new Opcao("Não temos os recursos",12,-2, -2, -3);
        Card hidreletrica = new Card("Usina Hidrelétrica", "Vamos construir uma usina Hidrelétrica", "Construçao", opcaoCons3a, opcaoCons3b, finalCaminho+"Construção\\Hidreletrica.png");
        
        Opcao opcaoCons4a = new Opcao("Construir", -23, 15, -13, 13);
        Opcao opcaoCons4b = new Opcao("Não temos os recursos", 15,-2, -2, -2);
        Card nuclear = new Card("Usina Nuclear", "Vamos construir uma usina Nuclear", "Construçao", opcaoCons4a, opcaoCons4b, finalCaminho+"Construção\\Nuclear.png");
        
        Opcao opcaoCons5a = new Opcao("Construir", -13, 10, 2, 7);
        Opcao opcaoCons5b = new Opcao("Não temos os recursos", 12,-2, -2, -3);
        Card solar = new Card("Paineis solares", "Vamos construir um parque solares", "Construçao", opcaoCons5a, opcaoCons5b, finalCaminho+"Construção\\Solar.png");
        
        Opcao opcaoCons6a = new Opcao("Construir", -10, 5, 2, 2);
        Opcao opcaoCons6b = new Opcao("Não temos os recursos", 7,-2, -2, -3);
        Card oceanica = new Card("Pás oceânicas", "Vamos construir pás oceânicas", "Construçao", opcaoCons6a, opcaoCons6b, finalCaminho+"Construção\\Oceanica.png");
        
        
        listaCards.add(eolica);
        listaCards.add(empresario);
        listaCards.add(presidente);
        listaCards.add(geotermica);
        listaCards.add(vulcao);
        listaCards.add(horario);
        listaCards.add(hidreletrica);
        listaCards.add(jayce);
        listaCards.add(palestra);
        listaCards.add(duvida);
        listaCards.add(nuclear);
        listaCards.add(financiamento);
        listaCards.add(solar);
        listaCards.add(oceanica);
        listaCards.add(diplomacia);   
        
        Iterator.adicionaCarta(listaCards);
        cardAtual = Iterator.getProximaCarta();
        

    }

    public void chamaCarta() {
        checkGameOver();
        
        cardAtual = Iterator.getProximaCarta();
        carregaCarta(cardAtual);

    }
    
    public void checkwin(){
        if(check == listaCards.size()){
            GameOver.setTitulo("Você conseguiu!");
            GameOver.setDescricao("Você conseguiu gerir a crise por enquanto! Continue economizando energia e lembre-se \n o planeta não pode continuar dessa forma!");
            GameOver.setImagem(finalCaminho+"Gameover\\win.jpg");
            this.setVisible(false);
            TelaFimDeJogo next = new TelaFimDeJogo();
            next.setVisible(true);
            this.dispose();
        }
    }

    public void scaleImage(String imagem) {
        ImageIcon icon = new ImageIcon("C:\\Users\\Aluno\\OneDrive - EDU - Organização Educacional Barão de Mauá\\Facul\\6º Sem\\Padrões e Paradigmas de Programação\\Projeto 2º Bim - Project Zeus\\Jogo\\ProjectZeus-master\\src\\projectzeus\\Evento\\" + imagem);
        //scaling image to fit in jlable
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(labelImagem.getWidth(), labelImagem.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        labelImagem.setIcon(scaledIcon);
    }

    public void carregaCarta(Card card) {

        ImageIcon icon = new ImageIcon(card.getImagem());
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(labelImagem.getWidth(), labelImagem.getHeight(), Image.SCALE_SMOOTH);     
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        labelImagem.setIcon(scaledIcon);
        labelTitulo.setText("<html>" + card.getTitulo() + "</html>");
        labelOpcaoA.setText("<html>" + card.getOpcaoA().getDescricao() + "</html>");
        labelOpcaoB.setText("<html>" + card.getOpcaoB().getDescricao() + "</html>");
        labelDescricao.setText("<html>" + card.getDescricaoEvento() + "</html>");

    }
    ;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelDinheiro;
    private javax.swing.JLabel labelEnergia;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JLabel labelImpacto;
    private javax.swing.JButton labelOpcaoA;
    private javax.swing.JButton labelOpcaoB;
    private javax.swing.JLabel labelOpiniao;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JProgressBar progressoDinheiro;
    private javax.swing.JProgressBar progressoEnergia;
    private javax.swing.JProgressBar progressoImpacto;
    private javax.swing.JProgressBar progressoOpiniao;
    // End of variables declaration//GEN-END:variables
}
