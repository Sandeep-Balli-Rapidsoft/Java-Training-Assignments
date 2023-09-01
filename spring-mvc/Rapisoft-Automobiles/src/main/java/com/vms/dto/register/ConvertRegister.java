package com.vms.dto.register;

import com.vms.entity.Register;

public class ConvertRegister {
    
    public static RegisterDTO toRegisterDTO(Register register) {
        RegisterDTO registerDto = new RegisterDTO();
        registerDto.setId(register.getId());
        registerDto.setUser(register.getUser());
        registerDto.setVehicle(register.getVehicle());
        registerDto.setVehicleNumber(register.getVehicleNumber());
        registerDto.setCreatedAt(register.getCreatedAt());
        registerDto.setUpdatedAt(register.getUpdatedAt());
        registerDto.setIsActive(register.getIsActive());
        
        return registerDto;
    }
    
    public static Register toRegister(RegisterDTO registerDto) {
        Register register = new Register();
        register.setUser(registerDto.getUser());
        register.setVehicle(registerDto.getVehicle());
        register.setVehicleNumber(registerDto.getVehicleNumber());
        register.setCreatedAt(registerDto.getCreatedAt());
        register.setUpdatedAt(registerDto.getUpdatedAt());
        register.setIsActive(registerDto.getIsActive());
        
        return register;
    }
}
