package com.world.beauty.dto;

import java.util.List;

import com.world.beauty.entity.Cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDto {
	private Long id;
	private List<Cliente> cliente;

}
