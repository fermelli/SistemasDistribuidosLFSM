package com.fermelli.alumnos.service;

import com.fermelli.alumnos.dao.entity.AlumnoModel;
import com.fermelli.alumnos.data.Alumno;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fermelli.alumnos.dao.entity.AlumnoRepository;

@Service
public class AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    public Alumno create(final Alumno meet) {

        AlumnoModel alumnoModel = new AlumnoModel();
        BeanUtils.copyProperties(meet, alumnoModel);
        alumnoModel = alumnoRepository.save(alumnoModel);

        Alumno alumnoData = new Alumno();
        BeanUtils.copyProperties(alumnoModel, alumnoData);

        return alumnoData;
    }

    public List<Alumno> getAlumnos() {
        
        List<AlumnoModel> alumnos = new ArrayList<>();
        alumnoRepository.findAll().forEach(alumnos::add);

        List<Alumno> alumnoList = new ArrayList<>();
        for (AlumnoModel meetModel : alumnos) {
            Alumno alumno = new Alumno();
            BeanUtils.copyProperties(meetModel, alumno);
            alumnoList.add(alumno);
        }

        return alumnoList;
    }

    public Alumno getAlumno(Long id) {

        Optional<AlumnoModel> alumno = alumnoRepository.findById(id);
        Alumno alumnoData = new Alumno();
        BeanUtils.copyProperties(alumno.get(), alumnoData);

        return alumnoData;
    }

    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }

    public Alumno update(final Alumno alumno, Long id) {

        Optional<AlumnoModel> optionalAlumno = alumnoRepository.findById(id);
        AlumnoModel recoveredAlumno;
        if (optionalAlumno.isPresent()) {
            recoveredAlumno = optionalAlumno.get(); //obtener directamente la clase producto
            BeanUtils.copyProperties(alumno, recoveredAlumno);
            recoveredAlumno = alumnoRepository.save(recoveredAlumno);
            return alumno;
        } else {
            // Avisar al usuario de que no se ha encontrado el producto
            return null;
        }
    }
    
}
