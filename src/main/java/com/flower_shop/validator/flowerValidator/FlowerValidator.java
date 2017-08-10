package com.flower_shop.validator.flowerValidator;

import com.flower_shop.dao.FlowerDao;
import com.flower_shop.entity.Flower;
import com.flower_shop.service.FlowerService;
import com.flower_shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Администратор on 30.05.2017.
 */
@Component
public class FlowerValidator implements Validator {

    @Autowired
    private FlowerService flowerService;

    @Override
    public void validate(Object o) throws Exception {

        Flower flower = (Flower) o ;

        if(flower.getName().isEmpty()){
            throw new FlowerExeption(FlowerValidatorMessage.EMPTY_FLOWERNAME_FIELD);

        }else if(flower.getColor().isEmpty()){
            throw new FlowerExeption(FlowerValidatorMessage.EMPTY_COLOR_FIELD);

        }
//        else if(flower.getPrice() < 0){
//            throw  new flowerValidator(FlowerValidatorMessage.WRONG_PRICE);
//        }
    }
}
