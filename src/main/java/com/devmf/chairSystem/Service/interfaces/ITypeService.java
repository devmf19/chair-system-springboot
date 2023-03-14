package com.devmf.chairSystem.Service.interfaces;

import com.devmf.chairSystem.model.Type;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ITypeService {
    public List<Type> getTypes();

    public Optional<Type> getTypeById(long id);

    public void saveType(Type type);

    public void updateType(Type type);

    public void deleteType(Type type);
}
