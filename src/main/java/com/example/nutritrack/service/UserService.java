package com.example.nutritrack.service;

import com.example.nutritrack.dto.UserDTO;

import com.example.nutritrack.model.User;
import com.example.nutritrack.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO saveUser(UserDTO userDTO) {
        userDTO.setCalorias(calcularCalorias(userDTO));
        User user = modelMapper.map(userDTO, User.class);
        return modelMapper.map(userRepo.save(user), UserDTO.class);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        userDTO.setCalorias(calcularCalorias(userDTO));
        User user = modelMapper.map(userDTO, User.class);
        return modelMapper.map(userRepo.save(user), UserDTO.class);
    }

    public String deleteUser(int id) {
        userRepo.deleteById(id);
        return "Usuario eliminado";
    }

    private int calcularCalorias(UserDTO dto) {
        double tmb;
        double altura = 160;
        int edad = 30; // edad estimada

        if ("hombre".equalsIgnoreCase(dto.getSexo())) {
            tmb = 10 * dto.getPeso() + 6.25 * altura - 5 * edad + 5;
        } else {
            tmb = 10 * dto.getPeso() + 6.25 * altura - 5 * edad - 161;
        }

        double factor = switch (dto.getActividad().toLowerCase()) {
            case "ligero" -> 1.375;
            case "moderado" -> 1.55;
            case "intenso" -> 1.725;
            default -> 1.2;
        };

        return (int) Math.round(tmb * factor);
    }
}
