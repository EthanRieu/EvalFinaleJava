package GUI;

import Model.Pilote;
import Model.VoitureF1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGUI {
    private JFrame frame;
    private List<Pilote> pilotes;
    private List<VoitureF1> voitures;
    private int currentLap;
    private Timer lapTimer;
    private Random random;
    private JTextArea raceStatusArea;
    private JPanel pilotPanel;

    public RaceGUI() {
        pilotes = new ArrayList<>();
        voitures = new ArrayList<>();
        currentLap = 0;
        random = new Random();

        initialize();
    }

    private void initialize() {
        frame = new JFrame("Gestion de Course F1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        pilotPanel = new JPanel();
        pilotPanel.setLayout(new BoxLayout(pilotPanel, BoxLayout.Y_AXIS));
        pilotPanel.setBorder(BorderFactory.createTitledBorder("Pilotes"));

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JButton addPilotButton = new JButton("Ajouter Pilote");
        addPilotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPilot();
            }
        });

        JButton startRaceButton = new JButton("Démarrer Course");
        startRaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRace();
            }
        });

        controlPanel.add(addPilotButton);
        controlPanel.add(startRaceButton);

        raceStatusArea = new JTextArea();
        raceStatusArea.setEditable(false);

        frame.add(pilotPanel, BorderLayout.WEST);
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(raceStatusArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void addPilot() {
        if (pilotes.size() >= 2) {
            JOptionPane.showMessageDialog(frame, "Maximum de 2 pilotes atteint.");
            return;
        }

        String nom = JOptionPane.showInputDialog(frame, "Nom du pilote:");
        String prenom = JOptionPane.showInputDialog(frame, "Prénom du pilote:");

        if (nom != null && prenom != null && !nom.isEmpty() && !prenom.isEmpty()) {
            Pilote pilote = new Pilote(nom, prenom);
            pilotes.add(pilote);
            voitures.add(new VoitureF1("F1-" + (voitures.size() + 1), pilote));
            pilotPanel.add(new JLabel(prenom + " " + nom));
            pilotPanel.revalidate();
            pilotPanel.repaint();
            JOptionPane.showMessageDialog(frame, "Pilote ajouté: " + prenom + " " + nom);
        }
    }

    private void startRace() {
        if (pilotes.size() < 1) {
            JOptionPane.showMessageDialog(frame, "Ajoutez au moins un pilote pour démarrer la course.");
            return;
        }

        currentLap = 0;
        lapTimer = new Timer(40000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentLap++;
                System.out.println("Tour " + currentLap); // Message de débogage
                updateRaceStatus();
                checkPitStopProbability();
                if (currentLap >= 70) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        lapTimer.start();
        System.out.println("Course démarrée"); // Message de débogage
    }

    private void updateRaceStatus() {
        for (VoitureF1 voiture : voitures) {
            raceStatusArea.append(voiture.getPilote().getPrenom() + " " + voiture.getPilote().getNom() + " a passé le tour " + currentLap + "/70\n");
        }
    }

    private void checkPitStopProbability() {
        for (VoitureF1 voiture : voitures) {
            double probability = 0.01 * currentLap; // Probabilité augmente avec le nombre de tours
            if (random.nextDouble() < probability) {
                JOptionPane.showMessageDialog(frame, "Arrêt au stand nécessaire pour la voiture: " + voiture.getModele());
                // Réinitialiser la probabilité après un arrêt au stand
                currentLap = 0;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RaceGUI();
            }
        });
    }
}
