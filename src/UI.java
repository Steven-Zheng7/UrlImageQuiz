import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class UI implements ActionListener {
    //question
    String question = "Who is this character?";
    //answer choices
    String[][] options = {
            {"Nero", "Jotaro", "Caesar", "Arthur"},
            {"Gon", "Killua", "Ichigo", "Kazuma"},
            {"Goku", "Black Goku", "Zamasu", "Evil Goku"}
    };
    //URL linkes to images
    String[] urlArrQuiz = {
            "https://gamepress.gg/grandorder/sites/grandorder/files/styles/servant_image/public/2017-07/005%20Nero%20Claudius%204.png?itok=F5Z2fzEQ",
            "https://static0.cbrimages.com/wordpress/wp-content/uploads/2021/03/Killua-Cropped.jpg?q=50&fit=crop&w=740&h=370&dpr=1.5",
            "https://static.wikia.nocookie.net/dragonball/images/b/b8/Super_Saiyan_Rose.png/revision/latest/scale-to-width-down/1000?cb=20190211104411"
    };

    //hints
    String[][] hints = {
            {"She is from a popular mobile game in japan.", "She is model after a Roman emperor", "Her last name is Claudis"},
            {"He is from HunterxHunter", "He is one of the major side character", "He is an assassin"},
            {"Divine Justice", "New order", "peasants"}
    };
    //ArrayList to store imageIcon after running it through for loop
    ArrayList<ImageIcon> quizPic = new ArrayList<>();

    //answer key
    char[] answer = {
            'A',
            'B',
            'C'
    };


    char choice;
    int index;
    double correctGuesses = 0;
    double totalQuestion = answer.length;
    double result;
    int seconds = 20;
    int hintCount = 0;

    //frame declaration
    JFrame frame = new JFrame();

    //cardLayout
    CardLayout layout = new CardLayout();

    //creating panel
    JPanel panelContainer = new JPanel();
    JPanel panelStart = new JPanel();
    JPanel panelInfo = new JPanel();
    JPanel panelQuiz = new JPanel();
    JPanel panelResult = new JPanel();
    JPanel panelDownload = new JPanel();

    //Start Button
    JButton buttonStart = new JButton();

    //Info button
    JButton buttonInfo = new JButton();

    // Main Screen Button
    JButton buttonQuizA = new JButton();
    JButton buttonQuizB = new JButton();
    JButton buttonQuizC = new JButton();
    JButton buttonQuizD = new JButton();

    //Labels options for buttons
    JLabel optionA = new JLabel();
    JLabel optionB = new JLabel();
    JLabel optionC = new JLabel();
    JLabel optionD = new JLabel();
    JLabel results = new JLabel();
    JLabel resultIn = new JLabel();
    JLabel downloadReward = new JLabel();
    JLabel downloadRewardTwo = new JLabel();
    JLabel hintBoxOne = new JLabel();
    JLabel hintBoxTwo = new JLabel();
    JLabel hintBoxThree = new JLabel();
    JLabel hintTitle = new JLabel();

    //Main Screen Button Textfields;
    JTextField textfield = new JTextField();


    //Text Area
    JTextArea textArea = new JTextArea();
    JTextArea infoText = new JTextArea();

    //Result Screen
    JButton buttonScore = new JButton();

    //Last Screen
    JButton buttonDownload = new JButton();

    //JLabel as image
    JLabel image = new JLabel();
    JLabel imageTitle = new JLabel();
    JLabel imageOne = new JLabel();
    JLabel jebait = new JLabel();

    //Time label
    JLabel timeLabel = new JLabel();
    JLabel secondsLeft = new JLabel();

    //hint button
    JButton hintButton = new JButton();

    //hint left
    JLabel hintLeft = new JLabel();


    public UI() throws IOException {
        //basic frame declaration
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setResizable(false);

        //info text
        infoText.setBounds(100, 100, 900, 500);
        infoText.setLineWrap(true); //if the text go off the screen, it will move to next line
        infoText.setWrapStyleWord(true);
        infoText.setBackground(Color.RED);
        infoText.setForeground(new Color(25, 25, 25));
        infoText.setFont(new Font("Pixal Font", Font.BOLD, 30));
        infoText.setEditable(false);
        infoText.setText("1)GUESS THE ANIME CHARACTER IN THE PICTURE.\n2)YOU WILL HAVE 30 SECONDS EACH QUESTION.\n3)GOOD LUCK.");

        //setting of textfield properties for main screen
        textfield.setBounds(0,0,500,50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Pixal Font", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        //text area properties
        textArea.setBounds(0, 60, 500, 50);
        textArea.setLineWrap(true); //if the text go off the screen, it will move to next line
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25, 255, 0));
        textArea.setFont(new Font("Pixal Font", Font.BOLD, 30));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        //setting of button properties
        buttonStart.setBounds(420, 500, 160, 80);
        buttonStart.setFont(new Font("Ink Free", Font.BOLD, 30));
        buttonStart.setText("BEGIN");

        buttonInfo.setBounds(420,500,160,80);
        buttonInfo.setFont(new Font("Pixal Font", Font.BOLD, 30));
        buttonInfo.setText("START");

        buttonQuizA.setBounds(50,400,160,80);
        buttonQuizA.setFont(new Font("Pixal Font", Font.BOLD,30));
        buttonQuizA.setText("A");
        buttonQuizA.addActionListener(this);

        buttonQuizB.setBounds(50,550,160,80);
        buttonQuizB.setFont(new Font("Pixal Font", Font.BOLD,30));
        buttonQuizB.setText("B");
        buttonQuizB.addActionListener(this);

        buttonQuizC.setBounds(500,400,160,80);
        buttonQuizC.setFont(new Font("Pixal Font", Font.BOLD,30));
        buttonQuizC.setText("C");
        buttonQuizC.addActionListener(this);

        buttonQuizD.setBounds(500,550,160,80);
        buttonQuizD.setFont(new Font("Pixal Font", Font.BOLD,30));
        buttonQuizD.setText("D");
        buttonQuizD.addActionListener(this);

        // Result Button
        buttonScore.setBounds(420,500,160,80);
        buttonScore.setFont(new Font("Pixal Font", Font.BOLD,30));
        buttonScore.setText("Next");

        // Download Screen Button
        buttonDownload.setBounds(400,300,160,80);
        buttonDownload.setFont(new Font("Pixal Font", Font.BOLD,20));
        buttonDownload.setText("Download");

        //hint Button
        hintButton.setBounds(525, 10, 100, 100);
        hintButton.setFont(new Font("Pixal Font", Font.BOLD, 20));
        hintButton.setText("Hint");



        //setting answer labels
        optionA.setBounds(210,400,400,80);
        optionA.setForeground(new Color(25,25,25));
        optionA.setFont(new Font("Pixal Font",Font.BOLD,30));
        optionA.setText("Artoria Pendragon");

        optionB.setBounds(210,550,400,80);
        optionB.setForeground(new Color(25,25,25));
        optionB.setFont(new Font("Pixal Font",Font.BOLD,30));
        optionB.setText("Artoria Pendragon");

        optionC.setBounds(660,400,400,80);
        optionC.setForeground(new Color(25,25,25));
        optionC.setFont(new Font("Pixal Font",Font.BOLD,30));
        optionC.setText("Artoria Pendragon");

        optionD.setBounds(660,550,400,80);
        optionD.setForeground(new Color(25,25,25));
        optionD.setFont(new Font("Pixal Font",Font.BOLD,30));
        optionD.setText("Artoria Pendragon");

        // Results Screen Label
        results.setBounds(400,250,400,80);
        results.setForeground(new Color(200,30,40));
        results.setFont(new Font("Pixal Font",Font.BOLD,30));
        results.setText("You Scored:");

        //time Label
        secondsLeft.setBounds(525,275,100,100);
        secondsLeft.setBackground(new Color(25,25,25));
        secondsLeft.setForeground(new Color(255,0,0));
        secondsLeft.setFont(new Font("Ink Free", Font.BOLD,60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(525, 250, 100, 25);
        timeLabel.setBackground(new Color(25, 25, 25));
        timeLabel.setForeground(new Color(255,0,0));
        timeLabel.setFont(new Font("Ink Free",Font.PLAIN,20));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment((JTextField.CENTER));
        timeLabel.setText("Timer: ");

        hintBoxOne.setBounds(650, 60, 325, 100);
        hintBoxOne.setBackground(new Color(25, 25, 25));
        hintBoxOne.setForeground(new Color(255,0,0));
        hintBoxOne.setFont(new Font("Ink Free",Font.BOLD,15));
        hintBoxOne.setBorder(BorderFactory.createBevelBorder(1));
        hintBoxOne.setOpaque(true);
        hintBoxOne.setHorizontalAlignment((JTextField.CENTER));

        hintBoxTwo.setBounds(650, 160, 325, 100);
        hintBoxTwo.setBackground(new Color(25, 25, 25));
        hintBoxTwo.setForeground(new Color(255,0,0));
        hintBoxTwo.setFont(new Font("Ink Free",Font.BOLD,15));
        hintBoxTwo.setBorder(BorderFactory.createBevelBorder(1));
        hintBoxTwo.setOpaque(true);
        hintBoxTwo.setHorizontalAlignment((JTextField.CENTER));

        hintBoxThree.setBounds(650, 260, 325, 100);
        hintBoxThree.setBackground(new Color(25, 25, 25));
        hintBoxThree.setForeground(new Color(255,0,0));
        hintBoxThree.setFont(new Font("Ink Free",Font.BOLD,15));
        hintBoxThree.setBorder(BorderFactory.createBevelBorder(1));
        hintBoxThree.setOpaque(true);
        hintBoxThree.setHorizontalAlignment((JTextField.CENTER));

        hintTitle.setBounds(650,10,325,50);
        hintTitle.setBackground(new Color(25,25,25));
        hintTitle.setForeground(new Color(255,0,0));
        hintTitle.setFont(new Font("Ink Free", Font.BOLD,60));
        hintTitle.setBorder(BorderFactory.createBevelBorder(1));
        hintTitle.setOpaque(true);
        hintTitle.setHorizontalAlignment(JTextField.CENTER);
        hintTitle.setText("HINTS");

        hintLeft.setBounds(525, 130, 100, 100);
        hintLeft.setBackground(new Color(25,25,25));
        hintLeft.setForeground(new Color(255,0,0));
        hintLeft.setFont(new Font("Ink Free", Font.BOLD,50));
        hintLeft.setBorder(BorderFactory.createBevelBorder(1));
        hintLeft.setOpaque(true);
        hintLeft.setHorizontalAlignment(JTextField.CENTER);
        hintLeft.setText("0/3");


        // Download Screen Label
        downloadReward.setBounds(570,300,500,250);
        URL url4 = new URL("https://www.vhv.rs/dpng/d/414-4145119_transparent-pointing-finger-png-big-finger-point-png.png");
        Image urlImg4 = ImageIO.read(url4);
        ImageIcon icon4 = new ImageIcon(urlImg4);
        Image scaledImg4 = icon4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        icon4 = new ImageIcon(scaledImg4);
        downloadReward.setIcon(icon4);
        /****
         downloadRewardTwo.setBounds(0,300,500,250);
         URL url6 = new URL("https://www.pngkit.com/png/full/6-65553_pointing-finger-png-free-pointing-finger-clipart.png");
         Image urlImg6 = ImageIO.read(url6);
         ImageIcon icon5 = new ImageIcon(urlImg6);
         Image scaledImg5 = icon5.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
         icon5 = new ImageIcon(scaledImg5);
         downloadRewardTwo.setIcon(icon5);
         ***/

        //background
        image.setBounds(0,0,1000,700);
        URL url = new URL("https://external-preview.redd.it/HFIDcIjI3kOScb9jyAVge6Mmno9ugaYM7mROjzhLRWE.jpg?width=960&crop=smart&auto=webp&s=02bb30627ed76ee8e4af0d13e125f407d9b58175");
        Image urlImg = ImageIO.read(url);
        ImageIcon icon = new ImageIcon(urlImg);
        Image scaledImg = icon.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        icon = new ImageIcon(scaledImg);
        image.setIcon(icon);

        //title place holder
        imageTitle.setBounds(300,100,400,300);
        URL urlTitle = new URL("https://media.discordapp.net/attachments/835148175760949299/859650778536738816/Untitled_Artwork1169.png?width=810&height=1080");
        Image urlImgTitle = ImageIO.read(urlTitle);
        ImageIcon iconTitle = new ImageIcon(urlImgTitle);
        Image scaledImgTitle = iconTitle.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        iconTitle = new ImageIcon(scaledImgTitle);
        imageTitle.setIcon(iconTitle);


        // panelQuiz image
        imageOne.setBounds(0,125,500,250);
        //setting for loop to add image into arrayList
        for(int a = 0; a < totalQuestion; a++) {
            URL urlQuiz = new URL(urlArrQuiz[a]);
            Image urlImgQuiz = ImageIO.read(urlQuiz);
            ImageIcon iconQuiz = new ImageIcon(urlImgQuiz);
            Image scaledQuizImg = iconQuiz.getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT);
            quizPic.add(new ImageIcon(scaledQuizImg));
        }

        // Results Screen Text
        resultIn.setBounds(250,0,500,300);
        URL url3 = new URL("https://contenthub-static.grammarly.com/blog/wp-content/uploads/2019/04/thumbnail-7075f02d50b2e1b87acaac02e0592003.jpeg");
        Image urlImg5 = ImageIO.read(url3);
        ImageIcon icon3 = new ImageIcon(urlImg5);
        Image scaledImg3 = icon3.getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT);
        icon3 = new ImageIcon(scaledImg3);
        resultIn.setIcon(icon3);

        //show hidden image
        jebait.setBounds(250,0,500,300);
        URL urlJebait = new URL("https://cdn1.dotesports.com/wp-content/uploads/2021/03/27104612/jebaited.jpg");
        Image imgJebait = ImageIO.read(urlJebait);
        ImageIcon iconJebait = new ImageIcon(imgJebait);
        Image scaledJebait = iconJebait.getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT);
        iconJebait = new ImageIcon(scaledJebait);
        ImageIcon finalIconJebait = iconJebait;


        //panelStart.setBackground(Color.orange);
        panelInfo.setBackground(Color.red);
        panelQuiz.setBackground(Color.pink);

        // Result Screen
        panelResult.setBackground(Color.yellow);

        // Download Screen
        panelDownload.setBackground(Color.CYAN);




        //adding button to frame
        panelStart.add(imageTitle);
        panelStart.add(image);
        panelStart.add(buttonStart);
        panelInfo.add(buttonInfo);
        panelInfo.add(infoText);
        //main screen starts
        panelQuiz.add(textfield);
        panelQuiz.add(textArea);
        panelQuiz.add(buttonQuizA);
        panelQuiz.add(buttonQuizB);
        panelQuiz.add(buttonQuizC);
        panelQuiz.add(buttonQuizD);
        panelQuiz.add(imageOne);
        panelQuiz.add(optionA);
        panelQuiz.add(optionB);
        panelQuiz.add(optionC);
        panelQuiz.add(optionD);
        panelQuiz.add(timeLabel);
        panelQuiz.add(secondsLeft);
        panelQuiz.add(hintBoxOne);
        panelQuiz.add(hintBoxTwo);
        panelQuiz.add(hintBoxThree);
        panelQuiz.add(hintTitle);
        panelQuiz.add(hintButton);
        panelQuiz.add(hintLeft);

        //end of main screen
        panelResult.add(buttonScore);
        panelResult.add(results);
        panelResult.add(resultIn);
        panelDownload.add(buttonDownload);
        panelDownload.add(downloadReward);
        panelDownload.add(downloadRewardTwo);
        panelDownload.add(jebait);


        //setting card layout
        panelContainer.setLayout(layout);


        //disabling default layout
        panelStart.setLayout(null);
        panelInfo.setLayout(null);
        panelQuiz.setLayout(null);
        panelResult.setLayout(null);
        panelDownload.setLayout(null);

        panelContainer.add(panelStart, "1");
        panelContainer.add(panelInfo, "2");
        panelContainer.add(panelQuiz, "3");
        panelContainer.add(panelResult, "4");
        panelContainer.add(panelDownload, "5");
        layout.show(panelContainer, "1");

        //button action listener for start, info, result, and download
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(panelContainer, "2");
            }
        });

        buttonInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startQuiz();
            }
        });

        buttonScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                layout.show(panelContainer, "5");
            }
        });

        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hintCount < 3) {
                    if(hintCount == 0) {
                        hintBoxOne.setText(hints[index][0]);
                    }
                    if(hintCount == 1) {
                        hintBoxTwo.setText(hints[index][1]);
                    }
                    if(hintCount == 2) {
                        hintBoxThree.setText(hints[index][2]);
                    }
                    hintCount++;
                    hintLeft.setText(hintCount + "/3");
                }
                else {
                    hintButton.setEnabled(false);
                }
            }
        });



        buttonDownload.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jebait.setIcon(finalIconJebait);
                panelDownload.remove(buttonDownload);
                panelDownload.repaint();
            }
        });

        frame.add(panelContainer);
        frame.setVisible(true); //<<this was moved here cuz the text wouldn't appear on screen4
    }

    public void startQuiz() {

        //switching screen
        layout.show(panelContainer, "3");
        nextQuestion();


    }
    Timer timer = new Timer(700, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));

            if(seconds == 0) {
                displayAnswer();
            }
        }
    });
    public void nextQuestion() {
        if(index >= totalQuestion) {
            System.out.println(correctGuesses);
            result = (correctGuesses/totalQuestion)*100;
            results.setText("You scored: " + result + "%");
            layout.show(panelContainer, "4");
        }
        else {
            textfield.setText("Question " + (index + 1));
            textArea.setText(question);
            imageOne.setIcon(quizPic.get(index));
            optionA.setText(options[index][0]);
            optionB.setText(options[index][1]);
            optionC.setText(options[index][2]);
            optionD.setText(options[index][3]);

            hintCount = 0;
            hintBoxOne.setText("");
            hintBoxTwo.setText("");
            hintBoxThree.setText("");
            hintLeft.setText("0/3");
            hintButton.setEnabled(true);
            timer.start();

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //disable button
        buttonQuizA.setEnabled(false);
        buttonQuizB.setEnabled(false);
        buttonQuizC.setEnabled(false);
        buttonQuizD.setEnabled(false);

        if(e.getSource() == buttonQuizA) {
            choice = 'A';
            if(choice == answer[index]) {
                correctGuesses++;
            }
        }

        if(e.getSource() == buttonQuizB) {
            choice = 'B';
            if(choice == answer[index]) {
                correctGuesses++;
            }
        }

        if(e.getSource() == buttonQuizC) {
            choice = 'C';
            if(choice == answer[index]) {
                correctGuesses++;
            }
        }

        if(e.getSource() == buttonQuizD) {
            choice = 'D';
            if(choice == answer[index]) {
                correctGuesses++;
            }
        }
        System.out.println("Reached");

        displayAnswer();
    }
    public void displayAnswer() {
        buttonQuizA.setEnabled(false);
        buttonQuizB.setEnabled(false);
        buttonQuizC.setEnabled(false);
        buttonQuizD.setEnabled(false);

        if(answer[index] != 'A') {
            optionA.setForeground(new Color(255,0,0));
        }
        if(answer[index] != 'B') {
            optionB.setForeground(new Color(255,0,0));
        }
        if(answer[index] != 'C') {
            optionC.setForeground(new Color(255,0,0));
        }
        if(answer[index] != 'D') {
            optionD.setForeground(new Color(255,0,0));
        }

        if(answer[index] == 'A') {
            optionA.setForeground(new Color(25,255,0));
        }
        if(answer[index] == 'B') {
            optionB.setForeground(new Color(25,255,0));
        }
        if(answer[index] == 'C') {
            optionC.setForeground(new Color(25,255,0));
        }
        if(answer[index] == 'D') {
            optionD.setForeground(new Color(25,255,0));
        }

        Timer pause = new Timer(700, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonQuizA.setEnabled(true);
                buttonQuizB.setEnabled(true);
                buttonQuizC.setEnabled(true);
                buttonQuizD.setEnabled(true);

                optionA.setForeground(new Color(25,25,25));
                optionB.setForeground(new Color(25,25,25));
                optionC.setForeground(new Color(25,25,25));
                optionD.setForeground(new Color(25,25,25));

                seconds = 20;
                choice = ' ';
                secondsLeft.setText(String.valueOf(seconds));

                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
}