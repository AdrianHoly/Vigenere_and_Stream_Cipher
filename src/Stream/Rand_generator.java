package Stream;

public class Rand_generator {
    long seed;
    public Rand_generator(long seed) {
        this.seed = seed;
    }
    public double randomizer(){
        seed = (84589 * seed + 45989) % 217728;
        return (double) seed / 217728.0;
    }
}
