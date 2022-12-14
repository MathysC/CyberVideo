package ui.utils.observer.cart;

import fc.films.Film;
import ui.managers.FilmEvents;

/**
 * Common Interface for Observable cart related object.
 * @author MathysC
 * @see ui.utils.observer.cart.ICartObserver
 * @see ui.managers.FilmsEvents
 */
public interface ICartObservable {

    /**
     * Add an observer.
     * @author MathysC
     *
     * @param cartObserver The observer to register.
     */
    void registerCart(ICartObserver cartObserver);
    
    /**
     * Remove an observer.
     * @author MathysC
     *
     * @param cartObserver The observer to unregister.
     */
    void unregisterCart(ICartObserver cartObserver);
    
    /**
     * Notify observers of any change depending on the Event
     * @author MathysC
     *
     * @param event The type of event (e.g. ADDTOCART).
     * @param film The film related to this change.
     * @param supportType The supportType related to this Film.
     */
    void notifyCartObservers(FilmEvents event, Film film, String supportType);
}
