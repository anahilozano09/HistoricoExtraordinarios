package unam.fes.service.profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.fes.model.entity.ProfesorEntity;
import unam.fes.repository.ProfesorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    @Transactional
    public ProfesorEntity save(ProfesorEntity profesor) {
        return  profesorRepository.save(profesor);
    }

    @Override
    public List<ProfesorEntity> findAll() {
        return profesorRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        profesorRepository.deleteById(id);
    }

    @Override
    public ProfesorEntity findById(Long id) {
        Optional<ProfesorEntity> op = profesorRepository.findById(id);
        return op.orElse(null);
    }
}
