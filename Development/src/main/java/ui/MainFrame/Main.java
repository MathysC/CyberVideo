package ui.MainFrame;

import ui.Decorations;
import ui.Bundles.Multilingual;
import ui.Pages.Welcome.WelcomePage;

import java.awt.BorderLayout;

import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * @author MathysC
 * Main Class of AL2000. Initialize the machine Interface.
 */
@SuppressWarnings("serial")
public class Main extends JFrame implements Multilingual {

    /*Components*/
    protected TopBar topBar = new TopBar();
    protected JLabel banner = new JLabel();
    protected WelcomePage welcomePage = new WelcomePage();

    /*Actions*/
    static final String SWITCHFR = "Switch_to_fr";
    static final String SWITCHEN = "Switch_to_en";

    /**
     * Constructor of Main.
     * Initialize the AL200 Main Window.
     * @author MathysC
     *
     */
    public Main() {
        super("AL2000");
        new Interaction(this);
        // Set options.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Add the Top Bar.
        this.add(this.topBar, BorderLayout.NORTH);

        // Add a banner.
        banner = new JLabel(Decorations.ICON_BANNER.getIcon());
        banner.setBorder(Decorations.BORDER_DEFAULT.getBorder());
        this.add(banner, BorderLayout.WEST);

        
        // Add the welcome page.
        this.add(welcomePage, BorderLayout.CENTER);
        this.setLanguage(this.getRbEN());
        this.pack();

        // Maximize the Window.
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Change all Main and Main’s Child text.
     * @author MathysC
     * @param rb the choosen language bundle.
     */
    @Override
    public void setLanguage(ResourceBundle rb) {
        // Set MainFrame Components text.

        // Set all multilingual child.
    	this.welcomePage.setLanguage(rb);
    }

    /**
     * Run the Main Window of AL2000.
     * @author MathysC
     * 
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}