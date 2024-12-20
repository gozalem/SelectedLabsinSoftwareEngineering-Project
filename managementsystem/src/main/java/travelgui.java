import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class travelgui extends JFrame {
    private JTextField destinationField;
    private JTextField dateField;
    private JTextField priceField;
    private JComboBox<String> accommodationCombo;
    private JComboBox<String> packageCombo;

    public travelgui() {
        setTitle("Travel Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createHomePage(), BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createHomePage() {
        JPanel homePanel = new JPanel(new BorderLayout());
        homePanel.setBackground(new Color(173, 216, 230));
        JLabel imageLabel = new JLabel();
        try {
            ImageIcon originalIcon = new ImageIcon("C:\\Users\\DELL\\Downloads\\6cf2b2169950287.Y3JvcCwxOTk5LDE1NjQsMCwyMTc.jpg");
            Image scaledImage = originalIcon.getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            imageLabel.setIcon(scaledIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        homePanel.add(imageLabel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Welcome to the Travel Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 102, 153));
        homePanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(173, 216, 230));

     
        JButton bookButton = new JButton("Book a Trip");
        bookButton.setFont(new Font("Arial", Font.BOLD, 16));
        bookButton.setBackground(new Color(0, 153, 204));
        bookButton.setForeground(Color.WHITE);
        bookButton.setPreferredSize(new Dimension(160, 50));
        bookButton.addActionListener(e -> showBookingPage());
        buttonPanel.add(bookButton);

      
        JButton userProfileButton = new JButton("User Profile");
        userProfileButton.setFont(new Font("Arial", Font.BOLD, 16));
        userProfileButton.setBackground(new Color(255, 165, 0));
        userProfileButton.setForeground(Color.WHITE);
        userProfileButton.setPreferredSize(new Dimension(160, 50));
        userProfileButton.addActionListener(e -> showUserProfilePage());
        buttonPanel.add(userProfileButton);

        homePanel.add(buttonPanel, BorderLayout.SOUTH);

        return homePanel;
    }

    private void showBookingPage() {
        JFrame bookingFrame = new JFrame("Booking Page");
        bookingFrame.setSize(800, 600);
        bookingFrame.setLayout(new BorderLayout());

      
        JLabel titleLabel = new JLabel("Book Your Trip", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 153));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        bookingFrame.add(titleLabel, BorderLayout.NORTH);

      
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

     
        destinationField = new JTextField(20);
        dateField = new JTextField(20);
        priceField = new JTextField(20);

     
        String[] accommodations = {"Hotel", "Hostel", "Resort"};
        accommodationCombo = new JComboBox<>(accommodations);
        String[] packages = {"Luxury", "Adventure", "Cultural"};
        packageCombo = new JComboBox<>(packages);

      
        addFormRow(formPanel, gbc, "Destination:", destinationField, 0);
        addFormRow(formPanel, gbc, "Date:", dateField, 1);
        addFormRow(formPanel, gbc, "Price:", priceField, 2);
        addFormRow(formPanel, gbc, "Accommodation:", accommodationCombo, 3);
        addFormRow(formPanel, gbc, "Package:", packageCombo, 4);

        bookingFrame.add(formPanel, BorderLayout.CENTER);

      
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton bookButton = new JButton("Book Now");
        bookButton.setBackground(new Color(0, 102, 153));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFont(new Font("Arial", Font.BOLD, 14));
        bookButton.setPreferredSize(new Dimension(150, 40));
        bookButton.addActionListener(e -> {
            try {
                String destination = destinationField.getText();
                String date = dateField.getText();
                double price = 0;
                try {
                    price = Double.parseDouble(priceField.getText());
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Invalid price format.");
                }

             
                Accommodation accommodation = AccommodationFactory.createAccommodation((String) accommodationCombo.getSelectedItem());
                TravelPackage travelPackage = PackageFactory.createPackage((String) packageCombo.getSelectedItem());

                
                Trip trip = new TripBuilder(destination, date, price)
                        .withAccommodation(accommodation.getDescription())
                        .withPackage(travelPackage.getDescription())
                        .build();

                
    
         BookingService bookingService = new BookingProxy(destination, date, price, travelPackage.getDescription(), accommodation.getDescription());
              String bookingSummary = bookingService.showBooking();


                
                JOptionPane.showMessageDialog(bookingFrame, bookingSummary, "Booking Details", JOptionPane.INFORMATION_MESSAGE);

             
                FlightBooking flightBooking = new FlightAdapter();
                String flightDetails = flightBooking.bookFlight(); 
                JOptionPane.showMessageDialog(bookingFrame, flightDetails, "Flight Booking", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(bookingFrame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });


        buttonPanel.add(bookButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setPreferredSize(new Dimension(150, 40));
        backButton.setBackground(new Color(255, 102, 102));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> bookingFrame.dispose());
        buttonPanel.add(backButton);
        bookingFrame.add(buttonPanel, BorderLayout.SOUTH);
        bookingFrame.setVisible(true);
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc, String label, JComponent field, int row) {
       
        gbc.gridx = 0; 
        gbc.gridy = row; 
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(labelComponent, gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private void showUserProfilePage() {
        
        UserProfileManager profileManager = UserProfileManager.getInstance();
        String userDetails = profileManager.getUserDetails();

      
        JFrame profileFrame = new JFrame("User Profile");
        profileFrame.setSize(500, 400);
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.setLayout(new BorderLayout(10, 10));

      
        JTextArea profileArea = new JTextArea();
        profileArea.setText(userDetails);  
        profileArea.setEditable(false);
        profileArea.setFont(new Font("Arial", Font.PLAIN, 14));
        profileArea.setBackground(new Color(240, 240, 240));
        profileArea.setMargin(new Insets(10, 10, 10, 10));
        profileFrame.add(new JScrollPane(profileArea), BorderLayout.CENTER);

      
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> profileFrame.dispose());
        profileFrame.add(backButton, BorderLayout.SOUTH);

        profileFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new travelgui());
    }
}