package ui.utils.factory.filmpanel.factories;

import fc.films.Film;
import ui.utils.factory.filmpanel.products.FilmPanelButton;
import ui.utils.factory.filmpanel.products.RentButton;

/**
 * Factory to create FilmRentPanel.
 * @author MathysC
 */
@SuppressWarnings("serial")
public class FilmRentPanel extends FilmPanel {

    public FilmRentPanel(Film film) {
	super(film);
    }

    @Override
    protected FilmPanelButton createButton(String supportType) {
	RentButton button = new RentButton(this.getFilm(), supportType);
	
	this.buttonPanel.add(button); // Add to the panel 
	return button;
    }

}
