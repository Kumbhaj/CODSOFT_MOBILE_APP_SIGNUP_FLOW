import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SignupFlow extends JFrame {
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JButton signupButton;
    private JLabel messageLabel;

    public SignupFlow() {
        setTitle("Signup Flow");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(5, 1));

        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        signupButton = new JButton("Sign Up");
        messageLabel = new JLabel("Please fill in your details.");

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(signupButton);
        add(messageLabel);

        signupButton.addActionListener(new SignupButtonListener());

        setVisible(true);
    }

    private class SignupButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (validateInput(name, email, password)) {
                messageLabel.setText("Welcome, " + name + "! Signup successful.");
                // Proceed with storing user information securely
            } else {
                messageLabel.setText("Please fill out all fields correctly.");
            }
        }

        private boolean validateInput(String name, String email, String password) {
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                return false;
            }
            if (!email.contains("@") || !email.contains(".")) {
                messageLabel.setText("Invalid email format.");
                return false;
            }
            if (password.length() < 6) {
                messageLabel.setText("Password must be at least 6 characters.");
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        new SignupFlow();
    }
}
