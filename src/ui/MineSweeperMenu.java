package ui;

import presenter.MineSweeper;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import process.ExitAction;

public class MineSweeperMenu {

    public static JMenuBar menuBar() {
        String difficultySetting = "Beginner";
        ExitAction ea = new ExitAction();
        ea.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(gameMenu);
        menuBar.add(helpMenu);

        JMenuItem newGame = new JMenuItem("New");
        newGame.setAccelerator(KeyStroke.getKeyStroke("F2"));
        JRadioButtonMenuItem beginner = new JRadioButtonMenuItem("Beginner");
        JRadioButtonMenuItem intermediate = new JRadioButtonMenuItem("Intermediate");
        JRadioButtonMenuItem expert = new JRadioButtonMenuItem("Expert");
        JMenuItem exit = new JMenuItem("Exit");
        ButtonGroup difficulty = new ButtonGroup();
        difficulty.add(beginner);
        difficulty.add(intermediate);
        difficulty.add(expert);
        gameMenu.add(newGame);
        gameMenu.addSeparator();
        gameMenu.add(beginner);
        gameMenu.add(intermediate);
        gameMenu.add(expert);
        gameMenu.addSeparator();
        gameMenu.add(new JMenuItem(ea));
        newGame.addActionListener((ActionEvent e) -> {
            MineSweeperUI.Dispose();
            MineSweeper.startGame(MineSweeper.getDifficulty());
        });

        beginner.addActionListener((ActionEvent e) -> {
            MineSweeper.setDifficulty("Beginner");
        });

        intermediate.addActionListener((ActionEvent e) -> {
            MineSweeper.setDifficulty("Intermediate");
        });
        expert.addActionListener((ActionEvent e) -> {
            MineSweeper.setDifficulty("Expert");
        });

        return menuBar;
    }
}
