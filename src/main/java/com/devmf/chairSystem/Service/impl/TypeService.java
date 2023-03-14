package com.devmf.chairSystem.Service.impl;

import com.devmf.chairSystem.Service.interfaces.ITypeService;
import com.devmf.chairSystem.model.Type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TypeService implements ITypeService {
    @Override
    public List<Type> getTypes() {
        return null;
    }

    @Override
    public Optional<Type> getTypeById(long id) {
        return Optional.empty();
    }

    @Override
    public void saveType(Type type) {

    }

    @Override
    public void updateType(Type type) {

    }

    @Override
    public void deleteType(Type type) {

    }
}
