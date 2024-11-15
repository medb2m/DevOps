package tn.foyer.mohamedbenmohamedtpfoyer.Services;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tn.foyer.mohamedbenmohamedtpfoyer.Repositories.FoyerRepository;
import tn.foyer.mohamedbenmohamedtpfoyer.entities.Foyer;

import java.util.List;


@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{

    FoyerRepository foyerRepository;

    @Override
    public Foyer add(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> addAll(List<Foyer> foyers) {
        return foyerRepository.saveAll(foyers);
    }

    @Override
    public Foyer update(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> updateAll(List<Foyer> foyers) {
        return foyerRepository.saveAll(foyers);
    }

    @Override
    public Foyer selectById(long id) {
        return foyerRepository.findById(id).get();
    }

    @Override
    public List<Foyer> selectAll() {
        return foyerRepository.findAll();
    }

    @Override
    public void delete(Foyer foyer) {
        foyerRepository.delete(foyer);
    }

    @Override
    public void deleteById(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Foyer> foyers) {
        foyerRepository.deleteAll(foyers);
    }

    @Override
    public void deleteAll() {
        foyerRepository.deleteAll();
    }

    @Override
    public long count() {
        return foyerRepository.count();
    }

}
