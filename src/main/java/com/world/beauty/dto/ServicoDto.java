package com.world.beauty.dto;

import java.util.List;

import com.world.beauty.entity.Servico;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicoDto {
	private Long id;
	private List<Servico> servico;
}
