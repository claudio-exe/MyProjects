
public interface GestioneParcheggio {
    void ingresso() throws InterruptedException;
    void uscita();
    void parcheggia(int piano)throws PianoInesistente, NoStalliLiberi;
    void partenza(int piano) throws PianoInesistente;
    int postiLiberi();
    int stalliLiberi(int piano) throws PianoInesistente;
}

