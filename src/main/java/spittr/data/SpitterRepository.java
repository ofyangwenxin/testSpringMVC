package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {

    Spitter save(Spitter spittle);

    Spitter findByUsername(String username);
}
