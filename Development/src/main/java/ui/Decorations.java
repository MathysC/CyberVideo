package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * Enumerations of all parameters used.
 * 
 * TODO: Find a better way to represent this ugly code.
 * 
 * @author MathysC
 * 
 */
public enum Decorations {

    // Dimensions
    DIM_BUTTON(new Dimension(100, 100)),
    DIM_LOGO(new Dimension(200, 150)),

    // Icons
    IMG_LOGO("Light_Logo"),
    IMG_BUTTON("Test_Button"),
    IMG_CURRENTFR("CurrentFR"),
    IMG_CURRENTEN("CurrentEN"),
    IMG_CURRENTLIGHT("CurrentLight"),
    IMG_CURRENTDARK("CurrentDark"),
    IMG_BANNERIT("BannerIT"),
    IMG_BANNERPOLICE("BannerPOLICE"),
    IMG_BANNERDESERT("BannerDESERT"),
    IMG_FILM("Test_Film"), // TODO
    ICO_KEYBOARD("edit"),

    // Borders
    BORDER_DEFAULT(new EmptyBorder(10, 10, 10, 10)),

	// Fonts
	FONT_BASIC("Helvetica"),
	FONT_PLACEHOLDER("Monospaced");
    private Object decoration;
    private static String PREFIXPATH = "resources/";
    private static String FORMATIMAGE = ".png";

    Decorations(Object o) {
        this.decoration = o;
    }

    /**
     * Get the enumerated Dimension
     * @author MathysC
     *
     * @return Dimension if the enumerated element name’s start with "DIM_";
     */
    public Dimension getDimension() {
        if (this.name().startsWith("DIM_"))
            return (Dimension) this.decoration;
        else
            return null;
    }

    /**
     * Get the enumerated Image
     * @author MathysC
     *
     * @return ImageIcon if the enumerated element name’s start with "IMG_";
     */
    public ImageIcon getImg() {
        if (this.name().startsWith("IMG_"))
            return new ImageIcon(PREFIXPATH + (String) this.decoration + FORMATIMAGE);
        else
            return null;
    }

    /**
     * Get the enumerated Border
     * @author MathysC
     *
     * @return Border if the enumerated element name’s start with "BORDER_";
     */
    public Border getBorder() {
        if (this.name().startsWith("BORDER_"))
            return (Border) this.decoration;
        else
            return null;
    }
    
    
    /**
     * Get the enumerated Font
     * @author MathysC
     *
     * @param style The style of the font.
     * @param size	The size of the font.
     * @return Font if the enumerated element name’s start with "FONT_";
     */
    public Font getFont(int style, int size) {
        if (this.name().startsWith("FONT_"))
            return new Font(this.decoration.toString(),style,size);
        else
            return null;
    }
}