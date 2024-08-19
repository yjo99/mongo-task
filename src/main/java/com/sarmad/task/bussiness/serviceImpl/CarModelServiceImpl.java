package com.sarmad.task.bussiness.serviceImpl;

import com.sarmad.task.bussiness.dto.CarModelDto;
import com.sarmad.task.bussiness.dto.UserCarsDto;
import com.sarmad.task.bussiness.service.CarModelService;
import com.sarmad.task.persistence.entity.CarModel;
import com.sarmad.task.persistence.entity.UserCars;
import com.sarmad.task.persistence.repository.CarModelRedisRepo;
import com.sarmad.task.persistence.repository.CarModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    private CarModelRedisRepo carModelRedisRepo;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Optional<CarModelDto> getCashedCarModel(String id) {
        if(getCarModelCached()==null ||!getCarModelCached().iterator().hasNext()){
            List<CarModel> carModels = getAllCarModelData();
            CacheCarModelDtos(mapUserCarsToDtos(carModels));
        }
        return carModelRedisRepo.findById(id);
    }

    public List<CarModel> getAllCarModelData(){
        return carModelRepository.findAll();
    }
    public void CacheCarModelDtos(Iterable<CarModelDto> carModels){
        carModelRedisRepo.saveAll(carModels);
    }
    public Iterable<CarModelDto> getCarModelCached(){
        return carModelRedisRepo.findAll();
    }


    private Iterable<CarModelDto> mapUserCarsToDtos(List<CarModel> carModels) {
        return carModels.stream()
                .map(carModel -> modelMapper.map(carModel, CarModelDto.class))
                .collect(Collectors.toList()); // Collect to List which is Iterable
    }

}
