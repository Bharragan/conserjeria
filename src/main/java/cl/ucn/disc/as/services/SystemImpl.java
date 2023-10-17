        package cl.ucn.disc.as.services;
import cl.ucn.disc.as.model.Edificio;
import io.ebean.PersistenceIOException;
import io.ebean.annotation.NotNull;

public class SystemImpl implements System{
    public SystemImpl(Database database)


    @Override
    public Edificio add(@NotNull Edificio Edificio) {
        try{
            this.database.save(edificio);
        } catch (PersistenceIOException exception){
            log.error("Error", exception);
        }

    }
}
