package unam.fes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unam.fes.model.entity.MateriasEntity;
import unam.fes.repository.MateriasRepository;

import java.util.List;

@Service
public class MateriasServiceImpl implements MateriasService {

    @Autowired
    private MateriasRepository materiasRepository;

    @Override
    @Transactional
    public MateriasEntity save(MateriasEntity materia) {
        return materiasRepository.save(materia);
    }

    @Override
    public MateriasEntity findById(String claveMateria) {
        return materiasRepository.findById(claveMateria)
                .orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(String claveMateria) {
        materiasRepository.deleteById(claveMateria);
    }

    public MateriasServiceImpl(MateriasRepository materiasRepository) {
        this.materiasRepository = materiasRepository;
    }

    @Override
    public List<MateriasEntity> findAll() {
        return materiasRepository.findAllByOrderByNombreMateriaAscClaveMateriaAsc();
    }
}
