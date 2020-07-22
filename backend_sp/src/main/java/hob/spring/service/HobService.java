package hob.spring.service;

import hob.spring.model.Hob;
import hob.spring.repository.HobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobService {
    @Autowired
    private HobRepository hobRepository;

    public Hob get(final String id){
        return hobRepository.findById(id).orElse(null);
    }

    public Hob create(final Hob hob){
        if (hob == null) {
            throw new NullPointerException("hob data cannot be null");
        }
        return hobRepository.insert(hob);
    }

    public List<Hob> getAll() {
        return hobRepository.findAll();
    }
}
