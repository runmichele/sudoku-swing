import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGUI extends JFrame {
    private JTextField[][] cells = new JTextField[9][9];
    private SudokuBoard board;

    public SudokuGUI() {
        board = new SudokuBoard();
        setTitle("Sudoku");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel grid = new JPanel(new GridLayout(9, 9));
        Font font = new Font("Arial", Font.BOLD, 20);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFont(font);
                grid.add(cells[i][j]);
            }
        }

        JButton solveBtn = new JButton("Resolver");
        solveBtn.addActionListener(e -> solveSudoku());

        add(grid, BorderLayout.CENTER);
        add(solveBtn, BorderLayout.SOUTH);
    }

    private void solveSudoku() {
        // Carrega valores da interface para o board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String text = cells[i][j].getText();
                board.board[i][j] = text.isEmpty() ? 0 : Integer.parseInt(text);
            }
        }

        if (SudokuSolver.solve(board)) {
            // Mostra o resultado na interface
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    cells[i][j].setText(String.valueOf(board.board[i][j]));
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sem solução!");
        }
    }
}
