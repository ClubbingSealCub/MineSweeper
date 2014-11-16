package view;

import presenter.MineSweeper;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import presenter.ExitAction;

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
        JMenuItem about = new JMenuItem("About");
        JMenuItem howToPlay = new JMenuItem("How To Play");
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
        helpMenu.add(about);
        helpMenu.add(howToPlay);
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
        about.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(helpMenu, "Game created by Daniel Roel Amat.", "About", JOptionPane.DEFAULT_OPTION);
        });
        howToPlay.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(helpMenu, "Find the empty squares and avoid the mines.\n"
                    + "Left click on a square to reveal it, It'll tell you how many mines are in its vecinity.\n"
                    + "If not a single mine is near it, it'll also reveal adjacent squares."
                    + "\nIf you step on a mine, you lose! Don't worry though, the first square you reveal will never be a mine.\n"
                    + "Right click a square to flag it. This helps you track possible mine spots.\n"
                    + "Reveal all safe squares while avoiding all mines to win!\n"
                    + "Beginner mode has 10 mines, Intermediate has 22 and Expert has 40.", "How to play", JOptionPane.INFORMATION_MESSAGE);
        });
        return menuBar;
    }
}
