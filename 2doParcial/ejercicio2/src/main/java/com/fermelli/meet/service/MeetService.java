package com.fermelli.meet.service;

import com.fermelli.meet.dao.entity.MeetModel;
import com.fermelli.meet.data.Meet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fermelli.meet.dao.entity.MeetRepository;

@Service
public class MeetService {

    @Autowired
    MeetRepository meetRepository;

    public Meet create(final Meet meet) {

        MeetModel meetModel = new MeetModel();
        BeanUtils.copyProperties(meet, meetModel);
        meetModel = meetRepository.save(meetModel);

        Meet meetData = new Meet();
        BeanUtils.copyProperties(meetModel, meetData);

        return meetData;
    }

    public List<Meet> getMeets() {
        
        List<MeetModel> meets = new ArrayList<>();
        meetRepository.findAll().forEach(meets::add);

        List<Meet> meetList = new ArrayList<>();
        for (MeetModel meetModel : meets) {
            Meet meet = new Meet();
            BeanUtils.copyProperties(meetModel, meet);
            meetList.add(meet);
        }

        return meetList;
    }

    public Meet getMeet(Long id) {

        Optional<MeetModel> meet = meetRepository.findById(id);
        Meet meetData = new Meet();
        BeanUtils.copyProperties(meet.get(), meetData);

        return meetData;
    }

    public void delete(Long id) {
        meetRepository.deleteById(id);
    }

    public Meet update(final Meet meet, Long id) {

        Optional<MeetModel> optionalMeet = meetRepository.findById(id);
        MeetModel recoveredMeet;
        if (optionalMeet.isPresent()) {
            recoveredMeet = optionalMeet.get(); //obtener directamente la clase producto
            BeanUtils.copyProperties(meet, recoveredMeet);
            recoveredMeet = meetRepository.save(recoveredMeet);
            return meet;
        } else {
            // Avisar al usuario de que no se ha encontrado el producto
            return null;
        }
    }
    
}
