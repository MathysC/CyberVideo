package ui.Pages.actions;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import fc.Films.Film;
import ui.Decorations;
import ui.Bundles.Multilingual;
import ui.Colors.ColorTheme;
import ui.Colors.Dark;
import ui.Colors.Light;

@SuppressWarnings("serial")
public class CheckoutPanel extends JPanel implements Multilingual, ColorTheme {

	/* Checkout Part */
    	private JPanel cartPanel = new JPanel();
	private JButton checkoutButton = new JButton();

	private HashMap<Film, CartItemPanel> cart = new HashMap<>();
	
	public CheckoutPanel() {
	    this.setLayout(new BorderLayout());

	    cartPanel.setLayout(new GridLayout(3,0));
	    this.add(cartPanel, BorderLayout.NORTH);
		
	    JPanel panelforCheckoutButton = new JPanel();
	    panelforCheckoutButton.setOpaque(false);
	    checkoutButton.setPreferredSize(new Dimension(200, 75));
	    panelforCheckoutButton.add(checkoutButton);
	    this.add(panelforCheckoutButton, BorderLayout.SOUTH);
	}
	
	/**
	 * Create a JPanel with data from the Rented film.
	 * @author MathysC
	 *
	 * @param film the rented film.
	 * @param rent how the film is rented.
	 * @return The complete JPanel of this film.
	 */
	public boolean addToCart(Film film, String rent) {
	    if (this.cart.size() == 3) return false;
	    CartItemPanel item = new CartItemPanel(film, rent);
	    this.cartPanel.add(item); // TODO#29 addFilm to manager
	    this.cart.put(film, item);

	    return true;
	}
	
	@Override
	public void setLight() {
	    // This Panel
	    this.setBackground(Light.BG.getColor());
	    this.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Light.BLACK.getColor()));

	    // Checkout Manager
	    this.cartPanel.setBackground(this.cartPanel.getParent().getBackground());
	    // CheckedOutFilmPanel from cart
	    for(CartItemPanel fp : cart.values()) {
		fp.setLight();
	    }

	    // Checkout Button
	    this.checkoutButton.setBackground(Light.BLUE.getColor());
	    this.checkoutButton.setForeground(Light.WHITE.getColor());
	    this.checkoutButton.setFont(Decorations.FONT_BASIC.getFont(Font.BOLD, 20));		
	}

	@Override
	public void setDark() {
	    // This Panel
	    this.setBackground(Dark.BG.getColor());
	    this.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Dark.FOREGROUND.getColor()));

	    // Checkout Manager
	    this.cartPanel.setBackground(this.cartPanel.getParent().getBackground());

	    // CheckedOutFilmPanel from cart
	    for(CartItemPanel fp : cart.values()) {
		fp.setDark();		
	    }
		
	    // Checkout Button
	    this.checkoutButton.setBackground(Dark.BLUE.getColor());
	    this.checkoutButton.setForeground(Dark.FOREGROUND.getColor());
	    this.checkoutButton.setFont(Decorations.FONT_BASIC.getFont(Font.BOLD, 20));	
	}

	@Override
	public void setLanguage(ResourceBundle rb) {
	    checkoutButton.setText(rb.getString("checkout_button"));
	    for(CartItemPanel fp : cart.values()) {
		fp.setLanguage(rb);	
	    }
	}
}