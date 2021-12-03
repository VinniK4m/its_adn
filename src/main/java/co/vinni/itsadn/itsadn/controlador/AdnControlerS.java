package co.vinni.itsadn.itsadn.controlador;

import co.vinni.itsadn.itsadn.modelo.Adn;

import java.util.List;

public interface AdnControlerS {
    List<Adn> getAllAdn();
    Adn guardaAdn(Adn dato);
    Adn editarAdn(Adn dato);
    Adn getAdnbyID(long id);
    void borrarAdnbyId(long id);
}