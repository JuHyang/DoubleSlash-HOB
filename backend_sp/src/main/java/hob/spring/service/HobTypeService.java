package hob.spring.service;

import hob.spring.model.HobType;
import hob.spring.repository.HobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobTypeService {
    @Autowired
    private HobTypeRepository hobTypeRepository;

    public HobType get(final String id){
        return hobTypeRepository.findById(id).orElse(null);
    }

    public HobType create(final HobType hobType){
        if (hobType == null) {
            throw new NullPointerException("hobType data cannot be null");
        }
        return hobTypeRepository.insert(hobType);
    }

    public List<HobType> getAll() {
        return hobTypeRepository.findAll();
    }
}
