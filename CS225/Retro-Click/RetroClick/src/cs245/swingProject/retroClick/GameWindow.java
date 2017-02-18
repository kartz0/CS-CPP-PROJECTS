/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245.swingProject.retroClick;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import java.text.DateFormatSymbols;
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;
import java.lang.String;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

/**
 *
 * @author kartiksoni
 */
public class GameWindow extends javax.swing.JFrame {

    

    

    private HighScores scores;
    private HangMan     hangManGame;
    private ColorGame   colorGame; 
    private SudokuGame  sGame;

    /**
     * Creates new form Intro
     */
    public GameWindow() {
        
        // on ESC key close frame
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); 
        getRootPane().getActionMap().put("Cancel", new AbstractAction(){ 
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                dispose();
            }
        });
        
        // on close window the close method is called
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) 
            {
                setVisible(false);
                dispose();
            }
        });
        
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "Team"); 
        getRootPane().getActionMap().put("Team", new AbstractAction(){ 
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Kartik Soni--009529468\n"
                        + "Brian Sandoval--09529468\n"
                        + "Christian Lopez--009529299\n"
                        + "Shane Avila--009727367\n"
                        + "Kean Jafari--009533238\n\n"
                        + "Team Name:  Retro Click\n"
                        + "Term:  Winter 2016");
            }
        });

        gameInit();
        initComponents();  
        clock();
        setDefault();
    }
    
    public void gameInit()  {
        scores = new HighScores();
        scores.load();
        
        hangManGame = new HangMan();
        colorGame   = new ColorGame();
        sGame = new SudokuGame();
        
    }
    // method: clock
    // purpose: will get the current time and date and
    // send the information to the jlabel to display them
    public void clock() {
        // create a thread for non-static time
        Thread clock = new Thread() {
            public void run(){
                try {
                    while(true){
                        // create calendar object
                        Calendar cal = new GregorianCalendar();

                        // initialize time & date components
                        int hour = cal.get(Calendar.HOUR);
                        // minutes
                        int minutes = cal.get(Calendar.MINUTE);
                        String minutesString = Integer.toString(minutes);
                        if (minutes < 10){ minutesString = String.format("%02d", minutes); }
                        // seconds
                        int seconds = cal.get(Calendar.SECOND);
                        
                        String month = getMonth((cal.get(Calendar.MONTH)) + 1);
                        int day = cal.get(Calendar.DATE);
                        int year = cal.get(Calendar.YEAR);
                        
                     
                        // print on jlabel
                        //clockLabel.setText(hour + ":" + minutesString + " " + seconds);
                        //dateLabel.setText(month + " " + day + ", " + year);
                        gameDate.setText(month + " " + day + ", " + year);
                        gameClock.setText(hour + ":" + minutesString + ":" + seconds);
                        gameDate1.setText(month + " " + day + ", " + year);
                        gameClock1.setText(hour + ":" + minutesString + ":" + seconds);
                        sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        clock.start();
    }
    
    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }
    
    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField40 = new javax.swing.JTextField();
        menu = new javax.swing.JPanel();
        startGameButton = new javax.swing.JButton();
        highScoreButton = new javax.swing.JButton();
        creditsButton = new javax.swing.JButton();
        mainMenuPicture = new javax.swing.JLabel();
        game = new javax.swing.JPanel();
        skipButton = new javax.swing.JButton();
        aButton = new javax.swing.JButton();
        bButton = new javax.swing.JButton();
        cButton = new javax.swing.JButton();
        dButton = new javax.swing.JButton();
        eButton = new javax.swing.JButton();
        fButton = new javax.swing.JButton();
        gButton = new javax.swing.JButton();
        hButton = new javax.swing.JButton();
        iButton = new javax.swing.JButton();
        jButton = new javax.swing.JButton();
        kButton = new javax.swing.JButton();
        lButton = new javax.swing.JButton();
        mButton = new javax.swing.JButton();
        nButton = new javax.swing.JButton();
        oButton = new javax.swing.JButton();
        pButton = new javax.swing.JButton();
        qButton = new javax.swing.JButton();
        rButton = new javax.swing.JButton();
        sButton = new javax.swing.JButton();
        tButton = new javax.swing.JButton();
        uButton = new javax.swing.JButton();
        vButton = new javax.swing.JButton();
        wButton = new javax.swing.JButton();
        xButton = new javax.swing.JButton();
        yButton = new javax.swing.JButton();
        gameDate = new javax.swing.JLabel();
        zButton = new javax.swing.JButton();
        hangManPicture = new javax.swing.JLabel();
        gameWordDisplay = new javax.swing.JLabel();
        gameClock = new javax.swing.JLabel();
        highScores = new javax.swing.JPanel();
        highScoreBackButton = new javax.swing.JButton();
        highScoreTitleLabel = new javax.swing.JLabel();
        highScore_1 = new javax.swing.JLabel();
        highScore_2 = new javax.swing.JLabel();
        highScore_3 = new javax.swing.JLabel();
        highScore_4 = new javax.swing.JLabel();
        highScore_5 = new javax.swing.JLabel();
        credits = new javax.swing.JPanel();
        creditsTitle = new javax.swing.JLabel();
        kartikLabel = new javax.swing.JLabel();
        brianLabel = new javax.swing.JLabel();
        crisitianLabel = new javax.swing.JLabel();
        shaneLabel = new javax.swing.JLabel();
        keanLabel = new javax.swing.JLabel();
        creditsBackButton = new javax.swing.JButton();
        gameTwo = new javax.swing.JPanel();
        correctText = new javax.swing.JLabel();
        YELLOW = new javax.swing.JButton();
        RED = new javax.swing.JButton();
        BLUE = new javax.swing.JButton();
        PURPLE = new javax.swing.JButton();
        GREEN = new javax.swing.JButton();
        gameDate1 = new javax.swing.JLabel();
        gameClock1 = new javax.swing.JLabel();
        gameOver = new javax.swing.JPanel();
        winOrLose = new javax.swing.JLabel();
        playerScore = new javax.swing.JLabel();
        mainMenuFromGameOver = new javax.swing.JButton();
        notifyUserToSave = new javax.swing.JLabel();
        userInputName = new javax.swing.JTextField();
        saveHighScore = new javax.swing.JButton();
        gameThree = new javax.swing.JPanel();
        sudokuGame = new javax.swing.JPanel();
        gridOne = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        gridTwo = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        gridThree = new javax.swing.JPanel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        gridFour = new javax.swing.JPanel();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        gridfive = new javax.swing.JPanel();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        gridSix = new javax.swing.JPanel();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jTextField55 = new javax.swing.JTextField();
        gridSeven = new javax.swing.JPanel();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jTextField62 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        jTextField64 = new javax.swing.JTextField();
        gridEight = new javax.swing.JPanel();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jTextField70 = new javax.swing.JTextField();
        jTextField71 = new javax.swing.JTextField();
        jTextField72 = new javax.swing.JTextField();
        jTextField73 = new javax.swing.JTextField();
        gridNine = new javax.swing.JPanel();
        jTextField74 = new javax.swing.JTextField();
        jTextField75 = new javax.swing.JTextField();
        jTextField76 = new javax.swing.JTextField();
        jTextField77 = new javax.swing.JTextField();
        jTextField78 = new javax.swing.JTextField();
        jTextField79 = new javax.swing.JTextField();
        jTextField80 = new javax.swing.JTextField();
        jTextField81 = new javax.swing.JTextField();
        jTextField82 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jTextField40.setText("jTextField40");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        menu.setName(""); // NOI18N
        menu.setPreferredSize(new java.awt.Dimension(600, 400));

        startGameButton.setText("Start Game");
        startGameButton.setToolTipText("Launches game");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        highScoreButton.setText("High Scores");
        highScoreButton.setToolTipText("Navigates to High Score Screen");
        highScoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highScoreButtonActionPerformed(evt);
            }
        });

        creditsButton.setText("Credits");
        creditsButton.setToolTipText("Displays Credits");
        creditsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsButtonActionPerformed(evt);
            }
        });

        mainMenuPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/retroClick/images.jpg"))); // NOI18N
        mainMenuPicture.setText("jLabel1");

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(creditsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(highScoreButton, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(startGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(mainMenuPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainMenuPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(startGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creditsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        game.setToolTipText("");
        game.setPreferredSize(new java.awt.Dimension(624, 400));

        skipButton.setText("Skip");
        skipButton.setToolTipText("Navigates to Next Game");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        aButton.setText("A");
        aButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aButtonActionPerformed(evt);
            }
        });

        bButton.setText("B");
        bButton.setToolTipText("");
        bButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bButtonActionPerformed(evt);
            }
        });

        cButton.setText("C");
        cButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButtonActionPerformed(evt);
            }
        });

        dButton.setText("D");
        dButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dButtonActionPerformed(evt);
            }
        });

        eButton.setText("E");
        eButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eButtonActionPerformed(evt);
            }
        });

        fButton.setText("F");
        fButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fButtonActionPerformed(evt);
            }
        });

        gButton.setText("G");
        gButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gButtonActionPerformed(evt);
            }
        });

        hButton.setText("H");
        hButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hButtonActionPerformed(evt);
            }
        });

        iButton.setText("I");
        iButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iButtonActionPerformed(evt);
            }
        });

        jButton.setText("J");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        kButton.setText("K");
        kButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButtonActionPerformed(evt);
            }
        });

        lButton.setText("L");
        lButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lButtonActionPerformed(evt);
            }
        });

        mButton.setText("M");
        mButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButtonActionPerformed(evt);
            }
        });

        nButton.setText("N");
        nButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nButtonActionPerformed(evt);
            }
        });

        oButton.setText("O");
        oButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oButtonActionPerformed(evt);
            }
        });

        pButton.setText("P");
        pButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pButtonActionPerformed(evt);
            }
        });

        qButton.setText("Q");
        qButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qButtonActionPerformed(evt);
            }
        });

        rButton.setText("R");
        rButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButtonActionPerformed(evt);
            }
        });

        sButton.setText("S");
        sButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sButtonActionPerformed(evt);
            }
        });

        tButton.setText("T");
        tButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tButtonActionPerformed(evt);
            }
        });

        uButton.setText("U");
        uButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uButtonActionPerformed(evt);
            }
        });

        vButton.setText("V");
        vButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButtonActionPerformed(evt);
            }
        });

        wButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        wButton.setText("W");
        wButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wButtonActionPerformed(evt);
            }
        });

        xButton.setText("X");
        xButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButtonActionPerformed(evt);
            }
        });

        yButton.setText("Y");
        yButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yButtonActionPerformed(evt);
            }
        });

        gameDate.setText("Date");

        zButton.setText("Z");
        zButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zButtonActionPerformed(evt);
                letterButtonActionPerformed(evt);
            }
        });

        hangManPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/retroClick/Pole.png"))); // NOI18N
        hangManPicture.setText("jLabel3");

        gameWordDisplay.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        gameWordDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameWordDisplay.setText(hangManGame.getDash());

        gameClock.setText("Clock");

        javax.swing.GroupLayout gameLayout = new javax.swing.GroupLayout(game);
        game.setLayout(gameLayout);
        gameLayout.setHorizontalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(gameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameLayout.createSequentialGroup()
                        .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gameLayout.createSequentialGroup()
                                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(gameLayout.createSequentialGroup()
                                        .addComponent(lButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(oButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(wButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(gameLayout.createSequentialGroup()
                                        .addComponent(xButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(zButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(gameLayout.createSequentialGroup()
                                        .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(qButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(gameLayout.createSequentialGroup()
                                .addComponent(aButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameLayout.createSequentialGroup()
                        .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gameWordDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(gameLayout.createSequentialGroup()
                                        .addComponent(hangManPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(135, 135, 135)
                                        .addComponent(skipButton))
                                    .addGroup(gameLayout.createSequentialGroup()
                                        .addComponent(gameDate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gameClock, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)))
                        .addContainerGap())))
        );
        gameLayout.setVerticalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameClock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hangManPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameWordDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aButton)
                    .addComponent(bButton)
                    .addComponent(cButton)
                    .addComponent(dButton)
                    .addComponent(eButton)
                    .addComponent(fButton)
                    .addComponent(gButton)
                    .addComponent(hButton)
                    .addComponent(iButton)
                    .addComponent(jButton)
                    .addComponent(kButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lButton)
                    .addComponent(mButton)
                    .addComponent(nButton)
                    .addComponent(oButton)
                    .addComponent(pButton)
                    .addComponent(qButton)
                    .addComponent(rButton)
                    .addComponent(sButton)
                    .addComponent(tButton)
                    .addComponent(uButton)
                    .addComponent(vButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xButton)
                    .addComponent(yButton)
                    .addComponent(zButton)
                    .addComponent(wButton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        highScoreBackButton.setText("Back");
        highScoreBackButton.setToolTipText("Navigates back to Main Menu");
        highScoreBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                highScoreBackButtonMouseClicked(evt);
            }
        });
        highScoreBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highScoreBackButtonActionPerformed(evt);
            }
        });

        highScoreTitleLabel.setText("High Scores");

        highScore_1.setText("ABC......00000");

        highScore_2.setText("ABC......00000");

        highScore_3.setText("ABC......00000");

        highScore_4.setText("ABC......00000");

        highScore_5.setText("ABC......00000");

        javax.swing.GroupLayout highScoresLayout = new javax.swing.GroupLayout(highScores);
        highScores.setLayout(highScoresLayout);
        highScoresLayout.setHorizontalGroup(
            highScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highScoresLayout.createSequentialGroup()
                .addComponent(highScoreBackButton)
                .addGap(0, 545, Short.MAX_VALUE))
            .addGroup(highScoresLayout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addGroup(highScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(highScore_1)
                    .addComponent(highScoreTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(highScore_2)
                    .addComponent(highScore_3)
                    .addComponent(highScore_4)
                    .addComponent(highScore_5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        highScoresLayout.setVerticalGroup(
            highScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, highScoresLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(highScoreTitleLabel)
                .addGap(18, 18, 18)
                .addComponent(highScore_1)
                .addGap(18, 18, 18)
                .addComponent(highScore_2)
                .addGap(18, 18, 18)
                .addComponent(highScore_3)
                .addGap(18, 18, 18)
                .addComponent(highScore_4)
                .addGap(18, 18, 18)
                .addComponent(highScore_5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(highScoreBackButton))
        );

        creditsTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        creditsTitle.setText("Credits");

        kartikLabel.setText("Kartik Soni, 009529468");

        brianLabel.setText("Brian Sandoval, 009633078");

        crisitianLabel.setText("Cristian Lopez, 009529299");

        shaneLabel.setText("Shane Avila, 009727367");

        keanLabel.setText("Kean Jafari, 009533238");

        creditsBackButton.setText("Back");
        creditsBackButton.setToolTipText("Navigates back to Main Menu");
        creditsBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creditsBackButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout creditsLayout = new javax.swing.GroupLayout(credits);
        credits.setLayout(creditsLayout);
        creditsLayout.setHorizontalGroup(
            creditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creditsLayout.createSequentialGroup()
                .addGroup(creditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(creditsLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addGroup(creditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creditsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(creditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(kartikLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(keanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(shaneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(crisitianLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(brianLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(creditsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(creditsBackButton)))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        creditsLayout.setVerticalGroup(
            creditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creditsLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(creditsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kartikLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brianLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crisitianLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shaneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keanLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(creditsBackButton)
                .addContainerGap())
        );

        correctText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        setTextColor();
        correctText.setText(colorGame.getWord());

        YELLOW.setBackground(new java.awt.Color(255, 255, 0));
        YELLOW.setOpaque(true);
        YELLOW.setBorderPainted(false);
        YELLOW.setText("YELLOW");
        YELLOW.setToolTipText("Toggles Yellow Button");
        YELLOW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YELLOWMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                YELLOWMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                YELLOWMouseExited(evt);
            }
        });
        YELLOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YELLOWActionPerformed(evt);
            }
        });

        RED.setBackground(Color.RED);
        RED.setOpaque(true);
        RED.setBorderPainted(false);
        RED.setText("RED");
        RED.setToolTipText("Toggles Red Button");
        RED.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                REDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                REDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                REDMouseExited(evt);
            }
        });
        RED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REDActionPerformed(evt);
            }
        });

        BLUE.setBackground(Color.BLUE);
        BLUE.setOpaque(true);
        BLUE.setBorderPainted(false);
        BLUE.setText("BLUE");
        BLUE.setToolTipText("Toggles Blue Button");
        BLUE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BLUEMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BLUEMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BLUEMouseEntered(evt);
            }
        });

        PURPLE.setBackground(new java.awt.Color(255, 0, 255));
        PURPLE.setOpaque(true);
        PURPLE.setBorderPainted(false);
        PURPLE.setText("PURPLE");
        PURPLE.setToolTipText("Toggles Purple Button");
        PURPLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PURPLEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PURPLEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PURPLEMouseExited(evt);
            }
        });

        GREEN.setBackground(Color.green);
        GREEN.setOpaque(true);
        GREEN.setBorderPainted(false);
        GREEN.setText("GREEN");
        GREEN.setToolTipText("Toggles Green Button");
        GREEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GREENMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GREENMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GREENMouseEntered(evt);
            }
        });

        gameDate1.setText("Date");

        gameClock1.setText("Clock");

        javax.swing.GroupLayout gameTwoLayout = new javax.swing.GroupLayout(gameTwo);
        gameTwo.setLayout(gameTwoLayout);
        gameTwoLayout.setHorizontalGroup(
            gameTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameTwoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(gameTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameTwoLayout.createSequentialGroup()
                        .addComponent(YELLOW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PURPLE))
                    .addGroup(gameTwoLayout.createSequentialGroup()
                        .addGroup(gameTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gameTwoLayout.createSequentialGroup()
                                .addComponent(RED, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameTwoLayout.createSequentialGroup()
                                .addGap(0, 167, Short.MAX_VALUE)
                                .addComponent(GREEN, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135)))
                        .addComponent(BLUE, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gameTwoLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(correctText)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameTwoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gameDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameClock1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        gameTwoLayout.setVerticalGroup(
            gameTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameTwoLayout.createSequentialGroup()
                .addGroup(gameTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameClock1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(gameTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameTwoLayout.createSequentialGroup()
                        .addComponent(PURPLE, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameTwoLayout.createSequentialGroup()
                        .addComponent(YELLOW, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGroup(gameTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameTwoLayout.createSequentialGroup()
                        .addComponent(BLUE, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameTwoLayout.createSequentialGroup()
                        .addComponent(RED, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
            .addGroup(gameTwoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(correctText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GREEN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gameOver.setPreferredSize(new java.awt.Dimension(600, 400));

        winOrLose.setText("GAME OVER");

        playerScore.setText("Your Score: 00000");

        mainMenuFromGameOver.setText("END");
        mainMenuFromGameOver.setToolTipText("Navigates to Main Menu");
        mainMenuFromGameOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuFromGameOverActionPerformed(evt);
            }
        });

        notifyUserToSave.setText("Enter 3 inital name to save your high score.");

        userInputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputNameActionPerformed(evt);
            }
        });

        saveHighScore.setText("Save");
        saveHighScore.setToolTipText("Saves high score");
        saveHighScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveHighScoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameOverLayout = new javax.swing.GroupLayout(gameOver);
        gameOver.setLayout(gameOverLayout);
        gameOverLayout.setHorizontalGroup(
            gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameOverLayout.createSequentialGroup()
                .addGroup(gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameOverLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(mainMenuFromGameOver))
                    .addGroup(gameOverLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notifyUserToSave, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(gameOverLayout.createSequentialGroup()
                                .addComponent(userInputName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveHighScore))))
                    .addGroup(gameOverLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addGroup(gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerScore, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(gameOverLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(winOrLose)))))
                .addGap(27, 138, Short.MAX_VALUE))
        );
        gameOverLayout.setVerticalGroup(
            gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameOverLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(winOrLose)
                .addGap(18, 18, 18)
                .addComponent(playerScore)
                .addGap(84, 84, 84)
                .addComponent(notifyUserToSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gameOverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userInputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveHighScore))
                .addGap(48, 48, 48)
                .addComponent(mainMenuFromGameOver)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        sudokuGame.setBackground(java.awt.Color.white);
        sudokuGame.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        gridOne.setBackground(new java.awt.Color(153, 153, 153));
        gridOne.setLayout(new java.awt.GridLayout(3, 3));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 0, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("8");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        gridOne.add(jTextField1);

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridOne.add(jTextField2);

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridOne.add(jTextField3);

        jTextField4.setBackground(new java.awt.Color(204, 204, 204));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridOne.add(jTextField4);

        jTextField5.setBackground(new java.awt.Color(204, 204, 204));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridOne.add(jTextField5);

        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridOne.add(jTextField6);

        jTextField7.setBackground(new java.awt.Color(204, 204, 204));
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridOne.add(jTextField7);

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(204, 204, 204));
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 0, 51));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("1");
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridOne.add(jTextField8);

        jTextField9.setBackground(new java.awt.Color(204, 204, 204));
        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridOne.add(jTextField9);

        sudokuGame.add(gridOne);

        gridTwo.setLayout(new java.awt.GridLayout(3, 3));

        jTextField10.setEditable(false);
        jTextField10.setBackground(java.awt.Color.white);
        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 0, 51));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("4");
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridTwo.add(jTextField10);

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridTwo.add(jTextField11);

        jTextField12.setEditable(false);
        jTextField12.setBackground(java.awt.Color.white);
        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(255, 0, 51));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("6");
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        gridTwo.add(jTextField12);

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridTwo.add(jTextField13);

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridTwo.add(jTextField14);

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridTwo.add(jTextField15);

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridTwo.add(jTextField16);

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridTwo.add(jTextField17);

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridTwo.add(jTextField18);

        sudokuGame.add(gridTwo);

        gridThree.setBackground(new java.awt.Color(153, 153, 153));
        gridThree.setLayout(new java.awt.GridLayout(3, 3));

        jTextField19.setBackground(new java.awt.Color(204, 204, 204));
        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridThree.add(jTextField19);

        jTextField20.setBackground(new java.awt.Color(204, 204, 204));
        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridThree.add(jTextField20);

        jTextField21.setEditable(false);
        jTextField21.setBackground(new java.awt.Color(204, 204, 204));
        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(255, 0, 51));
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setText("7");
        jTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridThree.add(jTextField21);

        jTextField22.setEditable(false);
        jTextField22.setBackground(new java.awt.Color(204, 204, 204));
        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField22.setForeground(new java.awt.Color(255, 0, 51));
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setText("4");
        jTextField22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridThree.add(jTextField22);

        jTextField23.setBackground(new java.awt.Color(204, 204, 204));
        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridThree.add(jTextField23);

        jTextField24.setBackground(new java.awt.Color(204, 204, 204));
        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridThree.add(jTextField24);

        jTextField25.setEditable(false);
        jTextField25.setBackground(new java.awt.Color(204, 204, 204));
        jTextField25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField25.setForeground(new java.awt.Color(255, 0, 51));
        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setText("6");
        jTextField25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        gridThree.add(jTextField25);

        jTextField26.setEditable(false);
        jTextField26.setBackground(new java.awt.Color(204, 204, 204));
        jTextField26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField26.setForeground(new java.awt.Color(255, 0, 51));
        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.setText("5");
        jTextField26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridThree.add(jTextField26);

        jTextField27.setBackground(new java.awt.Color(204, 204, 204));
        jTextField27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridThree.add(jTextField27);

        sudokuGame.add(gridThree);

        gridFour.setLayout(new java.awt.GridLayout(3, 3));

        jTextField28.setEditable(false);
        jTextField28.setBackground(java.awt.Color.white);
        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(255, 0, 51));
        jTextField28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField28.setText("5");
        jTextField28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridFour.add(jTextField28);

        jTextField29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridFour.add(jTextField29);

        jTextField30.setEditable(false);
        jTextField30.setBackground(java.awt.Color.white);
        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField30.setForeground(new java.awt.Color(255, 0, 51));
        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setText("9");
        jTextField30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });
        gridFour.add(jTextField30);

        jTextField31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridFour.add(jTextField31);

        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridFour.add(jTextField32);

        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridFour.add(jTextField33);

        jTextField34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridFour.add(jTextField34);

        jTextField35.setEditable(false);
        jTextField35.setBackground(java.awt.Color.white);
        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField35.setForeground(new java.awt.Color(255, 0, 51));
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField35.setText("4");
        jTextField35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridFour.add(jTextField35);

        jTextField36.setEditable(false);
        jTextField36.setBackground(java.awt.Color.white);
        jTextField36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField36.setForeground(new java.awt.Color(255, 0, 51));
        jTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField36.setText("8");
        jTextField36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridFour.add(jTextField36);

        sudokuGame.add(gridFour);

        gridfive.setBackground(new java.awt.Color(153, 153, 153));
        gridfive.setLayout(new java.awt.GridLayout(3, 3));

        jTextField37.setBackground(new java.awt.Color(204, 204, 204));
        jTextField37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridfive.add(jTextField37);

        jTextField38.setEditable(false);
        jTextField38.setBackground(new java.awt.Color(204, 204, 204));
        jTextField38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField38.setForeground(new java.awt.Color(255, 0, 51));
        jTextField38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField38.setText("3");
        jTextField38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridfive.add(jTextField38);

        jTextField39.setBackground(new java.awt.Color(204, 204, 204));
        jTextField39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridfive.add(jTextField39);

        jTextField41.setBackground(new java.awt.Color(204, 204, 204));
        jTextField41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridfive.add(jTextField41);

        jTextField42.setEditable(false);
        jTextField42.setBackground(new java.awt.Color(204, 204, 204));
        jTextField42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField42.setForeground(new java.awt.Color(255, 0, 51));
        jTextField42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField42.setText("7");
        jTextField42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridfive.add(jTextField42);

        jTextField43.setBackground(new java.awt.Color(204, 204, 204));
        jTextField43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridfive.add(jTextField43);

        jTextField44.setBackground(new java.awt.Color(204, 204, 204));
        jTextField44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridfive.add(jTextField44);

        jTextField45.setEditable(false);
        jTextField45.setBackground(new java.awt.Color(204, 204, 204));
        jTextField45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField45.setForeground(new java.awt.Color(255, 0, 51));
        jTextField45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField45.setText("2");
        jTextField45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridfive.add(jTextField45);

        jTextField46.setBackground(new java.awt.Color(204, 204, 204));
        jTextField46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridfive.add(jTextField46);

        sudokuGame.add(gridfive);

        gridSix.setLayout(new java.awt.GridLayout(3, 3));

        jTextField47.setEditable(false);
        jTextField47.setBackground(java.awt.Color.white);
        jTextField47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField47.setForeground(new java.awt.Color(255, 0, 51));
        jTextField47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField47.setText("7");
        jTextField47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField47ActionPerformed(evt);
            }
        });
        gridSix.add(jTextField47);

        jTextField48.setEditable(false);
        jTextField48.setBackground(java.awt.Color.white);
        jTextField48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField48.setForeground(new java.awt.Color(255, 0, 51));
        jTextField48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField48.setText("8");
        jTextField48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSix.add(jTextField48);

        jTextField49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSix.add(jTextField49);

        jTextField50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSix.add(jTextField50);

        jTextField51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSix.add(jTextField51);

        jTextField52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSix.add(jTextField52);

        jTextField53.setEditable(false);
        jTextField53.setBackground(java.awt.Color.white);
        jTextField53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField53.setForeground(new java.awt.Color(255, 0, 51));
        jTextField53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField53.setText("1");
        jTextField53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSix.add(jTextField53);

        jTextField54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSix.add(jTextField54);

        jTextField55.setEditable(false);
        jTextField55.setBackground(java.awt.Color.white);
        jTextField55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField55.setForeground(new java.awt.Color(255, 0, 51));
        jTextField55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField55.setText("3");
        jTextField55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSix.add(jTextField55);

        sudokuGame.add(gridSix);

        gridSeven.setBackground(new java.awt.Color(153, 153, 153));
        gridSeven.setLayout(new java.awt.GridLayout(3, 3));

        jTextField56.setBackground(new java.awt.Color(204, 204, 204));
        jTextField56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSeven.add(jTextField56);

        jTextField57.setEditable(false);
        jTextField57.setBackground(new java.awt.Color(204, 204, 204));
        jTextField57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField57.setForeground(new java.awt.Color(255, 0, 51));
        jTextField57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField57.setText("5");
        jTextField57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField57ActionPerformed(evt);
            }
        });
        gridSeven.add(jTextField57);

        jTextField58.setEditable(false);
        jTextField58.setBackground(new java.awt.Color(204, 204, 204));
        jTextField58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField58.setForeground(new java.awt.Color(255, 0, 51));
        jTextField58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField58.setText("2");
        jTextField58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSeven.add(jTextField58);

        jTextField59.setBackground(new java.awt.Color(204, 204, 204));
        jTextField59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSeven.add(jTextField59);

        jTextField60.setBackground(new java.awt.Color(204, 204, 204));
        jTextField60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSeven.add(jTextField60);

        jTextField61.setEditable(false);
        jTextField61.setBackground(new java.awt.Color(204, 204, 204));
        jTextField61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField61.setForeground(new java.awt.Color(255, 0, 51));
        jTextField61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField61.setText("1");
        jTextField61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSeven.add(jTextField61);

        jTextField62.setEditable(false);
        jTextField62.setBackground(new java.awt.Color(204, 204, 204));
        jTextField62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField62.setForeground(new java.awt.Color(255, 0, 51));
        jTextField62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField62.setText("3");
        jTextField62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField62ActionPerformed(evt);
            }
        });
        gridSeven.add(jTextField62);

        jTextField63.setBackground(new java.awt.Color(204, 204, 204));
        jTextField63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSeven.add(jTextField63);

        jTextField64.setBackground(new java.awt.Color(204, 204, 204));
        jTextField64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField64.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridSeven.add(jTextField64);

        sudokuGame.add(gridSeven);

        gridEight.setLayout(new java.awt.GridLayout(3, 3));

        jTextField65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField65.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridEight.add(jTextField65);

        jTextField66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridEight.add(jTextField66);

        jTextField67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField67.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridEight.add(jTextField67);

        jTextField68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridEight.add(jTextField68);

        jTextField69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridEight.add(jTextField69);

        jTextField70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridEight.add(jTextField70);

        jTextField71.setEditable(false);
        jTextField71.setBackground(java.awt.Color.white);
        jTextField71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField71.setForeground(new java.awt.Color(255, 0, 51));
        jTextField71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField71.setText("9");
        jTextField71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField71ActionPerformed(evt);
            }
        });
        gridEight.add(jTextField71);

        jTextField72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField72.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridEight.add(jTextField72);

        jTextField73.setEditable(false);
        jTextField73.setBackground(java.awt.Color.white);
        jTextField73.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField73.setForeground(new java.awt.Color(255, 0, 51));
        jTextField73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField73.setText("2");
        jTextField73.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridEight.add(jTextField73);

        sudokuGame.add(gridEight);

        gridNine.setBackground(new java.awt.Color(153, 153, 153));
        gridNine.setForeground(new java.awt.Color(255, 51, 102));
        gridNine.setLayout(new java.awt.GridLayout(3, 3));

        jTextField74.setBackground(new java.awt.Color(204, 204, 204));
        jTextField74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridNine.add(jTextField74);

        jTextField75.setEditable(false);
        jTextField75.setBackground(new java.awt.Color(204, 204, 204));
        jTextField75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField75.setForeground(new java.awt.Color(255, 0, 51));
        jTextField75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField75.setText("9");
        jTextField75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridNine.add(jTextField75);

        jTextField76.setBackground(new java.awt.Color(204, 204, 204));
        jTextField76.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField76.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridNine.add(jTextField76);

        jTextField77.setBackground(new java.awt.Color(204, 204, 204));
        jTextField77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField77.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridNine.add(jTextField77);

        jTextField78.setBackground(new java.awt.Color(204, 204, 204));
        jTextField78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField78.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridNine.add(jTextField78);

        jTextField79.setBackground(new java.awt.Color(204, 204, 204));
        jTextField79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField79.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridNine.add(jTextField79);

        jTextField80.setBackground(new java.awt.Color(204, 204, 204));
        jTextField80.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField80.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridNine.add(jTextField80);

        jTextField81.setBackground(new java.awt.Color(204, 204, 204));
        jTextField81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField81.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridNine.add(jTextField81);

        jTextField82.setEditable(false);
        jTextField82.setBackground(new java.awt.Color(204, 204, 204));
        jTextField82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField82.setForeground(new java.awt.Color(255, 0, 51));
        jTextField82.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField82.setText("5");
        jTextField82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField82ActionPerformed(evt);
            }
        });
        gridNine.add(jTextField82);

        sudokuGame.add(gridNine);

        jButton1.setText("Submit");
        jButton1.setToolTipText("Enters board to evaluate score");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Quit");
        jButton2.setToolTipText("Navigates to Main Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/images/sudokugfx.png"))); // NOI18N

        javax.swing.GroupLayout gameThreeLayout = new javax.swing.GroupLayout(gameThree);
        gameThree.setLayout(gameThreeLayout);
        gameThreeLayout.setHorizontalGroup(
            gameThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameThreeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sudokuGame, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 39, Short.MAX_VALUE)
                .addGroup(gameThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addGap(25, 25, 25))
        );
        gameThreeLayout.setVerticalGroup(
            gameThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameThreeLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(gameThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameThreeLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(222, 222, 222)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(sudokuGame, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(highScores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(credits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(gameTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(gameThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(gameOver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(highScores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(credits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(gameTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(gameThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(gameOver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void highScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highScoreButtonActionPerformed
        User[] user = scores.getUserArray();
        
        highScore_1.setText(user[0].getName() + "         " + user[0].getScore());
        highScore_2.setText(user[1].getName() + "         " + user[1].getScore());
        highScore_3.setText(user[2].getName() + "         " + user[2].getScore());
        highScore_4.setText(user[3].getName() + "         " + user[3].getScore());
        highScore_5.setText(user[4].getName() + "         " + user[4].getScore());
        
        menu.setVisible(false);
        credits.setVisible(false);
        highScores.setVisible(true);
        game.setVisible(false);
    }//GEN-LAST:event_highScoreButtonActionPerformed

    private void creditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsButtonActionPerformed
        menu.setVisible(false);   
        credits.setVisible(true);
        highScores.setVisible(false);
        game.setVisible(false);
    }//GEN-LAST:event_creditsButtonActionPerformed

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        hangManGame.reset();
        colorGame.reset();
        gameWordDisplay.setText(hangManGame.getDash());
        
        menu.setVisible(false);
        credits.setVisible(false);
        highScores.setVisible(false);
        game.setVisible(true);
        buttonReset();
        //gameWordDisplay.setText(hangManGame.getDash());
        hangManPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/retroClick/Pole.png")));
        //hangManGame.reset();
        hangManGame.print();
        
    }//GEN-LAST:event_startGameButtonActionPerformed

    private void highScoreBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_highScoreBackButtonMouseClicked
        menu.setVisible(true);       
        credits.setVisible(false);
        highScores.setVisible(false);
        game.setVisible(false);
    }//GEN-LAST:event_highScoreBackButtonMouseClicked

    private void highScoreBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highScoreBackButtonActionPerformed
        menu.setVisible(true);      
        credits.setVisible(false);
        highScores.setVisible(false);
        game.setVisible(false);
    }//GEN-LAST:event_highScoreBackButtonActionPerformed

    private void creditsBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creditsBackButtonMouseClicked
        menu.setVisible(true);
        credits.setVisible(false);
        highScores.setVisible(false);
        game.setVisible(false);
    }//GEN-LAST:event_creditsBackButtonMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          long time   = System.currentTimeMillis();
                long time2  = System.currentTimeMillis();
                while(time2 <= time+3000){
                time2 =System.currentTimeMillis();
                }
    }//GEN-LAST:event_formWindowOpened

    // method: updateGame
    // purpose: updates the hang man game based
    // on the user input. Updates the number of treis
    // as well as what the text will be if they win or lose
    private void updateGame() {
        hangManGame.print();
        //gameWordDisplay.setText(hangManGame.getDash());
        // Will draw letters or body here
        hangManGame.checkGameStatus();
        updatePicture(hangManGame.numberOfTries());
        if(hangManGame.gameOver()) {
            // We need to make a game over panel visible
            if(hangManGame.didWin()) {
                winOrLose.setText("YOU WON!");
                //gameOverPicture.setVisible(false);
            } else {
                winOrLose.setText("YOU LOST...");
                //gameOverPicture.setVisible(true);
            }
            playerScore.setText("Your Score: " + hangManGame.highScore());
            gameTwo.setVisible(true);
            game.setVisible(false);
        }
    }
    
    // method: updateGame2
    // purpose: will check the status of the color game
    // and update the game values accordingly
    private void updateGame2(){
        
        colorGame.print();
        colorGame.checkGameStatus();
        if(colorGame.gameOver()){
            playerScore.setText("Your Score: " + (colorGame.highScore()+hangManGame.highScore()));
            User[] us = scores.getUserArray();
            if(us[4].getScore() >= (hangManGame.highScore() + colorGame.highScore())) {
                saveHighScore.setEnabled(false);
                userInputName.setEnabled(false);
            }
            //gameOver.setVisible(true);
            gameTwo.setVisible(false);
            resetSudoku();
            gameThree.setVisible(true);
            
        }
    }
    
    private void updateGame3(){
        if(colorGame.gameOver()){
            playerScore.setText("Your Score: " + (colorGame.highScore()+hangManGame.highScore()+sGame.getScore()));
            User[] us = scores.getUserArray();
            if(us[4].getScore() >= (hangManGame.highScore() + colorGame.highScore())) {
                saveHighScore.setEnabled(false);
                userInputName.setEnabled(false);
            }
            gameOver.setVisible(true);
            //gameTwo.setVisible(false);
            gameThree.setVisible(false);
            
        }
    }
    
    
    private void updatePicture(int attempts) {
        switch (attempts) {
            case 1:
                hangManPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/retroClick/Head.png")));
                break;
            case 2:
                hangManPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/retroClick/Body.png")));
                break;
            case 3:
                hangManPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/retroClick/LeftArm.png")));
                break;
            case 4:
                hangManPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/retroClick/RightArm.png")));
                break;
            case 5:
                hangManPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/retroClick/LeftLeg.png")));
                break;
            case 6:
                hangManPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs245/swingProject/retroClick/DeadMan.png")));
                break;
            default:
                break;
        }
    }
    
    private void mainMenuFromGameOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuFromGameOverActionPerformed
        // TODO add your handling code here:
        //gameOverPicture.setVisible(false);
        
        menu.setVisible(true);
        gameOver.setVisible(false);
        userInputName.setText("");
    }//GEN-LAST:event_mainMenuFromGameOverActionPerformed

    private void zButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('z'));
        zButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_zButtonActionPerformed

    // Wanted to have all letter buttons go through this but currently
    // they are going through individual buttons
    private void letterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letterButtonActionPerformed
        // TODO add your handling code here:
        //        String text = evt.getActionCommand();
        //        char userInput = text.charAt(0);
        //        System.out.println("User: " + userInput);
        //        hangManGame.updateNumberOfTries(hangManGame.checkUserInput(userInput));
        //        hangManGame.print();
    }//GEN-LAST:event_letterButtonActionPerformed

    private void yButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('y'));
        yButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
        
    }//GEN-LAST:event_yButtonActionPerformed

    private void xButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('x'));
        xButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_xButtonActionPerformed

    private void wButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('w'));
        wButton.setEnabled(false);
        updateGame();
    }//GEN-LAST:event_wButtonActionPerformed

    private void vButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('v'));
        vButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_vButtonActionPerformed

    private void uButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('u'));
        uButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_uButtonActionPerformed

    private void tButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('t'));
        tButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_tButtonActionPerformed

    private void sButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('s'));
        sButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_sButtonActionPerformed

    private void rButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('r'));
        rButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_rButtonActionPerformed

    private void qButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('q'));
        qButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_qButtonActionPerformed

    private void pButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('p'));
        pButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_pButtonActionPerformed

    private void oButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('o'));
        oButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_oButtonActionPerformed

    private void nButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('n'));
        nButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_nButtonActionPerformed

    private void mButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('m'));
        mButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_mButtonActionPerformed

    private void lButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('l'));
        lButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_lButtonActionPerformed

    private void kButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('k'));
        kButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_kButtonActionPerformed

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('j'));
        jButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_jButtonActionPerformed

    private void iButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('i'));
        iButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_iButtonActionPerformed

    private void hButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('h'));
        hButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_hButtonActionPerformed

    private void gButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('g'));
        gButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_gButtonActionPerformed

    private void fButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('f'));
        fButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_fButtonActionPerformed

    private void eButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('e'));
        eButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_eButtonActionPerformed

    private void dButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('d'));
        dButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_dButtonActionPerformed

    private void cButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('c'));
        cButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_cButtonActionPerformed

    private void bButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('b'));
        bButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_bButtonActionPerformed

    private void aButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aButtonActionPerformed
        // TODO add your handling code here:
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('a'));
        aButton.setEnabled(false);
        updateGame();
        gameWordDisplay.setText(hangManGame.getDash());
    }//GEN-LAST:event_aButtonActionPerformed

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipButtonActionPerformed
        //gameWordDisplay.setText(hangManGame.getDash());
        hangManGame.updateNumberOfTries(hangManGame.checkUserInput('*'));
        playerScore.setText("Your Score: " + hangManGame.highScore());
        User[] us = scores.getUserArray();
            if(us[4].getScore() >= (hangManGame.highScore() + colorGame.highScore())) {
                saveHighScore.setEnabled(false);
                userInputName.setEnabled(false);
            }
        //gameOver.setVisible(true);
        game.setVisible(false);
        gameTwo.setVisible(true);
    }//GEN-LAST:event_skipButtonActionPerformed

    private void REDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_REDActionPerformed

    private void YELLOWMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YELLOWMouseEntered
        YELLOW.setBorderPainted(true);
    }//GEN-LAST:event_YELLOWMouseEntered

    private void YELLOWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YELLOWMouseExited
        YELLOW.setBorderPainted(false);
    }//GEN-LAST:event_YELLOWMouseExited

    private void REDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REDMouseEntered
        RED.setBorderPainted(true);
    }//GEN-LAST:event_REDMouseEntered

    private void REDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REDMouseExited
        RED.setBorderPainted(false);
    }//GEN-LAST:event_REDMouseExited

    private void GREENMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GREENMouseExited
        GREEN.setBorderPainted(false);
    }//GEN-LAST:event_GREENMouseExited

    private void GREENMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GREENMouseEntered
        GREEN.setBorderPainted(true);
    }//GEN-LAST:event_GREENMouseEntered

    private void BLUEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BLUEMouseEntered
        BLUE.setBorderPainted(true);
    }//GEN-LAST:event_BLUEMouseEntered

    private void BLUEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BLUEMouseExited
        BLUE.setBorderPainted(false);
    }//GEN-LAST:event_BLUEMouseExited

    private void PURPLEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PURPLEMouseEntered
        PURPLE.setBorderPainted(true);
    }//GEN-LAST:event_PURPLEMouseEntered

    private void PURPLEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PURPLEMouseExited
       PURPLE.setBorderPainted(false);
    }//GEN-LAST:event_PURPLEMouseExited

    private void YELLOWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YELLOWMouseClicked
        colorGame.updateNumberOfTries(colorGame.checkUserInput("YELLOW"));
        correctText.setText(colorGame.getWord());
        colorGame.print();
        setTextColor();
        updateGame2();
    }//GEN-LAST:event_YELLOWMouseClicked

    private void GREENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GREENMouseClicked
        colorGame.updateNumberOfTries(colorGame.checkUserInput("GREEN"));
        correctText.setText(colorGame.getWord());
        colorGame.print();
        setTextColor();
        updateGame2();
    }//GEN-LAST:event_GREENMouseClicked

    private void REDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REDMouseClicked
        colorGame.updateNumberOfTries(colorGame.checkUserInput("RED"));
        correctText.setText(colorGame.getWord());
        colorGame.print();
        setTextColor();
        updateGame2();
    }//GEN-LAST:event_REDMouseClicked

    private void PURPLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PURPLEMouseClicked
        colorGame.updateNumberOfTries(colorGame.checkUserInput("PURPLE"));
        correctText.setText(colorGame.getWord());
        colorGame.print();
        setTextColor();
        updateGame2();
    }//GEN-LAST:event_PURPLEMouseClicked


    private void BLUEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BLUEKeyPressed
         colorGame.updateNumberOfTries(colorGame.checkUserInput("BLUE"));
         correctText.setText(colorGame.getWord());
    }//GEN-LAST:event_BLUEKeyPressed

    // method: saveHighScoresActionPerfomred
    // purpose: will save the score if the user has a
    // name of 3 length, and will save the scores 
    // by serializing the file
    
    private void saveHighScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveHighScoreActionPerformed
        // TODO add your handling code here:
        String name = userInputName.getText();
        if(name.length() == 3) {
            scores.add(name, (hangManGame.highScore() + colorGame.highScore()));
            scores.save();
        }
        notifyUserToSave.setText("SCORE SAVED!");
        userInputName.setText("");
        saveHighScore.setEnabled(false);
        userInputName.setEnabled(false);
    }//GEN-LAST:event_saveHighScoreActionPerformed

    private void userInputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputNameActionPerformed
        // TODO add your handling code here:
       // userInputName.setText("");
    }//GEN-LAST:event_userInputNameActionPerformed

    // method: BlueMouseClicked
    // purpose: will check if the user chose the right
    // color and will update the game accordingly
    private void BLUEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BLUEMouseClicked
        colorGame.updateNumberOfTries(colorGame.checkUserInput("BLUE"));
        correctText.setText(colorGame.getWord());
        colorGame.print();
        setTextColor();
        updateGame2();
    }//GEN-LAST:event_BLUEMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField47ActionPerformed

    private void jTextField82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField82ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField82ActionPerformed

    private void jTextField71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField71ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField71ActionPerformed

    private void jTextField62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField62ActionPerformed

    private void jTextField57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField57ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField57ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[][] check = { 
                       {"8",jTextField2.getText(),jTextField3.getText(),"4",jTextField11.getText(),"6",jTextField19.getText(),jTextField20.getText(),"7"},
                       {jTextField4.getText(),jTextField5.getText(),jTextField6.getText(),jTextField13.getText(),jTextField14.getText(),jTextField15.getText(),"4",jTextField23.getText(),jTextField24.getText()},
                       {jTextField7.getText(),"1",jTextField9.getText(),jTextField16.getText(),jTextField17.getText(),jTextField18.getText(),"6","5",jTextField27.getText()},
                       {"5",jTextField29.getText(),"9",jTextField37.getText(),"3",jTextField39.getText(),"7","8",jTextField49.getText()},
                       {jTextField31.getText(),jTextField32.getText(),jTextField33.getText(),jTextField41.getText(),"7",jTextField43.getText(),jTextField50.getText(),jTextField51.getText(),jTextField52.getText()},
                       {jTextField34.getText(),"4","8",jTextField44.getText(),"2",jTextField46.getText(),"1",jTextField54.getText(),"3"},
                       {jTextField56.getText(),"5","2",jTextField65.getText(),jTextField66.getText(),jTextField67.getText(),jTextField74.getText(),"9",jTextField76.getText()},
                       {jTextField59.getText(),jTextField60.getText(),"1",jTextField68.getText(),jTextField69.getText(),jTextField70.getText(),jTextField77.getText(),jTextField78.getText(),jTextField79.getText()},
                       {"3",jTextField63.getText(),jTextField64.getText(),"9",jTextField72.getText(),"2",jTextField80.getText(),jTextField81.getText(),"5"} };
 
        boolean sudokuFinish = sGame.checkSolution(check);
        System.out.println(sGame.getScore());
        if (sudokuFinish) { 
            updateGame3();
        }
        else {
            JOptionPane.showMessageDialog(null, "Your solution is incorrect\nCurrent Score: " + sGame.getScore());       
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        gameThree.setVisible(false);
        updateGame3();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void YELLOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YELLOWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YELLOWActionPerformed

    
    
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GameWindow intr = new GameWindow();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        }});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BLUE;
    private javax.swing.JButton GREEN;
    private javax.swing.JButton PURPLE;
    private javax.swing.JButton RED;
    private javax.swing.JButton YELLOW;
    private javax.swing.JButton aButton;
    private javax.swing.JButton bButton;
    private javax.swing.JLabel brianLabel;
    private javax.swing.JButton cButton;
    private javax.swing.JLabel correctText;
    private javax.swing.JPanel credits;
    private javax.swing.JButton creditsBackButton;
    private javax.swing.JButton creditsButton;
    private javax.swing.JLabel creditsTitle;
    private javax.swing.JLabel crisitianLabel;
    private javax.swing.JButton dButton;
    private javax.swing.JButton eButton;
    private javax.swing.JButton fButton;
    private javax.swing.JButton gButton;
    private javax.swing.JPanel game;
    private javax.swing.JLabel gameClock;
    private javax.swing.JLabel gameClock1;
    private javax.swing.JLabel gameDate;
    private javax.swing.JLabel gameDate1;
    private javax.swing.JPanel gameOver;
    private javax.swing.JPanel gameThree;
    private javax.swing.JPanel gameTwo;
    private javax.swing.JLabel gameWordDisplay;
    private javax.swing.JPanel gridEight;
    private javax.swing.JPanel gridFour;
    private javax.swing.JPanel gridNine;
    private javax.swing.JPanel gridOne;
    private javax.swing.JPanel gridSeven;
    private javax.swing.JPanel gridSix;
    private javax.swing.JPanel gridThree;
    private javax.swing.JPanel gridTwo;
    private javax.swing.JPanel gridfive;
    private javax.swing.JButton hButton;
    protected javax.swing.JLabel hangManPicture;
    private javax.swing.JButton highScoreBackButton;
    private javax.swing.JButton highScoreButton;
    private javax.swing.JLabel highScoreTitleLabel;
    private javax.swing.JLabel highScore_1;
    private javax.swing.JLabel highScore_2;
    private javax.swing.JLabel highScore_3;
    private javax.swing.JLabel highScore_4;
    private javax.swing.JLabel highScore_5;
    private javax.swing.JPanel highScores;
    private javax.swing.JButton iButton;
    private javax.swing.JButton jButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField75;
    private javax.swing.JTextField jTextField76;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField80;
    private javax.swing.JTextField jTextField81;
    private javax.swing.JTextField jTextField82;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton kButton;
    private javax.swing.JLabel kartikLabel;
    private javax.swing.JLabel keanLabel;
    private javax.swing.JButton lButton;
    private javax.swing.JButton mButton;
    private javax.swing.JButton mainMenuFromGameOver;
    private javax.swing.JLabel mainMenuPicture;
    private javax.swing.JPanel menu;
    private javax.swing.JButton nButton;
    private javax.swing.JLabel notifyUserToSave;
    private javax.swing.JButton oButton;
    private javax.swing.JButton pButton;
    private javax.swing.JLabel playerScore;
    private javax.swing.JButton qButton;
    private javax.swing.JButton rButton;
    private javax.swing.JButton sButton;
    private javax.swing.JButton saveHighScore;
    private javax.swing.JLabel shaneLabel;
    private javax.swing.JButton skipButton;
    private javax.swing.JButton startGameButton;
    private javax.swing.JPanel sudokuGame;
    private javax.swing.JButton tButton;
    private javax.swing.JButton uButton;
    private javax.swing.JTextField userInputName;
    private javax.swing.JButton vButton;
    private javax.swing.JButton wButton;
    private javax.swing.JLabel winOrLose;
    private javax.swing.JButton xButton;
    private javax.swing.JButton yButton;
    private javax.swing.JButton zButton;
    // End of variables declaration//GEN-END:variables

    // method: setDefault 
    // purpose: will set the default visibility
    // of the screen when the game starts
    private void setDefault() {
        menu.setVisible(true);
        game.setVisible(false);
        highScores.setVisible(false);
        credits.setVisible(false);
        gameOver.setVisible(false);
        gameTwo.setVisible(false);
        gameThree.setVisible(false);
        
   
    }

    // method: buttonReset
    // purpose: will reset the buttons
    // for hang man letters for a new game
    private void buttonReset() {
        aButton.setEnabled(true);
        bButton.setEnabled(true);
        cButton.setEnabled(true);
        dButton.setEnabled(true);
        eButton.setEnabled(true);
        fButton.setEnabled(true);
        gButton.setEnabled(true);
        hButton.setEnabled(true);
        iButton.setEnabled(true);
        jButton.setEnabled(true);
        kButton.setEnabled(true);
        lButton.setEnabled(true);
        mButton.setEnabled(true);
        nButton.setEnabled(true);
        oButton.setEnabled(true);
        pButton.setEnabled(true);
        qButton.setEnabled(true);
        rButton.setEnabled(true);
        sButton.setEnabled(true);
        tButton.setEnabled(true);
        uButton.setEnabled(true);
        vButton.setEnabled(true);
        wButton.setEnabled(true);
        xButton.setEnabled(true);
        yButton.setEnabled(true);
        zButton.setEnabled(true);
        
        saveHighScore.setEnabled(true);
        notifyUserToSave.setText("Enter 3 initial name to save your high score.");
        userInputName.setEnabled(true);
    }

    // method: setTextColor
    // purpose: will randomly set the color
    // of the buttons to appear on screen
    private void setTextColor() {
        Random rand = new Random();
        int clr     = rand.nextInt(5);
        System.out.print("color" + clr);
        
        if(clr == 0){
            correctText.setForeground(Color.RED);//RED
            colorGame.setWinnnigColor("RED");
        }
        else if (clr == 1){
            correctText.setForeground(Color.YELLOW);//YELLOW
            colorGame.setWinnnigColor("YELLOW");
        }
        else if (clr == 2){
            correctText.setForeground(Color.GREEN);// GREEN
            colorGame.setWinnnigColor("GREEN");
        }
        else if (clr == 3){
            correctText.setForeground(Color.MAGENTA);// PURPLE
            colorGame.setWinnnigColor("PURPLE");
        }
        else if (clr == 4){
            correctText.setForeground(Color.BLUE);// BLUE
            colorGame.setWinnnigColor("BLUE");
        }//To change body of generated methods, choose Tools | Templates.
    }

    private void resetSudoku() {
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField9.setText("");
        jTextField11.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField27.setText("");
        jTextField29.setText("");
        jTextField31.setText("");
        jTextField32.setText("");
        jTextField33.setText("");
        jTextField34.setText("");
        jTextField37.setText("");
        jTextField39.setText("");
        jTextField41.setText("");
        jTextField43.setText("");
        jTextField44.setText("");
        jTextField46.setText("");
        jTextField49.setText("");
        jTextField50.setText("");
        jTextField51.setText("");
        jTextField52.setText("");
        jTextField54.setText("");
        jTextField56.setText("");
        jTextField59.setText("");
        jTextField60.setText("");
        jTextField63.setText("");
        jTextField64.setText("");
        jTextField65.setText("");
        jTextField66.setText("");
        jTextField67.setText("");
        jTextField68.setText("");
        jTextField69.setText("");
        jTextField70.setText("");
        jTextField72.setText("");
        jTextField74.setText("");
        jTextField76.setText("");
        jTextField77.setText("");
        jTextField78.setText("");
        jTextField79.setText("");
        jTextField80.setText("");
        jTextField81.setText("");
        
        
        
    }
    
    
}
