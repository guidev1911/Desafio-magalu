package com.guidev1911.agendamento_notificacao_api.business.mapper;

import com.guidev1911.agendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.guidev1911.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.guidev1911.agendamento_notificacao_api.infrastructure.entities.Agendamento;
import com.guidev1911.agendamento_notificacao_api.infrastructure.repository.AgendamentoRepository;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamento);

    AgendamentoRecordOut paraOut(Agendamento agendamento);
}
