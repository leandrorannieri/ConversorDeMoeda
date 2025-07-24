import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMoedaGUI extends JFrame {

    private final JComboBox<String> comboOpcoes;
    private final JTextField campoValor;
    private final JLabel resultadoLabel;

    public ConversorMoedaGUI() {
        setTitle("Conversor de Moeda");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel titulo = new JLabel("    Conversor de Moeda    ", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo);

        comboOpcoes = new JComboBox<>(new String[]{
                "1 - Dólar (USD) → Real (BRL)",
                "2 - Euro (EUR) → Real (BRL)",
                "3 - Real (BRL) → Dólar (USD)",
                "4 - Real (BRL) → Euro (EUR)",
                "5 - Peso (ARS) → Real (BRL)",
                "6 - Real (BRL) → Peso (ARS)"
        });
        add(comboOpcoes);

        campoValor = new JTextField();
        campoValor.setHorizontalAlignment(JTextField.CENTER);
        campoValor.setToolTipText("Digite o valor a converter");
        add(campoValor);

        JButton botaoConverter = new JButton("Converter");
        add(botaoConverter);

        resultadoLabel = new JLabel("Resultado: ", JLabel.CENTER);
        add(resultadoLabel);

        botaoConverter.addActionListener(new ConverterListener());
    }

    private class ConverterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double valor = Double.parseDouble(campoValor.getText());
                int opcao = comboOpcoes.getSelectedIndex() + 1;

                final double USD_PARA_BRL = 5.10;
                final double EUR_PARA_BRL = 5.50;
                final double ARS_PARA_BRL = 0.025;

                final double BRL_PARA_USD = 1 / USD_PARA_BRL;
                final double BRL_PARA_EUR = 1 / EUR_PARA_BRL;
                final double BRL_PARA_ARS = 1 / ARS_PARA_BRL;

                double resultado = 0;
                String simboloOrigem = "", simboloDestino = "";

                switch (opcao) {
                    case 1:
                        resultado = valor * USD_PARA_BRL;
                        simboloOrigem = "USD";
                        simboloDestino = "BRL";
                        break;
                    case 2:
                        resultado = valor * EUR_PARA_BRL;
                        simboloOrigem = "EUR";
                        simboloDestino = "BRL";
                        break;
                    case 3:
                        resultado = valor * BRL_PARA_USD;
                        simboloOrigem = "BRL";
                        simboloDestino = "USD";
                        break;
                    case 4:
                        resultado = valor * BRL_PARA_EUR;
                        simboloOrigem = "BRL";
                        simboloDestino = "EUR";
                        break;
                    case 5:
                        resultado = valor * ARS_PARA_BRL;
                        simboloOrigem = "ARS";
                        simboloDestino = "BRL";
                        break;
                    case 6:
                        resultado = valor * BRL_PARA_ARS;
                        simboloOrigem = "BRL";
                        simboloDestino = "ARS";
                        break;
                    default:
                        resultadoLabel.setText("Opção inválida.");
                        return;
                }

                resultadoLabel.setText(String.format("Valor convertido de %s para %s: %.2f %s",
                        simboloOrigem, simboloDestino, resultado, simboloDestino));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        // Look and Feel do sistema operacional
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            ConversorMoedaGUI app = new ConversorMoedaGUI();
            app.setVisible(true);
        });
    }
}
