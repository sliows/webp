import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CardSwitchGame extends JFrame {
    public CardSwitchGame() {
        setTitle("카드 스위치게임");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        MyPanel panel = new MyPanel();
        c.add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private CardLabel cardArray[] = new CardLabel[12];

        public MyPanel() {
            setLayout(new GridLayout(3, 4, 10, 10));
            MouseClick mc = new MouseClick();

            for (int i = 0; i < cardArray.length; i++) {
                cardArray[i] = new CardLabel(i + 1);
                this.add(cardArray[i]);
                cardArray[i].addMouseListener(mc);
            }
        }

        public class MouseClick extends MouseAdapter {
            private CardLabel firstCard = null;
            private CardLabel prev[] = new CardLabel[2];

            public MouseClick() {
                firstCard = null;
                prev[0] = null;
                prev[1] = null;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (firstCard == null) {
                    if (prev[0] != null) {
                        prev[0].deSelect();
                        prev[1].deSelect();
                    }
                    firstCard = (CardLabel) e.getSource();
                    firstCard.select();
                    prev[0] = firstCard;

                } else {
                    CardLabel secondCard = (CardLabel) e.getSource();
                    secondCard.select();
                    prev[1] = secondCard;

                    int tmp = firstCard.getNumber();
                    firstCard.setNumber(secondCard.getNumber());
                    secondCard.setNumber(tmp);

                    firstCard = null;
                }
            }

        }
    }

    public class CardLabel extends JLabel {
        private int Number;
        private final static Color NORMAL_COLOR = Color.YELLOW;
        private final static Color SELECTED_COLOR = Color.MAGENTA;

        public CardLabel(int Number) {
            super();
            this.Number = Number;
            setText(Integer.toString(Number));
            setHorizontalAlignment(JLabel.CENTER);
            setBackground(NORMAL_COLOR);
            setOpaque(true);
            setFont(new Font("Gothic", Font.PLAIN, 20));
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int n) {
            Number = n;
            setText(Integer.toString(Number));
        }

        public void select() {
            setBackground(SELECTED_COLOR);
        }

        public void deSelect() {
            setBackground(NORMAL_COLOR);
        }
    }

    public static void main(String[] args) {
        new CardSwitchGame();
    }
}